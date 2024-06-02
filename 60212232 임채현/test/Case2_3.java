package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Case2_3 {//테스트 케이스 3: 클럽 내 회원 정보 업데이트 테스트
	void testUpdateMemberInClub() {
        MemberRepository repository = new MemberRepository();
        MemberService service = new MemberService(repository);
        MemberController controller = new MemberController(service);
        Club club = new Club("Coding Club");

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
        controller.addMemberToClub(club, member);

        Member updatedMember = new Member.Builder()
        		.id(1)
                .name("임채현")
                .studentId(60212232)
                .email("ch0101044@naver.com")
                .phone("010-4130-3862")
                .introduction("안녕하세요!. 반가워요")
                .profileImage("profile2.jpg")
                .build();

        assertTrue(controller.updateMemberInClub(club, updatedMember));
        assertEquals("chaehyun010104@gmail.com", club.getMembers().get(0).getEmail());
    }
}
