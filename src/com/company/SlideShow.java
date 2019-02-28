package com.company;

import java.util.ArrayList;

public abstract class SlideShow {
    public ArrayList<Slide> Slides = new ArrayList<Slide>();
    public ArrayList<Transition> Transitions = new ArrayList<Transition>();
    public Dataset Dataset;
    public int Score;

    public SlideShow(Dataset dataset){
        this.Dataset = dataset;
    }

    public void startEvaluation(){
        for (int i = 0; i < this.Transitions.size(); i++) {
            this.Score += this.Transitions.get(i).getScore();
        }
    }
    public void saveToFile(){}

    abstract void startAlgorithm();
}
