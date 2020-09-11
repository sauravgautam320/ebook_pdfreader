package com.examplecompany.ebook;

public class Book {
    //if your filename and fileurl content holder is not named 'filename' and 'fileurl' then change the below name to exactly what it is named

    String filename, fileurl;

    public Book() {
    }

    public Book(String filename, String fileurl) {
        this.filename = filename;
        this.fileurl = fileurl;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }
}
