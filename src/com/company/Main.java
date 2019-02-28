package com.company;

public class Main {

    public static void main(String[] args) {
	    new TestSlideshow();
    }
}


class TestSlideshow extends SlideShow {
    public TestSlideshow(){
        super(new DatasetB());
    }

    public void startAlgorithm(){

    }
}