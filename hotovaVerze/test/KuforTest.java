/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */




import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída KuforTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class KuforTest
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
    
    /**
     * Metoda testInventory
     * Testuje se vkladani veci do batohu a vyhozovani veci z batohu
     * 
     */
    @Test
    public void testInventory(){
    Kufor kufor = new Kufor();
    Vec vec1 = new Vec("1", true, "");
    Vec vec2 = new Vec("2", true, "");
    kufor.vlozVec(vec1);
    assertTrue(kufor.jeVKufru("1"));
    assertFalse(kufor.jeVKufru("2"));
    kufor.vlozVec(vec2);
    assertTrue(kufor.jeVKufru("1"));
    assertTrue(kufor.jeVKufru("2"));
    assertEquals(" 1, 2", kufor.getVeci());
    assertEquals(null, kufor.getVec("3"));
    assertEquals(vec2, kufor.getVec("2"));
    assertEquals(vec2, kufor.zahod("2"));
    assertFalse(kufor.jeVKufru("2"));
    assertEquals(" 1", kufor.getVeci());
    }
    
     @Test
    public void testMaxVeci(){
    Kufor kufor = new Kufor();
    Vec vec1 = new Vec("1", true, "");
    Vec vec2 = new Vec("2", true, "");
    Vec vec3 = new Vec("3", true, "");
    Vec vec4 = new Vec("4", true, "");
    Vec vec5 = new Vec("5", true, "");
    Vec vec6 = new Vec("6", true, "");
    kufor.vlozVec(vec1);
    kufor.vlozVec(vec2);
    kufor.vlozVec(vec3);
    kufor.vlozVec(vec4);
    kufor.vlozVec(vec5);
    assertFalse(kufor.jeMistoVKufru());
    kufor.vlozVec(vec6);
    assertFalse(kufor.jeVKufru("6"));
    }
}
