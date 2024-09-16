package com.artlanguage.checkIn.service;

import com.artlanguage.checkIn.DTO.CheckInRequest;
import com.artlanguage.checkIn.DTO.UsersResponseDTO;
import com.artlanguage.checkIn.entity.CheckIn;
import com.artlanguage.checkIn.entity.CheckInUser;
import com.artlanguage.checkIn.entity.Users;
import com.artlanguage.checkIn.mapper.UserMapper;
import com.artlanguage.checkIn.repository.CheckInRepository;
import com.artlanguage.checkIn.repository.CheckInUserRepository;
import com.artlanguage.checkIn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CheckInService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CheckInRepository checkInRepository;
    @Autowired
    private CheckInUserRepository checkInUserRepository;
    @Autowired
    private UserMapper userMapper;

    public HashMap<Object, Object> checkIn(CheckInRequest checkInRequest) {
        HashMap<Object, Object> msg = new HashMap<>();
        CheckIn checkIn= CheckIn.builder()
                .locationId(checkInRequest.getLocationId())
                .userId(checkInRequest.getInitiatorId())
                .build();
//      checkIn.setLocationId(checkInRequest.getLocationId());
//      checkIn.setUserId(checkInRequest.getInitiatorId());
        try{

            checkInRepository.save(checkIn);
            msg.put("success", "saved main check in successfully");

        }catch (Exception e){
            msg.put("error", "can not save main check in");


        }


        // Find the initiator (the user who is checking in)
        Users initiator = userRepository.findById(checkInRequest.getInitiatorId())
                .orElseThrow(() -> new RuntimeException("USER NOT FOUND!"));

        // Save initiator check-in information
        CheckInUser checkInUser = CheckInUser.builder()
                .checkIn(checkIn)
                .user(initiator)
                .isInitiator(true)
                .build();

//        checkInUser.setCheckIn(checkIn);
//        checkInUser.setUser(initiator);
//        checkInUser.setIsInitiator(true);

        try{
            checkInUserRepository.save(checkInUser);
            msg.put("success", "saved initiator check in successfully");
        }
        catch (Exception e){
            msg.put("error", "can not save initiator check in");
        }

        // Get friends and save their check-in details
        List<Users> friends = new ArrayList<>();
        List<Integer> friendIds = checkInRequest.getFriendsId();
        if (friendIds != null) {
            for (Integer friendId : friendIds) {
                try {
                    Optional<Users> friendOpt = userRepository.findById(friendId);
                    if (friendOpt.isPresent()) {
                        Users friend = friendOpt.get();

                        CheckInUser checkInFriend = CheckInUser.builder()
                                .checkIn(checkIn)
                                .user(friend)
                                .isInitiator(false)
                                .build();
                        checkInUserRepository.save(checkInFriend);

                        friends.add(friend);  // Add friend to list
                    } else {
                        msg.put("error", "Friend not found with ID: " + friendId);
                    }
                    msg.put("success", "saved check in successfully");

                } catch (Exception e) {
                    msg.put("error", "Exception occurred while processing friend with ID: " + friendId);
                }
            }


        }

//        // Convert initiator and friends to UsersResponseDTO
//        List<UsersResponseDTO> userResponseDTOs = new ArrayList<>();
//        userResponseDTOs.add(userMapper.toResponseDto(initiator));  // Add initiator to DTO list
//        friends.forEach(friend -> userResponseDTOs.add(userMapper.toResponseDto(friend)));  // Add friends to DTO list

        return msg;
    }
}
