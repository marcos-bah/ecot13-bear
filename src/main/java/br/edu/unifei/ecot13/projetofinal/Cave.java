package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cave")
public class Cave {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double temperature;
    private int capacity;
    private boolean isExplored;

    public Cave() {
    }

    public Cave(String name, double temperature, int capacity, boolean isExplored) {
        this.name = name;
        this.temperature = temperature;
        this.capacity = capacity;
        this.isExplored = isExplored;
    }
}
