package com.arcovid19project.Models;

public class Official_Directories {

    String name, dc, si, dmos;

    public Official_Directories() {
    }

    public Official_Directories(String name, String dc, String si, String dmos) {
        this.name = name;
        this.dc = dc;
        this.si = si;
        this.dmos = dmos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getDmos() {
        return dmos;
    }

    public void setDmos(String dmos) {
        this.dmos = dmos;
    }
}
