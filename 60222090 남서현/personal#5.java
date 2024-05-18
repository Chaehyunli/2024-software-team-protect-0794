import java.time.LocalDateTime;
import java.util.*;

// Model
class Event{
    private int id;
    private int club_id;
    private String title;
    private String description;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String location;
    private List<Integer> participants;

    public Event(int id, int clubId, String title, String description, LocalDateTime startDate, LocalDateTime endDate, String location) {
        this.id = id;
        this.club_id = clubId;
        this.title = title;
        this.description = description;
        this.start_date = startDate;
        this.end_date = endDate;
        this.location = location;
        this.participants = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClubId() {
        return club_id;
    }

    public void setClubId(int clubId) {
        this.club_id = clubId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDate() {
        return start_date;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.start_date = startDate;
    }

    public LocalDateTime getEndDate() {
        return end_date;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.end_date = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Integer> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Integer> participants) {
        this.participants = participants;
    }

    public boolean create() {
        return true;
    }

    public boolean update() {
        return true;
    }

    public boolean delete() {
        return true;
    }

    public boolean register(int memberId) {
        if (participants.contains(memberId)) {
            return false; // 이미 등록된 경우 등록 실패
        }

        participants.add(memberId); // 새로운 참가자를 등록
        return true; // 등록 성공
    }
    
    public boolean unregister(int memberId) {
        if (!participants.contains(memberId)) {
            return false; // 등록되지 않은 참가자인 경우 해제 실패
        }
        
        participants.remove((Integer) memberId); // 참가자를 해제
        return true; // 동록 해제 성공
    }

    @Override
    public String toString() {
        return "이벤트 고유 식별자: " + id + "\n동아리 고유 식별자: " + club_id + "\n이벤트 제목: " + title +
               "\n이벤트 설명: " + description + ", 이벤트 시작 날짜: " + start_date +
               "\n이벤트 종료 날짜: " + end_date + "\n이벤트 장소: " + location + "\n이벤트 참가자: " + participants;
    }
}

interface Club{
    public boolean create();
    public boolean update();
    public boolean delete();
    public List<Member> get_members();
    public List<Event> get_events();
    public List<Announcement> get_announcements();
}

class Announcement{
    private int id;
    private int club_id;
    private String title;
    private String content;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    private Stack<AnnouncementMemento> stateStack;

    public Announcement(int id, int club_id, String title, String content, LocalDateTime created_at, LocalDateTime updated_at, Stack<AnnouncementMemento> stateStack) {
        this.id = id;
        this.club_id = club_id;
        this.title = title;
        this.content = content;
        this.create_at = created_at;
        this.update_at = updated_at;
        this.stateStack = stateStack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClubId() {
        return club_id;
    }

    public void setClubId(int club_id) {
        this.club_id = club_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return create_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.create_at = created_at;
    }

    public LocalDateTime getUpdatedAt() {
        return update_at;
    }

    public void setUpdatedAt(LocalDateTime updated_at) {
        this.update_at = updated_at;
    }

    public Stack<AnnouncementMemento> getStateStack() {
        return stateStack;
    }

    public void setStateStack(Stack<AnnouncementMemento> stateStack) {
        this.stateStack = stateStack;
    }

    public boolean create() {
        return true;
    }

    public boolean update() {
        return true;
    }

    public boolean delete() {
        return true;
    }

    public boolean publish() {
        return true;
    }

    public boolean unpublish() {
        return true;
    }

    private AnnouncementMemento createMemento() {
        return null;
    }

    private void setMemento(AnnouncementMemento m) {
        //
    }
}

class ApplicationStatus {
    private int club_id;
    private int member_id;
    private String status;

    public boolean updateStatus(String newStatus) {
        return true;
    }

    public int getClubId() {
        return club_id;
    }

    public int getMemberId() {
        return member_id;
    }

    public String getStatus() {
        return status;
    }
}

class Application{
	int id;
	int member_id;
	int club_id;
	String motivation;
	String activities;
	String self_introduction;
	
	public boolean create() {
		return true;
	}
	
	public boolean update() {
		return true;
	}
	
	public boolean delete() {
		return true;
	}
	
	public boolean sumbit() {
		return true;
	}
	
	public boolean withdraw() {
		return true;
	}
}

class Member {
	private int id;
	private String name;
	private int student_Id;
	private String email; 
	private String phone; 
	private String introduction;
	private String profile_Image;
	
	public static class Builder {
		public Builder setid(int id) {
			return this;
		}
		
		public Builder setname(String name) {
			return this;
		}

		public Builder setstudentId(int studentId) {
			return this;
		}
		
		public Builder setemail(String email) {
			return this;
		}
		
		public Builder setphone(String phone) {
			return this;
		}
		
		public Builder setintroduction(String introduction) {
			return this;
		}
		
		public Builder setprofileImage(String profileImage) {
			return this;
		}

		public Member build() {
			return new Member();
		}
	}

	public String getName() {
		return null;
	}

	public int getId() {
		return 0;
	}
	
	public int getStudentId() {
		return 0;
	}
	
	public String getEmail() {
		return null;
	}
	
	public String getPhone() {
		return null;
	}
	
	public String getIntroduction() {
		return null;
	}
	
	public String getProfileImage() {
		return null;
	}
	
	public boolean create() {
		return true;
	}
	
	public boolean update() {
		return true;
	}
	
	public boolean delete() {
		return true;
	}
	
	public boolean apply_club() {
		return true;
	}
	
	public boolean join_club() {
		return true;
	}
	
	public boolean leave_club() {
		return true;
	}
}

class ChatMessage{
	private int id;
	private int sender_id;
	private int receiver_id;
	private String content;
	private String sent_at;
	
	public boolean send(GroupElement group) {
		return true;
	}
	
	public boolean receive(GroupElement group) {
		return true;
	}
	
	public boolean delete(GroupElement group) {
		return true;
	}	
}

abstract class GroupElement {
    abstract void send();
    abstract void receive();
    abstract void delete();
}

class Survey {

    private int id;
    private int club_id;
    private String title;
    private String description;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String[] questions;

    public Boolean create(int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String[] questions) {
        return true;
    }

    public Boolean update(int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String[] questions) {
        return true;
    }

    public Boolean delete(int id) {
        return true;
    }

    public Boolean publish(int id) {
        return true;
    }

    public Boolean unPublish(int id) {
        return true;
    }

    public Boolean submit_response(int survey_id, int member_id, String[] responses) {
        return true;
    }

    public void attach(Observer observer) {

    }

    public void detach(Observer observer) {

    }

    public void my_notify() {

    }

}

class Observer {

    public void update(String old, String my_new) {

    }

}

class SurveyObserver extends Observer {

    @Override
    public void update(String old, String my_new) {

    }
}

class Board {

    private int id;
    private int club_id;
    private String name;
    private String description;

    public Boolean create(int club_id, String name, String description) {
        return true;
    }

    public Boolean update(int id, int club_id, String name, String description) {
        return true;
    }

    public Boolean delete(int id) {
        return true;
    }

    public BoardPost[] get_posts(int id) {

        BoardPost[] boardPosts = new BoardPost[1];

        return boardPosts;
    }
}

class Comment {
    //
}

class BoardPost {

    private int id;
    private int board_id;
    private int author_id;
    private String title;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Boolean create(int board_id, int author_id, String title, String content) {
        return true;
    }

    public Boolean update(int id, String title, String content) {
        return true;
    }

    public Boolean delete(int id) {
        return true;
    }

    public Comment[] get_comments(int post_id) {

        Comment[] comments = new Comment[1];

        return comments;
    }
}

// Repository
abstract class Repository{
    //
}

class ClubRepository extends Repository{
     private Map<Integer, RealClub> clubMap; // 동아리 정보를 저장하기 위한 맵

     public ClubRepository() {
         this.clubMap = new HashMap<>();
     }

     public boolean save_Club(RealClub c) {
         if (c == null || clubMap.containsKey(c.getId())) {
             return false;
             // c의 값이 비었을때 실패
         }

         clubMap.put(c.getId(), c);

         return c.create(); // 저장 성공
     }
 
     public RealClub get_Club(int club_id) {
         return clubMap.getOrDefault(club_id, null); // 해당 ID의 동아리 반환, 없으면 null 반환
     }
 
     public boolean update_Club(RealClub c) {
         if (c == null || !clubMap.containsKey(c.getId())) {
             return false;
             // c의 값이 비었을때 실패
         }

         clubMap.put(c.getId(), c); // 동아리 정보 갱신

         return c.update(); // 수정 성공
     }
 
     public boolean delete_Club(int club_id) {
         if (!clubMap.containsKey(club_id)) {
             return false; // 해당 ID를 가진 동아리가 존재하지 않으면 삭제 실패
         }

         clubMap.remove(club_id); // 동아리 정보 삭제

         return true; // 삭제 성공
     }
}

class AnnouncementRepository extends Repository {
    private Map<Integer, Announcement> announcementMap;

    public AnnouncementRepository() {
        this.announcementMap = new HashMap<>();
    }

    public boolean save_Announcement(Announcement a) {
        if (a == null) {
            return false;
            // a의 값이 비었을때 실패
        }

        int announcementId = a.getId();
        if (announcementMap.containsKey(announcementId)) {
            return false; // 이미 해당 ID를 가진 공지사항이 존재하면 저장 실패
        }

        announcementMap.put(announcementId, a);
        return a.create(); // 저장 성공
    }

    public Announcement get_Announcement(int announcement_id) {
        return announcementMap.getOrDefault(announcement_id, null); // 해당 ID의 공지사항 반환, 없으면 null 반환
    }

    public boolean update_Announcement(Announcement a) {
        if (a == null) {
            return false;
            // a의 값이 비었을때 실패
        }

        int announcementId = a.getId();

        announcementMap.put(announcementId, a); // 공지사항 정보 갱신
        return a.update(); // 수정 성공
    }

    public boolean delete_Announcement(int announcement_id) {
        announcementMap.remove(announcement_id); // 공지사항 정보 삭제

        return true; // 삭제 성공
    }
}

class EventRepository extends Repository {
    private Map<Integer, Event> eventMap;

    public EventRepository() {
        this.eventMap = new HashMap<>();
    }

    public boolean save_Event(Event event) {
        if (eventMap.containsKey(event.getId())) {
            // 이미 존재하는 이벤트 ID인 경우 저장 실패
            return false;
        }

        eventMap.put(event.getId(), event);

        return event.create(); // 저장 성공
    }

    public Event get_Event(int eventId) {
        return eventMap.get(eventId);
    }

    public boolean update_Event(Event event) {
        eventMap.put(event.getId(), event);
        
        return event.update(); // 수정 성공
    }

    public boolean delete_Event(int eventId) {        
        eventMap.remove(eventId);

        return true; // 삭제 성공
    }

    public List<Event> getAllEvents() {
        return eventMap.values().stream().collect(Collectors.toList());
    }

    public List<Event> getEventsByClub(int clubId) {
        return eventMap.values().stream()
                .filter(event -> event.getClubId() == clubId)
                .collect(Collectors.toList());
    }
}

class MemberRepository extends Repository{
    private List<Member> members;

    public MemberRepository() {
    }

    public boolean save(Member member) {
        return true;
    }

    public List<Member> findAll() {
        return null;
    }
}

class ChatRepository extends Repository{
	public void saveMessage(ChatMessage message) {
	}

	public List<ChatMessage> getAllMessages() {
		return null;
	}
}

class SurveyRepository extends Repository{
	public SurveyRepository() {
	}
	 public boolean saveSurvey(Survey survey) {
	        return true;
	    }

	    public Survey getSurvey(int id) {
	        return null;
	    }

	    public boolean updateSurvey(Survey survey) {
	        return true;
	    }

	    public boolean deleteSurvey(int id) {
	        return true;
	    }
}

class BoardRepository extends Repository{
    private BoardRepository instance;

    public Boolean save_board(Board board) {
        return true;
    }

    public Boolean get_board(int board_id) {
        return true;
    }

    public Boolean update_board(Board board) {
        return true;
    }

    public Boolean delete_board(int board_id) {
        return true;
    }

    public Boolean save_post(BoardPost post) {
        return true;
    }

    public BoardPost get_post(int post_id) {

        BoardPost boardPost = new BoardPost();
        return boardPost;
    }

    public Boolean update_post(BoardPost post) {
        return true;
    }

    public Boolean delete_post(int post_id) {
        return true;
    }

    public BoardRepository getInstance() {

        BoardRepository boardRepository = new BoardRepository();
        return boardRepository;

    }

}

class ApplicationRepository extends Repository{
    //
}

// Service
abstract class Service{
    //
}

class EventService extends Service {
    private EventEvent eventEvent;
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository, EventEvent eventEvent) {
        this.eventRepository = eventRepository;
        this.eventEvent = eventEvent;
    }

    public boolean createEvent(int id, int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String location) {
        Event event = new Event(id, club_id, title, description, start_date, end_date, location);

        return eventRepository.save_Event(event);
    }

    public boolean updateEvent(int id, int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String location) {
        Event event = eventRepository.get_Event(id);

        if (event == null) {
            return false; // 해당 ID의 이벤트가 존재하지 않으면 업데이트 실패
        }

        event.setClubId(club_id);
        event.setTitle(title);
        event.setDescription(description);
        event.setStartDate(start_date);
        event.setEndDate(end_date);
        event.setLocation(location);

        return eventRepository.update_Event(event);
    }

    public boolean deleteEvent(int id) {
        Event event = eventRepository.get_Event(id);
        if (event == null) {
            return false; // 해당 ID의 이벤트가 존재하지 않으면 삭제 실패
        }

        return eventRepository.delete_Event(id);
    }

    public boolean registerEvent(int eventId, int memberId) {
        Event event = eventRepository.get_Event(eventId);
        if (event == null) {
            return false;
        }
        return event.register(memberId);
    }

    public boolean unregisterEvent(int eventId, int memberId) {
        Event event = eventRepository.get_Event(eventId);
        if (event == null) {
            return false;
        }
        return event.unregister(memberId);
    }

    public Event getEvent(int eventId) {
        return eventRepository.get_Event(eventId);
    }

    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }

    public List<Event> getEventsByClub(int clubId) {
        return eventRepository.getEventsByClub(clubId);
    }

    // 일정 연기
    public boolean postponeEvent(int eventId, LocalDateTime newStartDate, LocalDateTime newEndDate) {
        Event event = eventRepository.get_Event(eventId);
        if (event == null) {
            return false;
        }
        event.setStartDate(newStartDate);
        event.setEndDate(newEndDate);
        return eventRepository.update_Event(event);
    }

    // TITLE 변경
    public boolean updateEventTitle(int eventId, String newTitle) {
        Event event = eventRepository.get_Event(eventId);
        if (event == null) {
            return false;
        }
        event.setTitle(newTitle);
        return eventRepository.update_Event(event);
    }

    // 내용 변경
    public boolean updateEventDescription(int eventId, String newDescription) {
        Event event = eventRepository.get_Event(eventId);
        if (event == null) {
            return false;
        }
        event.setDescription(newDescription);
        return eventRepository.update_Event(event);
    }

    // 위치 변경
    public boolean updateEventLocation(int eventId, String newLocation) {
        Event event = eventRepository.get_Event(eventId);
        if (event == null) {
            return false;
        }
        event.setLocation(newLocation);
        return eventRepository.update_Event(event);
    }

    // 기간 연장
    public boolean extendEvent(int eventId, LocalDateTime newEndDate) {
        Event event = eventRepository.get_Event(eventId);
        if (event == null) {
            return false;
        }
        event.setEndDate(newEndDate);
        return eventRepository.update_Event(event);
    }

    // 기간 단축
    public boolean shortenEvent(int eventId, LocalDateTime newEndDate) {
        Event event = eventRepository.get_Event(eventId);
        if (event == null) {
            return false;
        }
        if (newEndDate.isBefore(event.getStartDate())) {
            return false; // 새로운 종료 날짜가 시작 날짜보다 이전이면 실패
        }
        event.setEndDate(newEndDate);
        return eventRepository.update_Event(event);
    }

    // 일정 변경
    public boolean rescheduleEvent(int eventId, LocalDateTime newStartDate, LocalDateTime newEndDate) {
        Event event = eventRepository.get_Event(eventId);
        if (event == null) {
            return false;
        }
        event.setStartDate(newStartDate);
        event.setEndDate(newEndDate);
        return eventRepository.update_Event(event);
    }

    // 참가자 목록 반환
    public List<Integer> getEventParticipants(int eventId) {
        Event event = eventRepository.get_Event(eventId);
        if (event == null) {
            return null;
        }
        return event.getParticipants();
    }
}

class AnnouncementService  extends Service {
    private AnnouncementRepository announcementRepository;
    private AnnouncementEvent announcementEvent;

    public AnnouncementService(AnnouncementRepository announcementRepository, AnnouncementEvent announcementEvent) {
        this.announcementRepository = announcementRepository;
        this.announcementEvent = announcementEvent;
    }

    public boolean createAnnouncement(int id, int club_id, String title, String content, LocalDateTime created_at, LocalDateTime updated_at, Stack<AnnouncementMemento> stateStack) {
        Announcement announcement = new Announcement(id, club_id, title, content, created_at, updated_at, stateStack);

        return announcementRepository.save_Announcement(announcement);
    }

    public boolean updateAnnouncement(int id, String title, String content, LocalDateTime updated_at) {
        Announcement announcement = announcementRepository.get_Announcement(id);

        if (announcement == null) {
            return false; // 해당 ID의 공지사항이 존재하지 않으면 업데이트 실패
        }

        announcement.setTitle(title);
        announcement.setContent(content);
        announcement.setUpdatedAt(updated_at);

        return announcementRepository.update_Announcement(announcement);
    }

    public boolean deleteAnnouncement(int id) {
        Announcement announcement = announcementRepository.get_Announcement(id);
        if (announcement == null) {
            return false; // 해당 ID의 공지사항이 존재하지 않으면 삭제 실패
        }

        return announcementRepository.delete_Announcement(id);
    }

    public boolean publishAnnouncement(int announcementId) {
        Announcement announcement = announcementRepository.get_Announcement(announcementId);
        if (announcement == null) {
            return false; // 해당 ID의 공지사항이 존재하지 않으면 발행 실패
        }

        return announcement.publish();
    }

    public boolean unpublishAnnouncement(int announcementId) {
        Announcement announcement = announcementRepository.get_Announcement(announcementId);
        if (announcement == null) {
            return false; // 해당 ID의 공지사항이 존재하지 않으면 발행 취소 실패
        }

        return announcement.unpublish();
    }
}

class ApplicationService extends Service{
    private ApplicationRepository repository;

    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }
    
    public boolean createApplication(Application application) {
        return true;
    }
    
    public Application getApplication(int id) {
        return null;
    }

    public boolean updateApplication(Application application) {
        return true;
    }

    public boolean deleteApplication(Application application) {
        return true;
    }
}

class ChatService extends Service{
	private ChatRepository repository;

	public ChatService(ChatRepository repository) {
        this.repository = repository;
	}

	public void saveChatMessage(ChatMessage message) {
	}

	public List<ChatMessage> getAllChatMessages() {
		return null;
	}
}

class BoardService extends Service{
    private BoardRepository repository;

    public BoardService(BoardRepository repository) {
        this.repository = repository;
    }
    
    public boolean saveBoard(Board board) {
        return true;
    }

    public Board getBoard(int id) {
        return null;
    }

    public boolean updateBoard(Board board) {
        return true;
    }

    public boolean deleteBoard(int id) {
        return true;
    }
}

class SurveyService extends Service{

    public Boolean create_survey(int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String[] questions) {
        return true;
    }

    public Boolean update_survey(int survey_id) {
        return true;
    }

    public Boolean delete_survey(int survey_id) {
        return true;
    }

    public Survey get_survey(int survey_id) {
        Survey survey = new Survey();
        return survey;
    }

    public Boolean publish_survey(int survey_id) {
        return true;
    }

    public Boolean unpublish_survey(int survey_id) {
        return true;
    }

    public Boolean submit_survey_response(int survey_id, int member_id, String[] responses) {
        return true;
    }
}

class ClubService extends Service{

    private ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public boolean create_Club(int id, String name, String description, String history, String categoryInfo, String contactInfo) {
        RealClub club = new RealClub(id, name, description, history, categoryInfo, contactInfo);
        return clubRepository.save_Club(club);
    }

    public boolean update_Club(int id, String name, String description, String history, String categoryInfo, String contactInfo) {
        RealClub club = clubRepository.get_Club(id);
        if (club == null) {
            return false;
        }
        club.setName(name);
        club.setDescription(description);
        club.setHistory(history);
        club.setCategoryInfo(categoryInfo);
        club.setContactInfo(contactInfo);
        return clubRepository.update_Club(club);
    }

    public boolean delete_Club(int id) {
        return clubRepository.delete_Club(id);
    }

    public RealClub getClub(int id) {
        return clubRepository.get_Club(id);
    }

    public List<Member> getMembers(int clubId) {
        RealClub club = clubRepository.get_Club(clubId);
        if (club == null) {
            return null;
        }
        return club.get_members();
    }

    public List<Event> getEvents(int clubId) {
        RealClub club = clubRepository.get_Club(clubId);
        if (club == null) {
            return null;
        }
        return club.get_events();
    }

    public List<Announcement> getAnnouncements(int clubId) {
        RealClub club = clubRepository.get_Club(clubId);
        if (club == null) {
            return null;
        }
        return club.get_announcements();
    }

    public boolean addMemberToClub(int clubId, Member member) {
        RealClub club = clubRepository.get_Club(clubId);
        if (club == null) {
            return false;
        }
        club.addMember(member);
        return clubRepository.update_Club(club);
    }

    public boolean removeMemberFromClub(int clubId, Member member) {
        RealClub club = clubRepository.get_Club(clubId);
        if (club == null) {
            return false;
        }
        club.removeMember(member);
        return clubRepository.update_Club(club);
    }

    public boolean addEventToClub(int clubId, Event event) {
        RealClub club = clubRepository.get_Club(clubId);
        if (club == null) {
            return false;
        }
        club.addEvent(event);
        return clubRepository.update_Club(club);
    }

    public boolean removeEventFromClub(int clubId, Event event) {
        RealClub club = clubRepository.get_Club(clubId);
        if (club == null) {
            return false;
        }
        club.removeEvent(event);
        return clubRepository.update_Club(club);
    }

    public boolean addAnnouncementToClub(int clubId, Announcement announcement) {
        RealClub club = clubRepository.get_Club(clubId);
        if (club == null) {
            return false;
        }
        club.addAnnouncement(announcement);
        return clubRepository.update_Club(club);
    }

    public boolean removeAnnouncementFromClub(int clubId, Announcement announcement) {
        RealClub club = clubRepository.get_Club(clubId);
        if (club == null) {
            return false;
        }
        club.removeAnnouncement(announcement);
        return clubRepository.update_Club(club);
    }
}

class MemberService extends Service{

    private MemberRepository memberRepository;

    public Boolean create_member(String name, int student_id, String email, String phone, String introduction, String profile_image) {
        return true;
    }

    public Boolean update_member(int id) {
        return true;
    }

    public Boolean delete_member(int id) {
        return true;
    }

    public Boolean validate_name(String name) {
        return true;
    }

    public Boolean validate_student_id(int student_id) {
        return true;
    }

    public Boolean validate_email(String email) {
        return true;
    }

    public Boolean add_member_to_club(int club_id, int member_id) {
        return true;
    }

    public Boolean remove_member_from_club(int club_id, int member_id) {
        return true;
    }

}

// Controller
abstract class Controller{
    //
}

class EventController extends Controller{
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    public void createEvent(int id, int clubId, String title, String description, LocalDateTime startDate, LocalDateTime endDate, String location) {
        boolean created = eventService.createEvent(id, clubId, title, description, startDate, endDate, location);
        if (created) {
            System.out.println("이벤트 생성 성공");
        } else {
            System.out.println("이벤트 생성 실패");
        }
    }

    public void updateEvent(int id, int clubId, String title, String description, LocalDateTime startDate, LocalDateTime endDate, String location) {
        boolean updated = eventService.updateEvent(id, clubId, title, description, startDate, endDate, location);
        if (updated) {
            System.out.println("이벤트 업데이트 성공");
        } else {
            System.out.println("이벤트 업데이트 실패");
        }
    }

    public void deleteEvent(int id) {
        boolean deleted = eventService.deleteEvent(id);
        if (deleted) {
            System.out.println("이벤트 삭제 성공");
        } else {
            System.out.println("이벤트 삭제 실패");
        }
    }

    public void registerEvent(int eventId, int memberId) {
        boolean registered = eventService.registerEvent(eventId, memberId);
        if (registered) {
            System.out.println("이벤트 참가 성공");
        } else {
            System.out.println("이벤트 참가 시래");
        }
    }

    public void unregisterEvent(int eventId, int memberId) {
        boolean unregistered = eventService.unregisterEvent(eventId, memberId);
        if (unregistered) {
            System.out.println("이벤트 참가 취소 성공");
        } else {
            System.out.println("이벤트 참가 취소 실패");
        }
    }

    public void getEventDetails(int eventId) {
        Event event = eventService.getEvent(eventId);
        if (event != null) {
            System.out.println("이벤트 설명: " + event.toString());
        } else {
            System.out.println("이벤트 없음");
        }
    }

    public void getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        if (!events.isEmpty()) {
            for (Event event : events) {
                System.out.println(event.toString());
            }
        } else {
            System.out.println("이벤트 없음");
        }
    }

    public void getEventsByClub(int clubId) {
        List<Event> events = eventService.getEventsByClub(clubId);
        if (!events.isEmpty()) {
            for (Event event : events) {
                System.out.println(event.toString());
            }
        } else {
            System.out.println(clubId + "에 이벤트 없음");
        }
    }

    public void updateEventTitle(int eventId, String newTitle) {
        boolean updated = eventService.updateEventTitle(eventId, newTitle);
        if (updated) {
            System.out.println("이벤트 제목 업데이트 성공");
        } else {
            System.out.println("이벤트 제목 업데이트 실패");
        }
    }

    public void updateEventDescription(int eventId, String newDescription) {
        boolean updated = eventService.updateEventDescription(eventId, newDescription);
        if (updated) {
            System.out.println("이벤트 설명 업데이트 성공");
        } else {
            System.out.println("이벤트 설명 업데이트 실패");
        }
    }

    public void updateEventLocation(int eventId, String newLocation) {
        boolean updated = eventService.updateEventLocation(eventId, newLocation);
        if (updated) {
            System.out.println("이벤트 장소 업데이트 성공");
        } else {
            System.out.println("이벤트 장소 업데이트 실패");
        }
    }

    public void getEventParticipants(int eventId) {
        List<Integer> participants = eventService.getEventParticipants(eventId);
        if (!participants.isEmpty()) {
            System.out.println("이벤트 번호: " + eventId + "\n참가자 명단: " + participants.toString());
        } else {
            System.out.println("이벤트 번호: " + eventId + "\n참가자 명단: 없음");
        }
    }
}

class ClubController extends Controller{
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    public void createClub(int id, String name, String description, String history, String category_info, String contact_info) {
        boolean success = clubService.create_Club(id, name, description, history, category_info, contact_info);
        if (success) {
            System.out.println("동아리 생성 성공");
        } else {
            System.out.println("동아리 생성 실패");
        }
    }

    public void updateClub(int id, String name, String description, String history, String category_info, String contact_info) {
        boolean success = clubService.update_Club(id, name, description, history, category_info, contact_info);
        if (success) {
            System.out.println("동아리 업데이트 성공");
        } else {
            System.out.println("동아리 업데이트 실패");
        }
    }

    public void deleteClub(int id) {
        boolean success = clubService.delete_Club(id);
        if (success) {
            System.out.println("동아리 삭제 성공");
        } else {
            System.out.println("동아리 삭제 실패");
        }
    }

    public void getAllMembers(int clubId) {
        List<Member> members = clubService.getMembers(clubId);
        if (members != null && !members.isEmpty()) {
            for (Member member : members) {
                System.out.println(member.toString());
            }
        } else {
            System.out.println(clubId + "에 멤버 없음");
        }
    }

    public void getAllEvents(int clubId) {
        List<Event> events = clubService.getEvents(clubId);
        if (events != null && !events.isEmpty()) {
            for (Event event : events) {
                System.out.println(event.toString());
            }
        } else {
            System.out.println(clubId + "에 이벤트 없음");
        }
    }

    public void getAllAnnouncements(int clubId) {
        List<Announcement> announcements = clubService.getAnnouncements(clubId);
        if (announcements != null && !announcements.isEmpty()) {
            for (Announcement announcement : announcements) {
                System.out.println(announcement.toString());
            }
        } else {
            System.out.println(clubId + "에 공지사항 없음");
        }
    }

    public void addMemberToClub(int clubId, Member member) {
        boolean added = clubService.addMemberToClub(clubId, member);
        if (added) {
            System.out.println("동아리로부터의 멤버 추가 성공");
        } else {
            System.out.println("동아리로부터의 멤버 추가 실패");
        }
    }

    public void removeMemberFromClub(int clubId, Member member) {
        boolean removed = clubService.removeMemberFromClub(clubId, member);
        if (removed) {
            System.out.println("동아리로부터의 멤버 삭제 성공");
        } else {
            System.out.println("동아리로부터의 멤버 삭제 실패");
        }
    }

    public void addEventToClub(int clubId, Event event) {
        boolean added = clubService.addEventToClub(clubId, event);
        if (added) {
            System.out.println("동아리로부터의 이벤트 생성 성공");
        } else {
            System.out.println("동아리로부터의 이벤트 생성 실패");
        }
    }

    public void removeEventFromClub(int clubId, Event event) {
        boolean removed = clubService.removeEventFromClub(clubId, event);
        if (removed) {
            System.out.println("동아리로부터의 이벤트 삭제 성공");
        } else {
            System.out.println("동아리로부터의 이벤트 삭제 실패");
        }
    }

    public void addAnnouncementToClub(int clubId, Announcement announcement) {
        boolean added = clubService.addAnnouncementToClub(clubId, announcement);
        if (added) {
            System.out.println("동아리로부터의 공지사항 추가 성공");
        } else {
            System.out.println("동아리로부터의 공지사항 추가 실패");
        }
    }

    public void removeAnnouncementFromClub(int clubId, Announcement announcement) {
        boolean removed = clubService.removeAnnouncementFromClub(clubId, announcement);
        if (removed) {
            System.out.println("동아리로부터의 공지사항 삭제 성공");
        } else {
            System.out.println("동아리로부터의 공지사항 삭제 실패");
        }
    }
}

class AnnouncementController extends Controller{
    private AnnouncementService announcementService;

    public void createAnnouncement(int id, int clubId, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt, Stack<AnnouncementMemento> stateStack) {
        boolean success = announcementService.createAnnouncement(id, clubId, title, content, createdAt, updatedAt, stateStack);
        if (success) {
            System.out.println("공지사항 생성 성공");
        } else {
            System.out.println("공지사항 생성 실패");
        }
    }

    public void updateAnnouncement(int id, String title, String content, LocalDateTime updatedAt) {
        boolean success = announcementService.updateAnnouncement(id, title, content, updatedAt);
        if (success) {
            System.out.println("공지사항 업데이트 성공");
        } else {
            System.out.println("공지사항 업데이트 실패");
        }
    }

    public void deleteAnnouncement(int id) {
        boolean success = announcementService.deleteAnnouncement(id);
        if (success) {
            System.out.println("공지사항 삭제 성공");
        } else {
            System.out.println("공지사항 삭제 실패");
        }
    }

    public void publishAnnouncement(int announcementId) {
        boolean success = announcementService.publishAnnouncement(announcementId);
        if (success) {
            System.out.println("공지사항 발행 성공");
        } else {
            System.out.println("공지사항 발행 실패");
        }
    }

    public void unpublishAnnouncement(int announcementId) {
        boolean success = announcementService.unpublishAnnouncement(announcementId);
        if (success) {
            System.out.println("공지사항 발행 취소 성공");
        } else {
            System.out.println("공지사항 발행 취소 실패");
        }
    }
}

class ChatController extends Controller{
	private ChatService service;

	public ChatController(ChatService service) {
	}

	public boolean sendMessage(ChatMessage message) {
		return true;
	}

	public List<ChatMessage> getMessages(int chatRoomId) {
		return null;
	}
}

class BoardController extends Controller{
	private BoardService service;

	public BoardController () {
	}
	
	public boolean createBoard(Board board) {
        return true;
    }

    public Board getBoard(int id) {
        return null;
    }

    public boolean updateBoard(Board board) {
        return true;
    }

    public boolean deleteBoard(int id) {
        return true;
    }
}

class MemberController extends Controller{

    private MemberService memberService;

    public ResponseEntity<Void> register_member(HttpRequest request) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Void> update_member(HttpRequest request, int member_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Void> delete_member(HttpRequest request, int member_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Member> get_member(HttpRequest request, int member_id) {
        Member member = new Member();
        return ResponseEntity.ok()
                .body(member);
    }

    public ResponseEntity<Void> apply_club(HttpRequest request, int club_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Void> join_club(HttpRequest request, int club_id, int member_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Void> leave_club(HttpRequest request, int club_id, int member_id) {
        return ResponseEntity.ok()
                .build();
    }

}

class ApplicationController extends Controller{

    private ApplicationService applicationService;

    public ResponseEntity<Void> create_application(HttpRequest request, int club_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Void> update_application(HttpRequest request, int application_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Void> delete_application(HttpRequest request, int application_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Void> submit_application(HttpRequest request, int application_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Void> withdraw_application(HttpRequest request, int application_id) {
        return ResponseEntity.ok()
                .build();
    }

}

class SurveyController extends Controller{

    private SurveyService surveyService;

    public ResponseEntity<Void> create_survey(HttpRequest request, int club_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Void> update_survey(HttpRequest request, int survey_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Void> delete_survey(HttpRequest request, int survey_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Survey> get_survey(HttpRequest request, int survey_id) {

        Survey survey = new Survey();
        return ResponseEntity.ok()
                .body(survey);
    }

    public ResponseEntity<Void> publish_survey(HttpRequest request, int survey_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Void> unpublish_survey(HttpRequest request, int survey_id) {
        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity<Void> submit_survey_response(HttpRequest request, int survey_id) {
        return ResponseEntity.ok()
                .build();

    }

}

// Event
abstract class AEvent{
    //
}

class EventEvent extends AEvent{
    private Event event;

    public boolean registerEvent(int eventId, int memberId) {
        return true;
    }

    public boolean unregisterEvent(int eventId, int memberId) {
        return true;
    }
}

class AnnouncementEvent extends AEvent{
    private Announcement announcement;

    public boolean createAnnouncement(int id, int club_id, String title, String content, LocalDateTime created_at, LocalDateTime updated_at, Stack<AnnouncementMemento> stateStack) {
        return true;
    }

    public boolean updateAnnouncement(int id, String title, String content, LocalDateTime updated_at) {
        return true;
    }

    public boolean deleteAnnouncement(int id) {
        return true;
    }

    public boolean publishAnnouncement(int announcementId) {
        return true;
    }

    public boolean unpublishAnnouncement(int announcementId) {
        return true;
    }
}

class ChatEvent extends AEvent{
	private String eventType;
	private ChatMessage message;

	public ChatEvent(String eventType, ChatMessage message) {
	}

	public String getEventType() {
		return null;
	}

	public ChatMessage getMessage() {
		return null;
	}
}

class BoardEvent extends AEvent{

	private int boardId;
	private String eventType;
	private int timestamp;

	public BoardEvent() {
	}

	public int getBoardId() {
		return 0;
	}

	public void setBoardId(int boardId) {
	}

	public String getEventType() {
		return null;
	}

	public void setEventType(String eventType) {
	}

	public int getTimestamp() {
		return 0;
	}

	public void setTimestamp(long timestamp) {
	}
}

class ApplicationEvent extends AEvent{
	private int applicationId;
    private String eventType;
    private int timestamp;

	
	public ApplicationEvent() {
	}
	
	public int getApplicationId() {
        return 0;
    }

    public void setApplicationId(int applicationId) {
    }

    public String getEventType() {
        return null;
    }

    public void setEventType(String eventType) {
    }

    public int getTimestamp() {
    	return 0;
    }

    public void setTimestamp(long timestamp) {
    }
}

class ClubEvent extends AEvent{
    private Club club;
}

class MemberEvent extends AEvent {

    private Member member;

}

class SurveyEvent extends AEvent {
    private Survey survey;
}

// Plus
class AnnouncementMemento {
    private HashMap<String, Object> state;

    public AnnouncementMemento(HashMap<String, Object> state) {
        this.state = new HashMap<>(state);
    }

    public HashMap<String, Object> getState() {
        return this.state;
    }

    public void setState(HashMap<String, Object> state) {
        this.state = new HashMap<>(state);
    }
}

class RealClub implements Club {
    private int id;
    private String name;
    private String description;
    private String history;
    private String category_info;
    private String contact_info;
    private List<Member> members;
    private List<Event> events;
    private List<Announcement> announcements;

    public RealClub(int id, String name, String description, String history, String categoryInfo, String contactInfo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.history = history;
        this.category_info = categoryInfo;
        this.contact_info = contactInfo;
        this.members = new ArrayList<>();
        this.events = new ArrayList<>();
        this.announcements = new ArrayList<>();
    }

    public int getId() {
        return id;
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

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getCategoryInfo() {
        return category_info;
    }

    public void setCategoryInfo(String categoryInfo) {
        this.category_info = categoryInfo;
    }

    public String getContactInfo() {
        return contact_info;
    }

    public void setContactInfo(String contactInfo) {
        this.contact_info = contactInfo;
    }

    @Override
    public boolean create() {
        return true;
    }

    @Override
    public boolean update() {
        return true;
    }

    @Override
    public boolean delete() {
        return true;
    }

    @Override
    public List<Member> get_members() {
        return members;
    }

    @Override
    public List<Event> get_events() {
        return events;
    }

    @Override
    public List<Announcement> get_announcements() {
        return announcements;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    public void addAnnouncement(Announcement announcement) {
        announcements.add(announcement);
    }

    public void removeAnnouncement(Announcement announcement) {
        announcements.remove(announcement);
    }

    @Override
    public String toString() {
        return "동아리 고유 식별자: " + id + "\n동아리 이름: " + name + "\n동아리 소개 및 설명: " + description +
               "\n동아리 연혁: " + history + "\n동아리 분류: " + category_info +
               "\n동아리 연락처 정보'" + contact_info + "\n동아리 소속 멤버: " + members + "\n동아리 이벤트: " + events +
               "\n동아리 공지사항: " + announcements;
    }
}

class Proxy implements Club {
    private RealClub realClub;

    public Proxy(RealClub realClub) {
        this.realClub = realClub;
    }

    @Override
    public boolean create() {
        return realClub.create();
    }

    @Override
    public boolean update() {
        return realClub.update();
    }

    @Override
    public boolean delete() {
        return realClub.delete();
    }

    @Override
    public List<Member> get_members() {
        return realClub.get_members();
    }

    @Override
    public List<Event> get_events() {
        return realClub.get_events();
    }

    @Override
    public List<Announcement> get_announcements() {
        return realClub.get_announcements();
    }

    @Override
    public String toString() {
        return realClub.toString();
    }
}

interface EventFactory {
    Event createEvent(int clubId, String title, String description, LocalDateTime startDate, LocalDateTime endDate, String location);
    int generateEventId();
}

class MyEventFactory implements EventFactory {
    private static int eventIdCounter = 0;

    @Override
    public Event createEvent(int clubId, String title, String description, LocalDateTime startDate, LocalDateTime endDate, String location) {
        return new Event(generateEventId(), clubId, title, description, startDate, endDate, location);
    }

    @Override
    public int generateEventId() {
        return eventIdCounter++;
    }
}

class Shape extends GroupElement {
    private String shapeType;

    @Override
    public void send() {
    }
    
    @Override
    public void receive() {
    }
    
    @Override
    public void delete() {
    }
}

class Text extends GroupElement {
    private String content;

    @Override
    public void send() {
    }
    
    @Override
    public void receive() {
    }
    
    @Override
    public void delete() {
    }
}

class Image extends GroupElement {
    private String imageName;

    @Override
    public void send() {
    }
    
    @Override
    public void receive() {
    }
    
    @Override
    public void delete() {
    }
}

class Group extends GroupElement {
    private List<GroupElement> elements = new ArrayList<>();

    public void Add(GroupElement element) {
    }

    public void Remove(GroupElement element) {
    }

    @Override
    public void send() {
    }
    
    @Override
    public void receive() {
    }
    
    @Override
    public void delete() {
    }
}

// Driver
public class SoftWare {
    public static void main(String[] args) {
       //
    }
}
