package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Case2_1 {//테스트 케이스 1: 회원 등록 및 저장 테스트
	void testRegisterMember() {
        MemberRepository repository = new MemberRepository();
        MemberService service = new MemberService(repository);
        MemberController controller = new MemberController(service);

        Member member = new Member.Builder()
                .id(1)
                .name("임채현")
                .studentId(60212232)
                .email("chaehyun010104@gmail.com")
                .phone("010-4049-3862")
                .introduction("안녕하세요!")
                .profileImage("profile1.jpg")
                .build();

        assertTrue(controller.registerMember(member));
        assertEquals(1, controller.getAllMembers().size());
        assertEquals("임채현", controller.getAllMembers().get(0).getName());
    }
}
