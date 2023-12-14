package br.edu.unifei.ecot13.projetofinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class SalmonGUI extends JFrame {
    private List<Habitat> habitats;
    private List<Ocean> oceans;

    private JTextField inputID;
    private JTextField inputNumberLegs;
    private JTextField inputCoat;

    private JComboBox habitatsBox;
    private JComboBox oceansBox;

    private JCheckBox isWildCheckBox;
    private JButton toggleButton;
    private JButton addButton;

    public SalmonGUI() {

        inputID = new JTextField();
        inputID.setEnabled(false);
        inputNumberLegs = new JTextField();
        inputCoat = new JTextField();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ursoPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Ocean> oceansQuery = em.createQuery("SELECT o FROM Ocean o", Ocean.class);

        this.oceans = oceansQuery.getResultList();

        TypedQuery<Habitat> habitatsQuery = em.createQuery("SELECT h FROM Habitat h", Habitat.class);

        this.habitats = habitatsQuery.getResultList();

        TypedQuery<Animal> animalsQuery = em.createQuery("SELECT a FROM Animal a", Animal.class);

        List<Animal> animals = animalsQuery.getResultList();

        em.close();
        emf.close();

        habitatsBox = new JComboBox<>(habitats.toArray());

        oceansBox = new JComboBox<>(oceans.toArray());

        isWildCheckBox = new JCheckBox();

        toggleButton = new JButton("Create");

        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toggleButton.getText().equals("Create")) {
                    toggleButton.setText("Edit");
                    inputID.setEnabled(true);
                } else {
                    toggleButton.setText("Create");
                    inputID.setEnabled(false);
                }
            }
        });

        addButton = new JButton("Add Salmon");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ursoPU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();

                Salmon salmon = new Salmon();

                if (toggleButton.getText().equals("Edit")) {
                    salmon = em.find(Salmon.class, Long.parseLong(inputID.getText()));
                }

                salmon.setNumber_of_legs(Integer.parseInt(inputNumberLegs.getText()));
                salmon.setCoat(inputCoat.getText());
                salmon.setHabitat((Habitat) habitatsBox.getSelectedItem());
                salmon.setOcean((Ocean) oceansBox.getSelectedItem());
                salmon.setWild(isWildCheckBox.isSelected());

                em.persist(salmon);

                em.getTransaction().commit();

                em.close();
                emf.close();
            }
        });


        // Set the layout
        setLayout(new BorderLayout());

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(8, 2));

        form.add(new JLabel("ID:"));
        form.add(inputID);
        form.add(new JLabel("Number of Legs:"));
        form.add(inputNumberLegs);
        form.add(new JLabel("Coat:"));
        form.add(inputCoat);
        form.add(new JLabel("Habitat:"));
        form.add(habitatsBox);
        form.add(new JLabel("Ocean:"));
        form.add(oceansBox);
        form.add(new JLabel("Is Wild:"));
        form.add(isWildCheckBox);

        form.add(new JLabel("Ação:"));
        form.add(toggleButton);

        form.add(new JLabel(""));
        form.add(addButton);

        JPanel list = new JPanel();
        list.setLayout(new GridLayout(animals.size()+10, 2));

        for (Animal animal : animals) {
            list.add(new JLabel(animal.getClass().getSimpleName() + " " + animal.getId()));
            JButton deleteButton = new JButton("Delete");
            list.add(deleteButton);
        }

        JButton refreshButton = new JButton("Refresh");
        list.add(refreshButton);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ursoPU");
                EntityManager em = emf.createEntityManager();

                // carregue os dados de animal
                TypedQuery<Animal> animalsQuery = em.createQuery("SELECT a FROM Animal a", Animal.class);

                List<Animal> animals = animalsQuery.getResultList();

                em.close();
                emf.close();

                list.removeAll();


                for (Animal animal : animals) {
                    list.add(new JLabel(animal.getClass().getSimpleName() + " " + animal.getId()));
                    JButton deleteButton = new JButton("Delete");

                    deleteButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ursoPU");
                            EntityManager em = emf.createEntityManager();

                            em.getTransaction().begin();

                            Animal animalOp = em.find(Animal.class, animal.getId());

                            em.remove(animalOp);

                            em.getTransaction().commit();

                            em.close();
                            emf.close();

                            list.remove(deleteButton.getParent());
                            list.updateUI();
                        }
                    });
                    list.add(deleteButton);
                }

                list.add(refreshButton);

                list.updateUI();
            }
        });

        add(form, BorderLayout.WEST);
        add(list, BorderLayout.EAST);

        form.setPreferredSize(new Dimension(400, 80));
        list.setPreferredSize(new Dimension(300, 80));

        add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.CENTER);

        // Set the title of the frame
        setTitle("Salmon GUI");
    }
}
