/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse.java.adventura.main;



import cz.vse.java.adventura.logika.*;
import cz.vse.java.adventura.uiText.TextoveRozhrani;


public class Start
{

    public static void main(String[] args)
    {
        
        IHra hra = new Hra();
        TextoveRozhrani ui = new TextoveRozhrani(hra);
        ui.hraj();
    }
}
