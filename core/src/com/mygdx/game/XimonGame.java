package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class XimonGame extends ApplicationAdapter implements InputProcessor {

       private Stage stage;


// create() method when extending Game
//    @Override
//    public void create() {
//        setScreen(new GameScreen());
//    }


    // Following a tutorial to better understand scene2d.//
    //          ------This is temporary------            //
    @Override
    public void create() {
        stage = new Stage(new ScreenViewport());
        stage.addActor(new MyActor2(new Texture(Gdx.files.internal("images/simon.png"))));
        Gdx.input.setInputProcessor(stage);
        stage.setKeyboardFocus(stage.getActors().first());

//        stage = new Stage(new ScreenViewport());
//        MyActor actor = new MyActor();
//        stage.addActor(actor);
//        Gdx.input.setInputProcessor(stage);

    }
    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }


    @Override
    public void resume () {

    }



    public void dispose () {

    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    // Will be using the touchDown and touchUp methods here for input
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}




