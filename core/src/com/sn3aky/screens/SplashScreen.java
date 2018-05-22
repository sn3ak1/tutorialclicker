package com.sn3aky.screens;

import com.badlogic.gdx.graphics.Texture;
import com.sn3aky.tutorialclicker.TutorialClickerGame;


public class SplashScreen extends AbstractScreen {

    private Texture splashImg;

    public SplashScreen(final TutorialClickerGame game) {
        super(game);

        com.badlogic.gdx.utils.Timer.schedule(new com.badlogic.gdx.utils.Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new GameplayScreen(game));
            }
        },1);
    }


    @Override
    protected void init() {
        splashImg=new Texture("splash.png");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(splashImg,0,0);
        spriteBatch.end();
    }
}
