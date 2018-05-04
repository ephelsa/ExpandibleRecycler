package com.personal.leonardo.testapp;

public class ParentModel {

    private String title;
    private int query;

    public ParentModel(String title, int query) {
        this.title = title;
        this.query = query;
    }

    public int getQuery() {
        return query;
    }

    public void setQuery(int query) {
        this.query = query;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
