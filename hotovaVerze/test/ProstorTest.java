


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Jarmila Pavlíčková
 * @version   pro skolní rok 2015/2016
 */
public class ProstorTest
{
    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře, 
     */
    @Test
    public  void testLzeProjit() {      
        Prostor prostor1 = new Prostor("hala", "vstupní hala budovy VŠE na Jižním městě");
        Prostor prostor2 = new Prostor("bufet", "bufet, kam si můžete zajít na svačinku");
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor2, prostor1.vratSousedniProstor("bufet"));
        assertEquals(null, prostor2.vratSousedniProstor("pokoj"));
    }

     /**Metoda testuje moznost pridani osob do mistnost 
     */
    @Test
    public void testVeci()
    {
        logika.Vec vec1 = new logika.Vec("a", true, "");
        logika.Vec vec2 = new logika.Vec("b", false, "");
        logika.Prostor prostor1 = new logika.Prostor(null, null);
        prostor1.vlozVec(vec1);
        prostor1.vlozVec(vec2);
        assertNull(prostor1.odeberVec("c"));
        assertSame(vec1, prostor1.odeberVec("a"));
        assertSame(vec2, prostor1.odeberVec("b"));
    }
    
    
     /**Metoda testuje moznost uzavreni mistnosti
     * 
     */
     @Test
    public  void testPostava() {  
        Prostor prostor1 = new Prostor("hala", "vstupní hala budovy VŠE na Jižním městě");
        Postava postava1 = new Postava("student1", "Ahoj", null);
        Postava postava2 = new Postava("student2", "Cau", null);
        prostor1.vlozPostavu(postava1);
        prostor1.vlozPostavu(postava2);
        assertEquals(postava1, prostor1.najdiPostavu("student1"));
        assertEquals(postava2, prostor1.najdiPostavu("student2"));
    }
    
    
        /**
     * Metoda testVeci
     * Testuje se vkladani a odebirani veci do mistnosti
     */
       @Test
    public void testClosed()
    {
        Prostor prostor1 = new Prostor("hala", "vstupní hala budovy VŠE na Jižním městě");
        prostor1.setJeZavreny(true);
        assertEquals(true, prostor1.jeZavreny());
        Vec klic = new Vec("klic", true, "");
        prostor1.setKey(klic);
        assertEquals(klic, prostor1.getKey());
    }
}

