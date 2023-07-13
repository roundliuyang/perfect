package com.yly.eventbus;

public class Player {
    private int level;
    private int exp;

    public Player() {
        this.level = 1;
        this.exp = 0;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void receiveExp(int value,EventBus eventBus ) {
        this.exp += value;
        if (this.exp >= 100) {
            LevelUpEvent event = new LevelUpEvent(this);
            eventBus.dispatch(event);
            this.exp = 0;
        }
    }
}