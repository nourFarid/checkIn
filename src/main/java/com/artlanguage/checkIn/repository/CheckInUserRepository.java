package com.artlanguage.checkIn.repository;

import com.artlanguage.checkIn.entity.CheckInUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInUserRepository extends JpaRepository<CheckInUser,Integer> {
}
