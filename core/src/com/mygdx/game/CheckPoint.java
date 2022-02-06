package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class CheckPoint {
    private float height;
    private float width;
    private Texture tx;
    private Vector2 pos;
    private Rectangle frame;
    public CheckPoint() {
        tx = new Texture("CheckPoint.png");
        pos = new Vector2(-100, -100);
        height = 20;
        width = 50;
        frame = new Rectangle(pos.x , pos.y, width, height);
    }
    public CheckPoint(int posx, int posy) {
        tx = new Texture("CheckPoint.png");
        pos = new Vector2(posx, posy);
        height = 20;
        width = 50;
        frame = new Rectangle(pos.x , pos.y, width, height);

    }

    public void render(SpriteBatch batch) {
        batch.draw(tx, pos.x, pos.y);
    }

    public Rectangle getFrame() {
        return frame;
    }

    public float getPos_x(){
        return pos.x;
    }
    public float getPos_y(){
        return pos.y;
    }
    public void setCheckPointAtciveTx(){ tx = new Texture("CheckPointActive.png");}
}
