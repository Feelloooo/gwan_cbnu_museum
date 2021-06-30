package org.project.cbnu_museum;

public class User {

    public String name;  // 사용자 id
    public String address; // 사용자명
    public String description;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress(){return address; }
    public void setAddress(String address){this.address = address;}

    public String getDescription() {return description;}
    public void setDescription(String description){this.description = description;}

}