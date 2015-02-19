package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;


public class XimonGame extends ApplicationAdapter implements InputProcessor {

    private SpriteBatch batch;
    private Stage stage;
    private OrthographicCamera camera;


    @Override
    public void create () {
        batch = new SpriteBatch();
        // Creating camera
        camera = new OrthographicCamera(800, 480);

        // Creating stage and actors
        stage = new Stage(new FitViewport(800, 480, camera));

        // Creating (constructing) actors. Parameter info: XimonButton("[png file]", x, y, width, height, "[name]")
        XimonButton actor_g = new XimonButton("img/green.png", 190, 240, 210, 210, "green");
        System.out.println(actor_g.toString() + " created.");
        XimonButton actor_r = new XimonButton("img/red.png", 400, 240, 210, 210, "red");
        System.out.println(actor_r.toString() + " created.");
        XimonButton actor_y = new XimonButton("img/yellow.png", 190, 30, 210, 210, "yellow");
        System.out.println(actor_y.toString() + " created.");
        XimonButton actor_b = new XimonButton("img/blue.png", 400, 30, 210, 210, "blue");
        System.out.println(actor_b.toString() + " created.");


//        Adding actors
//
        // Green button:
        stage.addActor(actor_g);

        // Blue button:
        stage.addActor(actor_b);

        // Red button:
        stage.addActor(actor_r);

        // Yellow button:
        stage.addActor(actor_y);


        Gdx.input.setInputProcessor(stage);

    }
    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        super.render();
        batch.end();

        // Setting fullscreen
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Restore stage's viewport
        stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize (int width, int height) {
            super.resize(width, height);
    }

    @Override
    public void pause () {
        super.pause();
    }


    @Override
    public void resume () {
        super.resume();
    }



    public void dispose () {
        stage.dispose();
    }


    @Override
    public boolean keyDown (int keycode) {
        return false;
    }

    @Override
    public boolean keyUp (int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped (char character) {
        return false;
    }

    // Will be using the touchDown and touchUp methods here for input
    @Override
    public boolean touchDown (int screenX, int screenY, int pointer, int button) {

        return false;
    }

    @Override
    public boolean touchUp (int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged (int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved (int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled (int amount) {
        return false;
    }
}




