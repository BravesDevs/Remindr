package com.dev.remindr.Event;

import com.dev.remindr.User.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "Event")
@Table(name = "event", uniqueConstraints = {

})
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
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "user_id_fk"))
    private User user;
    @Transient
    private int units;

    public enum Unit {
        MINUTE(60),
        HOUR(3600),
        DAY(86400);
        private final int i;

        Unit(int i) {
            this.i = i;
        }

        public int toSeconds(int amount) {
            return amount * this.i;
        }
    }

    @Transient
    private Unit unit;

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

    public int getUnits() {
        if (this.unit == null) {
            return 1;
        }
        return units;
    }

    public Unit getUnit() {
        if (this.unit == null) {
            return Unit.HOUR;
        }
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setUnits(int units) {
        this.units = units;

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

    public Event(String name, String description, Date dueDate, Date reminderDate, User user) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.reminderDate = reminderDate;
        this.user = user;
        this.units = 1;
        this.unit = Unit.HOUR;
    }

    public Event(Long id, String name, String description, Date dueDate, Date reminderDate, User user, int units, Unit unit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.reminderDate = reminderDate;
        this.user = user;
        this.units = units;
        this.unit = unit;
    }

    public Event(String name, String description, Date dueDate, Date reminderDate, User user, int units, Unit unit) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.reminderDate = reminderDate;
        this.user = user;
        this.units = units;
        this.unit = unit;
    }
}
