package com.example.newspaper;

public class ModelSP {
    String image,title,author,time,url;

    public ModelSP(String image, String title, String author, String time, String url) {
        this.image = image;
        this.title = title;
        this.author = author;
        this.time = time;
        this.url = url;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
