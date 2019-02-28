package com.company;

import java.util.ArrayList;

enum ImageOrientations {
    Vertical,
    Horizontal
}

public class Image {
    public ArrayList<Category> Categories;
    public ImageOrientations Orientation;

    public Image(ArrayList<Category> categories, ImageOrientations orientation){
        this.Categories = categories;
        this.Orientation = orientation;
    }
}
