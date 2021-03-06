package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.ArrayList;


public class XimonGame extends Game {

    private SpriteBatch batch;
    private Stage stage;
    private OrthographicCamera camera;
    XimonButton actor_g;
    XimonButton actor_gLit;
    XimonButton actor_r;
    XimonButton actor_rLit;
    XimonButton actor_y;
    XimonButton actor_yLit;
    XimonButton actor_b;
    XimonButton actor_bLit;
    public static ArrayList<Integer> playerList;
    public static ArrayList<Integer> computerList;
    public static ButtonSequencer buttonSequencer;
    private Sound beepGreen;
    private Sound beepRed;
    private Sound beepYellow;
    private Sound beepBlue;
    public RunnableAction ra;


    @Override
    public void create () {
        batch = new SpriteBatch();
        // Creating camera
        camera = new OrthographicCamera(800, 480);

        // Creating stage and actors
        stage = new Stage(new FitViewport(800, 480, camera));

        ra = new RunnableAction();

        // Creating ArrayLists & ButtonSequencer
        playerList = new ArrayList<Integer>();
        computerList = new ArrayList<Integer>();
        buttonSequencer = new ButtonSequencer();

        // Appending initial random number to computerList:
        buttonSequencer.appendRandomNumber(1, 4, computerList);
        System.out.println("Created computer's ArrayList.\nInitial number is: "
        + computerList.get(0));
        System.out.println("Size of computerList is currently " + computerList.size());

        // Creating sounds (for computer's playback)
        beepGreen = Gdx.audio.newSound(Gdx.files.internal("sounds/Green.wav"));
        beepRed = Gdx.audio.newSound(Gdx.files.internal("sounds/Red.wav"));
        beepYellow = Gdx.audio.newSound(Gdx.files.internal("sounds/Yellow.wav"));
        beepBlue = Gdx.audio.newSound(Gdx.files.internal("sounds/Blue.wav"));

        // Creating (constructing) actors. Parameter info:
        // XimonButton("[png file]", x, y, width, height, "[name]")
        actor_g = new XimonButton("img/green.png", 190, 240, 210, 210, 1);
        System.out.println(actor_g.toString() + " created.");
        // Lit version of button
        actor_gLit = new XimonButton("img/green_on.png", 190, 240, 210, 210, 0);

        actor_r = new XimonButton("img/red.png", 400, 240, 210, 210, 2);
        System.out.println(actor_r.toString() + " created.");
        // Lit version of button
        actor_rLit = new XimonButton("img/red_on.png", 400, 240, 210, 210, 0);

        actor_y = new XimonButton("img/yellow.png", 190, 30, 210, 210, 3);
        System.out.println(actor_y.toString() + " created.");
        // Lit version of button
        actor_yLit = new XimonButton("img/yellow_on.png", 190, 30, 210, 210, 0);

        actor_b = new XimonButton("img/blue.png", 400, 30, 210, 210, 4);
        System.out.println(actor_b.toString() + " created.");
        // Lit version of button
        actor_bLit = new XimonButton("img/blue_on.png", 400, 30, 210, 210, 0);


//        ADDING ACTORS
//
        // Green buttons:
        stage.addActor(actor_gLit);
        stage.addActor(actor_g);
        // Red buttons:
        stage.addActor(actor_rLit);
        stage.addActor(actor_r);
        // Yellow buttons:
        stage.addActor(actor_yLit);
        stage.addActor(actor_y);
        // Blue buttons:
        stage.addActor(actor_bLit);
        stage.addActor(actor_b);





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
    public void setScreen(Screen screen) {
        super.setScreen(screen);
    }

    @Override
    public Screen getScreen() {
        return super.getScreen();
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




}




