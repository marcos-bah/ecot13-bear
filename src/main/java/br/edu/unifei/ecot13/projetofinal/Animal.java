package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "animal")
public abstract class Animal {
    @Id
    @GeneratedValue
    private Long id;

    private int number_of_legs;
    private String coat;

    @ManyToOne
    private Habitat habitat;

    public Animal() {
    }

    public Animal(int number_of_legs, String coat, Habitat habitat) {
        this.number_of_legs = number_of_legs;
        this.coat = coat;
        this.habitat = habitat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber_of_legs() {
        return number_of_legs;
    }

    public void setNumber_of_legs(int number_of_legs) {
        this.number_of_legs = number_of_legs;
    }

    public String getCoat() {
        return coat;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }
}
