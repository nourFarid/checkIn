package com.artlanguage.checkIn.repository;

import com.artlanguage.checkIn.entity.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn,Integer> {
}
