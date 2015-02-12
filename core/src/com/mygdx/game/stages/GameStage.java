package com.mygdx.game.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class GameStage extends Stage {

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
    private Attribute attribute;


    public void show() {

        //Gdx.input.setInputProcessor(this);
        // width and height of native screen
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        System.out.println(spriteAlphaString);

        // Loading Textures, SpriteBatch, Sprite
        batch = new SpriteBatch();
        simonpad = new Texture(Gdx.files.internal("images/simon.png"));
        sprite = new Sprite(simonpad);

        // Creating Bitmap font
        font = new BitmapFont();
        font.setColor(Color.RED);
        font.setScale(1.0f);


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


        // Testing testing testing testing
        sprite.setColor(Color.rgba8888(.5f,.5f,.5f,.8f));
        spriteColor = sprite.getColor();
        spriteAlphaString = Float.toString(spriteColor.a);
        System.out.println("\nSprite color is  " + spriteColor);
        System.out.println("Sprite red: " + sprite.getColor().r);
        System.out.println("Sprite green: " + sprite.getColor().g);
        System.out.println("Sprite blue: " + sprite.getColor().b);
        System.out.println("Sprite alpha: " + sprite.getColor().a);
        System.out.println("What the heck...");




    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();


        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(simonpad, 0, 0, w, h);
        font.draw(batch, "Alpha channel value of sprite: " + spriteAlphaString, 400, 20);
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
    public void dispose() {

    }
}
