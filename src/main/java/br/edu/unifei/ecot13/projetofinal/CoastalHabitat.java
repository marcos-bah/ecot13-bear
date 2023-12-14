package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
}
