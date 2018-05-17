package com.sn3aky.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.sn3aky.tutorialclicker.TutorialClickerGame;

public abstract class AbstractScreen implements Screen {

    protected TutorialClickerGame game;
    protected Stage stage;
    private OrthographicCamera camera;
    SpriteBatch spriteBatch;

    public AbstractScreen(TutorialClickerGame game) {
        this.game = game;
        createCamera();
        stage=new Stage(new StretchViewport(TutorialClickerGame.WIDTH,TutorialClickerGame.HEIGHT, camera));
        spriteBatch=new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        init();
    }

    protected abstract void init();

    private void createCamera() {
        camera=new OrthographicCamera();
        camera.setToOrtho(false,TutorialClickerGame.WIDTH,TutorialClickerGame.HEIGHT);
        camera.update();
    }

    @Override
    public void render(float delta) {
        cleanScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void show() {

    }

    private void cleanScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void resume() {
        game.setPaused(false);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) { }

    @Override
    public void hide() { }
}
