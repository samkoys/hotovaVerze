/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.koys.adventura.logika;



/*******************************************************************************
 * Pomocí příkazu nabidni provádíme možnou výmenu předmětu za jiný předmět. Výmena je možná jenom s určitými postavami.
 *
 * @author    Samuel Koyš
 * @version   19.05.2017
 */
public class PrikazVymen implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
    private static final String NAZEV = "nabidni";
    private HerniPlan plan;

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor třídy PrikazVymen
     */
    public PrikazVymen(HerniPlan plan)
    {
        this.plan = plan;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
     /**
     *  Provádí příkaz "vymen". Pokud v batohu věc není vypíše chybovou hlášku.
     *  Pokud osoba neexistu vypise chybovou hlasku. 
     *  Lze vymenit jen jednu věc
     *  najednou.
     *
     *  @param  parametry   -jako  parametr se zadává jméno davane věci
     *  @return             zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "S kym se musim menit?";
        }

        String  jmenoPostavy = parametry[0];
        Kufor kufor = plan.getKufor();
        Prostor aktualni = plan.getAktualniProstor();
        Postava postava = aktualni.najdiPostavu(jmenoPostavy);
        
        if (postava==null){
            return jmenoPostavy + " tu neni";}
        
        if (!postava.getJeMenitelny()){
        return "S tim se menit neda";
        }
                
        if (parametry.length == 1) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Co musim vymenit? ";
        }
        
        String nazevVeci = parametry[1];      
         kufor = plan.getKufor();
        Vec proVymenu = kufor.getVec(nazevVeci);

        if(postava == null)
        {
            return jmenoPostavy + " tu neni";
        }
        if (proVymenu == null){
            return "Ja to v kufri nemam";
        }
        
        if (postava.getVymena()){
         return "To nepotrebuji";
        }
        
        if(!kufor.jeMistoVKufru()){
        return "Nemas misto v kufru";
        }
        System.out.println(postava.vymena(proVymenu));
        if (postava.getVymena()){
        kufor.zahod(nazevVeci);
        kufor.vlozVec(postava.getVec());
        
        }
        return "Uvidime se";
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
    //== Soukromé metody (instancí i třídy) ========================================

}