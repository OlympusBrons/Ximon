package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.screens.GameScreen;


public class XimonGame extends Game {


    private Color spriteColor;
    private float alpha;
    private String spriteAlphaString;

    private FreeTypeFontGenerator generator;
    private FreeTypeFontParameter parameter;
    private AssetManager manager;
    private FileHandleResolver resolver;
    private Sprite sprite;
    private Sprite spriteG;
    private Sprite spriteR;
    private Sprite spriteY;
    private Sprite spriteB;



    @Override
    public void create() {
        setScreen(new GameScreen());
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


}




