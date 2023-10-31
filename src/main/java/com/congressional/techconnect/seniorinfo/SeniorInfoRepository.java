package com.congressional.techconnect.seniorinfo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This class represents the repository for the SeniorInfos table in the database
 */
@Repository
@Transactional
public interface SeniorInfoRepository
        extends JpaRepository<SeniorInfo, Integer> {

    @Query("SELECT s FROM SeniorInfo s WHERE s.id = ?1")
    SeniorInfo findSeniorInfoById(Long homeId);

    @Query("SELECT s FROM SeniorInfo s WHERE s.email = ?1")
    Optional<SeniorInfo> findSeniorInfoByEmail(String email);

}
