package com.congressional.techconnect.seniorinfo;

import jakarta.persistence.*;

@Entity
@Table
public class TechRequest {
    @Id
    @SequenceGenerator(name = "TechRequest_sequence",
            sequenceName = "TechRequest_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "TechRequest_sequence"
    )
    private Long id;
    String topic;
    String requestDescription;
    String requestFromEmail;
    String requestFromName;

    public TechRequest() {
    }

    public TechRequest(String topic, String requestDescription, String requestFromEmail, String requestFromName) {
        this.topic = topic;
        this.requestDescription = requestDescription;
        this.requestFromEmail = requestFromEmail;
        this.requestFromName = requestFromName;
    }

    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public String getRequestFromEmail() {
        return requestFromEmail;
    }

    public void setRequestFromEmail(String requestFromEmail) {
        this.requestFromEmail = requestFromEmail;
    }

    public String getRequestFromName() {
        return requestFromName;
    }

    public void setRequestFromName(String requestFromName) {
        this.requestFromName = requestFromName;
    }

    @Override
    public String toString() {
        return "TechRequest{" +
                "topic='" + topic + '\'' +
                ", requestDescription='" + requestDescription + '\'' +
                ", requestFromEmail='" + requestFromEmail + '\'' +
                ", requestFromName='" + requestFromName + '\'' +
                '}';
    }
}
