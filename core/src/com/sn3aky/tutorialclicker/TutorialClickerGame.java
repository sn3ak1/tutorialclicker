package com.sn3aky.tutorialclicker;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.sn3aky.screens.SplashScreen;

public class TutorialClickerGame extends Game {

	public static final String GAME_NAME = "Clicker Game";
	public static final String GAME_PREFS = "com.sn3aky.tutorialclicker.prefs";
    public static final String GAME_SCORE = "com.sn3aky.tutorialclicker.prefs.score";

    public static final int WIDTH = 480;
	public static final int HEIGHT = 700;
	private boolean paused;
	private int points;
	private Preferences preferences;


	@Override
	public void create () {
	    init();
		this.setScreen(new SplashScreen(this));
	}

    private void init() {
        preferences = Gdx.app.getPreferences(GAME_PREFS);
        loadScore();
    }

    private void loadScore() {
        points=preferences.getInteger(GAME_SCORE);
    }

    public void addPoint(){
		points++;
		preferences.putInteger(GAME_SCORE,points);
		preferences.flush();
	}

	//getters and setters
	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public int getPoints() {
		return points;
	}
}
