package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

//
// This class is only set up to help understand actors
//
//
//
//
//
class MyActor extends Actor {

    Sprite sprite = new Sprite(new Texture(Gdx.files.internal("images/simon.png")));

    public MyActor() {
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        setTouchable(Touchable.enabled);

        addListener(new InputListener(){
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if(keycode == Input.Keys.SPACE) {
                    MoveByAction mba = new MoveByAction();
                    mba.setAmount(100f, 0f);
                    mba.setDuration(5f);

                    MyActor.this.addAction(mba);
                }
                return true;
            }
        });

    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }


}