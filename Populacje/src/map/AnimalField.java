package map;

import species.Animal;

public class AnimalField extends Field {

    Animal currentSpecies;

    public AnimalField(Animal animal) {
        this.currentSpecies = animal;
        this.setBackground(animal.getColor());
    }

    public Animal getCurrentSpecies() {
        return currentSpecies;
    }

}
