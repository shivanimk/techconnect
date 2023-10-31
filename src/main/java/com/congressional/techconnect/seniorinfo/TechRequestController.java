package com.congressional.techconnect.seniorinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class TechRequestController {
    TechRequestService techRequestService;

    @Autowired
    public TechRequestController(TechRequestService techRequestService) {
        this.techRequestService = techRequestService;
    }

    @PostMapping("/requests")
    public String getRequestsByEmail(String email, Model model) {
        List<TechRequest> requests = techRequestService.getTechRequests(email);
        model.addAttribute("myrequests", requests);
        return "requests";
    }

    @GetMapping("/allrequests")
    public String getAllRequests(Model model) {
        List<TechRequest> requests = techRequestService.getAllTechRequests();
        model.addAttribute("allrequests", requests);
        return "schoolrequests";
    }

    @PostMapping("/addrequest")
    public String addRequest(TechRequest request, Model model) {
        techRequestService.addRequest(request);
        List<TechRequest> requests = techRequestService.getTechRequests(request.getRequestFromEmail());
        model.addAttribute("myrequests", requests);
        return "requests";
    }

    @PostMapping("/removerequest")
    public String removeRequest(@RequestParam Integer requestId, Model model) {
        Optional<TechRequest> requestOptional = techRequestService.getRequest(requestId);
        TechRequest request = requestOptional.get();
        techRequestService.removeRequestById(requestId);
        List<TechRequest> requests = techRequestService.getTechRequests(request.getRequestFromEmail());
        model.addAttribute("myrequests", requests);
        return "requests";
    }

}
