package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class Case3_5 {//테스트 케이스 5: Club ID 기준으로 Application 순회 테스트
	void testByClubIdIterator() {
		Application application = new Application(1, 101, 201, "임채현", "나의 지원 동기", "나의 활동", "나의 소개");
		Application application2 = new Application(2, 102, 201, "남서현", "나의 지원 동기", "나의 활동", "나의 소개");
		Application application3 = new Application(3, 103, 202, "조수연", "나의 지원 동기", "나의 활동", "나의 소개");

        List<Application> applications = Arrays.asList(application1, application2, application3);
        ByClubIdIterator clubIdIterator = new ByClubIdIterator(applications);

        assertTrue(clubIdIterator.hasNext());
        assertEquals("임채현", clubIdIterator.next().getName());
        assertTrue(clubIdIterator.hasNext());
        assertEquals("남서현", clubIdIterator.next().getName());
        assertTrue(clubIdIterator.hasNext());
        assertEquals("조수연", clubIdIterator.next().getName());
        assertFalse(clubIdIterator.hasNext());
    }
}
