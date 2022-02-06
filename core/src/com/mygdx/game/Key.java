package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Key {
    private float height;
    private float width;
    private Texture tx;
    private Vector2 pos;
    private Rectangle frame;
    public Key() {
        tx = new Texture("Key.png");
        pos = new Vector2(-100, -100);
        height = 20;
        width = 40;
        frame = new Rectangle(pos.x + 5, pos.y, width, height);
    }
    public Key(int posx, int posy) {
        tx = new Texture("Key.png");
        pos = new Vector2(posx, posy);
        height = 20;
        width = 40;
        frame = new Rectangle(pos.x + 5, pos.y, width, height);

    }

    public void render(SpriteBatch batch) {
        batch.draw(tx, pos.x, pos.y);
    }

    public Rectangle getFrame() {
        return frame;
    }

    public void delete() {
        pos.x = -100;
        pos.y = -100;
        frame = new Rectangle(pos.x + 5, pos.y, width, height);
    }
}
