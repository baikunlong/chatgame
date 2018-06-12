package com.baikunlong.chatgame.service;

import com.baikunlong.chatgame.bean.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.Util;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.xml.ws.WebEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/chatSocket")
@Component
public class ChatSocket {

    private Logger logger=LoggerFactory.getLogger("ChatSocket");

    private Session session;
    private static CopyOnWriteArraySet<ChatSocket> chatSockets=new CopyOnWriteArraySet<>();
    private Msg msg = new Msg();

    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        chatSockets.add(this);//添加一个链接

        msg.setStatus(Msg.CONNECT);
        msg.setUserCount(chatSockets.size());
        msg.setMessage("用户名："+session+"上线了~");

        this.sendMessage(msg.toJson());
        logger.warn("测试一下日志的1");
        Util.report("测试一下日志的2");
    }

    public void sendMessage(String s) {

    }


}
