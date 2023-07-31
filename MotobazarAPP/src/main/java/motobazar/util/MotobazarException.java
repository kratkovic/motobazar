/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motobazar.util;

public class MotobazarException extends Exception{
    
    private String poruka;
    
    public MotobazarException(String poruka){
        super();
        this.poruka = poruka;
    }
    
    public String getPoruka(){
        return poruka;
    }
}
