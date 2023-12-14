package br.edu.unifei.ecot13.projetofinal;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class MountainHabitat extends Habitat {
    private float altitude;
    private String vegetation;
    private float temperature;

    @OneToMany
    private List<Cave> caves;

    public MountainHabitat() {
    }

    public MountainHabitat(String habitatType, String climate, float altitude, String vegetation, float temperature,
            List<Cave> caves) {
        super(habitatType, climate);
        this.altitude = altitude;
        this.vegetation = vegetation;
        this.temperature = temperature;
        this.caves = caves;
    }
}
