package com.artlanguage.checkIn.DTO;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
@Data
public class CheckInRequest {



    private  Integer initiatorId;
    private  Integer locationId;
    private List<Integer> friendsId;
}
