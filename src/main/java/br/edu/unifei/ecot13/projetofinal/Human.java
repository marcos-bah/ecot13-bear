package br.edu.unifei.ecot13.projetofinal;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Human extends Animal {
    private String name;
    private int age;

    @ManyToOne
    private City city;

    @ManyToMany
    private List<Bear> watch;

    public Human() {
    }

    public Human(int number_of_legs, String coat, Habitat habitat, String name, int age, City city, List<Bear> watch) {
        super(number_of_legs, coat, habitat);
        this.name = name;
        this.age = age;
        this.city = city;
        this.watch = watch;
    }
}
