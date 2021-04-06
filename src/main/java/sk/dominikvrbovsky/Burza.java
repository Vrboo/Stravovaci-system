package sk.dominikvrbovsky;

import java.util.ArrayList;

public class Burza {

    private ArrayList<Meal> meals;

    public Burza() {
        this.meals = new ArrayList<>();
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }


}
