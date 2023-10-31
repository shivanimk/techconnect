package com.congressional.techconnect.school;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Event {
    @Id
    @SequenceGenerator(name = "event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "event_sequence"
    )
    private Long id;
    private Long schoolId;
    private String schoolName;
    private LocalDateTime eventDateTime;
    private String duration;
    private String location;
    private Long seniorHomeId;
    private String title;
    private String description;

    public Event() {
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public Event(Long schoolId, String schoolName, LocalDateTime eventDateTime, String duration, String location, Long seniorHomeId, String title, String description) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.eventDateTime = eventDateTime;
        this.duration = duration;
        this.location = location;
        this.seniorHomeId = seniorHomeId;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getSeniorHomeId() {
        return seniorHomeId;
    }

    public void setSeniorHomeId(Long seniorHomeId) {
        this.seniorHomeId = seniorHomeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
