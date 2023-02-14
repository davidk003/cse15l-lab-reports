# Lab report 3 - Researching Commands
#### *by David Kim*
---
## Choosing command and options
The command I chose to research is the `grep` command.

The 4 specific options I researched are the following:

`grep -r, --recursive`

`grep -f FILE,  --file=FILE`

`grep -n, grep --line-number`

`grep -l, --files-with-matches`


---
## grep -r
`grep -r` or `grep --recursive`

Source used: `man grep` command

Searches through a given directory and its subdirectories recursively until all directories are read. If no directory is given, it will default to the current working directory.

Example 1:
This option is especially useful for searching through larger directories that contain even more directories. The below usage recursively searched through written_2/ to search for "test" and outputted many blocks of text for every instance of test found. In all the files in the directories and their recursive subdirectories.

![image](/pngs/lab3/grepr1.png)

Example 2:

The next example combines two options and their usefulness, `-r` to recursively grep, and `-l` to superess the normal output to only output the relative file path found.

![image](/pngs/lab3/grepr2.png)

---
## grep -f FILE
`grep -f FILE` or `grep --file=FILE` reads patterns to search for from a file 

Source used: `man grep` command

Can be used to find multiple words from an input

Example 1:

Here the `-f` option is used with the file `lab3.txt` which contains 3 words, "vista", "town" and "france" which are the words grep searches for.
This can be useful for having to search for many different words, instead of having to type out grep "example-text" for every match, you can load the search terms into a file and use `grep -f FILE`

![image](/pngs/lab3/grepf1.png)

Example 2:

Another usefulness/usage of the `-f` option might be using it in conjunction with the `-v` option to invert and ignore the parts that have your pattern.
In the following example, the file specified with the pattern is `test.txt` which contains `"`, `;`, and `,`. Instead of searching for these patterns, -v makes it do the
inverse, which is to only return lines without these patterns.

![image](/pngs/lab3/grepf2.png)

---
## grep -n
`grep -n` or `grep --line-number`

Source used: `man grep` command

Outputs the relative file path as well as the specified line number with 1 index for where the match was found.

Example 1:

In this example, a text file named `"HistoryGreek.txt"` is searched for using the word "Greek" and lists the line number of each occurence.
This might be useful in a ctrl + F type tool to move to a specific line.

![image](/pngs/lab3/grepn1.png)


Example 2:

This example uses `-n` to return the line number and `-r` to recursively search for the pattern `"Lucayans"`.
This is useful if you need the combined usefulness of searching through and entireity of a directory and finding the specified line of your pattern.

![image](/pngs/lab3/grepn2.png)


---
## grep -l
`grep -l` or `-files-with-matches`

Source used: `man grep` command

Instead of the usual grep output, the name of the input file that matches is printed. Because of this, file scanning is stopped on first match.

Example 1:

If you need to only know the file names and not the file contents this would be useful to not muck up the console with output you arent using.
For example, if you just need to know the file name containing your search pattern, I use `-l` with the text `festival` to search a file.
I then use the `cat` command to print the text to demonstrate what was in the file.

![image](/pngs/lab3/grepl1.png)

Example 2:

Another very useful application for `grep -l` would be for redirecting output to a file using `>` would be if you only need the names to input to another command.
Combined with the `-r` option you can store all the file names in a directory that match your pattern in a file.

![image](/pngs/lab3/grepl2.png)

And then a further example of usage would be to use the `rm` command to remove files matching some pattern using the file outputted from `grep -l` above.

![image](/pngs/lab3/grepl3.png)
--- 
