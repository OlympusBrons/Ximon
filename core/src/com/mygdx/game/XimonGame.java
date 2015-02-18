package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class XimonGame extends ApplicationAdapter implements InputProcessor {
    private SpriteBatch batch;
    private Stage stage;
    private OrthographicCamera camera;
    private Skin skin;
    private WidgetGroup widgetGroup;


    @Override
    public void create () {
        batch = new SpriteBatch();
        // Creating camera
        camera = new OrthographicCamera(800, 480);

        // Creating stage and actors
        stage = new Stage(new FitViewport(800, 480, camera));

        XimonButton actor_g = new XimonButton("img/Ximon_00ff00.png", 190, 240, 210, 210, "green");
        System.out.println(actor_g.toString() + " created.");
        XimonButton actor_r = new XimonButton("img/Ximon_ff0000.png", 400, 240, 210, 210, "red");
        System.out.println(actor_r.toString() + " created.");
        XimonButton actor_y = new XimonButton("img/Ximon_ffff00.png", 190, 30, 210, 210, "yellow");
        System.out.println(actor_y.toString() + " created.");
        XimonButton actor_b = new XimonButton("img/Ximon_0000ff.png", 400, 30, 210, 210, "blue");
        System.out.println(actor_b.toString() + " created.");


//        XimonButton actor_g = new XimonButton("img/Ximon_00ff00.png", 0, 240, 240, 240, "green");
//        System.out.println(actor_g.toString() + " created.");
//        XimonButton actor_b = new XimonButton("img/Ximon_0000ff.png", 240, 0, 240, 240, "blue");
//        System.out.println(actor_b.toString() + " created.");
//        XimonButton actor_r = new XimonButton("img/Ximon_ff0000.png", 240, 240, 240, 240, "red");
//        System.out.println(actor_r.toString() + " created.");
//        XimonButton actor_y = new XimonButton("img/Ximon_ffff00.png", 0, 0, 240, 240, "yellow");
//        System.out.println(actor_y.toString() + " created.");

//        Adding actors and assigning sprites to them
//
//        Actor - Green button:
        stage.addActor(actor_g);

        // Actor - Blue button:
        stage.addActor(actor_b);

        // Actor - Red button:
        stage.addActor(actor_r);

        // Actor - Yellow button:
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

    }

    @Override
    public void pause () {

    }


    @Override
    public void resume () {

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




