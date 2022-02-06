package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class JumpHelper {
    private final Texture tx;
    private int reload_counter;
    private final Vector2 startPos;
    private boolean delete;
    private Rectangle frame;

    public JumpHelper(int posx, int posy) {
        reload_counter = 0;
        tx = new Texture("JumpHelper.png");
        startPos = new Vector2(posx, posy);
        frame = new Rectangle(startPos.x + 18, startPos.y + 7, 12, 12);
        delete = false;
    }

    public void render(SpriteBatch batch) {
        if(!delete){
            batch.draw(tx, startPos.x, startPos.y);
        }
    }

    public Rectangle getFrame() {
        return frame;
    }

    public void delete() {
        Vector2 deletePos = new Vector2(-100, -100);
        frame = new Rectangle(deletePos.x + 22, deletePos.y + 10, 6, 6);
        reload_counter = 0;
        delete = true;
    }

    public void update() {
        if (delete) {
            reload_counter++;
            if (reload_counter > 200) {
                frame = new Rectangle(startPos.x + 22, startPos.y + 10, 6, 6);
                delete = false;
            }
        }
    }
}
