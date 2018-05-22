package com.sn3aky.screens;

import com.sn3aky.entities.Player;
import com.sn3aky.tutorialclicker.TutorialClickerGame;
import com.sn3aky.ui.IClickCallback;
import com.sn3aky.ui.PlayerButton;
import com.sn3aky.ui.ResetScoreButton;
import com.sn3aky.ui.ScoreLabel;


public class GameplayScreen extends AbstractScreen {

    private Player player;
    private ScoreLabel scoreLabel;

    GameplayScreen(TutorialClickerGame game) {
        super(game);
    }

    @Override
    protected void init() {
        initPlayer();
        initPlayerButton();
        initScoreLabel();
        initResetScoreButton();
    }


    private void initScoreLabel() {
        scoreLabel = new ScoreLabel("Score: " + game.getPoints());
        stage.addActor(scoreLabel);
    }

    private void initResetScoreButton() {
        ResetScoreButton resetScoreButton = new ResetScoreButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.resetGameScore();
                scoreLabel.setText("Score: "+game.getPoints());
            }
        });
        stage.addActor(resetScoreButton);
    }

    private void initPlayerButton() {
        PlayerButton playerButton = new PlayerButton(new IClickCallback(){
            @Override
            public void onClick() {
                player.reactOnClick();
                game.addPoint();
                scoreLabel.setText("Score: "+game.getPoints());
            }
        });
        stage.addActor(playerButton);
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
