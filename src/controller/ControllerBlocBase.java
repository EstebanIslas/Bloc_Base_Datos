/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import jdk.jfr.events.FileWriteEvent;
import model.ModelBlocBase;
import view.ViewBlocBase;

/**
 *
 * @author LAB-1
 */
public class ControllerBlocBase {

    ModelBlocBase modelBlocBase;
    ViewBlocBase viewBlocBase;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewBlocBase.jb_guardar) {
                abrirArchivo();
            }else if (e.getSource() == viewBlocBase.jb_primero) {
                primerArchivo();
            }else if (e.getSource() == viewBlocBase.jb_ultimo) {
                ultimoArchivo();
            }
        }
    };

    public ControllerBlocBase(ModelBlocBase modelBlocBase, ViewBlocBase viewBlocBase) {
        this.modelBlocBase = modelBlocBase;
        this.viewBlocBase = viewBlocBase;
        InitComponets();
        this.viewBlocBase.jb_guardar.addActionListener(actionListener);
        this.viewBlocBase.jb_primero.addActionListener(actionListener);
        this.viewBlocBase.jb_ultimo.addActionListener(actionListener);
    }
    
    public void primerArchivo(){
       try {
            String row;
            StringBuilder contenido = new StringBuilder();
            try (FileReader file = new FileReader(modelBlocBase.getPath())) {
                BufferedReader bufferedReader = new BufferedReader(file);
                int i = 0;
                while ((row = bufferedReader.readLine()) != null) {
                    contenido.append(row);
                    contenido.append("\n");
                }
                //viewRegistro.JTF_Name.setText(modelRegistro.getName());
                
                modelBlocBase.primerRegistro(String.valueOf(contenido));
                
                viewBlocBase.jtf_nombre.setText(modelBlocBase.getNombre());
                viewBlocBase.jtf_apellido.setText(modelBlocBase.getApellido());
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.err.println("File Not Found!! " + ex.getMessage());
            }
        } catch (IOException ex) {
            System.err.println("Error I/O Operation " + ex.getMessage());
        }
    }
    
    public void ultimoArchivo(){
       try {
            String row;
            StringBuilder contenido = new StringBuilder();
            try (FileReader file = new FileReader(modelBlocBase.getPath())) {
                BufferedReader bufferedReader = new BufferedReader(file);
                int i = 0;
                while ((row = bufferedReader.readLine()) != null) {
                    contenido.append(row);
                    contenido.append("\n");
                }
                //viewRegistro.JTF_Name.setText(modelRegistro.getName());
                
                modelBlocBase.ultimoRegistro(String.valueOf(contenido));
                
                viewBlocBase.jtf_nombre.setText(modelBlocBase.getNombre());
                viewBlocBase.jtf_apellido.setText(modelBlocBase.getApellido());
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.err.println("File Not Found!! " + ex.getMessage());
            }
        } catch (IOException ex) {
            System.err.println("Error I/O Operation " + ex.getMessage());
        }
    }

    public void abrirArchivo() {
        /*
        modelBlocBase.setNombre(viewBlocBase.jtf_nombre.getText());
        modelBlocBase.setApellido(viewBlocBase.jtf_apellido.getText());
        */
        try
        {
            File file = new File(modelBlocBase.getPath());
            FileWriter fileWriter = new FileWriter(file, true);
            try(PrintWriter printWriter = new PrintWriter(fileWriter)){
                printWriter.println(modelBlocBase.separarCadena(viewBlocBase.jtf_nombre.getText(), viewBlocBase.jtf_apellido.getText()));
                //printWriter.println(modelBlocBase.getNombre() + "," + modelBlocBase.getApellido());
                JOptionPane.showMessageDialog(null, "Archivo Almacenado!!");
                printWriter.close();
            }
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, "File Not Found!! " + ex.getMessage());
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Error I/O Operation " + ex.getMessage());
        }
    }
    public void InitComponets(){
        viewBlocBase.setVisible(true);
        viewBlocBase.setLocationRelativeTo(null);
    }
}
