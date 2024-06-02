package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Case2_5 {//테스트 케이스 5: 모든 회원 조회 테스트
	void testGetAllMembers() {
        MemberRepository repository = new MemberRepository();
        MemberService service = new MemberService(repository);
        MemberController controller = new MemberController(service);

        Member member1 = new Member.Builder()
        		.id(1)
                .name("임채현")
                .studentId(60212232)
                .email("chaehyun010104@gmail.com")
                .phone("010-4049-3862")
                .introduction("안녕하세요")
                .profileImage("profile1.jpg")
                .build();

        Member member2 = new Member.Builder()
                .id(2)
                .name("남서현")
                .studentId(60223435)
                .email("abcd@example.com")
                .phone("123-456-789")
                .introduction("반가워요!")
                .profileImage("profile2.jpg")
                .build();

        controller.registerMember(member1);
        controller.registerMember(member2);

        List<Member> members = controller.getAllMembers();
        assertEquals(2, members.size());
        assertEquals("임채현", members.get(0).getName());
        assertEquals("남서현", members.get(1).getName());
    }
}
