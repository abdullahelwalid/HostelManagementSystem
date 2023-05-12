/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HostelGradel;

/**
 *
 * @author abdullah
 */
import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner; 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandling {
    private String userType;
    private String userId;
    private static String basePath = "/Users/abdullah_1/Desktop/UNI/Degree level - 2/OOPJ/HostelGradel/app/src/main/java/HostelGradel/data/";
    public FileHandling(String userType, String userId){
        this.userType = userType;
        this.userId = userId;
    }
    public FileHandling(){

    }

    public String[] getFileData(String fileName){
        String[] lines = {};
        try { 
            File myObj = new File(basePath + fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              lines = Arrays.copyOf(lines, lines.length + 1);
              lines[lines.length - 1] = data;
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return lines;
    }
    
    public void addData(String fileName, String data){
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try (FileWriter f = new FileWriter(basePath + fileName, true);
                BufferedWriter b = new BufferedWriter(f);
                PrintWriter p = new PrintWriter(b);) {

            p.println(data);

        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public void removeFileData(String filename){
        File fl = new File(basePath + filename);
        try {
            FileWriter wt = new FileWriter(fl, false);
            wt.write("");
            wt.close();
        } catch (IOException ex) {
            Logger.getLogger(FileHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
                                                     
        
    }
}
