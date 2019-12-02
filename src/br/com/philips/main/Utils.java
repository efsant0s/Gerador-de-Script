/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.philips.main;

import java.io.*; 
import java.net.URISyntaxException; 
import java.util.List; 
import java.util.logging.Level;
import java.util.logging.Logger; 

/**
 *
 * @author efsantos
 */
public class Utils {

  

    String getJarFolder() {

        try {
            String caminho = new File(Utils.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath(); 
            if (caminho.contains(".jar")) {
                String nomeJar = new java.io.File(Utils.class.getProtectionDomain()
                        .getCodeSource()
                        .getLocation()
                        .getPath())
                        .getName();
                caminho = caminho.substring(0,caminho.indexOf(nomeJar));
            }
            System.out.println("-------------------");
            System.out.println(caminho);
            System.out.println("-------------------");
            return caminho;
        } catch (StringIndexOutOfBoundsException ex) {
            ex.printStackTrace();
            System.out.println("Caiu 2");
            return "C:\\Users\\efsantos\\Desktop\\Inconsistências\\";
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
            System.out.println("Caiu 2");
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return "C:\\Users\\efsantos\\Desktop\\Inconsistências\\";
        }

    }

 
    public static void search(final String pattern, final File folder, List<String> result) {
        for (final File f : folder.listFiles()) {

            if (f.isDirectory()) {
                search(pattern, f, result);
            }

            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    result.add(f.getAbsolutePath());
                }
            }

        }
    }

 
}
