package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Salmon extends Animal {
    private int size;
    private boolean isWild;

    @OneToOne
    private Ocean ocean;

    public Salmon() {
    }

    public Salmon(int number_of_legs, String coat, Habitat habitat, int size, boolean isWild, Ocean ocean) {
        super(number_of_legs, coat, habitat);
        this.size = size;
        this.isWild = isWild;
        this.ocean = ocean;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isWild() {
        return isWild;
    }

    public void setWild(boolean isWild) {
        this.isWild = isWild;
    }

    public Ocean getOcean() {
        return ocean;
    }

    public void setOcean(Ocean ocean) {
        this.ocean = ocean;
    }


}
