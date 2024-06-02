import cz.vse.java.adventura.logika.Batoh;
import cz.vse.java.adventura.logika.Hra;
import cz.vse.java.adventura.logika.HerniPlan;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KnihovnaTest {
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
        hra1.zpracujPrikaz("jdi Docela");
        hra1.zpracujPrikaz("jdi Knihovna");



        assertEquals("Dale odpověz na otazku(napíš \"odpovi a\" nebo \"odpovi b\" podle vašeho rozhodnuti. \n" +
                "Otazka: Chcete půjčit knihu? a = ano (půjčit), b = ne (ukrast)", hra1.zpracujPrikaz("seber Nekronomicon"));
        assertEquals("Knihovnice zavolala policii, protože tato kniha slouží jako návnada k chytání bláznů. Protože" +
                " je k sobe přitahuje. Teď strávíte zbytek života v psychiatrické léčebně.", hra1.zpracujPrikaz("odpovi a"));
        assertEquals(true, hra1.konecHry());
    }


        @Test
        public void seberTest2(){
            hra1.zpracujPrikaz("jdi Docela");
            hra1.zpracujPrikaz("jdi Knihovna");


            assertEquals("Dale odpověz na otazku(napíš \"odpovi a\" nebo \"odpovi b\" podle vašeho rozhodnuti. \n" +
                    "Otazka: Chcete půjčit knihu? a = ano (půjčit), b = ne (ukrast)",hra1.zpracujPrikaz("seber Nekronomicon"));
            assertEquals("Nekronomicon je v batohu.Ukradl jste knihu, tentokrát si toho nikdo nevšiml, ale příště buď opatrnější. ", hra1.zpracujPrikaz("odpovi b"));
            assertEquals(false, hra1.konecHry());








    }

}
