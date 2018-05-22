package com.sn3aky.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sn3aky.tutorialclicker.TutorialClickerGame;

public class PlayerButton extends Button {

    public PlayerButton(final IClickCallback callback){
        super(new ButtonStyle());
        init(callback);
    }

    private void init(final IClickCallback callback) {
        this.setWidth(TutorialClickerGame.WIDTH);
        this.setHeight(TutorialClickerGame.HEIGHT);
        this.setX(0);
        this.setY(0);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}
