package com.company;

import java.util.ArrayList;

enum ImageOrientations {
    Vertical,
    Horizontal
}

public class Image {
    public ArrayList<Category> Categories;
    public ImageOrientations Orientation;
    public Integer Id;

    public Image(ArrayList<Category> categories, ImageOrientations orientation, Integer id) {
        this.Categories = categories;
        this.Orientation = orientation;
    }
}
