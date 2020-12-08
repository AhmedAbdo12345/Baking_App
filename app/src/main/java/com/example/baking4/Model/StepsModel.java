package com.example.baking4.Model;

import java.util.ArrayList;

public class StepsModel {
    private ArrayList<String> stepsID;
    private ArrayList<String> shortDescription;
    private ArrayList<String> description ;
    private ArrayList<String> videoURL ;
    private ArrayList<String> thumbnailURL ;

    public StepsModel(){

    }

    public StepsModel(ArrayList<String> stepsID, ArrayList<String> shortDescription, ArrayList<String> description, ArrayList<String> videoURL, ArrayList<String> thumbnailURL) {
        this.stepsID = stepsID;
        this.shortDescription = shortDescription;
        this.description = description;
        this.videoURL = videoURL;
        this.thumbnailURL = thumbnailURL;
    }

    public ArrayList<String> getStepsID() {
        return stepsID;
    }

    public void setStepsID(ArrayList<String> stepsID) {
        this.stepsID = stepsID;
    }

    public ArrayList<String> getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(ArrayList<String> shortDescription) {
        this.shortDescription = shortDescription;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    public ArrayList<String> getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(ArrayList<String> videoURL) {
        this.videoURL = videoURL;
    }

    public ArrayList<String> getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(ArrayList<String> thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }
}
