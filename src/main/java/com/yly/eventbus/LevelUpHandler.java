package com.yly.eventbus;

public class LevelUpHandler {

    @Subscribe
    public void handle(LevelUpEvent event) {
        Player player = event.getPlayer();
        player.setLevel(player.getLevel() + 1);
    }
}