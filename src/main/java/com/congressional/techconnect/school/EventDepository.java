package com.congressional.techconnect.school;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface EventDepository
        extends JpaRepository<Event, Integer> {
    @Query("SELECT e FROM Event e WHERE e.schoolId = :schoolId")
    List<Event> getAllEventsForSchoolId(@Param("schoolId") Long sid);

    @Query("SELECT e from Event e where e.schoolId = :schoolId and e.eventDateTime >= :currentDateTime order by e.eventDateTime")
    List<Event> findUpcomingSchoolEvents(@Param("schoolId") Long schoolId, @Param("currentDateTime") LocalDateTime currentDateTime);

    @Query("SELECT e from Event e where e.schoolId = :schoolId and e.eventDateTime < :currentDateTime order by e.eventDateTime")
    List<Event> findPastSchoolEvents(@Param("schoolId") Long schoolId, @Param("currentDateTime") LocalDateTime currentDateTime);

    @Query("SELECT e from Event e where e.eventDateTime > :currentDateTime order by e.eventDateTime")
    List<Event> getAllUpcomingEvents(@Param("currentDateTime") LocalDateTime currentDateTime);
}
