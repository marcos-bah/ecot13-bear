package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "park")
public class Park {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String location;

    @ManyToOne
    private City city;

    public Park() {
    }

    public Park(String name, String location, City city) {
        this.name = name;
        this.location = location;
        this.city = city;
    }
}
