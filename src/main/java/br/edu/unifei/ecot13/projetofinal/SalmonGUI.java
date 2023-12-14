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
    // lista de opções
    private JComboBox habitatsBox;
    private JComboBox oceansBox;
    // checkbox
    private JCheckBox isWildCheckBox;
    // selecao de opcoes, para criar ou editar, toogle
    private JButton toggleButton;
    private JButton addButton;

    public SalmonGUI() {
        // Crie uma interface com swing para fazer um crod da Classe Salmon, o dado deve ser persistido no banco de dados com hibernate, a tela deve listar todos os dados de Salmon persistidos no banco de dados.

        inputID = new JTextField();
        inputID.setEnabled(false);
        inputNumberLegs = new JTextField();
        inputCoat = new JTextField();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ursoPU");
        EntityManager em = emf.createEntityManager();

        // carregue dados de habit e ocean
        TypedQuery<Ocean> oceansQuery = em.createQuery("SELECT o FROM Ocean o", Ocean.class);

        this.oceans = oceansQuery.getResultList();

        TypedQuery<Habitat> habitatsQuery = em.createQuery("SELECT h FROM Habitat h", Habitat.class);

        this.habitats = habitatsQuery.getResultList();

        // carregue os dados de animal
        TypedQuery<Animal> animalsQuery = em.createQuery("SELECT a FROM Animal a", Animal.class);

        List<Animal> animals = animalsQuery.getResultList();

        em.close();
        emf.close();

        // lista de opções carregadas do banco de dados
        habitatsBox = new JComboBox<>(habitats.toArray());
        oceansBox = new JComboBox<>(oceans.toArray());

        // checkbox
        isWildCheckBox = new JCheckBox();

        // selecao de opcoes, para criar ou editar
        toggleButton = new JButton("Create");

        // o toogle deve mudar o texto do botao para "Create" ou "Edit"
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

        // acao para criar ou editar um animal
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ursoPU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();

                // crie um novo animal
                Salmon salmon = new Salmon();

                // se o botao for de editar, carregue o animal do banco de dados
                if (toggleButton.getText().equals("Edit")) {
                    salmon = em.find(Salmon.class, Long.parseLong(inputID.getText()));
                }

                // atualize os dados do animal
                salmon.setNumber_of_legs(Integer.parseInt(inputNumberLegs.getText()));
                salmon.setCoat(inputCoat.getText());
                salmon.setHabitat((Habitat) habitatsBox.getSelectedItem());
                salmon.setOcean((Ocean) oceansBox.getSelectedItem());
                salmon.setWild(isWildCheckBox.isSelected());

                // persista o animal
                em.persist(salmon);

                em.getTransaction().commit();

                em.close();
                emf.close();
            }
        });


        // Set the layout
        setLayout(new BorderLayout());

        // Add components to the frame as a form and labels, adicione os componentes ao frame como um formulário e rótulos
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

        //adicionar toogle, ele deve ocupar duas colunas
        form.add(new JLabel("Ação:"));
        form.add(toggleButton);

        //adicionar botao de adicionar, ele deve ocupar duas colunas
        form.add(new JLabel(""));
        form.add(addButton);

        // faca um novo panel agora para uma lista de animais, deve ter um botao ao lado para excluir, a lista deve conter o tipo do animal
        JPanel list = new JPanel();
        list.setLayout(new GridLayout(animals.size()+10, 2));

        for (Animal animal : animals) {
            list.add(new JLabel(animal.getClass().getSimpleName() + " " + animal.getId()));
            JButton deleteButton = new JButton("Delete");
            list.add(deleteButton);
        }

        //adicionar um botao ao final da listagem para atualizar a lista
        JButton refreshButton = new JButton("Refresh");
        list.add(refreshButton);

        //adicionar acao para o botao de atualizar a lista
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

                // remova todos os componentes da lista
                list.removeAll();

                // adicione os componentes novamente
                for (Animal animal : animals) {
                    list.add(new JLabel(animal.getClass().getSimpleName() + " " + animal.getId()));
                    JButton deleteButton = new JButton("Delete");
                    // adicione a acao para o botao de deletar
                    deleteButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ursoPU");
                            EntityManager em = emf.createEntityManager();

                            em.getTransaction().begin();

                            // carregue o animal do banco de dados
                            Animal animalOp = em.find(Animal.class, animal.getId());

                            // remova o animal
                            em.remove(animalOp);

                            em.getTransaction().commit();

                            em.close();
                            emf.close();

                            // atualize a lista
                            list.remove(deleteButton.getParent());
                            list.updateUI();
                        }
                    });
                    list.add(deleteButton);
                }

                // adicione o botao de atualizar
                list.add(refreshButton);

                // atualize a lista
                list.updateUI();
            }
        });

        // Add components to the frame, um ao lado do outro, adicionar uma linha como divisao e um titulo para cada lado
        add(form, BorderLayout.WEST);
        add(list, BorderLayout.EAST);

        form.setPreferredSize(new Dimension(300, 80));
        list.setPreferredSize(new Dimension(300, 80));

        //adicionar linha vertical de divisao
        add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.CENTER);

        // Set the title of the frame
        setTitle("Salmon GUI");
    }
}
