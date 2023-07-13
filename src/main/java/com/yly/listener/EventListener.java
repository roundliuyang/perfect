package com.yly.listener;

public interface  EventListener extends java.util.EventListener {
    void handleEvent(EventObject event);
}
