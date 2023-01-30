# Lab report 2 - Servers and Bugs
#### *by David Kim*
---
## Part 1
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


```java
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


I also added my own variable (`numOfStrings`) to Keep track of the number of string in the root

### Example of the root path:

![Image](/pngs/lab2/part1-screenshot1.png)

### Example of adding "testing":

![Image](/pngs/lab2/part1-screenshot2.png)

In this image, the path ` /add-message` is used, so the `if (url.getPath().equals("/add-message"))` if statement runs, 
which then splits the url's query into an array separated by "=" by running the line  `String[] parameters = url.getQuery().split("=");` 
parameters now contains `"s"` and `"testing"` in that order. The server code checks if the the first query parameter is an "s" by doing 
`if(parameters[0].equals("s"))` and since this is true, `"testing"` is added to the string ``storedStrings`` followed by an `\n` 
escape sequence. My variable to track the number of strings is then incremented by `numOfStrings++`. Finally the resulting `storedStrings` 
variable is outputted to the website.

The following fields' values are changed in this example:
* `parameters[]` contains `{"s", "testing"}`
* `storedStrings` is equal to `"testing\n"`
* `numOfStrings` is equal to `1`.

The following methods were called in the handler process:
* `handleRequest(url)`
* `getPath()`
* `println("Path: " + url.getPath())`
* `equals("/add-message")` and `equals("s")`
* `getQuery()`
* `split("=")`

The following methods were called in the `StringServer`:
* `main({"34243"})`
* `parseInt(args[0])` or * `parseInt("34243")`
* `start(port, new Handler())`

### Example of adding "hello-world" after "testing":

![Image](/pngs/lab2/part1-screenshot3.png)


In this image, the path ` /add-message` is used, so the `if (url.getPath().equals("/add-message"))` if statement runs, 
which then splits the url's query into an array separated by "=" by running the line  `String[] parameters = url.getQuery().split("=");` 
parameters now contains `"s"` and `"hello-world"` in that order. The server code checks if the the first query parameter is an "s" by doing 
`if(parameters[0].equals("s"))` and since this is true, `"hello-world"` is added to the string ``storedStrings`` followed by an `\n` 
escape sequence. My variable to track the number of strings is then incremented by `numOfStrings++`. Finally the resulting `storedStrings` 
variable is outputted to the website.

The following methods were called in the handler process:
* `handleRequest(url)`
* `getPath()`
* `println("Path: " + url.getPath())`
* `equals("/add-message")` and `equals("s")`
* `getQuery()`
* `split("=")`

The following methods were called in the `StringServer`:
* `main({"34243"})`
* `parseInt(args[0])` or * `parseInt("34243")`
* `start(port, new Handler())`


The following fields' values are changed in this example:
* `parameters[]` contains `{"s", "hello-world"}`
* `storedStrings` is equal to `"testing\nhello-world\n"`
* `numOfStrings` is equal to `2`.

### To test that my variable for tracking the number of strings is working, I go back to the root path.

![Image](/pngs/lab2/part1-screenshot4.png)

As you can see, it sucessfully tracked the two strings I added in the examples.

---

## Part 2
---
## Part 3
### What have I learned?

Something I learned from week 2 and 3's labs were on how to properly compare floating point and double values in 
JUnit testing. While I knew that decimal values were calculated using exponents and were generally hard to compare,
I never looked into how to compare until the lab. I learned that to compare or check that values are equal, you have
to set an epsilon value that is the maximum difference allowed between the two values before they are evaluated as 
not equal.