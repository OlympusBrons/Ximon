package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

class XimonButton extends Actor {

    Sprite sprite;
    String sound;
    String name = "XimonButton";

    public XimonButton(String file, int x, int y, final String name) {
        sprite = new Sprite(new Texture(Gdx.files.internal(file)));
        this.setBounds(x, y, sprite.getWidth(), sprite.getHeight());
        this.name = name;

        setTouchable(Touchable.enabled);

        addListener(new InputListener(){


            // CURRENTLY UNDER CONSTRUCTION
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("You touched the " + this.toString() + " button.");
                return true;
                    }



            //            @Override
//            public boolean keyDown(InputEvent event, int keycode) {
//                if(keycode == Input.Keys.SPACE) {
//                    MoveByAction mba = new MoveByAction();
//                    mba.setAmount(100f, 0f);
//                    mba.setDuration(5f);
//
//                    XimonButton.this.addAction(mba);
//                }
//                return true;
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(sprite, this.getX(), this.getY(), this.getWidth()/2, this.getHeight()/2);

    }

    @Override
    public String toString() {
        return this.name;
    }
}
