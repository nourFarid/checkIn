package com.artlanguage.checkIn.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "check_in_user")
public class CheckInUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "check_in_id", nullable = false)
    private CheckIn checkIn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    private Boolean isInitiator;  // True if this user is the one who initiated the check-in


//    public CheckInUser(CheckIn checkIn,Users user, Boolean isInitiator){
//        this.checkIn = checkIn;
//        this.user = user;
//        this.isInitiator = isInitiator;
//    }
}
