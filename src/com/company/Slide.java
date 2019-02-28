package com.company;

import java.util.ArrayList;

public class Slide {
    public ArrayList<Image> Images;

    public Slide(ArrayList<Image> images){
        if(images.size() > 2){
            throw new RuntimeException("max 2 images per slide");
        } else if(images.size() == 2 && images.get(0).Orientation == ImageOrientations.Horizontal && images.get(1).Orientation == ImageOrientations.Horizontal){
            throw new RuntimeException("max 1 images per slide horizontal");
        }

        this.Images = images;
    }
}
