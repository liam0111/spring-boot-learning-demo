package com.liam.springboot.websocket;

import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

import static com.liam.springboot.websocket.utils.WebSocketUtils.ONLINE_USER_SESSIONS;
import static com.liam.springboot.websocket.utils.WebSocketUtils.sendMessageAll;

/**
 * @Author: Liam
 * @Date: 2019/2/23 19:50
 */
@RestController
@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {
    /**
     * 客户端建立连接
     *
     * @param username
     * @param session
     */
    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        ONLINE_USER_SESSIONS.put(username, session);
        String message = "欢迎用户[" + username + "]来到聊天室！";
        System.out.println("用户登录：" + message);
        sendMessageAll(message);
    }

    /**
     * 服务器向客户端同步消息
     *
     * @param username
     * @param message
     */
    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        System.out.println("发送消息：" + message);
        sendMessageAll("用户[" + username + "]：" + message);
    }

    /**
     * 客户端断开连接
     *
     * @param username
     * @param session
     */
    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        ONLINE_USER_SESSIONS.remove(username);
        sendMessageAll("用户[" + username + "]已经离开聊天室！");
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接异常处理
     *
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Throwable msg " + throwable.getMessage());
    }
}
