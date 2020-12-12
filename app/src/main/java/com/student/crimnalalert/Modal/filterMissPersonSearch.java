package com.student.crimnalalert.Modal;

public class filterMissPersonSearch {

    public filterMissPersonSearch() {
    }

    public String getHeight_to() {
        return height_to;
    }

    public void setHeight_to(String height_to) {
        this.height_to = height_to;
    }

    public filterMissPersonSearch(String name, String age, String gender, String height_to, String weight, String complexion, String year_of_birth, String photo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height_to = height_to;
        this.complexion = complexion;
        this.year_of_birth = year_of_birth;
        this.photo = photo;
    }

    String name,age,gender,weight,height_to,complexion,year_of_birth,photo;

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(String year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public String getComplexion() {
        return complexion;
    }

    public void setComplexion(String complexion) {
        this.complexion = complexion;
    }


}
