package com.dev.remindr.User;

import com.dev.remindr.Event.Event;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "User")
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
})
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Event> events;
}
