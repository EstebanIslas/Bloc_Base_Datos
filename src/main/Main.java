/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.ModelBlocBase;
import view.ViewBlocBase;
import controller.ControllerBlocBase;

/**
 *
 * @author LAB-1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModelBlocBase modelBlocBase = new ModelBlocBase();
        ViewBlocBase viewBlocBase = new ViewBlocBase();
        ControllerBlocBase controllerBlocBase = new ControllerBlocBase(modelBlocBase, viewBlocBase);
    }
    
}
