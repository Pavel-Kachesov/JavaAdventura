import cz.vse.java.adventura.logika.Batoh;
import cz.vse.java.adventura.logika.Hra;
import cz.vse.java.adventura.logika.HerniPlan;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DocelaTest {
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
        hra1.zpracujPrikaz("jdi Docela");
        assertEquals("Od barmana Jima jste zjistil, že tvůj strýc strávil hodně času v bibilitce a možná tam najdeš odpovědi na své otázky.", hra1.zpracujPrikaz("mluv Barman_Jim"));




    }


}
