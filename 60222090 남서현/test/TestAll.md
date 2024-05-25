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
- testcase
  1. id : 1, club_id : 100, title : XX동아리, description : 설명~~~, startDate : 2024-05-20 10:00, endDate : 2024-05-22 10:00, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
    - postponeEvent_Successful : PASS
      <br> newStartDate : startDate+days2, newEndDate : endDate+days2
    - updateEventTitle_Successful : PASS
      <br> newTitle : 새로운 제목
    - updateEventDescription_Successful : PASS
      <br> newDescription : 새로운 설명
    - updateEventLocation_Successful : PASS
      <br> newLocation : 새로운 위치
    - extendEvent_Successful : PASS
      <br> newEndDate : endDate+days5
  
  2. id : 3, club_id : 200, title : XO동아리, description : 설명~~~, startDate : 2024-05-22 10:00, endDate : 2024-05-24 10:00, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
    - postponeEvent_Successful : PASS
      <br> newStartDate : startDate+days4, newEndDate : endDate+days5
    - updateEventTitle_Successful : PASS
      <br> newTitle : 새로운 제목
    - updateEventDescription_Successful : PASS
      <br> newDescription : 새로운 설명
    - updateEventLocation_Successful : PASS
      <br> newLocation : 새로운 위치
    - extendEvent_Successful : PASS
      <br> newEndDate : endDate+days1

  3. id : 2, club_id : 300, title : WW동아리, description : 설명~~~, startDate : 2024-12-20 08:00, endDate : 2024-12-22 10:00, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
    - postponeEvent_Successful : PASS
      <br> newStartDate : startDate+days4, newEndDate : endDate+days4
    - updateEventTitle_Successful : PASS
      <br> newTitle : 새로운 제목
    - updateEventDescription_Successful : PASS
      <br> newDescription : 새로운 설명
    - updateEventLocation_Successful : PASS
      <br> newLocation : 새로운 위치
    - extendEvent_Successful : PASS
      <br> newEndDate : endDate+days5

  4. id : 1, club_id : 100, title : XX동아리, description : 설명~~~, startDate : 2024-11-20 10:00, endDate : 2024-11-25 12:00, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
    - postponeEvent_Successful : PASS
      <br> newStartDate : startDate+days10, newEndDate : endDate+days12
    - updateEventTitle_Successful : PASS
      <br> newTitle : 새로운 제목
    - updateEventDescription_Successful : PASS
      <br> newDescription : 새로운 설명
    - updateEventLocation_Successful : PASS
      <br> newLocation : 새로운 위치
    - extendEvent_Successful : PASS
      <br> newEndDate : endDate+days10

  5. id : 1, club_id : 400, title : OX동아리, description : 설명~~~, startDate : 2025-05-20 08:00, endDate : 2025-05-22 22:00, location :
명지대 자연캠퍼스 5공학관 4층 Y5411
    - postponeEvent_Successful : PASS
      <br> newStartDate : startDate+days10, newEndDate : endDate+days10
    - updateEventTitle_Successful : PASS
      <br> newTitle : 새로운 제목
    - updateEventDescription_Successful : PASS
      <br> newDescription : 새로운 설명
    - updateEventLocation_Successful : PASS
      <br> newLocation : 새로운 위치
    - extendEvent_Successful : PASS
      <br> newEndDate : endDate+days2

ClubService
- Method
  - addMemberToClub
  - removeMemberFromClub
  - addEventToClub
  - removeEventFromClub
  - addAnnouncementToClub
  - removeAnnouncementFromClub
- testcase
  1. clubId : 100, member, (event => id : 1, club_id : clubId, title : null, description : null, startDate : null, endDate : null, location : null), (announcement => id : 1, club_id : clubId, title : null, content : null, create_at : null, update_at : null, stateStack : null)
    - addMemberToClub : PASS
    - removeMemberFromClub : PASS
    - addEventToClub : PASS
    - removeEventFromClub : PASS
    - addAnnouncementToClub : PASS
    - removeAnnouncementFromClub : PASS

  2. clubId : 200, member, (event => id : 2, club_id : clubId, title : null, description : null, startDate : null, endDate : null, location : null), (announcement => id : 3, club_id : clubId, title : null, content : null, create_at : null, update_at : null, stateStack : null)
    - addMemberToClub : PASS
    - removeMemberFromClub : PASS
    - addEventToClub : PASS
    - removeEventFromClub : PASS
    - addAnnouncementToClub : PASS
    - removeAnnouncementFromClub : PASS
 
  3. clubId : 300, member, (event => id : 5, club_id : clubId, title : null, description : null, startDate : null, endDate : null, location : null), (announcement => id : 1, club_id : clubId, title : null, content : null, create_at : null, update_at : null, stateStack : null)
    - addMemberToClub : PASS
    - removeMemberFromClub : PASS
    - addEventToClub : PASS
    - removeEventFromClub : PASS
    - addAnnouncementToClub : PASS
    - removeAnnouncementFromClub : PASS
 
  4. clubId : 200, member, (event => id : 2, club_id : clubId, title : null, description : null, startDate : null, endDate : null, location : null), (announcement => id : 1, club_id : clubId, title : null, content : null, create_at : null, update_at : null, stateStack : null)
    - addMemberToClub : PASS
    - removeMemberFromClub : PASS
    - addEventToClub : PASS
    - removeEventFromClub : PASS
    - addAnnouncementToClub : PASS
    - removeAnnouncementFromClub : PASS
 
  5. clubId : 500, member, (event => id : 5, club_id : clubId, title : null, description : null, startDate : null, endDate : null, location : null), (announcement => id : 3, club_id : clubId, title : null, content : null, create_at : null, update_at : null, stateStack : null)
    - addMemberToClub : PASS
    - removeMemberFromClub : PASS
    - addEventToClub : PASS
    - removeEventFromClub : PASS
    - addAnnouncementToClub : PASS
    - removeAnnouncementFromClub : PASS
