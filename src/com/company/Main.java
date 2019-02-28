package com.company;

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

    public void startAlgorithm() {
        System.out.println("123");
    }
}
