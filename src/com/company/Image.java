package com.company;

import java.util.ArrayList;

enum ImageOrientations {
    Vertical,
    Horizontal
}

public class Image {
    public ArrayList<Category> Categories;
    public ImageOrientations Orientation;
    public int Id;

    public Image(ArrayList<Category> categories, ImageOrientations orientation, int id) {
        this.Id = id;
        this.Categories = categories;
        this.Orientation = orientation;
    }
}
