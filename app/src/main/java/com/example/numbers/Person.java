package com.example.numbers;

public class Person {

    public String name ;
    public String phone ;
    private Integer  image;

    public Person(String name,String phone) {
        this.name = name;
        this.phone=phone;
    }

    public Person(String name,String phone,int image) {
        this.name = name;
        this.phone=phone;
        this.image=image;
    }



    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
