package unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Case1_4 {//테스트 케이스 4: 메시지 그룹 전송 테스트
	void testSendMessageGroup() {
        ChatMessage.Sender sender1 = new ChatMessage.Sender(1, "임채현");
        ChatMessage.Receiver receiver1 = new ChatMessage.Receiver(2, "남서현");
        ChatMessage message1 = new ChatMessage(1, sender1, receiver1, "안녕하세요");

        ChatMessage.Sender sender2 = new ChatMessage.Sender(3, "조수연");
        ChatMessage.Receiver receiver2 = new ChatMessage.Receiver(4, "문대경");
        ChatMessage message2 = new ChatMessage(2, sender2, receiver2, "반갑습니다");

        MessageGroup group = new MessageGroup();
        group.add(message1);
        group.add(message2);

        group.send();

        assertTrue(sender1.getSentMessages().contains("안녕하세요"));
        assertTrue(receiver1.getReceivedMessages().contains("안녕하세요"));
        assertTrue(sender2.getSentMessages().contains("반갑습니다"));
        assertTrue(receiver2.getReceivedMessages().contains("반갑습니다"));
    }
}
