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
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
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
    private final int code;


    public XimonButton (String file, int x, int y, int w, int h, final int colorCode) {
        sprite = new Sprite(new Texture(Gdx.files.internal(file)));
        this.setBounds(x, y, w, h);
        this.num = colorCode;
        count = 0;
        code = colorCode;

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

        setTouchable(Touchable.disabled);

        try {
            performAISequence();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

//                Stop the sound and "turn off" the button light
                sound.stop();
                XimonButton.this.setVisible(true);


//                 Count the number of touches for this turn
                XimonGame.buttonSequencer.incrementCount();
                System.out.println("Count is: " + XimonGame.buttonSequencer.getCount());
                System.out.println("Color code is: " + colorCode);

//                 Append the colorCode to the playerList.
//                 Loop through the computer list to check if current touch matches
//                 the computer's num for the index in the ArrayList.
                XimonGame.playerList.add(colorCode);
                System.out.println("Player list is: " + XimonGame.playerList.toString() + "\n");
//

            }



        });




    }

    public void performAISequence () throws InterruptedException {

        setTouchable(Touchable.disabled);
        System.out.println(XimonGame.computerList.toString());
        for (int i = 0; i < XimonGame.computerList.size(); i++) {

            if (code == XimonGame.computerList.get(i)) {
                sound.play(0.4f);
                XimonButton.this.setVisible(false);
                Thread.sleep(XimonGame.buttonSequencer.getRandomInt(400,600));
                sound.stop();
                XimonButton.this.setVisible(true);
                Thread.sleep(XimonGame.buttonSequencer.getRandomInt(100,150));

            }

        }
        setTouchable(Touchable.enabled);
    }


    @Override
    public void draw (Batch batch, float parentAlpha) {
        batch.draw(sprite, this.getX(), this.getY(), this.getWidth(), this.getHeight());

    }



}
