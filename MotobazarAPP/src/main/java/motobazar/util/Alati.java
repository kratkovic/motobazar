package motobazar.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

/**
 * Klasa koja sadrži korisne alate za rad s OIB-om (Osobni Identifikacijski Broj).
 */
public class Alati {

    /**
     * Metoda koja dohvaća generirani OIB s web stranice "http://oib.itcentrala.com/oib-generator/".
     * Koristi BufferedReader za čitanje HTML sadržaja stranice, zatim koristi Jsoup za parsiranje
     * HTML-a i Xsoup za dohvaćanje vrijednosti putem XPath izraza.
     *
     * @return Generirani OIB u obliku Stringa ili prazan String u slučaju greške.
     */
    public static String dovuciOib() {
        try {
            // Kreiranje URL objekta za dohvaćanje web stranice
            URL url = new URL("http://oib.itcentrala.com/oib-generator/");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            url.openStream()));
            
            // Čitanje sadržaja web stranice
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
           
            // Parsiranje HTML-a pomoću Jsoup-a
            Document d = Jsoup.parse(sb.toString());

            // Dohvaćanje OIB-a iz HTML strukture pomoću XPath izraza
            return Xsoup.compile("/html/body/div[1]/div[1]/text()").evaluate(d).get();

        } catch (Exception e) {
            // U slučaju greške vraća prazan string
        }

        return "";
    }

    /**
     * Metoda koja provjerava je li dani OIB valjan prema službenom algoritmu kontrole OIB-a.
     * Provjerava duljinu, sadrži li samo brojeve i validira kontrolni broj prema definiranom postupku.
     *
     * @param oib OIB koji se provjerava.
     * @return true ako je OIB valjan, false ako nije.
     */
    public static boolean kontrolaOIB(String oib) {
        // OIB mora imati točno 11 znakova
        if (oib == null || oib.length() != 11) {
            return false;
        }

        char[] chars = oib.toCharArray();
        int a = 10;

        // Provjera svakog znaka i primjena algoritma kontrole OIB-a
        for (int i = 0; i < 10; i++) {
            char c = chars[i];

            // Ako neki znak nije broj, OIB nije valjan
            if (c < '0' || c > '9') {
                return false;
            }

            // Izračun prema algoritmu kontrole
            a = a + (c - '0');
            a = a % 10;
            if (a == 0) {
                a = 10;
            }
            a *= 2;
            a = a % 11;
        }

        // Računanje kontrolnog broja
        int kontrolni = 11 - a;
        kontrolni = kontrolni % 10;

        // Provjera je li izračunati kontrolni broj jednak zadnjem znamenku OIB-a
        return kontrolni == (chars[10] - '0');
    }
}
