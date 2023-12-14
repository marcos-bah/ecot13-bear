package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ocean")
public class Ocean {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private float depth;
    private float salinity;
    private float temperature;

    public Ocean(String name, float depth, float salinity, float temperature) {
        this.name = name;
        this.depth = depth;
        this.salinity = salinity;
        this.temperature = temperature;
    }

    public Ocean() {
    }

    public String getName() {
        return name;
    }
}
