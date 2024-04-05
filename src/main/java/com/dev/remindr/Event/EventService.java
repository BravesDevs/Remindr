package com.dev.remindr.Event;

import com.dev.remindr.common.Helpers;
import com.dev.remindr.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event addEvent(Event event) {
        try {
            if (event.getName().isEmpty()) {
                throw new ApiRequestException("Event name cannot be empty");
            }
            if (event.getDescription().isEmpty()) {
                throw new ApiRequestException("Event description cannot be empty");
            }
            if (event.getDueDate() == null) {
                throw new ApiRequestException("Event due date cannot be empty");
            }

            // Setting the reminder date
            event.setReminderDate(Helpers.getDifferenceDate(event));

            return this.eventRepository.save(event);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }
    }

    public List<Event> getEvents(Long id) {
        return this.eventRepository.findAllByUserId(id);
    }

    public void deleteEvent(Long id) {
        this.eventRepository.deleteById(id);
    }
}
