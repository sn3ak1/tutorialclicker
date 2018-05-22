package com.sn3aky.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sn3aky.entities.Player;
import com.sn3aky.tutorialclicker.TutorialClickerGame;
import com.sn3aky.ui.IClickCallback;
import com.sn3aky.ui.PlayerButton;


public class GameplayScreen extends AbstractScreen {

    private Player player;
    private Label scoreLabel;

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

    private void initResetScoreButton() {
        Button resetScoreButton = new Button(new Button.ButtonStyle());
        resetScoreButton.setWidth(100);
        resetScoreButton.setHeight(100);
        resetScoreButton.setX(330);
        resetScoreButton.setY(560);
        resetScoreButton.setDebug(true);

        stage.addActor(resetScoreButton);

        resetScoreButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.resetGameScore();
                scoreLabel.setText("Score: "+game.getPoints());
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initScoreLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        scoreLabel = new Label("Score: " + game.getPoints(),labelStyle);
        scoreLabel.setX(20);
        scoreLabel.setY(650);
        stage.addActor(scoreLabel);
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
