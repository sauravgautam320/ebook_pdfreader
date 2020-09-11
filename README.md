# ebook_pdfreader
E-book is an android app developed using android studio IDE, basic JAVA language knowledge, Firebase as a real time database host.

## :rocket: Quick start

### Step 1: Clone the repo
Fork the repository. then clone the repo locally

### Step 2: Change package name.
Change package name to something unique. Firebase requires this.

### Step 3: Download google-services.json file
This projects uses firebase. So we need to download `google-services.json` file.
You can go through this: https://firebase.google.com/docs/android/setup

### Step 4: Using google services file.
Now, you need to add `google-services.json` given by firebase to app directory.

### Step 5: To add books
If you want to add books you can directly add it to your firebase's realtime database by creating 'documents'(you can give your custom name but you have to change the path reference in the 'MainActivity.java' file to exactly match your directory name) directory by adding file title in 'filename' and link to your pdf in 'fileurl' (you can give your custom name here also but you will have to make changes in 'myAdapter.java' , 'Book.java' , 'item.java' file according to what you named them).

### Step 6: This is it.
After this all, all thats left is to run the app
</br></br></br>
## :v: Contributing
After cloning & setting up the local project you can push the changes to your github fork and make a pull request.
