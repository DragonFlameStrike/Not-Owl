package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import java.io.FileReader;
import java.io.IOException;


public class MyGdxGame extends ApplicationAdapter {
    public SpriteBatch batch;
    public BackGround bg;
    public Hero hero;
    public Door door;
    public Key key;
    public CheckPoint checkpoint;
    public MainMenu menu;
    public Levels levels;
    public Array<Panel> panels;
    public Array<Spices> spices;
    public int current_level;
    public int start_game;


    @Override
    public void create() {
        //const objects
        batch = new SpriteBatch();
        bg = new BackGround();
        menu = new MainMenu();
        //changing objects
        levels = new Levels();
        current_level = 0;
        start_game = 0;
        hero = new Hero();
        key = new Key();
        checkpoint = new CheckPoint();
        door = new Door();
        panels = new Array<>();
        spices = new Array<>();

    }

    @Override
    public void render() {
        try {
            update();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        bg.render(batch);
        if (start_game == 0) {
            menu.render(batch);
        }
        if (start_game == 1) {
            for (Spices spice : spices) {
                spice.render(batch);
            }
            for (Panel panel : panels) {
                panel.render(batch);
            }
            door.render(batch);
            hero.render(batch);
            key.render(batch);
            checkpoint.render(batch);
        }
        batch.end();
    }

    public void update() throws InterruptedException {
        if (start_game == 0) {
            start_game = menu.update();
            if (start_game == 1) {
                loadLevel();
            }
        }
        if (start_game == 1) {
            Vector2 lastHeroPos = hero.update();
            check_panels(lastHeroPos);
            check_spices(lastHeroPos);
            check_bg(lastHeroPos);
            check_underwindow();
            check_door();
            check_key();
            check_checkpoint();

        }

    }

    @Override
    public void dispose() {
        batch.dispose();

    }

    public void level_update(FileReader level) throws IOException {
        // читаем посимвольно
        panels.clear();
        spices.clear();
        int c;
        int x_counter = 0;
        int y_counter = 23;
        while ((c = level.read()) != -1) {
            // panel - 1
            // hero - 2
            // spices - 3
            // OpenDoor - 4
            // CloseDoor - 5
            // Key - 6
            // CheckPoint - 7
            if (c == '1') {
                panels.add(new Panel(x_counter * 50, y_counter * 25));
            }
            if (c == '2') {
                Vector2 pos = new Vector2(x_counter * 50, y_counter * 25);
                hero.setPos(pos);
                hero.setStartpos(pos);
            }
            if (c == '3') {
                spices.add(new Spices(x_counter * 50, y_counter * 25));
            }
            if (c == '4') {
                door = new Door(x_counter * 50, y_counter * 25, false);
            }
            if (c == '5') {
                door = new Door(x_counter * 50, y_counter * 25, true);
            }
            if (c == '6') {
                key = new Key(x_counter * 50, y_counter * 25);
            }
            if (c == '7') {
                checkpoint = new CheckPoint(x_counter * 50, y_counter * 25);
            }
            x_counter++;
            if (x_counter > 15) {
                x_counter = -2;
                y_counter--;
            }

        }
    }

    public void check_panels(Vector2 lastHeroPos) {
        for (Panel panel : panels) {
            if (hero.getFrame().overlaps(panel.getFrameUp())) {
                hero.setSpeed_y(0);
                hero.resetJump_counter();
                hero.setPos_y(lastHeroPos.y);
            }
            if (hero.getFrame().overlaps(panel.getFrameLeft())) {
                hero.setSpeed_x(0);
                hero.setPos_x(lastHeroPos.x);
            }
            if (hero.getFrame().overlaps(panel.getFrameRight())) {
                hero.setSpeed_x(0);
                hero.setPos_x(lastHeroPos.x);
            }
            if (hero.getFrame().overlaps(panel.getFrameDown())) {
                hero.setSpeed_y(0);
                hero.setPos_y(lastHeroPos.y);
            }
        }
    }

    public void check_spices(Vector2 lastHeroPos) {
        for (Spices spice : spices) {
            if (hero.getFrame().overlaps(spice.getFrameUp())) {
                hero.setSpeed_y(0);
                hero.resetJump_counter();
                hero.setPos_y(lastHeroPos.y);
            }
            if (hero.getFrame().overlaps(spice.getFrameLeft())) {
                hero.setSpeed_x(0);
                hero.setPos_x(lastHeroPos.x);
            }
            if (hero.getFrame().overlaps(spice.getFrameRight())) {
                hero.setSpeed_x(0);
                hero.setPos_x(lastHeroPos.x);
            }
            if (hero.getFrame().overlaps(spice.getFrameDown())) {
                hero.setSpeed_y(0);
                hero.setPos_y(lastHeroPos.y);
            }
            if (hero.getFrame().overlaps(spice.getFrameSpices())) {
                hero.die();
                spice.setSpicesBloodTx();
            }
        }
    }

    public void check_bg(Vector2 lastHeroPos) {
        if (hero.getFrame().overlaps(bg.getFrameLeft()) || hero.getFrame().overlaps(bg.getFrameRight())) {
            hero.setSpeed_x(0);
            hero.setPos_x(lastHeroPos.x);
        }
    }

    public void check_key() {
        if (hero.getFrame().overlaps(key.getFrame())) {
            door.OpenTheDoor();
            key.delete();
        }
    }

    public void check_checkpoint(){
        if (hero.getFrame().overlaps(checkpoint.getFrame())) {
            Vector2 current_pos = new Vector2(checkpoint.getPos_x(),checkpoint.getPos_y());
            hero.setStartpos(current_pos);
            checkpoint.setCheckPointActiveTx();
        }
    }

    public void check_underwindow() {
        if (hero.getPos().y < -50) {
            hero.die();
        }
    }

    public void check_door() {
        if (hero.getFrame().overlaps(door.getFrame()) && !door.CantOpen()) {
            levels.NextLevel();
            hero.setPos_x(0);
            hero.setPos_y(0);
            loadLevel();
        }
    }

    public void loadLevel() {
        try (FileReader level = new FileReader(levels.getCurrentLevel())) {
            level_update(level);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
