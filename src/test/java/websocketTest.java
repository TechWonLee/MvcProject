

import static org.mockito.Mockito.*;

import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wonlee.spring.chat.WebSocketChat;

public class websocketTest {

	private WebSocketChat webSocketChat;
    private Session session;
    private Basic basicRemote;

    @BeforeEach
    public void setUp() {
        // WebSocketChat 객체 초기화
        webSocketChat = new WebSocketChat();

        // Mock 세션 및 RemoteEndpoint 생성
        session = mock(Session.class);
        basicRemote = mock(Basic.class);
        
        // Session에 대해 getBasicRemote가 호출될 때 mock된 basicRemote 반환
        when(session.getBasicRemote()).thenReturn(basicRemote);
    }

    @Test
    public void testOnOpen() throws Exception {
        // Session ID 설정
        when(session.getId()).thenReturn("12345");

        // onOpen 메서드 호출
        webSocketChat.onOpen(session);

        // 메세지 전송이 호출됐는지 검증
        verify(basicRemote, times(1)).sendText("어서오세요 대화방에 참가하셨습니다.");
    }

    @Test
    public void testOnMessage() throws Exception {
        // Session ID 설정
        when(session.getId()).thenReturn("12345");

        // onMessage 메서드 호출
        webSocketChat.onMessage("Hello,User1", session);

        // 메시지 전송이 호출됐는지 검증
        verify(basicRemote, times(1)).sendText("<나> : Hello");
    }

    @Test
    public void testOnError() throws Exception {
        // Session ID 설정
        when(session.getId()).thenReturn("12345");

        // Throwable 에러 시뮬레이션
        Throwable throwable = new RuntimeException("Test Error");

        // onError 메서드 호출
        webSocketChat.onError(throwable, session);

        // 에러 발생 후 세션 종료를 검증
        verify(session, times(1)).close();
    }
}
