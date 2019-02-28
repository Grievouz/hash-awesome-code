package com.company;

import org.jgrapht.Graph;
import org.jgrapht.alg.tour.ChristofidesThreeHalvesApproxMetricTSP;
import org.jgrapht.alg.tour.HeldKarpTSP;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
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
        var graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        Map<String, ArrayList<Image>> categoryMap = new HashMap<>();

        for (Image image : this.Dataset.Images){
            graph.addVertex(image.Id.toString());

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

                    Transition trans = new Transition(images.get(i), images.get(j));
                    DefaultWeightedEdge e = graph.addEdge(images.get(i).Id.toString(), images.get(j).Id.toString());
                    graph.setEdgeWeight(e, -trans.getScore());
                }
            }
        }


        var solver = new HeldKarpTSP();
        var tour = solver.getTour(graph);

        System.out.println(tour.toString());
    }
}