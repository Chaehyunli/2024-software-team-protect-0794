package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Case1_5 {//테스트 케이스 5: 저장된 모든 메시지 조회 테스트
	  void testGetAllMessages() {
	        ChatMessage.Sender sender = new ChatMessage.Sender(1, "임채현");
	        ChatMessage.Receiver receiver = new ChatMessage.Receiver(2, "남서현");
	        ChatMessage message1 = new ChatMessage(1, sender, receiver, "안녕하세요");
	        ChatMessage message2 = new ChatMessage(2, sender, receiver, "잘 지내세요");

	        ChatRepository repository = new ChatRepository();
	        ChatService service = new ChatService(repository);
	        ChatController controller = new ChatController(service);

	        controller.saveChatMessage(message1);
	        controller.saveChatMessage(message2);

	        List<ChatMessage> messages = controller.getAllChatMessages();
	        assertEquals(2, messages.size());
	        assertEquals("안녕하세요", messages.get(0).getContent());
	        assertEquals("잘 지내세요", messages.get(1).getContent());
	    }
}
