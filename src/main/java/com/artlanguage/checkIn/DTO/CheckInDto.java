package com.artlanguage.checkIn.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Data
public class CheckInDto {

    private int id;

    private int userId;

    private int locationId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    private Date date;

}
