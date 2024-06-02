import cz.vse.java.adventura.logika.Batoh;
import cz.vse.java.adventura.logika.Hra;
import cz.vse.java.adventura.logika.HerniPlan;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BazinyTest2 {
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
    public void jdiTest(){
        hra1.zpracujPrikaz("jdi Docela");
        hra1.zpracujPrikaz("jdi Knihovna");
        batoh.vloz(hra1.getHerniPlan().getAktualniProstor().vratVec("Mapy_bažin_New_Orlean"));
        hra1.zpracujPrikaz("seber Mapy_bažin_New_Orlean");
        assertEquals("Mapy_bažin_New_Orlean ; ", batoh.prehled());
        assertEquals("Knihovna", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals("veci: Pohadky_Nového_Orleanu ;  Nekronomicon ;  Kniha_o_psychiatrické_lečebně_v_New_Orleanu ;  Volání_Ktulhu ; ", hra1.getHerniPlan().getAktualniProstor().popisVeci());
        assertEquals("Jsi v lokaci Rozlehlé bažiny na okraji New Orleansu, kde se nachází starobylý chrám R'lyeh.\n" +
                "\n" +
                "východy:Chram_Rlyeh ; Gammellův_dům ; \n" +
                "veci:\n" +
                "postavy:\n",hra1.zpracujPrikaz("jdi Bažiny"));


    }

}
