
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

@Getter
@Setter
@NoArgsConstructor
class Survey {

    private int id;
    private int club_id;
    private String title;
    private String description;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String[] questions;

    public Survey(int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String[] questions) {

        this.club_id = club_id;
        this.title = title;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.questions = questions;
    }

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


@Getter
@Setter
class Board {

    private int id;
    private int club_id;
    private String name;
    private String description;

    public Boolean create(int club_id, String name, String description) {
        Board newBoard = new Board();
        newBoard.club_id = club_id;
        newBoard.name = name;
        newBoard.description = description;

        BoardRepository boardRepository = new BoardRepository();
        return boardRepository.save_board(newBoard);
    }

    public Boolean update(int id, String name, String description) {
        Board updatedBoard = new Board();
        updatedBoard.id = id;
        updatedBoard.club_id = this.club_id;
        updatedBoard.name = name;
        updatedBoard.description = description;

        BoardRepository boardRepository = new BoardRepository();
        boolean isUpdated = boardRepository.update_board(updatedBoard);
        if (isUpdated) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
        return isUpdated;
    }

    public Boolean delete(int id) {
        BoardRepository boardRepository = new BoardRepository();
        return boardRepository.delete_board(id);
    }

    public BoardPost[] get_posts(int id, int posts_size) {
        BoardRepository boardRepository = new BoardRepository();
        List<BoardPost> posts = new ArrayList<>();

        for (int i = 1; i <= posts_size; i++) {
            BoardPost post = boardRepository.get_post(i);
            posts.add(post);
        }

        return posts.toArray(new BoardPost[0]);
    }
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
        BoardPost newPost = new BoardPost();
        newPost.board_id = board_id;
        newPost.author_id = author_id;
        newPost.title = title;
        newPost.content = content;
        newPost.created_at = LocalDateTime.now();
        newPost.updated_at = LocalDateTime.now();

        BoardRepository boardRepository = new BoardRepository();
        return boardRepository.save_post(newPost);
    }

    public Boolean update(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.updated_at = LocalDateTime.now();

        BoardRepository boardRepository = new BoardRepository();
        return boardRepository.update_post(this);
    }

    public Boolean delete(int id) {
        BoardRepository boardRepository = new BoardRepository();
        return boardRepository.delete_post(id);
    }

    public Comment[] get_comments(int post_id) {
        BoardRepository boardRepository = new BoardRepository();
        BoardPost post = boardRepository.get_post(post_id);
        return post.get_comments(post_id);
    }


}

class Comment {
    private int id;
    private int post_id;
    private int author_id;
    private String content;
    private LocalDateTime created_at;
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


class ApplicationRepository extends Repository {

    public Boolean save_application(Application application) {
        return true;
    }

    public Application get_application(int application_id) {
        Application application = new Application();
        return application;
    }

    public Boolean update_application(Application application) {
        return true;
    }

    public Boolean delete_application(int application_id) {
        return true;
    }

}

class BoardRepository extends Repository{

    private BoardRepository instance;

    public Boolean save_board(Board board) {
        return true;
    }

    public Board get_board(int board_id) {
        Board board = new Board();
        return board;
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

    public Comment[] get_comments(int post_id) {

        Comment[] comments = new Comment[1];
        return comments;
    }

    public BoardRepository getInstance() {

        BoardRepository boardRepository = new BoardRepository();
        return boardRepository;

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
        return null;
    }

    public boolean updateSurvey(Survey survey) {
        return true;
    }

    public boolean deleteSurvey(int id) {
        return true;
    }

    public boolean saveSurveyResponse(int survey_id, int member_id, String[] responses) {return true;}
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
        return true;
    }

    public boolean updateEvent(int id, int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String location) {
        return true;
    }

    public boolean deleteEvent(int id) {
        return true;
    }

    public boolean registerEvent(int eventId, int memberId) {
        return true;
    }

    public boolean unregisterEvent(int eventId, int memberId) {
        return true;
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

class SurveyService extends Service{

    private SurveyRepository surveyRepository;

    public Boolean create_survey(int club_id, String title, String description, LocalDateTime start_date, LocalDateTime end_date, String[] questions) {

        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("설문의 제목은 필수 항목입니다.");
        }
        if (start_date == null || end_date == null || start_date.isAfter(end_date)) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다.");
        }
        if (questions == null || questions.length == 0) {
            throw new IllegalArgumentException("설문은 한 개 이상의 질문을 포함하고 있어야 합니다.");
        }

        try {
            Survey survey = new Survey(club_id, title, description, start_date, end_date, questions);
            return surveyRepository.saveSurvey(survey);
        } catch (Exception e) {
            System.out.println("설문을 생성할 수 없습니다. ");
            return false;
        }
    }

    public Boolean update_survey(int survey_id) {
        Survey existingSurvey = surveyRepository.getSurvey(survey_id);
        if (existingSurvey == null) {
            System.out.println("설문이 존재하지 않습니다. ID : " + survey_id);
        }

        // 유효성 검사
        if (existingSurvey.getTitle() == null || existingSurvey.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Survey title cannot be null or empty.");
        }
        if (existingSurvey.getStart_date() == null || existingSurvey.getEnd_date() == null || existingSurvey.getStart_date().isAfter(existingSurvey.getEnd_date())) {
            throw new IllegalArgumentException("Invalid survey dates.");
        }
        if (existingSurvey.getQuestions() == null || existingSurvey.getQuestions().length == 0) {
            throw new IllegalArgumentException("Survey must have at least one question.");
        }

        try {
            existingSurvey.setTitle(existingSurvey.getTitle());
            existingSurvey.setDescription(existingSurvey.getDescription());
            existingSurvey.setStart_date(existingSurvey.getStart_date());
            existingSurvey.setEnd_date(existingSurvey.getEnd_date());
            existingSurvey.setQuestions(existingSurvey.getQuestions());

            return surveyRepository.updateSurvey(existingSurvey);
        } catch (Exception e) {
            System.out.println("설문을 업데이트할 수 없습니다. ");
            return false;
        }

    }

    public Boolean delete_survey(int survey_id) {
        Survey existingSurvey = surveyRepository.getSurvey(survey_id);
        if (existingSurvey == null) {
            System.out.println("설문이 존재하지 않습니다. id : " + survey_id);
        }

        try {
            return surveyRepository.deleteSurvey(survey_id);
        } catch (Exception e) {
            System.out.println("설문을 삭제할 수 없습니다. ");
            return false;
        }
    }

    public Survey get_survey(int survey_id) {
        Survey survey = surveyRepository.getSurvey(survey_id);
        if (survey == null) {
            System.out.println("설문이 존재하지 않습니다. id : " + survey_id);
        }
        return survey;
    }

    public Boolean publish_survey(int survey_id) {
        Survey survey = surveyRepository.getSurvey(survey_id);
        if (survey == null) {
            System.out.println("설문이 존재하지 않습니다. ID : " + survey_id);
        }

        try {
            return survey.publish(survey_id);
        } catch (Exception e) {
            System.out.println("설문을 시작할 수 없습니다. ");
            return false;
        }
    }

    public Boolean unpublish_survey(int survey_id) {
        Survey survey = surveyRepository.getSurvey(survey_id);
        if (survey == null) {
            System.out.println("설문이 존재하지 않습니다. ID : " + survey_id);
        }

        try {
            return survey.unPublish(survey_id);
        } catch (Exception e) {
            System.out.println("설문을 종료할 수 없습니다. ");
            return false;
        }
    }

    public Boolean submit_survey_response(int survey_id, int member_id, String[] responses) {
        Survey survey = surveyRepository.getSurvey(survey_id);
        if (survey == null) {
            System.out.println("설문이 존재하지 않습니다. ID : " + survey_id);
        }

        if (responses.length != survey.getQuestions().length) {
            throw new IllegalArgumentException("유효하지 않은 응답 횟수입니다.");
        }

        try {
            // 응답 저장 로직 구현
            return surveyRepository.saveSurveyResponse(survey_id, member_id, responses);
        } catch (Exception e) {
            System.out.println("응답을 저장할 수 없습니다. ");
            return false;
        }

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
        this.repository = repository;
    }

    public boolean saveBoard(Board board) {
        try
            {
            if (board.getName() == null || board.getName().isEmpty()) {
                System.out.println("게시판 이름이 필수 항목입니다.");
                return false;
            }
            if (board.getDescription() == null || board.getDescription().isEmpty()) {
                System.out.println("게시판 설명이 필수 항목입니다.");
                return false;
            }

            if (board.getName().length() > 100) {
                System.out.println("게시판 이름은 100자를 초과할 수 없습니다.");
                return false;
            }
            if (board.getDescription().length() > 1000) {
                System.out.println("게시판 설명은 1000자를 초과할 수 없습니다.");
                return false;
            }

            Board existingBoard = repository.get_board(board.getId());
            if (existingBoard != null) {
                System.out.println("이미 존재하는 게시판입니다. ID: " + board.getId());
                return false;
            }

            boolean isSaved = repository.save_board(board);

            if (isSaved) {
                System.out.println("게시판이 성공적으로 저장되었습니다. ID: " + board.getId());
                return true;
            } else {
                System.out.println("게시판 저장에 실패했습니다. ID: " + board.getId());
                return false;
            }

        } catch (Exception e) {
            System.out.println("게시판 저장 중 예외가 발생했습니다. 메시지: " + e.getMessage());
            return false;
        }

    }

    public Board getBoard(int id) throws IllegalArgumentException, SQLException {

        if (id <= 0) {
            throw new IllegalArgumentException("유효하지 않은 게시판 ID입니다.");
        }

        Board board = repository.get_board(id);

        if (board == null) {
            throw new IllegalArgumentException("해당 ID에 해당하는 게시판을 찾을 수 없습니다. ID: " + id);
        }

        System.out.println("게시판을 성공적으로 조회했습니다. ID: " + id);
        return board;
    }


    public boolean updateBoard(Board board) throws SQLException {

        if (board == null) {
            throw new IllegalArgumentException("값이 비어있을 수 없습니다.");
        }

        int boardId = board.getId();

        if (boardId <= 0) {
            throw new IllegalArgumentException("유효하지 않은 ID 입니다. ID : " + boardId);
        }

        Board existingBoard = repository.get_board(boardId);

        if (existingBoard == null) {
            throw new IllegalArgumentException("해당 ID로 게시판을 찾을 수 없습니다. ID: " + boardId);
        }

        String newName = board.getName();
        String newDescription = board.getDescription();

        if (newName == null || newName.isEmpty() || newDescription == null || newDescription.isEmpty()) {
            throw new IllegalArgumentException("게시판 이름과 설명은 필수 입력란 입니다.");
        }

        existingBoard.setName(newName);
        existingBoard.setDescription(newDescription);

        return repository.update_board(existingBoard);

    }


    public boolean deleteBoard(int id) throws SQLException {

        if (id <= 0) {
            throw new IllegalArgumentException("유효하지 않은 ID 입니다. ID: " + id);
        }

        Board existingBoard = repository.get_board(id);

        if (existingBoard == null) {
            throw new IllegalArgumentException("해당 ID로 게시판을 찾을 수 없습니다. ID: " + id);
        }

        boolean isDeleted = repository.delete_board(id);

        if (!isDeleted) {
            throw new SQLException("게시판을 삭제하는 데 실패했습니다. ID: " + id);
        }

        return true;
    }

}



class ClubService extends Service {

    private ClubRepository clubRepository;

    public Boolean create_club(String name, String description, String history, String category_info, String contact_info) {
        return true;
    }

    public Boolean update_club(int id) {
        return true;
    }

    public Boolean delete_club(int id) {
        return true;
    }

    public Boolean validate_club_name(String name) {
        return true;
    }

    public Boolean validate_club_category(String category_info) {
        return true;
    }

    public Boolean add_member_to_club(int club_id, int member_id) {
        return true;
    }

    public Boolean remove_member_to_club(int club_id, int member_id) {
        return true;
    }

    public Boolean add_club_announcement(int announcement_id, int club_id, String title, String content) {
        return true;
    }

    public Boolean update_club_announcement(int announcement_id, int club_id, String title, String content) {
        return true;
    }

    public Boolean remove_club_announcement(int announcement_id, int club_id) {
        return true;
    }

}

class MemberService extends Service {

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
        //
    }

    public void updateEvent(int id, int clubId, String title, String description, LocalDateTime startDate, LocalDateTime endDate, String location) {
        //
    }

    public void deleteEvent(int id) {
        //
    }

    public void registerEvent(int eventId, int memberId) {
        //
    }

    public void unregisterEvent(int eventId, int memberId) {
        //
    }
}

class MemberController extends Controller {

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


class ApplicationController extends Controller {

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

class SurveyController extends Controller {

    private SurveyService surveyService;
    private ObjectMapper objectMapper;

    public ResponseEntity<Void> create_survey(HttpServletRequest request, int club_id) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDateTime start_date = LocalDateTime.parse(request.getParameter("start_date"), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime end_date = LocalDateTime.parse(request.getParameter("end_date"), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String[] questions = request.getParameterValues("questions");

        boolean success = surveyService.create_survey(club_id, title, description, start_date, end_date, questions);

        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    public ResponseEntity<Void> update_survey(HttpServletRequest request, int survey_id) {
        try {
            JsonNode requestBody = objectMapper.readTree(request.getInputStream());

            Survey updatedSurvey = new Survey();
            updatedSurvey.setTitle(requestBody.get("title").asText());
            updatedSurvey.setDescription(requestBody.get("description").asText());
            updatedSurvey.setStart_date(LocalDateTime.parse(requestBody.get("start_date").asText(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            updatedSurvey.setEnd_date(LocalDateTime.parse(requestBody.get("end_date").asText(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            updatedSurvey.setQuestions(objectMapper.readValue(requestBody.get("questions").toString(), String[].class));

            boolean success = surveyService.update_survey(updatedSurvey.getId());

            if (success) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Void> delete_survey(HttpRequest request, int survey_id) {
        boolean success = surveyService.delete_survey(survey_id);

        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Survey> get_survey(HttpRequest request, int survey_id) {
        Survey survey = surveyService.get_survey(survey_id);

        if (survey != null) {
            return ResponseEntity.ok().body(survey);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> publish_survey(HttpRequest request, int survey_id) {
        boolean success = surveyService.publish_survey(survey_id);

        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Void> unpublish_survey(HttpRequest request, int survey_id) {
        boolean success = surveyService.unpublish_survey(survey_id);

        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Void> submit_survey_response(HttpServletRequest request, int survey_id) {
        int member_id = Integer.parseInt(request.getParameter("member_id"));
        String[] responses = request.getParameterValues("responses");

        boolean success = surveyService.submit_survey_response(survey_id, member_id, responses);

        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

}


class ClubController extends Controller{
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    public void createClub(String name, String description, String history, String categoryInfo, String contactInfo) {
        //
    }

    public void updateClub(int id) {
        //
    }

    public void deleteClub(int id) {
        //
    }

    public void removeMemberFromClub(int clubId, int memberId) {
        //
    }

    public void addClubAnnouncement(int clubId, int announcementId, String title, String content) {
        //
    }

    public void updateClubAnnouncement(int clubId, int announcementId, String title, String content) {
        //
    }

    public void removeClubAnnouncement(int clubId, int announcementId) {
        //
    }
}

class AnnouncementController extends Controller{
    private AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    public void createAnnouncement(int id, int clubId, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt, Stack<AnnouncementMemento> stateStack) {
        //
    }

    public void updateAnnouncement(int id, String title, String content, LocalDateTime updatedAt) {
        //
    }

    public void deleteAnnouncement(int id) {
        //
    }

    public void publishAnnouncement(int announcementId) {
        //
    }

    public void unpublishAnnouncement(int announcementId) {
        //
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

class ClubEvent extends AEvent {

    private Club club;

}

class MemberEvent extends AEvent {

    private Member member;

}

class SurveyEvent extends AEvent {

    private Survey survey;

}


// Driver
public class mypart {

}
