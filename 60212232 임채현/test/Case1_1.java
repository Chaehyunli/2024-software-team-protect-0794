package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Case1_1 { //테스트 케이스 1: 메시지 전송 및 저장 테스트
	void testSendMessageAndSave() {
        ChatMessage.Sender sender = new ChatMessage.Sender(1, "임채현");
        ChatMessage.Receiver receiver = new ChatMessage.Receiver(2, "남서현");
        ChatMessage message = new ChatMessage(1, sender, receiver, "안녕하세요");

        ChatRepository repository = new ChatRepository();
        ChatService service = new ChatService(repository);
        ChatController controller = new ChatController(service);

        controller.saveChatMessage(message);
        message.send();

        assertEquals(1, controller.getAllChatMessages().size());
        assertEquals("안녕하세요", controller.getAllChatMessages().get(0).getContent());
    }

}

