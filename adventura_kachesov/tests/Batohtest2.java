import cz.vse.java.adventura.logika.Batoh;
import cz.vse.java.adventura.logika.Vec;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Batohtest2 {

    private Batoh batoh;
    private Vec vec1;
    private Vec vec2;

    @Before
    public void setUp() {
        batoh = new Batoh();
        vec1 = new Vec("Klíč", "dfghj ", " iyf975789");
        vec2 = new Vec("Mapa", " ;lkjh", " 4567");
    }

    @Test
    public void testVloz() {

        assertTrue(batoh.vloz(vec1));
        assertEquals("dfghj ", vec1.getPopis());
        assertEquals(" iyf975789", vec1.getObsah());
        assertEquals(1, batoh.getBatoh().size());
        assertTrue(batoh.getBatoh().containsKey("Klíč"));
    }


    @Test
    public void testVyhod() {
        batoh.vloz(vec1);
        assertTrue(batoh.vyhod(vec1));
        assertEquals(0, batoh.getBatoh().size());
    }


    @Test
    public void testGetVec() {
        batoh.vloz(vec1);
        assertEquals(vec1, batoh.getVec("Klíč"));
        assertNull(batoh.getVec("Mapa"));
    }

    @Test
    public void testMasVec() {
        batoh.vloz(vec1);
        assertTrue(batoh.masVec("Klíč"));
        assertFalse(batoh.masVec("Mapa"));
    }
    @Test
    public void testMasVec2() {
        batoh.vloz(vec1);
        assertEquals(true,batoh.masVec("Klíč"));
        assertEquals(false,batoh.masVec("Mapa"));
    }
}
