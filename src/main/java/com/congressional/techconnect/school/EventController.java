package com.congressional.techconnect.school;

import com.congressional.techconnect.seniorinfo.TechRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class EventController {
    EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/upcomingevents")
    public String getUpcomingEvents(Long schoolId, Model model) {
        List<Event> upcomingEvents = eventService.getUpcomingEvents(schoolId);
        model.addAttribute("upcomingevents", upcomingEvents);
        return "schoolupcomingevents";
    }

    @GetMapping("/allupcomingevents")
    public String getAllUpcomingEvents(Model model) {
        List<Event> upcomingEvents = eventService.getAllUpcomingEvents();
        model.addAttribute("allupcomingevents", upcomingEvents);
        return "upcomingevents";
    }

    @PostMapping("/addevent")
    public String addEvent(@ModelAttribute Event event, Long schoolId, String schoolName, Model model) {
        event.setSchoolId(schoolId);
        event.setSchoolName(schoolName);
        eventService.addEvent(event);
        List<Event> upcomingEvents = eventService.getUpcomingEvents(schoolId);
        model.addAttribute("upcomingevents", upcomingEvents);
        return "schoolupcomingevents";
    }

    @PostMapping("/deleteevent")
    public String deleteEvent(@RequestParam Integer eventId, Model model) {
        Optional<Event> requestOptional = eventService.getEvent(eventId);
        Event event = requestOptional.get();
        eventService.removeEventById(eventId);
        List<Event> upcomingEvents = eventService.getUpcomingEvents(event.getSchoolId());
        model.addAttribute("upcomingevents", upcomingEvents);
        return "schoolupcomingevents";
    }
}
