package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Case3_1 {//테스트 케이스 1: Application 생성 및 저장 테스트
    void testCreateApplication() {
        ApplicationRepository repository = new ApplicationRepository();
        Application application = new Application(1, 101, 201, "임채현", "나의 지원 동기", 
                                                  "나의 활동", "나의 소개");

        assertTrue(application.create());
    }
}
