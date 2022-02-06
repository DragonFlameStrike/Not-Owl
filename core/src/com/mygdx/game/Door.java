package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Door {
    private float height;
    private float width;
    private Texture tx;
    private Vector2 pos;
    private Rectangle frame;
    private boolean close;


    public Door() {
        tx = new Texture("DoorClose.png");
        close = true;
        pos = new Vector2(-100, -100);
        height = 50;
        width = 40;
        frame = new Rectangle(pos.x + 25, pos.y, 1, height / 2);
    }
    public Door(int posx, int posy, boolean closed) {
        if (closed) {
            tx = new Texture("DoorClose.png");
            close = true;
        } else {
            tx = new Texture("DoorOpen.png");
            close = false;
        }
        pos = new Vector2(posx + 5, posy);
        height = 50;
        width = 40;
        frame = new Rectangle(pos.x + 25, pos.y, 1, height / 2);

    }

    public void render(SpriteBatch batch) {
        batch.draw(tx, pos.x, pos.y);
    }

    public void OpenTheDoor() {
        tx = new Texture("DoorOpen.png");
        close = false;
    }

    public boolean CantOpen() {
        return close;
    }

    public Rectangle getFrame() {
        return frame;
    }
}
