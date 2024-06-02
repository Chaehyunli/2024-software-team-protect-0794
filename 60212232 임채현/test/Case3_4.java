package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class Case3_4 {// 테스트 케이스 4: Member ID 기준으로 Application 순회 테스트
	void testByMemberIdIterator() {
		Application application = new Application(1, 101, 201, "임채현", "나의 지원 동기", "나의 활동", "나의 소개");
		Application application2 = new Application(2, 102, 201, "남서현", "나의 지원 동기", "나의 활동", "나의 소개");
		Application application3 = new Application(3, 103, 202, "조수연", "나의 지원 동기", "나의 활동", "나의 소개");

		List<Application> applications = Arrays.asList(application1, application2, application3);
		ByMemberIdIterator memberIdIterator = new ByMemberIdIterator(applications);

		assertTrue(memberIdIterator.hasNext());
		assertEquals("임채현", memberIdIterator.next().getName());
		assertTrue(memberIdIterator.hasNext());
		assertEquals("남서현", memberIdIterator.next().getName());
		assertTrue(memberIdIterator.hasNext());
		assertEquals("조수연", memberIdIterator.next().getName());
		assertFalse(memberIdIterator.hasNext());
	}
}
