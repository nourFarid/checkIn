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
import java.util.List;

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

    public List<UsersResponseDTO> checkIn(@RequestBody CheckInRequest checkInRequest) {
        CheckIn checkIn = new CheckIn();
        checkIn.setLocationId(checkInRequest.getLocationId());
        checkIn.setUserId(checkInRequest.getInitiatorId());
        checkInRepository.save(checkIn);

        // Find the initiator (the user who is checking in)
        Users initiator = userRepository.findById(checkInRequest.getInitiatorId())
                .orElseThrow(() -> new RuntimeException("USER NOT FOUND!"));

        // Save initiator check-in information
        CheckInUser checkInUser = new CheckInUser();
        checkInUser.setCheckIn(checkIn);
        checkInUser.setUser(initiator);
        checkInUser.setIsInitiator(true);
        checkInUserRepository.save(checkInUser);

        // Get friends and save their check-in details
        List<Users> friends = new ArrayList<>();
        List<Integer> friendIds = checkInRequest.getFriendsId();
        if (friendIds != null) {
            for (Integer friendId : friendIds) {
                Users friend = userRepository.findById(friendId)
                        .orElseThrow(() -> new RuntimeException("Friend not found"));

                CheckInUser checkInFriend = new CheckInUser();
                checkInFriend.setCheckIn(checkIn);
                checkInFriend.setUser(friend);
                checkInFriend.setIsInitiator(false);
                checkInUserRepository.save(checkInFriend);

                friends.add(friend);  // Add friend to list
            }
        }

        // Convert initiator and friends to UsersResponseDTO
        List<UsersResponseDTO> userResponseDTOs = new ArrayList<>();
        userResponseDTOs.add(userMapper.toResponseDto(initiator));  // Add initiator to DTO list
        friends.forEach(friend -> userResponseDTOs.add(userMapper.toResponseDto(friend)));  // Add friends to DTO list

        return userResponseDTOs;
    }
}
