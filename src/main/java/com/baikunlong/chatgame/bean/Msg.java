package com.baikunlong.chatgame.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

public class Msg {
    public static String CONNECT;//链接状态
    public static String DISCONNECT;//断开状态

    private String status;//状态
    private int userCount;//在线人数
    private String message;//消息

    public Msg() {
    }

    public Msg(String status, int userCount, String message) {
        this.status = status;
        this.userCount = userCount;
        this.message = message;
    }

    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Msg{" +
                "status=" + status +
                ", userCount=" + userCount +
                ", message='" + message + '\'' +
                '}';
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
