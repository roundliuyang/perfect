package com.yly.eventbus;

public class Test {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new LevelUpHandler());
        Player player = new Player();
        player.setLevel(1);
        player.receiveExp(100,eventBus);
        System.out.println(player.getLevel());
    }

}
