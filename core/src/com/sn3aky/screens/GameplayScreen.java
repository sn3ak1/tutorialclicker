package com.sn3aky.screens;

import com.sn3aky.entities.Player;
import com.sn3aky.tutorialclicker.TutorialClickerGame;

public class GameplayScreen extends AbstractScreen {

    Player player;

    public GameplayScreen(TutorialClickerGame game) {
        super(game);
        init();
    }

    private void init() {
        initPlayer();
    }

    private void initPlayer() {
        player=new Player();
        stage.addActor(player);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        stage.act();
    }
}
