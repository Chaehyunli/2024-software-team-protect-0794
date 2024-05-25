EventRepository
- Method
  - save_Event
  - update_Event
  - delete_Event
  - getAllEvents
  - getEventsByClub
- testcase
  1. id : 1, club_id : 100, title : XX동아리 설명회, description : 설명회~~~, start_date : now, end_date : now+days2, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
      - saveEvent_NewEvent_ReturnsTrue : PASS
      - saveEvent_ExistingEvent_ReturnsFalse : NPASS
         <br> => newEvent <br> id : 1, club_id : 100, title : XX동아리 개파, description : 개강파티~~~, start_date : now, end_date : now+days1, location :
역북동
      - updateEvent_ExistingEvent_UpdatesData : PASS
           <br> => newEvent <br> id : 1, club_id : 100, title : XX동아리 설명회, description : 설명회!!, start_date : now, end_date : now+days3, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
      - deleteEvent_ExistingEvent_ReturnsTrue : PASS
        <br> => deleteEvent <br> id : 1
      - getAllEvents_ReturnsAllEvents : PASS
           <br> => newEvent <br> id : 2, club_id : 100, title : XX동아리 설명회, description : 설명회~~, start_date : now, end_date : now+days1, location :
미정
      - getEventsByClub_CorrectClubId_ReturnsFilteredEvents : PASS
           <br> => newEvent <br> id : 2, club_id : 100, title : XX 동아리 미정, description : 미정, start_date : now, end_date : now+hours24, location :
미정
    
  2. id : 4, club_id : 200, title : XO동아리 설명회, description : 설명회~~~, start_date : now, end_date : now+days3, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
      - saveEvent_NewEvent_ReturnsTrue : PASS
      - saveEvent_ExistingEvent_ReturnsFalse : PASS
         <br> => newEvent <br> id : 2, club_id : 200, title : XO동아리 개파, description : 개강파티~~~, start_date : now, end_date : now+days1, location :
역북동
      - updateEvent_ExistingEvent_UpdatesData : PASS
           <br> => newEvent <br> id : 4, club_id : 200, title : XO동아리 설명회, description : 설명회!!, start_date : now, end_date : now+days3, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
      - deleteEvent_ExistingEvent_ReturnsTrue : PASS
        <br> => deleteEvent <br> id : 4
      - getAllEvents_ReturnsAllEvents : PASS
           <br> => newEvent <br> id : 2, club_id : 200, title : XO동아리 설명회, description : 설명회~~, start_date : now, end_date : now+days1, location :
미정
      - getEventsByClub_CorrectClubId_ReturnsFilteredEvents : NPASS
           <br> => newEvent <br> id : 2, club_id : 100, title : OO 동아리 미정, description : 미정, start_date : now, end_date : now+hours24, location :
미정

  3. id : 2, club_id : 300, title : OX동아리 설명회, description : 설명회~~~, start_date : now, end_date : now+days1, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
      - saveEvent_NewEvent_ReturnsTrue : PASS
      - saveEvent_ExistingEvent_ReturnsFalse : PASS
         <br> => newEvent <br> id : 1, club_id : 300, title : OX동아리 개파, description : 개강파티~~~, start_date : now, end_date : now+days1, location :
역북동
      - updateEvent_ExistingEvent_UpdatesData : PASS
           <br> => newEvent <br> id : 2, club_id : 300, title : OX동아리 설명회, description : 설명회!!, start_date : now, end_date : now+days3, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
      - deleteEvent_ExistingEvent_ReturnsTrue : PASS
        <br> => deleteEvent <br> id : 2
      - getAllEvents_ReturnsAllEvents : PASS
           <br> => newEvent <br> id : 1, club_id : 300, title : OX동아리 설명회, description : 설명회~~, start_date : now, end_date : now+days1, location :
미정
      - getEventsByClub_CorrectClubId_ReturnsFilteredEvents : PASS
           <br> => newEvent <br> id : 1, club_id : 300, title : OX 동아리 미정, description : 미정, start_date : now, end_date : now+hours24, location :
미정

  4. id : 5, club_id : 400, title : OO동아리 설명회, description : 설명회~~~, start_date : now, end_date : now+days2, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
      - saveEvent_NewEvent_ReturnsTrue : PASS
      - saveEvent_ExistingEvent_ReturnsFalse : PASS
         <br> => newEvent <br> id : 1, club_id : 400, title : XX동아리 개파, description : 개강파티~~~, start_date : now, end_date : now+days1, location :
역북동
      - updateEvent_ExistingEvent_UpdatesData : PASS
           <br> => newEvent <br> id : 5, club_id : 400, title : XX동아리 설명회, description : 설명회!!, start_date : now, end_date : now+days3, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
      - deleteEvent_ExistingEvent_ReturnsTrue : NPASS
        <br> => deleteEvent <br> id : 6
      - getAllEvents_ReturnsAllEvents : PASS
           <br> => newEvent <br> id : 2, club_id : 400, title : XX동아리 설명회, description : 설명회~~, start_date : now, end_date : now+days1, location :
미정
      - getEventsByClub_CorrectClubId_ReturnsFilteredEvents : PASS
           <br> => newEvent <br> id : 2, club_id : 400, title : XX 동아리 미정, description : 미정, start_date : now, end_date : now+hours24, location :
미정

  5. id : 3, club_id : 500, title : WW동아리 설명회, description : 설명회~~~, start_date : now, end_date : now+days3, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
      - saveEvent_NewEvent_ReturnsTrue : PASS
      - saveEvent_ExistingEvent_ReturnsFalse : PASS
         <br> => newEvent <br> id : 1, club_id : 500, title : WW동아리 개파, description : 개강파티~~~, start_date : now, end_date : now+days1, location :
역북동
      - updateEvent_ExistingEvent_UpdatesData : PASS
           <br> => newEvent <br> id : 3, club_id : 500, title : WW동아리 설명회, description : 설명회!!, start_date : now, end_date : now+days3, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
      - deleteEvent_ExistingEvent_ReturnsTrue : PASS
        <br> => deleteEvent <br> id : 3
      - getAllEvents_ReturnsAllEvents : PASS
           <br> => newEvent <br> id : 2, club_id : 500, title : WW동아리 설명회, description : 설명회~~, start_date : now, end_date : now+days1, location :
미정
      - getEventsByClub_CorrectClubId_ReturnsFilteredEvents : PASS
           <br> => newEvent <br> id : 2, club_id : 500, title : WW 동아리 미정, description : 미정, start_date : now, end_date : now+hours24, location :
미정

EventService
- Method
  - postponeEvent
  - updateEventTitle
  - updateEventDescription
  - updateEventLocation
  - extendEvent

ClubService
- Method
  - addMemberToClub
  - removeMemberFromClub
  - addEventToClub
  - removeEventFromClub
  - addAnnouncementToClub
  - removeAnnouncementFromClub
