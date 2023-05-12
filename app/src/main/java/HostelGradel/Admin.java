/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HostelGradel;

/**
 *
 * @author abdullah
 */
public class Admin {
    private String firstName;
    private String lastName;
    private String displayName;
    private String gender;
    private String iD;

    
    public Admin(
        String firstName, 
        String gender,
        String displayName,
        String iD,
        String lastName
        ) {
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
        this.iD = iD;
        this.displayName = displayName;
    }
    public Admin() {

    }
    
    public String displayName(){
        return this.displayName;
    }
    public Boolean login(String adminId, String password){
        FileHandling fl = new FileHandling();
        String[] adminData = fl.getFileData("admin.txt");
        if (adminData.length > 0){
            for (int i = 0; i < adminData.length; i++){
                String[] admin = adminData[i].split(",");
                String username = admin[0];
                String passwordActual = admin[6];
                if (username.equals(adminId) && password.equals(passwordActual)){
                    return true;
                }
            } 
        }
        return false;
    }
}

