package com.kopo.grade;

public class Item {
    int idx;
    String name;
    int score;
    String created;
    String updated;


    Item() {

    }
    
    Item(int idx, String name, int score, String created, String updated){
        this.idx = idx;
        this.name = name;
        this.score = score;
        this.created = created;
        this.updated = updated;
    }

    Item(String name, int score){
        this.name = name;
        this.score = score;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setCreated(String created) {
        this.created = created;
    }
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getIdx() {
        return this.idx;
    }
    public int getScore() {
        return this.score;
    }
    public String getName() {
        return this.name;
    }
    public String getCreated() {
        return this.created;
    }
    public String getUpdated() {
        return this.updated;
    }
    

}
