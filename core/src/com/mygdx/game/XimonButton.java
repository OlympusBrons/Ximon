package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.XimonGame;

class XimonButton extends Actor {

    Sprite sprite;
    private String name = "XimonButton";
    private Sound sound;


    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }


    public XimonButton (String file, int x, int y, int w, int h, final String name) {
        sprite = new Sprite(new Texture(Gdx.files.internal(file)));
        this.setBounds(x, y, w, h);
        this.name = name;

            if (name == "green") {
                sound = Gdx.audio.newSound(Gdx.files.internal("sounds/Green.wav"));

            }
            else if (name == "red") {
                sound = Gdx.audio.newSound(Gdx.files.internal("sounds/Red.wav"));
            }
            else if (name == "yellow") {
                sound = Gdx.audio.newSound(Gdx.files.internal("sounds/Yellow.wav"));
            }
            else if (name == "blue") {
                sound = Gdx.audio.newSound(Gdx.files.internal("sounds/Blue.wav"));
            }
            else {
                System.out.println("Error: invalid string for " + this.toString());
            }

        setTouchable(Touchable.enabled);

        // Used to handle touch input
        addListener(new ClickListener(){

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("You touched the " + getName() + " button.");
                sound.play(0.4f);
                if (XimonButton.this.isVisible() == true) {
                    XimonButton.this.setVisible(false);
                }

                return true;
            }

            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                sound.stop();
                XimonButton.this.setVisible(true);


            }

        });
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        batch.draw(sprite, this.getX(), this.getY(), this.getWidth(), this.getHeight());

    }

}
