package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Spices {
    private Texture tx;
    private final Vector2 pos;
    private final Rectangle frameUp;
    private final Rectangle frameSpices;
    private final Rectangle frameLeft;
    private final Rectangle frameRight;
    private final Rectangle frameDown;



    public Spices(int pos_x,int pos_y){
        tx = new Texture("Spices.png");
        pos = new Vector2(pos_x,pos_y);
        float height = 25;
        float width = 50;
        frameUp = new Rectangle(pos.x,pos.y+11, width,1);
        frameSpices = new Rectangle(pos.x+4,pos.y+14, width -8,10);
        frameLeft = new Rectangle(pos.x,pos.y,1, height -12);
        frameRight = new Rectangle(pos.x+ width -1,pos.y,1, height -12);
        frameDown = new Rectangle(pos.x,pos.y, width,1);

    }
    public void render(SpriteBatch batch){
        batch.draw(tx,pos.x,pos.y);
    }
    public Rectangle getFrameUp(){
        return frameUp;
    }
    public Rectangle getFrameSpices(){
        return frameSpices;
    }
    public Rectangle getFrameLeft(){
        return frameLeft;
    }
    public Rectangle getFrameRight(){
        return frameRight;
    }
    public Rectangle getFrameDown(){
        return frameDown;
    }
    public void setSpicesBloodTx(){ tx = new Texture("SpicesBlood.png");}


}
