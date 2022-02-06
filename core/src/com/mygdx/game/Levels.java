package com.mygdx.game;

import java.io.FileReader;
import java.lang.reflect.Array;

public class Levels {

    private String level1 = "D:\\Program Files\\JetBrains\\IntelliJ IDEA 2021.3.1\\IdeaProjects\\game\\core\\levels\\level1";
    private String level2 = "D:\\Program Files\\JetBrains\\IntelliJ IDEA 2021.3.1\\IdeaProjects\\game\\core\\levels\\level2";
    private String level3 = "D:\\Program Files\\JetBrains\\IntelliJ IDEA 2021.3.1\\IdeaProjects\\game\\core\\levels\\level3";
    private String level4 = "D:\\Program Files\\JetBrains\\IntelliJ IDEA 2021.3.1\\IdeaProjects\\game\\core\\levels\\level4";
    private String[] all_levels = new String[]{
            level1,
            level2,
            level3,
            level4
    };
    private int current_level = 2;
    public void NextLevel(){
        current_level++;
    }
    public String getCurrentLevel(){
        return all_levels[current_level];
    }
}
