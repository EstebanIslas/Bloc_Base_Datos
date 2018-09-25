/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
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
            }
        }
    };

    public ControllerBlocBase(ModelBlocBase modelBlocBase, ViewBlocBase viewBlocBase) {
        this.modelBlocBase = modelBlocBase;
        this.viewBlocBase = viewBlocBase;
        InitComponets();
        this.viewBlocBase.jb_guardar.addActionListener(actionListener);
    }

    public void abrirArchivo() {
        modelBlocBase.setNombre(viewBlocBase.jtf_nombre.getText());
        modelBlocBase.setApellido(viewBlocBase.jtf_apellido.getText());
        
        try
        {
            File file = new File(modelBlocBase.getPath());
            FileWriter fileWriter = new FileWriter(file, true);
            try(PrintWriter printWriter = new PrintWriter(fileWriter)){
                printWriter.println(modelBlocBase.getNombre() + "," + modelBlocBase.getApellido());
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
