package com.artlanguage.checkIn.DTO;

import jakarta.persistence.*;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class UsersDTO {


    private Integer id;

    private String username;

    private String displayName;

    private String password;

    private String role = "10";

    private String dateOfJoin;

    private int age;

    private String country;

    private String city;

    private String phone;

    private String phoneStatus = "false";

    private String email;

    private String emailStatus = "false";

    private String gender;

    private String photo;

    private String language;

    private String name;

    private String twitter;

    private String facebook;

    private String instagram;

    private String bio;

    private Integer passwordAttemptsLeft = 5;


    private Date lastCorrectLogin;

    private Date lastFailureLogin;

    private int pointsLevel = 0;

    private int avatarNo;

    private int points;

    private String accountStatus = "active";

    public UsersDTO(){
        dateOfJoin = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
