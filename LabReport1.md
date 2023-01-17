<body style="background-color:#11C69F;">

<link rel="icon" type="image/png" href="/favicon.png">

# Lab report 1 - A tutorial for incoming CSE 15L students
#### *by David Kim*

# Installing VSCode
I use Linux(Ubuntu) on my laptop so I'll start with that.

## Linux(Debian based systems) Setup
![Image](/vscodeLinux1.png)	

[Link to official site](https://code.visualstudio.com/docs/setup/linux)

then run the following:

```
    sudo apt install ./<file>.deb
```

or this one on older systems:
```
    sudo dpkg -i <file>.deb
    sudo apt-get install -f # Install dependencies
```

## Mac Setup
#### taken from [here](https://code.visualstudio.com/docs/setup/mac)
![Image](/vscodeMac.png)
## Windows Setup
#### taken from [here](https://code.visualstudio.com/docs/setup/windows)
![Image](/vscodeWin.png)

# Remotely Connecting

## Getting your username and password

To connect, you will first need to know your username and password.

Lookup your username [here](https://sdacs.ucsd.edu/~icc/index.php)
and change your password with this [Tutorial](https://docs.google.com/document/d/1hs7CyQeh-MdUfM9uv99i8tqfneos6Y8bDU0uhn1wqho/edit)

## Installing git-bash

git bash is a program we need to remotely connect to the school's machines.

While Linux and many other unix/unix-like Operating system come with git bash preinstalled, Windows does not.

Therefore the following git bash installation process will address Windows users.

Visit [https://gitforwindows.org/](https://gitforwindows.org/) to install git

## Actually connecting

For this step, you can choose to either through VSCode's terminal by following [this Tutorial](https://stackoverflow.com/questions/42606837/how-do-i-use-bash-on-windows-from-the-visual-studio-code-integrated-terminal/50527994#50527994)

Otherwise you can use git bash by itself or use the terminal that came with your system. (Unless it is windows)

To connect, enter the following command into your terminal that fills in your own details.

`ssh <course specific username>@ieng6.ucsd.edu`

Ex: I would type in ssh cs15lwi23avr@ieng6.ucsd.edu because my course username is cs15lwi23avr

The terminal should then ask you for your password, and entering your password should log you in.

![Image](/pngs/passwordScreenshot.png)

On your very first login, you might encounter something like this:

```
The authenticity of host 'ieng6-202.ucsd.edu (128.54.70.227)' can't be established.
RSA key fingerprint is SHA256:ksruYwhnYH+sySHnHAtLUHngrPEyZTDl/1x99wUQcec.
Are you sure you want to continue connecting (yes/no/[fingerprint])? 
```
Type yes, then right after type in your password for the next prompt.

You should see something like this when you first login anytime.

![Image](/pngs/loginScreenshot.png)

# Trying Some Commands
Now, assuming that we have a connection to the machine using ssh lets try using some commands.

Try running:


`pwd` - stands for print working directory

![Image](/pngs/pwdScreenshot.png)

`ls`    - lists the files and directories under the current location you are in.

`ls -a`     - lists all files and directories, including hidden and system files which are usually denoted with a "."

`ls <directory>` - Where `<directory>` is some path in the system, lists files and directories in the given directory.

![Image](/pngs/lsScreenshot.png)

`cd <directory>`    - stands for "change directory" and changes your current directory location.

`cd ~` - which changes the directory to "~" which is known as the root directory of a system.

![Image](/pngs/cdScreenshot.png)

`touch <file name>` Creates a file name in the current working directory with the given name.

`rm <file path>` Deletes or removes a file.

![Image](/pngs/touchScreenshot.png)

`nano <file name>` Opens file in a command line text editor.

![Image](/pngs/nanoScreenshot.png)

`cp <file path> <directory>` - copies a file from a file path to the given directory.

![Image](/pngs/cpScreenshot.png)

`cat <file path>` - prints out the contents of a file (Ex: prints out text in a file).  

![Image](/pngs/catScreenshot.png)

If you ever have any questions about a command try `man <command>` to get a directions manual of a given command.

To log out of the ssh session, type `exit` into the console or "CTRL + D"

# THE END
