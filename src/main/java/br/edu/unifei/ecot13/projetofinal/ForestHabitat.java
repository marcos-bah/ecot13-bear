package br.edu.unifei.ecot13.projetofinal;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ForestHabitat extends Habitat {
    private float treeDensity;
    private String undergrowth;

    @OneToMany
    private List<Tree> trees;

    public ForestHabitat() {
    }

    public ForestHabitat(String habitatType, String climate, float treeDensity, String undergrowth, List<Tree> trees) {
        super(habitatType, climate);
        this.treeDensity = treeDensity;
        this.undergrowth = undergrowth;
        this.trees = trees;
    }

    @Override
    public String toString() {
        return "ForestHabitat [treeDensity=" + treeDensity + ", undergrowth=" + undergrowth + "]";
    }
}
