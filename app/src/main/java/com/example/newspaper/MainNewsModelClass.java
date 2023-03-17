package com.example.newspaper;

import java.util.ArrayList;

public class MainNewsModelClass {

    ArrayList<ModelClass> articles;
    String status;
    String totalResults;

    public MainNewsModelClass(ArrayList<ModelClass> articles, String status, String totalResults) {
        this.articles = articles;
        this.status = status;
        this.totalResults = totalResults;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }
}
