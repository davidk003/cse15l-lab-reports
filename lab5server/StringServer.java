import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    public record ServerRequest(Date reqDate, String reqType, String message){}

    ArrayList<String> stringList = new ArrayList<>();
    ArrayList<ServerRequest> requestLog = new ArrayList<>();
    String outputString = "";


    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            outputString = "STRING SERVER CONTENTS:\n"; //Reset string
            for (String s : stringList) {
                outputString = outputString + s + "\n";
            }
            return outputString;
        }
        else
        {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add-message"))
            {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s"))
                {
                    stringList.add(parameters[1]);
                    requestLog.add(new ServerRequest(new Date(System.currentTimeMillis()), "/add-message", parameters[1]));
                    return "Added [" + parameters[1] + "] to the stringserver.\n";
                }
            }
            else if(url.getPath().contains("/remove-message"))
            {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s"))
                {
                    if(stringList.contains(parameters[1]))
                    {
                        int count = 0;
                        while(stringList.contains(parameters[1]))
                        {
                            stringList.remove(parameters[1]);
                            count++;
                        }
                        requestLog.add(new ServerRequest(new Date(System.currentTimeMillis()),"/remove-message", parameters[1]));
                        return "Removed " + count + " instances of [" + parameters[1] + "] from the stringserver.\n";
                    }
                    else
                    {
                        requestLog.add(new ServerRequest(new Date(System.currentTimeMillis()),"/remove-message[FAILED]", parameters[1]));
                        return "Failed removing [" + parameters[1] + "], does not exist in stringserver.\n";
                    }
                }
            }
            else if(url.getPath().contains("/request-logs"))
            {
                outputString = "LOG START\n";
                for (ServerRequest serverRequest : requestLog) {
                    outputString = outputString + serverRequest.reqDate() + "| Request: " + serverRequest.reqType() + " " + serverRequest.message() + "\n";
                }
                outputString += "LOG END.\n";
                return outputString;
            }
            return "404 Not Found!";
        }
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());
    }
}