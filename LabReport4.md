# Lab report 4 - Competition
#### *by David Kim*
### Context
During week 7's lab, we were tasked with a challenge to race a
list of steps and try to do them the fastest.

The goal of this lab is to reproduce how tasks were done during the competition, down to the keystroke.

The steps in question:

    1. Setup Delete any existing forks of the repository you have on your account
    2. Setup Fork the repository
    3. The real deal Start the timer!
    4. Log into ieng6
    5. Clone your fork of the repository from your Github account
    6. Run the tests, demonstrating that they fail
    7. Edit the code file to fix the failing test
    8. Run the tests, demonstrating that they now succeed
    9. Commit and push the resulting change to your Github account (you can pick any commit message!)

### Setup
Steps 1-3 of this list are setup and will be described here.

Step 1: Deleting any existing forks can be done by going to the github repository

Click on the settings gear on the main page of your repository.

![image](pngs/lab4/step1_1.png)

From there, scroll all the way down until you see the section labeled "danger zone"

![image](pngs/lab4/step1_2.png)

Click "Delete this repository" and type the prompted text to delete the repository.

![image](pngs/lab4/step1_3.png)

Now assuming the repository has been deleted successfully, remove the files and directories associated with the lab7 repository on whatever device you were working on.
use `rm -rf <directory>` to delete it.