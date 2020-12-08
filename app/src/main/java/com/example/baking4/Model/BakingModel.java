package com.example.baking4.Model;

import java.util.ArrayList;

public class BakingModel {
//    private int Baking_id;
//    private String  name;
//
//
//
//
//    /*-------------------------------Constructor-----------------------------------------------------*/
//    public BakingModel(){
//
//    }
//
//    public BakingModel(int baking_id, String name) {
//        Baking_id = baking_id;
//        this.name = name;
//    }
//
//    public int getBaking_id() {
//        return Baking_id;
//    }
//
//    public void setBaking_id(int baking_id) {
//        Baking_id = baking_id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
    /*--------------------------------------------------*/
    private ArrayList<Integer> Baking_id;
    private ArrayList<String>   name;




    /*-------------------------------Constructor-----------------------------------------------------*/
    public BakingModel(){

    }

    public BakingModel(ArrayList<Integer> baking_id, ArrayList<String> name) {
        Baking_id = baking_id;
        this.name = name;
    }

    public ArrayList<Integer> getBaking_id() {
        return Baking_id;
    }

    public void setBaking_id(ArrayList<Integer> baking_id) {
        Baking_id = baking_id;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }
}
