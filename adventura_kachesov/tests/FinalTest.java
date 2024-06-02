import cz.vse.java.adventura.logika.Batoh;
import cz.vse.java.adventura.logika.Hra;
import cz.vse.java.adventura.logika.HerniPlan;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FinalTest {
    private Hra hra1;
    private Batoh batoh;
    private HerniPlan plan;

    @Before
    public void setUp() {
        hra1 = new Hra();
        batoh = new Batoh();
        plan = new HerniPlan();

    }
    @After
    public void tearDown() {
    }

    @Test
    public void mluvTest() {
        hra1.zpracujPrikaz("seber Kompas");
        hra1.zpracujPrikaz("jdi Docela");
        hra1.zpracujPrikaz("jdi Knihovna");
        batoh.vloz(hra1.getHerniPlan().getAktualniProstor().vratVec("Nekronomicon"));
        hra1.zpracujPrikaz("seber Nekronomicon");
        hra1.zpracujPrikaz("seber Mapy_bažin_New_Orlean");
        hra1.zpracujPrikaz("jdi Bažiny");
        hra1.zpracujPrikaz("jdi Chram_Rlyeh");


        assertEquals("Gratuluji, použili jste knižní kouzlo proti Ktulhu. Teď Ktulhu usnul na 100 let. Jste zahranil tento svět.", hra1.zpracujPrikaz("pouzit Nekronomicon"));




    }


}