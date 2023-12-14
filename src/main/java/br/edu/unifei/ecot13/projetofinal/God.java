package br.edu.unifei.ecot13.projetofinal;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "god")
public class God {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Animal> creations;

    public God() {
    }

    public God(List<Animal> creations) {
        this.creations = creations;
    }
}
