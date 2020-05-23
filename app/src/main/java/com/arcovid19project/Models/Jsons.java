package com.arcovid19project.Models;

public class Jsons {

    String home_treatment_images, home_treatment_links, lab_test, essential_commodities, health_cares,
            tweets, faq, epass, migrant, corona, vocational_education, government_orders, official_directories;

    public Jsons() {
    }

    public Jsons(String home_treatment_images, String home_treatment_links, String lab_test, String essential_commodities, String health_cares, String tweets, String faq, String epass, String migrant, String corona, String vocational_education, String government_orders, String official_directories) {
        this.home_treatment_images = home_treatment_images;
        this.home_treatment_links = home_treatment_links;
        this.lab_test = lab_test;
        this.essential_commodities = essential_commodities;
        this.health_cares = health_cares;
        this.tweets = tweets;
        this.faq = faq;
        this.epass = epass;
        this.migrant = migrant;
        this.corona = corona;
        this.vocational_education = vocational_education;
        this.government_orders = government_orders;
        this.official_directories = official_directories;
    }

    public String getHome_treatment_images() {
        return home_treatment_images;
    }

    public void setHome_treatment_images(String home_treatment_images) {
        this.home_treatment_images = home_treatment_images;
    }

    public String getHome_treatment_links() {
        return home_treatment_links;
    }

    public void setHome_treatment_links(String home_treatment_links) {
        this.home_treatment_links = home_treatment_links;
    }

    public String getLab_test() {
        return lab_test;
    }

    public void setLab_test(String lab_test) {
        this.lab_test = lab_test;
    }

    public String getEssential_commodities() {
        return essential_commodities;
    }

    public void setEssential_commodities(String essential_commodities) {
        this.essential_commodities = essential_commodities;
    }

    public String getHealth_cares() {
        return health_cares;
    }

    public void setHealth_cares(String health_cares) {
        this.health_cares = health_cares;
    }

    public String getTweets() {
        return tweets;
    }

    public void setTweets(String tweets) {
        this.tweets = tweets;
    }

    public String getFaq() {
        return faq;
    }

    public void setFaq(String faq) {
        this.faq = faq;
    }

    public String getEpass() {
        return epass;
    }

    public void setEpass(String epass) {
        this.epass = epass;
    }

    public String getMigrant() {
        return migrant;
    }

    public void setMigrant(String migrant) {
        this.migrant = migrant;
    }

    public String getCorona() {
        return corona;
    }

    public void setCorona(String corona) {
        this.corona = corona;
    }

    public String getVocational_education() {
        return vocational_education;
    }

    public void setVocational_education(String vocational_education) {
        this.vocational_education = vocational_education;
    }

    public String getGovernment_orders() {
        return government_orders;
    }

    public void setGovernment_orders(String government_orders) {
        this.government_orders = government_orders;
    }

    public String getOfficial_directories() {
        return official_directories;
    }

    public void setOfficial_directories(String official_directories) {
        this.official_directories = official_directories;
    }
}
