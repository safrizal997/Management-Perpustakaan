package com.safrizal.managementperpustakaan.model;

import javax.validation.constraints.Size;

public class UserRequest {

    @Size(min = 2, message = "Nama Harus Lebih dari dua karakter")
    private String userName;
    private String email;
    private String education;
    private String major;

    public UserRequest() {
    }

    public UserRequest(String userName, String email, String education, String major) {
        this.userName = userName;
        this.email = email;
        this.education = education;
        this.major = major;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
