/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hattmakare_projekt;

import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author theosohlman
 */
public class Start {

    private static InfDB idb;
    /**
     * Metod som upprättar koppling till databasen.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InfException {
        try {
            idb = new InfDB("hattmakdb","3306","hattdba","hattkey");
        }
        catch (InfException ex)
        {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
        new LoginPage(idb).setVisible(true);
    }
}
