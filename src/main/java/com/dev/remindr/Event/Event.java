package com.dev.remindr.Event;

import com.dev.remindr.User.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "Event")
public class Event {
    @Id
    @SequenceGenerator(name = "event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "due_date", nullable = false, columnDefinition = "DATETIME")
    private Date dueDate;

    @Column(name = "reminder_date", nullable = false, columnDefinition = "DATETIME")
    private Date reminderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", reminderDate=" + reminderDate +
                ", user=" + user +
                '}';
    }

    public Event() {
    }

    public Event(Long id, String name, String description, Date dueDate, Date reminderDate, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.reminderDate = reminderDate;
        this.user = user;
    }

    public Event(String name, String description, Date dueDate, Date reminderDate, User user) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.reminderDate = reminderDate;
        this.user = user;
    }
}
