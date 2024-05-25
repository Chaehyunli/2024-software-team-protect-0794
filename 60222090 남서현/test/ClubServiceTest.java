package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ClubServiceTests {
    @Mock
    private ClubRepository clubRepository;

    private ClubService clubService;

    private int clubId = 100;
    private Member member;
    private Event event;
    private Announcement announcement;
    private RealClub club;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clubService = new ClubService(clubRepository);
        club = new RealClub(clubId, "XX동아리", "XX", "2022", "XX", "dd@mju.ac.kr");
        member = new Member();
        event = new Event(1, clubId, null, null, null, null, null);
        announcement = new Announcement(1, clubId, null, null, null, null, null);

        when(clubRepository.get_Club(clubId)).thenReturn(club);
        when(clubRepository.update_Club(any(RealClub.class))).thenReturn(true);
    }

    @Test
    void addMemberToClub_Successful() {
        assertTrue(clubService.addMemberToClub(clubId, member), "동아리에 멤버를 추가하는 데 성공해야 합니다.");
    }

    @Test
    void removeMemberFromClub_Successful() {
        assertTrue(clubService.removeMemberFromClub(clubId, member), "동아리에서 멤버를 제거하는 데 성공해야 합니다.");
    }

    @Test
    void addEventToClub_Successful() {
        assertTrue(clubService.addEventToClub(clubId, event), "동아리에 이벤트를 추가하는 데 성공해야 합니다.");
    }

    @Test
    void removeEventFromClub_Successful() {
        assertTrue(clubService.removeEventFromClub(clubId, event), "동아리에서 이벤트를 제거하는 데 성공해야 합니다.");
    }

    @Test
    void addAnnouncementToClub_Successful() {
        assertTrue(clubService.addAnnouncementToClub(clubId, announcement), "동아리에 공지사항을 추가하는 데 성공해야 합니다.");
    }

    @Test
    void removeAnnouncementFromClub_Successful() {
        assertTrue(clubService.removeAnnouncementFromClub(clubId, announcement), "동아리에서 공지사항을 제거하는 데 성공해야 합니다.");
    }
}
