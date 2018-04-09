/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.koys.adventura.logika;



/*******************************************************************************
 * Pomocí příkazu Otevri se dostaneme do zamčeného místnosti, pro které otevření musím být v kufri klíč.
 *
 * @author    Samuel Koyš
 * @version   18.05.2017
 */
public class PrikazOtevri implements IPrikaz {
    private static final String NAZEV = "otevri";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy PrikazOtevri
     *  
     *  @param plan herní plán, je potřeba zjistit, zda jsem v místnosti
     *                    vedle místnosti, která se má odemknout
     */    
    public PrikazOtevri(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "otevri". Zjišťuji, zda z aktuální místnosti je
     *  východ do zadané místnosti. Pokud místnost existuje a je zamčená,
     *  tak se zjistí, zda v kufru je potřebný klíč. Pokud ano, odemknu
     *  místnost.
     *
     *@param parametry - jako  parametr obsahuje jméno místnosti,
     *                         do které se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední místnost), tak ....
            return "Co musim otevrit?";
        }

        String mistnost = parametry[0];
        Prostor sousedniMistnost = plan.getAktualniProstor().vratSousedniProstor(mistnost);
        if (sousedniMistnost == null) {
            return "Takova mistnost tu neni";
        }

        
        if (sousedniMistnost.jeZavreny()) {
            Vec key = sousedniMistnost.getKey();
            if (plan.getKufor().jeVKufru(key.getNazev())) {
                sousedniMistnost.setJeZavreny(false);
                return "Otevril jsi prostor";
            }
            else {
                return "Nemas klic";
            }
        }
        else {
            return "Mistnost "+mistnost+" je jiz otevrena";
        }

    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }

}