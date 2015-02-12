package com.mygdx.game;


import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.ColorAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//
// This class is only set up to help me understand actors
//
//
//
//
//

public class MyActor2 extends Image {

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(this.getColor());

        ((TextureRegionDrawable)getDrawable()).draw(batch, getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation());
    }

    public MyActor2(Texture texture) {
        super(texture);

        setBounds(getX(),getY(),getWidth(),getHeight());

        addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                switch(keycode) {
                    case Input.Keys.NUM_1:
                        MoveToAction moveToAction = new MoveToAction();
                        moveToAction.setPosition(200f,200f);
                        moveToAction.setDuration(5f);
                        MyActor2.this.addAction(moveToAction);
                        break;

                    case Input.Keys.NUM_2:
                        MoveByAction moveByAction = new MoveByAction();
                        moveByAction.setAmount(-200f,0f);
                        moveByAction.setDuration(3f);
                        MyActor2.this.addAction(moveByAction);
                        break;

                    case Input.Keys.NUM_3:
                        ColorAction colorAction = new ColorAction();
                        colorAction.setEndColor(Color.PURPLE);
                        colorAction.setDuration(.07f);
                        MyActor2.this.addAction(colorAction);
                        break;

                    case Input.Keys.NUM_4:
                        RotateToAction rta = new RotateToAction();
                        rta.setRotation(90f);
                        rta.setDuration(3f);

                        ScaleByAction sba = new ScaleByAction();
                        sba.setAmount(2f);
                        sba.setDuration(3f);

                        ParallelAction pa = new ParallelAction(rta, sba);
                        MyActor2.this.addAction(pa);


                        break;
                    }
                return true;
            }
        });
    }

}
