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

import java.util.ArrayList;

class XimonButton extends Actor {

    Sprite sprite;
    private String name;
    private Sound sound;
    private final int num;
    private int count;
    XimonGame game = new XimonGame();


    public XimonButton (String file, int x, int y, int w, int h, final int colorCode) {
        sprite = new Sprite(new Texture(Gdx.files.internal(file)));
        this.setBounds(x, y, w, h);
        this.num = colorCode;
        count = 0;

            if (colorCode == 1) {
                sound = Gdx.audio.newSound(Gdx.files.internal("sounds/Green.wav"));
            }
            else if (colorCode == 2) {
                sound = Gdx.audio.newSound(Gdx.files.internal("sounds/Red.wav"));
            }
            else if (colorCode == 3) {
                sound = Gdx.audio.newSound(Gdx.files.internal("sounds/Yellow.wav"));
            }
            else if (colorCode == 4) {
                sound = Gdx.audio.newSound(Gdx.files.internal("sounds/Blue.wav"));
            }


        setTouchable(Touchable.enabled);

        // Used to handle touch input
        addListener(new ClickListener(){

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                sound.play(0.4f);

                if (XimonButton.this.isVisible()) XimonButton.this.setVisible(false);


//                System.out.println("Current player list contains:");
//                for (int i=0; i < playerList.size(); i++) {
//                    System.out.println(playerList.get(i));
//                }

                return true;
            }

            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                sound.stop();
                XimonButton.this.setVisible(true);


                // Counting number of touches for this turn
                XimonGame.buttonSequencer.incrementCount();
                System.out.println("Count is: " + XimonGame.buttonSequencer.getCount());

        //         Append the colorCode to the playerList HERE.
        //         Loop through the computer list to check if current touch matches
        //         the computer's num for the index in the ArrayList.

//                ButtonSequencer.playerList.add(num);

//                System.out.println("playerList is now: " + ButtonSequencer.playerList.toString());

            }



        });
        // Call computer num here



    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        batch.draw(sprite, this.getX(), this.getY(), this.getWidth(), this.getHeight());

    }



}
