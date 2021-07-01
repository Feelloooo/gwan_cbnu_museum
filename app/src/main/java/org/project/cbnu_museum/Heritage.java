package org.project.cbnu_museum;

public class Heritage {

    public String name;  // 이름
    public String address; // 사용자명
    public String description;
    public String detail;
    public String era;
    public String place;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress(){return address; }
    public void setAddress(String address) {this.address = address;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getEra() {return era;}
    public void setEra(String era) {this.era = era;}

    public String getDetail() {return detail;}
    public void setDetail(String detail) {this.detail = detail;}

    public String getPlace() {return place;}
    public void setPlace(String place) {this.place = place;}

}