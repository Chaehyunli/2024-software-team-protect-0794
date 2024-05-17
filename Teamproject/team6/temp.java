public class Temp {
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

class SurveyService {

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

class BoardRepository {

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

class Comment {

}

class Club {

}

class Member {

}

class ClubRepository {

}

class MemberRepository {

}

class ClubService {

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

class MemberService {

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

class MemberController {

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

class ApplicationService {

}

class ApplicationController {

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

class SurveyController {

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

class ClubEvent {

    private Club club;

}

class BoardEvent {

    private Board board;
    private BoardPost boardPost;

}

class Application {

}

class ApplicationEvent {

    private Application application;

}
