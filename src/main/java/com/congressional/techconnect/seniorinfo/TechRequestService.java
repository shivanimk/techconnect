package com.congressional.techconnect.seniorinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechRequestService {
    TechRequestRepository techRequestRepository;

    @Autowired
    public TechRequestService(TechRequestRepository techRequestRepository) {
        this.techRequestRepository = techRequestRepository;
    }

    List<TechRequest> getTechRequests(String email) {
        return techRequestRepository.findTechRequestByEmail(email);
    }

    public void addRequest(TechRequest request) {
        techRequestRepository.save(request);
    }

    public List<TechRequest> getAllTechRequests() {
        return techRequestRepository.findAll();
    }

    public void removeRequestById(Integer requestId) {
        techRequestRepository.deleteById(requestId);
    }

    public Optional<TechRequest> getRequest(Integer id) {
        return techRequestRepository.findById(id);
    }
}
