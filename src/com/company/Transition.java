package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transition {
    public Image From;
    public Image To;

    private int Score = -1;

    public Transition(Image from, Image to){
        this.From = from;
        this.To = to;
    }

    public int getScore(){
        if(this.Score == -1){
            var numberOfCommonCategories = this.getNumberOfCommonCategories(this.categoriesToString(this.From.Categories), this.categoriesToString(this.To.Categories));

            var score = Math.min(Math.min(numberOfCommonCategories, this.From.Categories.size() - numberOfCommonCategories), this.To.Categories.size() - numberOfCommonCategories);

            this.Score = score;
        }

        return this.Score;
    }

    public int getNumberOfCommonCategories(String[] a, String[] b) {
        List<String> list1 = new ArrayList(Arrays.asList(a));
        List<String> list2 = Arrays.asList(b);
        list1.retainAll(list2);
        return list1.size();
    }

    public String[] categoriesToString(ArrayList<Category> categories){
        var strings = new String[categories.size()];

        for (int i = 0; i < categories.size(); i++) {
            strings[i] = categories.get(i).Name;
        }

        return  strings;
    }
}
