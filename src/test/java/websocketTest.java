import static org.mockito.Mockito.*;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.wonlee.spring.chat.WebSocketChat;

@TestMethodOrder(OrderAnnotation.class) // 테스트 순서를 명시적으로 지정
public class websocketTest {

    private WebSocketChat webSocketChat;
    private Session session;
    private Basic basicRemote;

    @BeforeEach
    public void setUp() {
        webSocketChat = new WebSocketChat(); // WebSocketChat 객체 초기화
        session = mock(Session.class); // Mock 세션 생성
        basicRemote = mock(Basic.class); // Mock Basic Remote 생성

        // Mock된 세션이 Basic Remote를 반환하도록 설정
        when(session.getBasicRemote()).thenReturn(basicRemote);
    }

    @Test
    @Order(1) // 실행 순서 1
    public void testOnOpen() throws Exception {
        when(session.getId()).thenReturn("12345"); // 세션 ID 설정
        webSocketChat.onOpen(session); // onOpen 호출
        verify(basicRemote, times(1)).sendText("어서오세요 대화방에 참가하셨습니다."); // 메시지 전송 검증
    }

    @Test
    @Order(2) // 실행 순서 2
    public void testOnMessage() throws Exception {
        when(session.getId()).thenReturn("12345"); // 세션 ID 설정
        webSocketChat.onMessage("Hello,User1", session); // onMessage 호출
        verify(basicRemote, times(1)).sendText("<나> : Hello"); // 메시지 전송 검증
    }

    @Test
    @Order(3) // 실행 순서 3
    public void testOnError() throws Exception {
        System.out.println("에러발생"); // 에러 로그 출력
        when(session.getId()).thenReturn("12345"); // 세션 ID 설정
        Throwable throwable = new RuntimeException("Test Error 발생"); // 에러 시뮬레이션
        webSocketChat.onError(throwable, session); // onError 호출
        verify(session, times(1)).close(); // 세션 종료 검증
    }
}
