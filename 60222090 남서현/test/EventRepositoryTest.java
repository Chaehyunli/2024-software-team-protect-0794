package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EventRepositoryTests {
    private EventRepository eventRepository;
    private Event testEvent;

    @BeforeEach
    void setUp() {
        eventRepository = new EventRepository();
        testEvent = new Event(1, 100, "XX동아리 설명회", "설명회~~~", LocalDateTime.now(), LocalDateTime.now().plusDays(2), "명지대 자연캠퍼스 5공학관 4층 Y5411");
    }

    @Test
    void saveEvent_NewEvent_ReturnsTrue() {
        boolean result = eventRepository.save_Event(testEvent);
        assertTrue(result, "첫 번째 저장에서는 행사가 저장되어야 합니다.");
    }

    @Test
    void saveEvent_ExistingEvent_ReturnsFalse() {
        eventRepository.save_Event(testEvent);
        Event duplicateEvent = new Event(1, 100, "XX동아리 개파", "개강파티~~", LocalDateTime.now(), LocalDateTime.now().plusDays(1), "역북동");
        boolean result = eventRepository.save_Event(duplicateEvent);
        assertFalse(result, "이미 존재하는 이벤트 ID로 저장하려고 하면 실패해야 합니다.");
    }

    @Test
    void updateEvent_ExistingEvent_UpdatesData() {
        eventRepository.save_Event(testEvent);
        Event updatedEvent = new Event(1, 100, "XX동아리 설명회", "설명회!!", LocalDateTime.now(), LocalDateTime.now().plusDays(3), "명지대 자연캠퍼스 5공학관 4층 Y5411");
        boolean result = eventRepository.update_Event(updatedEvent);
        assertTrue(result, "기존 이벤트 업데이트 시 true를 반환해야 합니다.");
    }

    @Test
    void deleteEvent_ExistingEvent_ReturnsTrue() {
        eventRepository.save_Event(testEvent);
        boolean result = eventRepository.delete_Event(1);
        assertTrue(result, "기존 이벤트를 삭제할 경우 true를 반환해야 합니다.");
        assertNull(eventRepository.get_Event(1), "삭제된 이벤트는 조회되어서는 안 됩니다.");
    }

    @Test
    void getAllEvents_ReturnsAllEvents() {
        Event anotherEvent = new Event(2, 200, "OO동아리 설명회", "설명회~~", LocalDateTime.now(), LocalDateTime.now().plusDays(1), "미정");
        eventRepository.save_Event(testEvent);
        eventRepository.save_Event(anotherEvent);
        List<Event> events = eventRepository.getAllEvents();
        assertEquals(2, events.size(), "저장된 모든 이벤트를 반환해야 합니다.");
    }

    @Test
    void getEventsByClub_CorrectClubId_ReturnsFilteredEvents() {
        eventRepository.save_Event(testEvent);
        Event anotherEvent = new Event(2, 100, "OO 동아리 미정", "미정", LocalDateTime.now(), LocalDateTime.now().plusHours(24), "미정");
        eventRepository.save_Event(anotherEvent);
        List<Event> events = eventRepository.getEventsByClub(100);
        assertEquals(2, events.size(), "동일 동아리 ID로 필터링된 이벤트들을 반환해야 합니다.");
        assertTrue(events.stream().allMatch(e -> e.getClubId() == 100), "모든 이벤트는 동일 클럽 ID를 가져야한다.");
    }
}
