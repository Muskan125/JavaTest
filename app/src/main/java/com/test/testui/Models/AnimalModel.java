package com.test.testui.Models;

import java.util.Objects;

public class AnimalModel {

    private final String animalName;
    private final String breed;
    private final boolean isVeg;
    private final double weight;
    private final boolean isDomestic;
    private final String img;

    public AnimalModel(String animalName, String breed, boolean isVeg, double weight, boolean isDomestic, String img) {
        this.animalName = Objects.requireNonNull(animalName, "Animal name cannot be null");
        this.breed = Objects.requireNonNull(breed, "Breed cannot be null");
        this.isVeg = isVeg;
        this.weight = weight;
        this.isDomestic = isDomestic;
        this.img = img;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getBreed() {
        return breed;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isDomestic() {
        return isDomestic;
    }

    public String getImg() {
        return img;
    }

}
