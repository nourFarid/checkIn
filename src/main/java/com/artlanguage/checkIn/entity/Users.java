package com.artlanguage.checkIn.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "display_name", length = 45)
    private String displayName;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "role", length = 11)
    private String role = "10";

    @Column(name = "date_of_join")
    private String dateOfJoin;

    @Column(name = "age" ,nullable = false )
    private int age;

    @Column(name = "country", length = 50, nullable = true)
    private String country;

    @Column(name = "city", length = 45, nullable = true)
    private String city;

    @Column(name = "phone", length = 50, nullable = true)
    private String phone;

    @Column(name = "phone_status", length = 45, nullable = true)
    private String phoneStatus = "false";

    @Column(name = "email", length = 50, nullable = true)
    private String email;

    @Column(name = "email_status", length = 45, nullable = true)
    private String emailStatus = "false";

    @Column(name = "gender", length = 50, nullable = true)
    private String gender;

    @Column(name = "photo", length = 50, nullable = true)
    private String photo;

    @Column(name = "language", length = 50, nullable = true)
    private String language;

    @Column(name = "name", length = 45, nullable = true)
    private String name;

    @Column(name = "twitter", length = 45, nullable = true)
    private String twitter;

    @Column(name = "facebook", length = 45, nullable = true)
    private String facebook;

    @Column(name = "instagram", length = 45)
    private String instagram;

    @Column(name = "bio", length = 500)
    private String bio;

    @Column(name = "password_attempts_left",columnDefinition = "INT(11) default 5")
    private Integer passwordAttemptsLeft = 5;

    @Column(name = "last_correct_login",  columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    @Temporal(TemporalType.DATE)
    private Date lastCorrectLogin;

    @Column(name = "last_failure_login", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date lastFailureLogin;

    @Column(name = "points_level", columnDefinition = "INT(11) default 0")
    private int pointsLevel = 0;

    @Column(name = "avatar_no", columnDefinition = "INT(11) default 0")
    private int avatarNo;

    @Column(name = "points_no", columnDefinition = "INT(11) default 0")
    private int points;

    @Column(name = "account_status", length = 45)
    private String accountStatus = "active";


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CheckInUser> checkIns = new ArrayList<>();

}
