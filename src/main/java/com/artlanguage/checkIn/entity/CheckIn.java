package com.artlanguage.checkIn.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "check_in")
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id" ,nullable = false)
    private int userId;

    @Column(name = "location_id" ,nullable = false)
    private int locationId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Column(name = "date" )
    private Date date;

    @OneToMany(mappedBy = "checkIn", cascade = CascadeType.ALL)
    private List<CheckInUser> users = new ArrayList<>();

}
