# Lab report 2 - Servers and Bugs
#### *by David Kim*
### Part 1
The objective of this lab report is to write a web server called StringServer.
The server should keep track of a single string that is added to by requests made to the server.
<br>
These requests should be in the following format:

```
/add-message?s=<string>
```
The way I decided to go about solving this was to use the previous example of a number server 
and adapting it to record strings when the path was "/add-message" and the query's first parameter
contained an s. The query string would be split into a string array by the split() method
and the 2nd parameter would be the string to add.

Instead of using an array to keep track of strings, a single string that was initially an empty string("")
was used to add strings to the end, followed by a "\n" escape sequence to signify a new line to separate
each string.

I also added my own function to Keep track of the number of string in the root


```
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    int numOfStrings = 0;
    String storedStrings = "";
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Server has added %d messages.\n" + storedStrings, numOfStrings);
        }
        else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().equals("/add-message")) {
                String[] parameters = url.getQuery().split("=");
                if(parameters[0].equals("s"))
                {
                    storedStrings += parameters[1] + "\n";
                    numOfStrings++;
                    return storedStrings;
                }
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

```
Example of the root path:
![Image](/lab2/part1-screenshot1.png)
<br>

![Image](/lab2/part1-screenshot2.png)

![Image](/lab2/part1-screenshot3.png)
### Part 2

### Part 3