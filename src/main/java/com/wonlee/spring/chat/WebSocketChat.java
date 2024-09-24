package com.wonlee.spring.chat;


import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@ServerEndpoint(value="/echo.do")
public class WebSocketChat {
	
	private static final List<Session> sessionList=new ArrayList<Session>();;
    private static final Logger logger = LoggerFactory.getLogger(WebSocketChat.class);
    public WebSocketChat() {
        // TODO Auto-generated constructor stub
        System.out.println("웹소켓(서버) 객체생성");
    }
    
    @OnOpen
    public void onOpen(Session session) {
        logger.info("Open session id:"+session.getId());
        try {
            final Basic basic=session.getBasicRemote();
            basic.sendText("어서오세요 대화방에 참가하셨습니다.");
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        sessionList.add(session);
    }
    
    /*
     * 모든 사용자에게 메시지를 전달한다.
     * @param self
     * @param sender
     * @param message
     */
    public void sendAllSessionToMessage(Session self, String sender, String message) {
    	
        try {
            for(Session session : WebSocketChat.sessionList) {
                if(!self.getId().equals(session.getId())) {
                    session.getBasicRemote().sendText(sender+" : "+message);
                }
            }
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    
    /*
     * 내가 입력하는 메세지
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session) {
    	
    	String sender = message.split(",")[1];
    	message = message.split(",")[0];
    	
        logger.info("Message From "+sender + ": "+message);
        try {
            final Basic basic=session.getBasicRemote();
            basic.sendText("<나> : "+message);
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        sendAllSessionToMessage(session, sender, message);
    }
    
    @OnError
    public void onError(Throwable e,Session session) {
    	//log 남기기
    	 System.out.println("Web소켓 통신에러" + session.getId() + ": : :"+ e.getMessage());
        
        try {
        	session.close();
        	session.getBasicRemote().sendText("에러발생 세션이 종료되었습니다" + e.getMessage()+"를 관리자에게 말씀해주세요");
        	
        	// 클라이언트에 에러메세지 전송
        }catch(Exception ex) {
        	 System.out.println("클라이언트에게 보낸 메세지 =>"+ "에러발생 : " + e.getMessage());
        }
        
    }
    
    @OnClose
    public void onClose(Session session) {
        logger.info("Session "+session.getId()+" has ended");
        sessionList.remove(session);
    }


}
	