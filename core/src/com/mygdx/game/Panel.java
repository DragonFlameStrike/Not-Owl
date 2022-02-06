package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Panel {
    private float height;
    private float width;
    private Texture tx;
    private Vector2 pos;
    private Rectangle frameup;
    private Rectangle frameleft;
    private Rectangle frameright;
    private Rectangle framedown;



    public Panel(int posx,int posy){
        tx = new Texture("Panel.png");
        pos = new Vector2(posx,posy);
        height=25;
        width=50;
        frameup = new Rectangle(pos.x,pos.y+height,width,1);
        frameleft = new Rectangle(pos.x,pos.y,1,height-2);
        frameright = new Rectangle(pos.x+width-1,pos.y,1,height-2);
        framedown = new Rectangle(pos.x,pos.y,width,1);

    }
    public void render(SpriteBatch batch){
        batch.draw(tx,pos.x,pos.y);
    }
    public Rectangle getFrameup(){
        return frameup;
    }
    public Rectangle getFrameleft(){
        return frameleft;
    }
    public Rectangle getFrameright(){
        return frameright;
    }
    public Rectangle getFramedown(){
        return framedown;
    }


}
