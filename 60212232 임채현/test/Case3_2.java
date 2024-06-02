package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Case3_2 {
	  void testUpdateApplication() {
	        ApplicationRepository repository = new ApplicationRepository();
	        Application application = new Application(1, 101, 201, "임채현", "나의 지원 동기", 
                    "나의 활동", "나의 소개");

	        assertTrue(application.create());

	        application = new Application(1, 101, 201, "임채현", "변경된 나의 지원 동기", 
	                                      "변경된 나의 활동", "변경된 나의 소개");

	        assertTrue(application.update());
	    }
}
