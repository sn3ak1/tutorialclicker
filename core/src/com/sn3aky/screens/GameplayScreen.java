package com.sn3aky.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.sn3aky.entities.Player;
import com.sn3aky.tutorialclicker.TutorialClickerGame;
import com.sn3aky.ui.IClickCallback;
import com.sn3aky.ui.PlayerButton;
import com.sn3aky.ui.ResetScoreButton;
import com.sn3aky.ui.ScoreLabel;


public class GameplayScreen extends AbstractScreen {

    private Image bgImage;
    private Player player;
    private ScoreLabel scoreLabel;

    GameplayScreen(TutorialClickerGame game) {
        super(game);
    }

    @Override
    protected void init() {
        initBgImage();
        initPlayer();
        initScoreLabel();
        initPlayerButton();
        initResetScoreButton();
    }

    private void initBgImage() {
        bgImage =new Image(new Texture("bg.png"));
        stage.addActor(bgImage);
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
        if(game.pointChanged())
            scoreLabel.setText("Score: "+game.getPoints());
    }
}
