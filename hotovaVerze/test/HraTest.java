

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková
 * @version  pro školní rok 2015/2016
 */
public class HraTest {
    private Hra hra1;

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
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void testPrubehHry() {
        assertEquals("Barneyho_apartmán", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi MetroA");
         assertEquals("MetroA", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi MetroB");
         assertEquals("MetroB", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi Nevestinec");
        assertEquals(false, hra1.konecHry());
        assertEquals("Nevestinec", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("seber leopardie_saty");
        assertTrue(hra1.getHerniPlan().getKufor().jeVKufru("leopardie_saty"));
        hra1.zpracujPrikaz("jdi MetroB");
        assertEquals(false, hra1.konecHry());
        assertEquals("MetroB", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi Dum_kamošky");
        assertEquals(false, hra1.konecHry());
        assertEquals("Dum_kamošky", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("nabidni Shelly leopardie_saty");
        assertTrue(hra1.getHerniPlan().getKufor().jeVKufru("cervene_boty"));
        hra1.zpracujPrikaz("jdi MetroB");
        assertEquals(false, hra1.konecHry());
        assertEquals("MetroB", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi Tedov_apartmán");
        assertEquals(false, hra1.konecHry());
        assertEquals("Tedov_apartmán", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("nabidni Ted cervene_boty");
        assertTrue(hra1.getHerniPlan().getKufor().jeVKufru("flasa_skotskej"));
        hra1.zpracujPrikaz("jdi MetroB");
        assertEquals(false, hra1.konecHry());
        assertEquals("MetroB", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi MetroA");
        assertEquals(false, hra1.konecHry());
        assertEquals("MetroA", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi Marshallov_apartmán");
        assertEquals(false, hra1.konecHry());
        assertEquals("Marshallov_apartmán", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("nabidni Marshall flasa_skotskej");
        assertTrue(hra1.getHerniPlan().getKufor().jeVKufru("klic"));
        hra1.zpracujPrikaz("otevri Lilyn_pokoj");
        assertFalse(hra1.getHerniPlan().getAktualniProstor().jeZavreny());
         hra1.zpracujPrikaz("jdi Lilyn_pokoj");
        assertEquals(false, hra1.konecHry());
        assertEquals("Lilyn_pokoj", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("seber playbook");
       
        assertEquals(true, hra1.konecHry());
        assertTrue(hra1.getHerniPlan().jeVyhra());
    }
}
