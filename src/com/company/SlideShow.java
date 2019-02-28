package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

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

    public void saveToFile(){
        var date = new Date();

        var name = date.getHours() + "_" + date.getMinutes() + "_" + date.getSeconds();

        try (PrintStream out = new PrintStream(new FileOutputStream("calculated/" + name))) {
            out.print(this.slideShowToString());
        } catch (FileNotFoundException exception){
            System.out.println(exception);
        }
    }

    public String slideShowToString(){
        var string = this.Slides.size()+ "\n";

        for (int i = 0; i < this.Slides.size(); i++) {
            var slide = "";

            for (int j = 0; j < this.Slides.get(i).Images.size(); j++) {
                slide += this.Slides.get(i).Images.get(j) + " ";
            }

            string += slide + "\n";
        }

        return  string;
    }

    abstract void startAlgorithm();
}
