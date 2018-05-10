package com.sn3aky.screens;

import com.badlogic.gdx.graphics.Texture;
import com.sn3aky.tutorialclicker.TutorialClickerGame;

public class SplashScreen extends AbstractScreen {

    private Texture splashImg;

    public SplashScreen(TutorialClickerGame game) {
        super(game);
        init();
    }

    private void init() {
        splashImg=new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(splashImg,0,0);
        spriteBatch.end();
    }
}
