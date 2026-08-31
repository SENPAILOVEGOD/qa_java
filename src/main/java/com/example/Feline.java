package com.example;

import java.util.List;

public class Feline extends Animal implements Predator, FelineBehavior {

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    @Override
    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }

    @Override
    public List<String> getFood() throws Exception {
        return getFood("Хищник");
    }
}
