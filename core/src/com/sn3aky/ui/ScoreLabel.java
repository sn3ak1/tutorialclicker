package com.sn3aky.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class ScoreLabel extends Label{

    public ScoreLabel(CharSequence text) {
        super(text, labelStyle());
        init();
    }

    private void init() {
        this.setX(60);
        this.setY(650);
    }

    private static LabelStyle labelStyle(){
        LabelStyle style;
        style = new LabelStyle();
        style.font = new BitmapFont();
        return style;
    }
}
