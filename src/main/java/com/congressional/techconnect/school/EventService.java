package com.congressional.techconnect.school;

import com.congressional.techconnect.seniorinfo.TechRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    EventDepository eventDepository;

    @Autowired
    public EventService(EventDepository eventDepository) {
        this.eventDepository = eventDepository;
    }

    /**
     * Returns list of event objects, given schoolId
     *
     * @param schoolId schoolId
     * @return returns list of event objects
     */
    public List<Event> getUpcomingEvents(Long schoolId) {
        List<Event> schoolEvents = eventDepository.
                findUpcomingSchoolEvents(schoolId, LocalDateTime.now());
        return schoolEvents;
    }

    /**
     * Returns list of event objects, given schoolId
     *
     * @param schoolId schoolId
     * @return returns list of event objects
     */
    public List<Event> getPastEvents(Long schoolId) {
        List<Event> schoolEvents = eventDepository.
                findPastSchoolEvents(schoolId, LocalDateTime.now());
        return schoolEvents;
    }

    public void addEvent(Event event) {
        eventDepository.save(event);
    }

    public void deleteEvent(Event event) {
        eventDepository.delete(event);
    }

    public List<Event> getAllUpcomingEvents() {
        return eventDepository.getAllUpcomingEvents(LocalDateTime.now());
    }

    public void removeEventById(Integer eventId) {
        eventDepository.deleteById(eventId);
    }

    public Optional<Event> getEvent(Integer id) {
        return eventDepository.findById(id);
    }
}
