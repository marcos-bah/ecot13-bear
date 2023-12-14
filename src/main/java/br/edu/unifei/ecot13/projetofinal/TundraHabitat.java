package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class TundraHabitat extends Habitat {
    private boolean permafrost;
    private String lowGrowingPlants;

    public TundraHabitat() {
    }

    public TundraHabitat(String habitatType, String climate, boolean permafrost, String lowGrowingPlants) {
        super(habitatType, climate);
        this.permafrost = permafrost;
        this.lowGrowingPlants = lowGrowingPlants;
    }

    @Override
    public String toString() {
        return "TundraHabitat [lowGrowingPlants=" + lowGrowingPlants + ", permafrost=" + permafrost + "]";
    }
}
