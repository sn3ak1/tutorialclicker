package com.sn3aky.tutorialclicker;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sn3aky.screens.SplashScreen;

public class TutorialClickerGame extends Game {

	public static final String GAME_NAME = "Clicker Game";
	public static final int WIDTH = 480;
	public static final int HEIGHT = 700;
	private boolean paused;
	private int points;


	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
	}

	public void addPoint(){
		points++;
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
