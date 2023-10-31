package com.congressional.techconnect.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public void addSchool(School school) throws Exception {
        Optional<School> shOptional = schoolRepository.
                findSchoolByEmail(school.getEmail());
        // make sure you have a Commack email
        if(shOptional.isPresent())
            throw new Exception("Email already registered");
        schoolRepository.save(school);
    }


    /**
     * Returns a school object, given the email and password  (for login)
     * @param email     given email
     * @param passwd    given password
     * @return Returns a school object, given the email and password
     */
    public School getSchool(String email, String passwd) {
        Optional<School> schoolOptional = schoolRepository.
                findSchoolByEmail(email);
        if(schoolOptional.isPresent()) {
            School school = schoolOptional.get();
            // check passwd
            if (school.getPasswd().equals(passwd)) {
                return school;
            } else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public List<School> getAllParticipatingSchools() {
        return schoolRepository.findAll();
    }
}
