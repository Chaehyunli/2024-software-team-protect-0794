package software_mypart;

import java.util.ArrayList;
import java.util.List;

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

class ChatEvent extends Event{
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

class BoardEvent extends Event{

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

class ApplicationEvent extends Event{
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

public class mypart {

}
