package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;


public class Saw {
    private Texture tx;
    private final Vector2 pos;
    private final Circle frameSaw;
    private final String[] textures;
    private int current_texture;
    private int temp_counter;



    public Saw(int pos_x,int pos_y){
        textures = new String[]{
                "Saw1.png",
                "Saw2.png",
                "Saw3.png"
        };
        current_texture=0;
        temp_counter=0;
        tx = new Texture(textures[current_texture]);
        pos = new Vector2(pos_x,pos_y);
        frameSaw = new Circle(pos_x+24,pos_y+24,25);

    }
    public void render(SpriteBatch batch){
        batch.draw(tx,pos.x,pos.y);
    }
    public Circle getFrameSaw(){
        return frameSaw;
    }
    public void update(){
        temp_counter++;
        if(temp_counter>1) {
            current_texture++;
            temp_counter=0;
            if (current_texture > 2) {
                current_texture = 0;
            }
            tx = new Texture(textures[current_texture]);

        }
    }




}
