package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Case1_2 {//테스트 케이스 2: 메시지 수신 확인 테스트
	 void testReceiveMessage() {
	        ChatMessage.Sender sender = new ChatMessage.Sender(1, "임채현");
	        ChatMessage.Receiver receiver = new ChatMessage.Receiver(2, "남서현");
	        ChatMessage message = new ChatMessage(1, sender, receiver, "안녕하세요");

	        message.send();
	        message.receive();

	        assertTrue(receiver.getReceivedMessages().contains("안녕하세요"));
	    }
}
