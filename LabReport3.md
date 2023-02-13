# Lab report 3 - Researching Commands
#### *by David Kim*
---
## Choosing command and options
The command I chose to research is the `grep` command.

The 4 specific options I researched are the following:

`grep -f FILE,  --file=FILE`

`grep -v, --invert-match`

`grep -l, --files-with-matches`

`grep -r, --recursive`

---
## grep -f FILE
`grep -f FILE` or `grep --file=FILE` reads patterns to search for from a file 

Source used: `man grep` command

Can be used to find multiple words from an input

Example 1:

![image](/pngs/lab3/grepf1.png)

Here the `-f` option is used with the file `lab3.txt` which contains 3 words, "vista", "town" and "france" which are the words grep searches for.
This can be useful for having to search for many different words, instead of having to type out grep "example-text" for every match, you can load the search terms into a file and use `grep -f FILE`



---
## grep -v
Source used: `man grep` command

---
## grep -l
`grep -l` or `-files-with-matches`

Source used: `man grep` command

Instead of the usual grep output, the name of the input file that matches is printed. Because of this, file scanning is stopped on first match.


--- 
## grep -r
`grep -r` or `grep --recursive`

Source used: `man grep` command

Searches through a given directory and its subdirectories recursively until all directories are read. If no directory is given, it will default to the current working directory. Very useful for searching through many directories at once.

![image](/pngs/lab3/grepr2.png)
The example above combines two options and their usefulness, `-r` to recursively grep, and `-l` to superss the normal output to only output the relative file path found.