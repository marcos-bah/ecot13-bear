package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "habitat")
public abstract class Habitat {
    @Id
    @GeneratedValue
    private int id;
    private String habitatType;
    private String climate;

    public Habitat() {
    }

    public Habitat(String habitatType, String climate) {
        this.habitatType = habitatType;
        this.climate = climate;
    }

    public String getHabitatType() {
        return habitatType;
    }
}
