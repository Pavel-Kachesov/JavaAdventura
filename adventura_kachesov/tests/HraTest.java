import cz.vse.java.adventura.logika.Hra;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková
 * @version  pro školní rok 2016/2017
 */
public class HraTest {
    private Hra hra1;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void testPrubehHry() {
        assertEquals("Gammellův_dům", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals("Tam se odsud jít nedá!", hra1.zpracujPrikaz("jdi Chram_Rlyeh") );
        assertEquals(false, hra1.konecHry());
        assertEquals("Tvým úkolem je zjistit co se děje ve městě a proč zemřel tvůj stryc.\n" +
                "\n" +
                "Můžeš zadat tyto příkazy:\n" +
                "help ; precti ; vyhodit ; mluv ; odpovi ; prehledBatohu ; jdi ; seber ; pouzit ; konec ; ", hra1.zpracujPrikaz("help"));
        assertEquals( "Dík, že jste si zahráli.  Ahoj.", hra1.vratEpilog());


    }

    @Test
    public void testPrikazJdi() {


        assertEquals("Gammellův_dům", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals("Nevím co tím myslíš? Tento příkaz neznám. ", hra1.zpracujPrikaz(""));
        assertEquals("Tam se odsud jít nedá!", hra1.zpracujPrikaz("jdi hasdab"));
        assertEquals("Kam mám jít? Musíš zadat jméno východu", hra1.zpracujPrikaz("jdi"));



    }

    @Test
    public void testMluv() {

        assertEquals("Gammellův_dům", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals("Nemáte s kym mluvit :(",hra1.zpracujPrikaz("mluv ddyhg"));
    }



    @Test
    public void testOdpovi() {



        assertEquals("Nemate na co odpovídat.",  hra1.zpracujPrikaz("odpovi b"));
        assertEquals(false, hra1.konecHry());
        assertEquals("Nevím co tím myslíš? Tento příkaz neznám. ", hra1.zpracujPrikaz("rekni a"));


        hra1.zpracujPrikaz("odpovi a");
        assertEquals(false, hra1.konecHry());

    }

    @Test
    public void testPouzit(){
        assertEquals("Taková věc není v aktualním prostoru", hra1.zpracujPrikaz("seber k"));
        assertEquals("Nevím co chcete sebrat.", hra1.zpracujPrikaz("seber "));

        assertEquals("Batoh je prazdný.",hra1.zpracujPrikaz("prehledBatohu"));



        assertEquals("Co chcete vyhodit? Napište název věci.",hra1.zpracujPrikaz("vyhodit "));
        assertEquals("Nemáte takovou věc :(",hra1.zpracujPrikaz("vyhodit gfhg "));


        assertEquals("Nevím co chcete použit",hra1.zpracujPrikaz("pouzit"));
        assertEquals("Taková věc není v batohu",hra1.zpracujPrikaz("pouzit haha"));
        assertEquals("Příliš hodně slov, napiště název věci jako jedno slovo",hra1.zpracujPrikaz("pouzit hodne slov"));


    }

    @Test
    public void testKonec(){
        assertEquals("hra ukončena příkazem konec", hra1.zpracujPrikaz("konec"));
        assertEquals(true, hra1.konecHry());
    }

}
