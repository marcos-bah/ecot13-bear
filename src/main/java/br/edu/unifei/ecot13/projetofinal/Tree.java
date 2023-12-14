package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tree")
public class Tree {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String type;
    private float height;
    private int age;

    public Tree() {
    }

    public Tree(String name, String type, float height, int age) {
        this.name = name;
        this.type = type;
        this.height = height;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
