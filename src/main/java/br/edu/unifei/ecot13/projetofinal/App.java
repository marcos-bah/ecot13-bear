package br.edu.unifei.ecot13.projetofinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public final class App {
    // public static void main(String[] args) {
    //     Urso urso = new Urso();
    //     urso.setNome("Bear");

    //     EntityManagerFactory emf = Persistence.createEntityManagerFactory("ursoPU");
    //     EntityManager em = emf.createEntityManager();

    //     em.getTransaction().begin();
    //     em.persist(urso);
    //     em.getTransaction().commit();

    //     em.close();
    //     emf.close();
    // }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ursoPU");

        JFrame frame = new JFrame("Urso App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(5, 2));

        JLabel label = new JLabel("Enter bear name:");
        pane.add(label);

        JTextField textField = new JTextField();
        pane.add(textField);

        DefaultListModel<Urso> listModel = new DefaultListModel<>();
        JList<Urso> list = new JList<>(listModel);

        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected,
                                                          boolean cellHasFocus) {
                Urso urso = (Urso) value;
                return super.getListCellRendererComponent(list, urso.getNome(), index, isSelected, cellHasFocus);
            }
        });

        pane.add(list);

        JButton createButton = new JButton("Create Bear");
        pane.add(createButton);

        JButton updateButton = new JButton("Update Bear");
        pane.add(updateButton);

        JButton deleteButton = new JButton("Delete Bear");
        pane.add(deleteButton);

        refreshList(emf, listModel);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();

                Urso urso = new Urso();
                urso.setNome(textField.getText());
                em.persist(urso);

                em.getTransaction().commit();
                em.close();

                refreshList(emf, listModel);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();

                Urso urso = list.getSelectedValue();
                urso.setNome(textField.getText());
                em.merge(urso);

                em.getTransaction().commit();
                em.close();

                refreshList(emf, listModel);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();

                Urso urso = list.getSelectedValue();
                urso = em.merge(urso);
                em.remove(urso);

                em.getTransaction().commit();
                em.close();

                refreshList(emf, listModel);
            }
        });

        frame.setVisible(true);
    }

    private static void refreshList(EntityManagerFactory emf, DefaultListModel<Urso> listModel) {
        EntityManager em = emf.createEntityManager();

        List<Urso> ursos = em.createQuery("SELECT u FROM Urso u", Urso.class).getResultList();

        em.close();

        listModel.clear();
        for (Urso urso : ursos) {
            listModel.addElement(urso);
        }
    }
}
