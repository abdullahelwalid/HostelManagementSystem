/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HostelGradel;

import java.util.Arrays;

/**
 *
 * @author abdullah
 */
public class Room {
    public Room() {}
    
    public String[] availableRooms(String roomType){
        FileHandling fl = new FileHandling();
        String[] availableRooms = {};
        String[] rooms = fl.getFileData("room.txt");
        String[] reservations = fl.getFileData("reservation.txt");
        for (String data : rooms) {
            
            if (data.split(",")[1].equals(roomType)){
                boolean reserved = false;
                for (String reservedRooms : reservations){
                    if (data.split(",")[0].equals(reservedRooms.split(",")[5])){
                        reserved = true;
                        break;
                    }
                }
                if (reserved == false){
                    availableRooms = Arrays.copyOf(availableRooms, availableRooms.length + 1);
                    availableRooms[availableRooms.length - 1] = data.split(",")[0];
                }
            }
        }
        return availableRooms;
    }



}
