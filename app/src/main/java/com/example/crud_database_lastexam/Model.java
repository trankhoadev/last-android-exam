package com.example.crud_database_lastexam;

public class Model {
    public String img, name, desc, email;

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getEmail() {
        return email;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Model(String img, String name, String desc, String email) {
        this.img = img;
        this.name = name;
        this.desc = desc;
        this.email = email;
    }
}
