
# First Contributions

It's hard. It's always hard the first time you do something. Especially when you are collaborating, making mistakes isn't a comfortable thing. I wish to simplify the way new open-source contributors learn & contribute for the first time.

Reading articles & watching tutorials can help, but what's better than actually doing the stuff in a practice environment? This guide aims at simplifying the way beginners make their first contribution. If you are looking to make your first contribution, follow the steps below.



<img align="right" width="300" src="https://firstcontributions.github.io/assets/Readme/fork.png" alt="fork this repository" />

#### If you don't have git on your machine, [install it](https://help.github.com/articles/set-up-git/).

## Fork this repository

Fork this repository by clicking on the fork button on the top of this page.
This will create a copy of this repository in your account.

## Clone the repository

<img align="right" width="300" src="https://firstcontributions.github.io/assets/Readme/clone.png" alt="clone this repository" />

Now clone the forked repository to your machine. Go to your GitHub account, open the forked repository, click on the code button and then click the _copy to clipboard_ icon.

Open a terminal and run the following git command:

```
git clone "url you just copied"
```

where "url you just copied" (without the quotation marks) is the url to this repository (your fork of this project). See the previous steps to obtain the url.

<img align="right" width="300" src="https://firstcontributions.github.io/assets/Readme/copy-to-clipboard.png" alt="copy URL to clipboard" />

For example:

```
git clone https://github.com/user_name/first-contributions.git
```

where `user_name` is your GitHub username. Here you're copying the contents of the first-contributions repository on GitHub to your computer.

## Create a branch

Change to the repository directory on your computer (if you are not already there):

```
cd USSD_Codes
```

Now create a branch using the `git checkout` command:

```
git checkout -b your-new-branch-name
```

For example:

```
git checkout -b feat-login-page
```

(The name of the branch does not need to have the word _feat_ in it, but it's a reasonable thing to include because the purpose of this branch is to add a feature called login to the project.)

## Make necessary changes and commit those changes

> ### Please, make sure to observe best practices, codestyles and naming conventions while writing your `clean code` :heart:

Your name will now be part of the [Contributors](https://github.com/ugwulo/USSD_Codes/graphs/contributors)

<img align="right" width="450" src="assets/git-status.png" alt="git status" />

If you go to the project directory and execute the command `git status`, you'll see there are changes.

Add those changes to the branch you just created using the `git add` command:

```
git add NAME_OF_FILE 
```
"to add a specific file"
```
git add .
```
"to add all files automatically ----notice the dot ( . )"

Now commit those changes using the `git commit` command:

```
git commit -m "add loging page"
```

the commit message should be in respect to what you are commiting
## Push changes to GitHub

Push your changes using the command `git push`:

```
git push origin <add-your-branch-name>
```

replacing `<add-your-branch-name>` with the name of the branch you created earlier.

## Submit your changes for review

If you go to your repository on GitHub, you'll see a `Compare & pull request` button. Click on that button.

<img style="float: right;" src="assets/compare-and-pull.png" alt="create a pull request" />

Now submit the pull request.

<img style="float: right;" src="assets/submit-pull-request.png" alt="submit pull request" />

Soon the project maintainer(s) will be merging all your changes into the master branch of this project. You will get a notification email once the changes have been merged.

**Happy Contributing** :heart: