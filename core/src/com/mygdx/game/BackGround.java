package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class BackGround {
    private final Texture tx;
    private final Vector2 pos;
    public Rectangle frameLeft = new Rectangle(0, 0, 1, 600);
    public Rectangle frameRight = new Rectangle(800, 0, 1, 600);

    public BackGround() {
        tx = new Texture("BackGround1.png");
        pos = new Vector2(0, 0);
    }

    public void render(SpriteBatch batch) {
        batch.draw(tx, pos.x, pos.y);
    }

    public Rectangle getFrameLeft() {
        return frameLeft;
    }

    public Rectangle getFrameRight() {
        return frameRight;
    }
}
