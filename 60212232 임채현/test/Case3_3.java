package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Case3_3 {//테스트 케이스 3: Application 삭제 테스트
	 void testDeleteApplication() {
	        ApplicationRepository repository = new ApplicationRepository();
	        Application application = new Application(1, 101, 201, "임채현", "나의 지원 동기", 
                    "나의 활동", "나의 소개");

	        assertTrue(application.create());
	        assertTrue(application.delete());
	    }

}
