package com.dev.remindr.User;

import com.dev.remindr.Event.Event;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "User")
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique", columnNames = "email"),
        @UniqueConstraint(name = "user_id_unique", columnNames = "id")
})
public class User {

    @Id
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Event> events;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '}';
    }

    public User() {
    }

    public User(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public User(String email) {
        this.email = email;
    }
}
