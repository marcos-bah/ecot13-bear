package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Bear extends Animal{
    private String name;
    private int age;
    private String furColor;

    public Bear() {
    }

    public Bear(int number_of_legs, String coat, Habitat habitat, String name, int age, String furColor) {
        super(number_of_legs, coat, habitat);
        this.name = name;
        this.age = age;
        this.furColor = furColor;
    }
}
