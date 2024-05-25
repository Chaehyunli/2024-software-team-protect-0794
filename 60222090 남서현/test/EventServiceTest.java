package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class EventServiceTests {
    @Mock
    private EventRepository eventRepository;

    private EventService eventService;

    private Event event;
    private int eventId = 1;
    private int clubId = 100;
    private String title = "XX동아리";
    private String description = "설명~~~";
    private String location = "명지대 자연캠퍼스 5공학관 4층 Y5411";
    private LocalDateTime startDate = LocalDateTime.of(2024, 5, 20, 10, 0);
    private LocalDateTime endDate = LocalDateTime.of(2024, 5, 22, 10, 0);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        eventService = new EventService(eventRepository, null);
        event = new Event(eventId, clubId, title, description, startDate, endDate, location);

        when(eventRepository.get_Event(eventId)).thenReturn(event);
        when(eventRepository.update_Event(any(Event.class))).thenReturn(true);
    }

    @Test
    void postponeEvent_Successful() {
        LocalDateTime newStartDate = startDate.plusDays(2);
        LocalDateTime newEndDate = endDate.plusDays(2);
        assertTrue(eventService.postponeEvent(eventId, newStartDate, newEndDate), "이벤트 연기가 성공적으로 수행되어야 합니다.");
    }

    @Test
    void updateEventTitle_Successful() {
        String newTitle = "새로운 제목";
        assertTrue(eventService.updateEventTitle(eventId, newTitle), "이벤트 제목 업데이트가 성공적으로 수행되어야 합니다.");
        assertEquals(newTitle, event.getTitle(), "이벤트 제목이 업데이트되어야 합니다.");
    }

    @Test
    void updateEventDescription_Successful() {
        String newDescription = "새로운 설명";
        assertTrue(eventService.updateEventDescription(eventId, newDescription), "이벤트 설명 업데이트가 성공적으로 수행되어야 합니다.");
        assertEquals(newDescription, event.getDescription(), "이벤트 설명이 업데이트되어야 합니다.");
    }

    @Test
    void updateEventLocation_Successful() {
        String newLocation = "새로운 위치";
        assertTrue(eventService.updateEventLocation(eventId, newLocation), "이벤트 위치 업데이트가 성공적으로 수행되어야 합니다.");
        assertEquals(newLocation, event.getLocation(), "이벤트 위치가 업데이트되어야 합니다.");
    }

    @Test
    void extendEvent_Successful() {
        LocalDateTime newEndDate = endDate.plusDays(5);
        assertTrue(eventService.extendEvent(eventId, newEndDate), "이벤트 기간 연장이 성공적으로 수행되어야 합니다.");
        assertEquals(newEndDate, event.getEndDate(), "이벤트 종료 날짜가 연장되어야 합니다.");
    }
}
