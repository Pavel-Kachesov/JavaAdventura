import cz.vse.java.adventura.logika.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PrectiTest {

    private PrikazPrecti prikaz;
    private Batoh batoh;
    private Hra hra;
    private HerniPlan herniPlan;

    @Before
    public void setUp() {
        batoh = new Batoh();
        hra = new Hra();
        herniPlan = new HerniPlan();
        prikaz = new PrikazPrecti(batoh, hra, herniPlan);
    }


    @Test
    public void testGetNazev() {
        assertEquals("Nejsou knihy ke čtení" ,hra.zpracujPrikaz("precti"));
        batoh.vloz(hra.getHerniPlan().getAktualniProstor().vratVec("Kompas"));
        hra.zpracujPrikaz("seber Kompas");
        assertEquals("\n" +
                "Nemůžete přečíst kompas." ,hra.zpracujPrikaz("precti Kompas"));

        assertEquals("precti", prikaz.getNazev());

    }
}
