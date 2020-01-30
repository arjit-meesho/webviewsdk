package com.example.ymwebview.models;


import java.util.HashMap;
import java.util.Map;

public class BotEventsModel{

    String code, data;

    public BotEventsModel(String code, String data) {
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
