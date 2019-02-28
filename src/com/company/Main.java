package com.company;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    var slideshow = new TestSlideshow();
	    slideshow.startAlgorithm();
	    slideshow.startEvaluation();

	    slideshow.saveToFile();
    }
}


class TestSlideshow extends SlideShow {
    public TestSlideshow(){
        super(new DatasetB());
    }

    public void startAlgorithm(){
        Graph<String, DefaultEdge> graph = new WeightedMultigraph<>(DefaultEdge.class);
        Map<String, ArrayList<Image>> categoryMap = new HashMap<>();

        for (Image image : this.Dataset.Images){
            for (Category category: image.Categories) {
                if (!categoryMap.containsKey(category.Name))  {
                    categoryMap.put(category.Name, new ArrayList<>());
                }

                categoryMap.get(category.Name).add(image);
            }
        }

        for (String category: categoryMap.keySet()) {
            ArrayList<Image> images = categoryMap.get(category);

            for (int i = 0; i < images.size(); i++) {
                for (int j = 0; j < images.size(); j++) {
                    if (i == j)
                        continue;

                    new Transition(images.get(i), images.get(j));
                }
            }

            for (Image baseImage: images) {
                for (Image image: images) {

                }
            }
        }
    }
}
