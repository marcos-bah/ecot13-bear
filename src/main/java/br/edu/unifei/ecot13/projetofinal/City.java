package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String location;

    public City() {
    }

    public City(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
