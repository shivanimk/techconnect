package com.congressional.techconnect.school;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface SchoolRepository
        extends JpaRepository<School, Integer> {
    @Query("SELECT s FROM School s WHERE s.email = ?1")
    Optional<School> findSchoolByEmail(String email);

    @Query("SELECT s FROM School s WHERE s.schoolId = ?1")
    School findSchoolById(int schoolId);
}
