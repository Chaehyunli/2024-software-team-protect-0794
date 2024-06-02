package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Case1_3 {//테스트 케이스 3: 메시지 삭제 테스트
	 void testDeleteMessage() {
	        ChatMessage.Sender sender = new ChatMessage.Sender(1, "임채현");
	        ChatMessage.Receiver receiver = new ChatMessage.Receiver(2, "남서현");
	        ChatMessage message = new ChatMessage(1, sender, receiver, "안녕하세요");

	        message.send();
	        message.delete();

	        assertTrue(sender.getDeletedMessages().contains("안녕하세요"));
	        assertTrue(receiver.getDeletedMessages().contains("안녕하세요"));
	    }
}
