package com.congressional.techconnect.seniorinfo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TechRequestRepository extends JpaRepository<TechRequest, Integer> {
    @Query("SELECT s FROM TechRequest s WHERE s.requestFromEmail = ?1")
    List<TechRequest> findTechRequestByEmail(String email);
}
