package com.arcovid19project.Models;

public class EssentialCommodities {
    String districts, name, contact_numbers;

    public EssentialCommodities() {
    }

    public EssentialCommodities(String districts, String name, String contact_numbers) {
        this.districts = districts;
        this.name = name;
        this.contact_numbers = contact_numbers;
    }

    public String getDistricts() {
        return districts;
    }

    public void setDistricts(String districts) {
        this.districts = districts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_numbers() {
        return contact_numbers;
    }

    public void setContact_numbers(String contact_numbers) {
        this.contact_numbers = contact_numbers;
    }
}
