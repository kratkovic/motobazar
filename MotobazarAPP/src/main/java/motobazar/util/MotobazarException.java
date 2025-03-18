/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package motobazar.util;

public class MotobazarException extends Exception {
    
    private String poruka;
    
    // Konstruktor koji prima samo poruku
    public MotobazarException(String poruka) {
        super();
        this.poruka = poruka;
    }

    // Konstruktor koji prima poruku i originalnu iznimku
    public MotobazarException(String poruka, Exception e) {
        super(e);  // Prosljeđujem originalnu iznimku roditeljskoj klasi
        this.poruka = poruka;  // Pohranjujem poruku
    }
    
    // Getter za poruku
    public String getPoruka() {
        return poruka;
    }
}
