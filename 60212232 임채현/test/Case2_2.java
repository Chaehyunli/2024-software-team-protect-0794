package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Case2_2 {//테스트 케이스 2: 클럽에 회원 추가 테스트
	 void testAddMemberToClub() {
	        MemberRepository repository = new MemberRepository();
	        MemberService service = new MemberService(repository);
	        MemberController controller = new MemberController(service);
	        Club club = new Club("소프트웨어공학");

	        Member member = new Member.Builder()
	                .id(1)
	                .name("임채현")
	                .studentId(60212232)
	                .email("chaehyun010104@gmail.com")
	                .phone("010-4049-3862")
	                .introduction("안녕하세요")
	                .profileImage("profile1.jpg")
	                .build();

	        controller.registerMember(member);
	        assertTrue(controller.addMemberToClub(club, member));
	        assertEquals(1, club.getMembers().size());
	        assertEquals("임채현", club.getMembers().get(0).getName());
	    }
}
