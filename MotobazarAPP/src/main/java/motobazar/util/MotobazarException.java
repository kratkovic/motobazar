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

    public MotobazarException(String došlo_je_do_pogreške_pri_dohvatu_dijela_i, Exception e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getPoruka(){
        return poruka;
    }
}
