package com.yly.eventbus;

public class LevelUpEvent implements Event {
    private Player player;

    public LevelUpEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}