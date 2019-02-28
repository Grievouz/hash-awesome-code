package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Dataset {
    public ArrayList<Image> Images;

    public Dataset(String name){
        try {
            File file = new File("assets/" + name + ".txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            String content = new String(data, "UTF-8");

            System.out.println(content);

        } catch (IOException exception){
            System.out.println(exception);
        }
    }


    private ArrayList<Image> StringToImages(String content){
        var images = new ArrayList<Image>();

        var lines = content.split("\n");

        for (int i = 1; i < lines.length; i++) {
            String[] lineData = lines[i].split(" ");

            var categories = new ArrayList<Category>();

            for (int j = 2; j < lineData.length; j++) {
                categories.add(new Category(lineData[j]));
            }

            var image = new Image(categories, lineData[0] == "H" ? ImageOrientations.Horizontal : ImageOrientations.Vertical);

            images.add(image);
        }

        return images;
    }

}


class DatasetB extends  Dataset {
    public DatasetB(){
        super("b_lovely_landscapes");
    }
}