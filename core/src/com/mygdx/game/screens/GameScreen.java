package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public class GameScreen implements Screen {

    OrthographicCamera camera;
    SpriteBatch batch;
    private float w;
    private float h;
    private Texture simonpad;
    private BitmapFont font;
    private Color spriteColor;
    private Sound grnbeep;
    private Sound redbeep;
    private Sound yelbeep;
    private Sound blubeep;
    private Sound razbeep;
    private Sprite sprite;
    private String spriteAlphaString;

    @Override
    public void show() {
        //Gdx.input.setInputProcessor(this);
        // width and height of native screen
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();


        // Loading Textures, SpriteBatch, Sprite
        batch = new SpriteBatch();
        simonpad = new Texture(Gdx.files.internal("images/simon.png"));
        sprite = new Sprite(simonpad);
        font = new BitmapFont();
        font.setColor(Color.RED);
        font.setScale(5.0f);

        // Loading camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // Loading sounds
        grnbeep = Gdx.audio.newSound(Gdx.files.internal("sounds/Green.wav"));
        redbeep = Gdx.audio.newSound(Gdx.files.internal("sounds/Red.wav"));
        yelbeep = Gdx.audio.newSound(Gdx.files.internal("sounds/Yellow.wav"));
        blubeep = Gdx.audio.newSound(Gdx.files.internal("sounds/Blue.wav"));
        razbeep = Gdx.audio.newSound(Gdx.files.internal("sounds/RAZZ.wav"));

        // Assigning alpha channel value to a variable
        spriteColor = sprite.getColor();

        spriteAlphaString = Float.toString(spriteColor.a);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();


        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(simonpad, 0, 0, w, h);
        font.draw(batch, "Alpha channel value of sprite: " + spriteAlphaString, 200, 200);
        batch.end();

        //   USE THIS FOR BUTTON FUNCTIONALITY!!!!!
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
//            if (spriteColor.a > 0.0f) {
//                Gdx.input.vibrate(500);
//                grnbeep.play(0.3f);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                grnbeep.stop();
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
