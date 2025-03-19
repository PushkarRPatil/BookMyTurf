package com.example.sport.repository;

import com.example.sport.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findByGroundId(Long groundId); // Fetch slots for a specific ground
    @Query("SELECT DISTINCT s.ground.id FROM Slot s")
    List<Long> findDistinctGroundIds();
    
    @Query("SELECT DISTINCT s.ground.id FROM Slot s")
    List<Long> findUsedGroundIds();
    
    boolean existsByGroundIdAndStartTimeAndEndTime(Long groundId, LocalTime startTime, LocalTime endTime);
}
