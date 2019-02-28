package com.company;

import java.util.ArrayList;

public abstract class SlideShow {
    public ArrayList<Slide> Slides = new ArrayList<Slide>();
    public Dataset Dataset;

    public SlideShow(Dataset dataset){
        this.Dataset = dataset;
    }

    public void startEvaluation(){}

    abstract void startAlgorithm();
}
