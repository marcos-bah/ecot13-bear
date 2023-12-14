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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getSalinity() {
        return salinity;
    }

    public void setSalinity(float salinity) {
        this.salinity = salinity;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Ocean [name=" + name + ", depth=" + depth + "]";
    }
}
