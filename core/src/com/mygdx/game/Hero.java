package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Hero {
    private float speed_y;
    private float speed_x;
    private final float accelerationdown;
    private Texture tx;
    private final Texture tx_right1;
    private final Texture tx_right2;
    private final Texture tx_right3;
    private final Texture tx_left1;
    private final Texture tx_left2;
    private final Texture tx_left3;
    private final Vector2 pos;
    private final Rectangle frame;
    private int jump_counter;
    private final int jump_limit;
    private final Vector2 startpos;
    private boolean leftlooking;


    public Hero() {
        tx_left1 = new Texture("HeroLeft1.png");
        tx_left2 = new Texture("HeroLeft2.png");
        tx_left3 = new Texture("HeroLeft3.png");
        tx_right1 = new Texture("HeroRight1.png");
        tx_right2 = new Texture("HeroRight2.png");
        tx_right3 = new Texture("HeroRight3.png");
        leftlooking = false;
        tx = tx_right1;
        pos = new Vector2(0, 0);
        startpos = new Vector2(0, 0);
        speed_y = 0;
        speed_x = 0;
        jump_counter = 0;
        jump_limit = 2;
        accelerationdown = -0.7f;
        float height = 48;
        float width = 32;
        frame = new Rectangle(pos.x + 6, pos.y + 1, width - 12, height - 1);
    }

    public void render(SpriteBatch batch) {
        batch.draw(tx, pos.x, pos.y);
    }

    public Vector2 update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (jump_counter < jump_limit) {
                speed_y = 8;
                jump_counter++;

            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            speed_x -= 0.7;
            leftlooking = true;

        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            speed_x += 0.7;
            leftlooking = false;

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            die();
        }
        Vector2 lastpos = new Vector2(pos.x, pos.y);
        if (leftlooking) {
            if (speed_y > -4) {
                tx = tx_left1;
            } else if (speed_y <= -4 && speed_y > -7) {
                tx = tx_left2;
            } else {
                tx = tx_left3;
            }
        } else {
            if (speed_y > -4) {
                tx = tx_right1;
            } else if (speed_y <= -4 && speed_y > -7) {
                tx = tx_right2;
            } else {
                tx = tx_right3;
            }
        }
        pos.y += speed_y;
        pos.x += speed_x;
        frame.x = pos.x + 6;
        frame.y = pos.y + 1;
        speed_x /= 1.2; //inertion
        if (Math.abs(speed_x) < 0.5) {
            speed_x = 0;
        }
        if (speed_x > 3) speed_x = 3;
        if (speed_x < -3) speed_x = -3;
        speed_y += accelerationdown;
        return lastpos;
    }

    public void setSpeed_y(float new_speed_y) {
        speed_y = new_speed_y;
    }

    public void setSpeed_x(float new_speed_x) {
        speed_x = new_speed_x;
    }

    public void setPos_y(float y) {
        pos.y = y;
    }

    public void setPos_x(float x) {
        pos.x = x;
    }

    public void setPos(Vector2 pos_new) {
        pos.x = pos_new.x;
        pos.y = pos_new.y;
    }

    public void setStartpos(Vector2 pos_new) {
        startpos.x = pos_new.x;
        startpos.y = pos_new.y;
    }

    public Rectangle getFrame() {
        return frame;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void resetJump_counter() {
        jump_counter = 0;
    }

    public void die() {
        setPos(startpos);
        speed_x = 0;
        speed_y = 0;
    }
}
