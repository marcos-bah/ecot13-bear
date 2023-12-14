package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CoastalHabitat extends Habitat {
    private boolean rockyShoreline;
    private String marineFoodSources;

    @ManyToOne
    private Ocean ocean;

    public CoastalHabitat() {
    }

    public CoastalHabitat(String habitatType, String climate, boolean rockyShoreline, String marineFoodSources,
            Ocean ocean) {
        super(habitatType, climate);
        this.rockyShoreline = rockyShoreline;
        this.marineFoodSources = marineFoodSources;
        this.ocean = ocean;
    }

    @Override
    public String toString() {
        return "CoastalHabitat [marineFoodSources=" + marineFoodSources + ", ocean=" + ocean + ", rockyShoreline="
                + rockyShoreline + "]";
    }
}
