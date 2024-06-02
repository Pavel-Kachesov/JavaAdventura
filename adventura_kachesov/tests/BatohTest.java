import cz.vse.java.adventura.logika.Batoh;
import cz.vse.java.adventura.logika.Hra;
import cz.vse.java.adventura.logika.HerniPlan;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BatohTest {
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
    public void seberTest1() {

        assertEquals("", batoh.prehled());
        batoh.vloz(hra1.getHerniPlan().getAktualniProstor().vratVec("Kompas"));
        batoh.vloz(hra1.getHerniPlan().getAktualniProstor().vratVec("Deník"));
        hra1.zpracujPrikaz("seber Deník");
        assertEquals("Deník - toto je deník vašeho stryce, který on psal až nezemřel.\n" +
                "\n", hra1.zpracujPrikaz("prehledBatohu"));
        hra1.zpracujPrikaz("jdi Docela");
        hra1.zpracujPrikaz("jdi Knihovna");
        batoh.vloz(hra1.getHerniPlan().getAktualniProstor().vratVec("Pohadky_Nového_Orleanu"));
        batoh.vloz(hra1.getHerniPlan().getAktualniProstor().vratVec("Nekronomicon"));

        assertEquals(false,  batoh.vloz(hra1.getHerniPlan().getAktualniProstor().vratVec("Kniha_o_psychiatrické_lečebně_v_New_Orleanu")));
        assertEquals(true, batoh.masVec("Kompas"));
        assertEquals("Kompas ; Pohadky_Nového_Orleanu ; Nekronomicon ; Deník ; ", batoh.prehled());
        assertEquals(false, batoh.vloz(hra1.getHerniPlan().getAktualniProstor().vratVec("Kniha_o_psychiatrické_lečebně_v_New_Orleanu")));

        assertEquals(true , batoh.vyhod(batoh.getVec("Kompas")));
        assertEquals(false, batoh.masVec("Kompas"));
        assertEquals("Pohadky_Nového_Orleanu ; Nekronomicon ; Deník ; ", batoh.prehled());
        assertEquals(true, batoh.vloz(hra1.getHerniPlan().getAktualniProstor().vratVec("Kniha_o_psychiatrické_lečebně_v_New_Orleanu")));



    }


}

