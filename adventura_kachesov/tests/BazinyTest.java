import cz.vse.java.adventura.logika.Batoh;
import cz.vse.java.adventura.logika.Hra;
import cz.vse.java.adventura.logika.HerniPlan;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BazinyTest {
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
    public void mluvTest1(){


        assertEquals("  ____    _    __  __ _____    _____     _______ ____  \n" +
                " / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ \n" +
                "| |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |\n" +
                "| |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < \n" +
                " \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\\n" +
                "Jste se utopil.Příště vemte s sebou mapy bažin.Avšak m jedenu sanci odpevez na otazku a muzes se voskrestnout:Dale odpověz na otazku(napíš \"odpovi a\" nebo \"odpovi b\" podle vašeho rozhodnuti. \n" +
                "\n" +
                " Mysliš že si Ježiš Kristus řekl Ach joo jsem mrtvej a pohřbenej?Odpovedí: \" odpovi a \" = ne, \" odpovi b \" = ano", hra1.zpracujPrikaz("jdi Bažiny"));
        assertEquals("Špatná odpověď\n" +
                "  ____    _    __  __ _____    _____     _______ ____  \n" +
                " / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ \n" +
                "| |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |\n" +
                "| |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < \n" +
                " \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\\n",hra1.zpracujPrikaz("odpovi a"));
        assertEquals(true, hra1.konecHry());

    }
    @Test
    public void mluvTest2(){
        hra1.zpracujPrikaz("jdi Bažiny");
        hra1.zpracujPrikaz("odpovi b");
        assertEquals(false, hra1.konecHry());



    }


}
