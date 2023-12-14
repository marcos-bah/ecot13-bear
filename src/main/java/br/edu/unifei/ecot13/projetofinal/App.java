package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.List;


public final class App {
    public static void main(String[] args) {
        // Ocean ocean = new Ocean("Atlantico", 1000, 1, 28);
        // Tree tree = new Tree("Pereira", "de Lei", 100, 34);
        // Cave cave = new Cave("Desconhecida", 20, 0, false);

        // List<Tree> treeList = new ArrayList<>();
        // treeList.add(tree);

        // List<Cave> caveList = new ArrayList<>();
        // Cave cave1 = new Cave("Caverna 1", 10, 5, true);
        // Cave cave2 = new Cave("Caverna 2", 15, 8, false);
        // Cave cave3 = new Cave("Caverna 3", 20, 12, true);

        // caveList.add(cave);
        // caveList.add(cave1);
        // caveList.add(cave2);
        // caveList.add(cave3);

        // CoastalHabitat coastalHabitat = new CoastalHabitat("umido", "quente", false, "Salmao", ocean);
        // ForestHabitat forestHabitat = new ForestHabitat("umido", "quente", 1, "mato", treeList);
        // MountainHabitat mountainHabitat = new MountainHabitat("Seco", "frio", 4200, "rasteira", -15, caveList);
        // TundraHabitat tundraHabitat = new TundraHabitat("seco", "quente", false, "erva daninha");

        // City city = new City("São Lourenço", "37470-000 - Brazil");
        // Park park = new Park("Parque das Aguas", "Sul de Minas", city);

        // Salmon salmon = new Salmon(0, "rateado", coastalHabitat, 10, false, ocean);

        // Bear bear = new Bear(2, "pelagem", forestHabitat, "joaozinho", 10, "preto");

        // List<Bear> bearList = new ArrayList<>();
        // bearList.add(bear);

        // Human human = new Human(2, "pele", tundraHabitat, "Rodrigo", 25, city, bearList);

        // List<Animal> animalList = new ArrayList<>();
        // animalList.add(bear);
        // animalList.add(human);
        // animalList.add(salmon);

        // God god = new God(animalList);

        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("ursoPU");
        // EntityManager em = emf.createEntityManager();

        // em.getTransaction().begin();

        // em.persist(ocean);
        // em.persist(tree);
        // em.persist(cave);
        // em.persist(cave1);
        // em.persist(cave2);
        // em.persist(cave3);
        // em.persist(coastalHabitat);
        // em.persist(forestHabitat);
        // em.persist(mountainHabitat);
        // em.persist(tundraHabitat);
        // em.persist(city);
        // em.persist(park);
        // em.persist(salmon);
        // em.persist(bear);
        // em.persist(human);
        // em.persist(god);

        // em.getTransaction().commit();

        // em.close();
        // emf.close();

        SalmonGUI salmonGUI = new SalmonGUI();
        salmonGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        salmonGUI.setSize(720, 400);
        salmonGUI.setVisible(true);
    }
}
