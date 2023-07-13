package com.yly.listener;

public class EventObject extends java.util.EventObject{
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventObject(Object source) {
        super(source);
    }
    public void doEvent(){
        System.out.println("通知一个事件源 source :"+ this.getSource());
    }
}
