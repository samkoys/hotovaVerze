/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */




import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída PostavaTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class PostavaTest
{
    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
    }

    //== VLASTNÍ TESTY =========================================================
    //
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXxx()
    //     {
    //     }
      @Test
    public  void testPostava() {
        Vec vec1 = new Vec("vec1", true, "");
        Vec vec2 = new Vec("vec2", true, "");
        Postava postava1 = new Postava ("1", "student1", null);
        Postava postava2 = new Postava ("2", "student2", null);
        assertEquals("student1", postava1.getRec());
        assertEquals("student2", postava2.getRec());
        postava1.setJeMenitelny(true);
        postava1.setVymena(vec1, "ne", "ano", "dik");
        assertEquals("nevec1", postava1.vymena(vec2));
        assertFalse(postava1.getVymena());
        assertEquals("dik", postava1.vymena(vec1));
        assertTrue(postava1.getVymena());
    }
    
}
