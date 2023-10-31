package com.congressional.techconnect.seniorinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *  This class represents the Service class for the SeniorHomes
 */
@Service
public class SeniorInfoService {
    SeniorInfoRepository seniorInfoRepository;

    @Autowired
    public SeniorInfoService(SeniorInfoRepository seniorInfoRepository) {
        this.seniorInfoRepository = seniorInfoRepository;
    }

    /**
     * Saves a new student to the SeniorInfoRepository.
     * Checks if email is already registered
     * @param seniorInfo New Senior to be added
     * @throws Exception when fails
     */
    public void addNewSeniorInfo(SeniorInfo seniorInfo) throws Exception {
        Optional<SeniorInfo> shOptional = seniorInfoRepository.
                findSeniorInfoByEmail(seniorInfo.getEmail());
        // make sure you have a Commack email
        if(shOptional.isPresent())
            throw new Exception("Email already registered");
//        Student studentIdCheck = SeniorInfosRepository.findSeniorHomeById(seniorHome.g());
//        if(studentIdCheck != null)
//            throw new Exception("Student ID already registered");
//        if(!(student.getEmail().contains("@commack.k12.ny.us")))
//            throw new Exception("invalid email");

        seniorInfoRepository.save(seniorInfo);
    }

    /**
     * Returns a student object, given the email and password  (for login)
     * @param email     given email
     * @param passwd    given password
     * @return Returns a student object, given the email and password
     */
    public SeniorInfo getSeniorInfo(String email, String passwd) {
        Optional<SeniorInfo> shOptional = seniorInfoRepository.
                findSeniorInfoByEmail(email);
        if(shOptional.isPresent()) {
            SeniorInfo seniorInfo = shOptional.get();
            // check passwd
            if (seniorInfo.getPasswd().equals(passwd)) {
                return seniorInfo;
            } else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public List<SeniorInfo> getAllUsers() {
        return seniorInfoRepository.findAll();
    }
}
