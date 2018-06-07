package com.guardado.threads;

import javax.swing.*;
import com.guardado.gui.Gui;

public class AnimalThread extends Thread {
    private String nombre;
    private int limite;
    private JLabel animal;
    private int x;
    private int y;
    boolean casilla = false;

    public AnimalThread(){}

    public AnimalThread(String nombre, int x, int y, int limite, JLabel animal) {
        this.nombre = nombre;
        this.x = x;
        this.y= y;
        this.limite = limite;
        this.animal = animal;
    }
    

    @Override
    public void run()
    {
        for (int i=x ; i<=this.limite ; i+=10)
        {
            if (this.nombre == "tortuga"){
             System.out.println(this.nombre + " avanza");
            this.animal.setLocation(i,y);
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   
            }
            else{
            System.out.println(this.nombre + " avanza");
            this.animal.setLocation(i,y);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }
        System.out.println(this.nombre + " a llegado a la meta");
        if (this.nombre == "tortuga"){
            casilla = true;
        }
        
        yield();
    }
}
