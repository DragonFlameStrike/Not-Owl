package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Panel {
    private final Texture tx;
    private final Vector2 pos;
    private final Rectangle frameUp;
    private final Rectangle frameLeft;
    private final Rectangle frameRight;
    private final Rectangle frameDown;



    public Panel(int pos_x,int pos_y){
        tx = new Texture("Panel.png");
        pos = new Vector2(pos_x,pos_y);
        float height = 25;
        float width = 50;
        frameUp = new Rectangle(pos.x,pos.y+ height, width,1);
        frameLeft = new Rectangle(pos.x,pos.y,1, height -2);
        frameRight = new Rectangle(pos.x+ width -1,pos.y,1, height -2);
        frameDown = new Rectangle(pos.x,pos.y, width,1);

    }
    public void render(SpriteBatch batch){
        batch.draw(tx,pos.x,pos.y);
    }
    public Rectangle getFrameUp(){
        return frameUp;
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


}
