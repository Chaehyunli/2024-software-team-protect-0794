package software_mypart;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.HashMap;
import java.time.LocalDateTime;

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

    public Event(int id, int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String location) {
        this.id = id;
        this.club_id = club_id;
        this.title = title;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.location = location;
        this.participants = new ArrayList<>();
    }

    public boolean create(){
        return true;
    }

    public boolean update(){
        return true;
    }

    public boolean delete(){
        return true;
    }

    public boolean register(){
        return true;
    }

    public boolean unregister(){
        return true;
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
    private LocalDateTime created_at;
    private LocalDateTime update_at;
    private Stack<AnnouncementMemento> stateStack;

    public Announcement(int id, int club_id, String title, String content, LocalDateTime created_at, LocalDateTime update_at, Stack<AnnouncementMemento> stateStack) {
        this.id = id;
        this.club_id = club_id;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.update_at = update_at;
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
        return new AnnouncementMemento(this.stateStack.peek().getState());
    }

    private void setMemento(AnnouncementMemento m) {
        this.stateStack.push(m);
    }
}

class ApplicationStatus {
    private int club_id;
    private int member_id;
    private String status;

    public ApplicationStatus(int club_id, int member_id, String status) {
        this.club_id = club_id;
        this.member_id = member_id;
        this.status = status;
    }

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

    public boolean create() {
        return true;
    }

    public boolean update() {
        return true;
    }

    public boolean delete() {
        return true;
    }

    public List<Member> get_members() {
        return null;
    }

    public List<Event> get_events() {
        return null;
    }

    public List<Announcement> get_announcements() {
        return null;
    }
}

class Proxy implements Club {
    private RealClub realClub;

    public boolean create() {
        return true;
    }

    public boolean update() {
        return true;
    }

    public boolean delete() {
        return true;
    }

    public List<Member> get_members() {
        return null;
    }

    public List<Event> get_events() {
        return null;
    }

    public List<Announcement> get_announcements() {
        return null;
    }
}

interface EventFactory {
    public Event createEvent();
}

class MyEventFactory implements EventFactory {
    public Event createEvent() {
        return null;
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

// Repository
abstract class Repository{
    //
}

class ClubRepository extends Repository{
    public boolean save_club(Club c){
        return true;
    }

    public Club get_Club(int club_id) {
        return null;
    }

    public boolean update_Club(Club c) {
        return true;
    }

    public boolean delete_Club(int club_id) {
        return true;
    }
}

class AnnouncementRepository extends Repository{
    public boolean save_Announcement(Announcement a) {
        return true;
    }

    public Announcement get_Announcement(int announcement_id) {
        return null;
    }

    public boolean update_Announcement(Announcement a) {
        return true;
    }

    public boolean delete_Announcement(int announcement_id) {
        return true;
    }
}

class EventRepository extends Repository{
    public boolean save_Event(Event e) {
        return true;
    }

    public Event get_Event(int event_id) {
        return null;
    }

    public boolean update_Event(Event e) {
        return true;
    }

    public boolean delete_Event(int event_id) {
        return true;
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
class ChatRepository {
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
	        return true;
	    }

	    public boolean updateSurvey(Survey survey) {
	        return true;
	    }

	    public boolean deleteSurvey(int id) {
	        return true;
	    }
}


// Service
abstract class Service{
    //
}

class EventService extends Service {
    private EventRepository eventRepository;
    private EventEvent eventEvent;

    public EventService(EventRepository eventRepository, EventEvent eventEvent) {
        this.eventRepository = eventRepository;
        this.eventEvent = eventEvent;
    }

    public boolean createEvent(int id, int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String location) {
        return eventRepository.save_Event(new Event(id, club_id, title, description, start_date, end_date, location));
    }

    public boolean updateEvent(int id, int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String location) {
        return true;
    }

    public boolean deleteEvent(int id) {
        return eventRepository.delete_Event(id);
    }

    public boolean registerEvent(int eventId, int memberId) {
        return eventEvent.registerEvent(eventId, memberId);
    }

    public boolean unregisterEvent(int eventId, int memberId) {
        return eventEvent.unregisterEvent(eventId, memberId);
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
        return announcementRepository.save_Announcement(new Announcement(id, club_id, title, content, created_at, updated_at, stateStack));
    }

    public boolean updateAnnouncement(int id, String title, String content, LocalDateTime updated_at) {
        return true;
    }

    public boolean deleteAnnouncement(int id) {
        return announcementRepository.delete_Announcement(id);
    }

    public boolean publishAnnouncement(int announcementId) {
        return announcementEvent.publishAnnouncement(announcementId);
    }

    public boolean unpublishAnnouncement(int announcementId) {
        return announcementEvent.unpublishAnnouncement(announcementId);
    }
}

class ApplicationService extends Service{
    private ApplicationRepository repository;

    public ApplicationService(ApplicationRepository repository) {
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

// Controller
abstract class Controller{
    //
}

class EventController extends Controller{
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    public boolean createEvent(int id, int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String location) {
        return eventService.createEvent(id, club_id, title, description, start_date, end_date, location);
    }

    public boolean updateEvent(int id, int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String location) {
        return eventService.updateEvent(id, club_id, title, description, start_date, end_date, location);
    }

    public boolean deleteEvent(int id) {
        return eventService.deleteEvent(id);
    }

    public boolean registerEvent(int eventId, int memberId) {
        return eventService.registerEvent(eventId, memberId);
    }

    public boolean unregisterEvent(int eventId, int memberId) {
        return eventService.unregisterEvent(eventId, memberId);
    }
}

class ClubController extends Controller {
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    public boolean createClub(Club club) {
        return clubService.createClub(club);
    }

    public boolean updateClub(Club club) {
        return clubService.updateClub(club);
    }

    public boolean deleteClub(int clubId) {
        return clubService.deleteClub(clubId);
    }
    
    public List<Member> getMembers(int clubId) {
        return clubService.getMembers(clubId);
    }

    public List<Event> getEvents(int clubId) {
        return clubService.getEvents(clubId);
    }

    public List<Announcement> getAnnouncements(int clubId) {
        return clubService.getAnnouncements(clubId);
    }
}

class AnnouncementController extends Controller{
    private AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    public boolean createAnnouncement(int id, int club_id, String title, String content, LocalDateTime created_at, LocalDateTime updated_at, Stack<AnnouncementMemento> stateStack) {
        return announcementService.createAnnouncement(id, club_id, title, content, created_at, updated_at, stateStack);
    }

    public boolean updateAnnouncement(int id, String title, String content, LocalDateTime updated_at) {
        return announcementService.updateAnnouncement(id, title, content, updated_at);
    }

    public boolean deleteAnnouncement(int id) {
        return announcementService.deleteAnnouncement(id);
    }

    public boolean publishAnnouncement(int announcementId) {
        return announcementService.publishAnnouncement(announcementId);
    }

    public boolean unpublishAnnouncement(int announcementId) {
        return announcementService.unpublishAnnouncement(announcementId);
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

// AEvent
abstract class AEvent{
    //
}

class EventEvent extends AEvent{
    public boolean registerEvent(int eventId, int memberId) {
        return true;
    }

    public boolean unregisterEvent(int eventId, int memberId) {
        return true;
    }  
}

class AnnouncementEvent extends AEvent{
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


// Driver
public class mypart {

}
