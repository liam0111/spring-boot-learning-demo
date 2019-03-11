package com.liam.springboot.websocket.utils;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Liam
 * @Date: 2019/2/23 19:43
 */
public class WebSocketUtils {
    /**
     * 存储在线用户
     */
    public static final Map<String, Session> ONLINE_USER_SESSIONS = new ConcurrentHashMap<>();

    public static void sendMessage(Session session, String message) {
        if (session == null) {
            return;
        }
        final RemoteEndpoint.Basic basic = session.getBasicRemote();
        if (basic == null) {
            return;
        }
        try {
            basic.sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageAll(String message) {
        ONLINE_USER_SESSIONS.forEach((sessionId, session) -> sendMessage(session, message));
    }
}
