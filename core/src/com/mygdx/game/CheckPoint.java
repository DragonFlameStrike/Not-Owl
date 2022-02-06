package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class CheckPoint {
    private final float height;
    private final float width;
    private Texture tx;
    private final Vector2 pos;
    private Rectangle frame;
    private boolean delete;

    public CheckPoint() {
        tx = new Texture("CheckPoint.png");
        pos = new Vector2(-100, -100);
        height = 20;
        width = 50;
        frame = new Rectangle(pos.x, pos.y, width, height);
        delete = true;
    }

    public CheckPoint(int posx, int posy) {
        tx = new Texture("CheckPoint.png");
        pos = new Vector2(posx, posy);
        height = 20;
        width = 50;
        frame = new Rectangle(pos.x, pos.y, width, height);
        delete = false;

    }

    public void render(SpriteBatch batch) {
        if (!delete) {
            batch.draw(tx, pos.x, pos.y);
        }
    }

    public Rectangle getFrame() {
        return frame;
    }

    public float getPos_x() {
        return pos.x;
    }

    public float getPos_y() {
        return pos.y;
    }

    public void setCheckPointActiveTx() {
        tx = new Texture("CheckPointActive.png");
    }

    public void delete() {
        Vector2 deletePos = new Vector2(-100, -100);
        frame = new Rectangle(deletePos.x + 22, deletePos.y + 10, 6, 6);
        delete = true;

    }
}
