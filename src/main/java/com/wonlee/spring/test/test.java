package com.wonlee.spring.test;

import org.junit.Test;

import com.wonlee.spring.chat.WebSocketChat;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.websocket.ContainerProvider;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.junit.Before;


public class test {
	
	@Test
	public void testWebSocketErrorHandling() throws Exception {
	    // WebSocket 서버에 연결
	    WebSocketContainer container = ContainerProvider.getWebSocketContainer();
	    URI uri = new URI("ws://localhost:8000/echo.do");

	    final CountDownLatch errorLatch = new CountDownLatch(1);
	    Session session = container.connectToServer(new Endpoint() {
	        @Override
	        public void onOpen(Session session, EndpointConfig config) {
	            try {
	                session.getBasicRemote().sendText("throwError");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        @Override
	        public void onError(Session session, Throwable thr) {
	            assertEquals("Test error", thr.getMessage());  // 서버에서 발생한 에러 확인
	            errorLatch.countDown();
	        }
	    }, uri);

	    // 에러 대기 (최대 5초)
	    assertTrue("Error not received in time", errorLatch.await(5, TimeUnit.SECONDS));

	    // 세션 종료
	    session.close();
	}

}

    

