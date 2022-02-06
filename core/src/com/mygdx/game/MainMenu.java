package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class MainMenu {
    private Texture tx;
    private final Vector2 pos;
    private final String[] textures;
    private int current_texture;


    public MainMenu(){
        textures = new String[]{
                "MainMenuStart.png",
                "MainMenuExit.png"
        };
        current_texture=0;
        tx = new Texture(textures[current_texture]);
        pos = new Vector2(0,0);


    }
    public void render(SpriteBatch batch){
        batch.draw(tx,pos.x,pos.y);
    }
    public int update() throws InterruptedException {
        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {

            if(current_texture!=textures.length-1){
                current_texture++;
                tx = new Texture(textures[current_texture]);
                Thread.sleep(100);
            }

        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if(current_texture!=0){
                current_texture--;
                tx = new Texture(textures[current_texture]);
                Thread.sleep(100);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.isKeyPressed(Input.Keys.E) || Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if(current_texture==0) { // start
                return 1;
            }
            if(current_texture==1) { // exit
                return 2;
            }
        }
        return 0;


    }
}
