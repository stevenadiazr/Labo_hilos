package com.guardado.gui;

import com.guardado.threads.AnimalThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {

    private JPanel [] paneles;
    private JLabel [] labels;
    private JButton inicio;
    private JButton reinicio;
    private String[] nombres = {"canguro","tortuga","dragon"};
    public boolean casilla= false;

    public Gui(){
        super("Carrera de animales");
        initialComponents();

    }

    
    
    public void reinicio(){
        
    }
    
    public void initialComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        paneles = new JPanel[3];
        labels = new JLabel[3];
        inicio = new JButton("Inicio");
        Container container = getContentPane();
        //llenando el panel
        for (int i=0 ; i < 3 ; i++)
        {
            labels[i] = new JLabel();
            //labels[i].setBackground(Color.BLUE);
            //labels[i].setOpaque(true);
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i]+".gif")));
            labels[i].setBounds(10,(i*220)+10,200,200);
            container.add(labels[i]);
        }
        
        inicio.setBounds(10,0,100,30);
        container.add(inicio);
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnimalThread canguro = new AnimalThread("canguro",labels[0].getX(),labels[0].getY(),510,labels[0]);
                AnimalThread tortuga = new AnimalThread("tortuga",labels[1].getX(),labels[1].getY(),510,labels[1]);
                AnimalThread dragon = new AnimalThread("dragon",labels[2].getX(),labels[2].getY(),510,labels[2]);
                canguro.start();
                tortuga.start();
                dragon.start();
            }
        });
        setSize(700,650);
        
        reinicio = new JButton("Reinicio");
        
        reinicio.setBounds(150,0,100,30);
        container.add(reinicio);
        reinicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnimalThread canguro = new AnimalThread("canguro",0,labels[0].getY(),510,labels[0]);
                AnimalThread tortuga = new AnimalThread("tortuga",0,labels[1].getY(),510,labels[1]);
                AnimalThread dragon = new AnimalThread("dragon",0,labels[2].getY(),510,labels[2]);
                canguro.start();
                tortuga.start();
                dragon.start();
            }
        });
        setSize(700,650);
    }
    

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

}
