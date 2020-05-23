package com.arcovid19project.Models;

public class GovernmentOrders {
    String date, title, link;

    public GovernmentOrders() {
    }

    public GovernmentOrders(String date, String title, String link) {
        this.date = date;
        this.title = title;
        this.link = link;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
