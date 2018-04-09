/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.koys.adventura.logika;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Kufor slouží jako prostředek přenášení předměty s vlastností přenositelná.
 *
 * @author    Samuel Koyš
 * @version   19.05.2017
 */
public class Kufor
{
    //== Datové atributy (statické i instancí)======================================

    private static final int MAX_VECI = 3;    // Maximální počet věcí v kufru
    private List<Vec> seznam;            // Seznam věcí v kufru
    private HerniPlan plan;

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor třídy Kufor
     */
    public Kufor(HerniPlan plan) {
        seznam = new ArrayList<>();
        this.plan = plan;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================

    /**
     * Metoda pro vložení věci.
     * 
     * @param   item    vkládaná věc
     * @return          zpravu kterou vrati hra hrace
     */
    public String vlozVec(Vec vec) {
        if (jeMistoVKufru()) 
        {          
            seznam.add(vec);
            return  "Vzal jsi vec";
        }
        plan.getAktualniProstor().vlozVec(vec);
        return "Tvuj kufr je plny";
    }

    public List<Vec> getSeznam() {
        return seznam;
    }
    
    
    
    

    /**
     * Zjišťuje, zda je v kufru ještě místo.
     * 
     * @return  true   -pokud místo je.
     */
    public boolean jeMistoVKufru() {
        if (seznam.size() < MAX_VECI) {
            return true;   
        }        
        return false;
    }

    /**
     * Zjišťuje, zda je věc v kufru.
     *  
     * @param   lookingItem    lookingItem vec
     * @return  true       pokud se věc v kufru nachází, jinak false
     */
    public boolean jeVKufru(String hleadanaVec) {
        for (Vec i: seznam) {
            if (i.getNazev().equals(hleadanaVec)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vrací seznam věcí v kufru
     * 
     * @return   list     grafický výpis věcí v kufru
     */
    public String getVeci() {
        String list = "";
        for (Vec i: seznam) {
            if (!list.equals("")) {
                //pro větší přehlednost dáme čárku
                list += ",";
            }
            list += " " + i.getNazev();
        }
        return list;
    }

    /**
     * Metoda najde věc, na kterou chceme odkázat
     * 
     * @param name      -název věci, kterou chceme najít
     * @return lookingItem   -odkaz na nalezenou věc. Je null, pokud věc nebyla nalezena
     */
    public Vec getVec(String jmeno) {
        Vec hledanaVec = null;
        for (Vec i: seznam) {
            if(i.getNazev().equals(jmeno)) {
                hledanaVec = i;
                break;
            }
        }
        return hledanaVec;
    }

    /**
     * Odstrani veci z kufru
     * 
     * @param   name      odstraňovaná věc
     * @return  deleted     odstraněná věc. Je null, pokud věc nebyla v kufru nalezena
     */
    public Vec zahod (String jmeno) {
        Vec zahodena = null;
        for(Vec i: seznam) {
            if(i.getNazev().equals(jmeno)) {
                zahodena = i;
                seznam.remove(i);
                break;
            }
        }
        return zahodena;
    }
    
    /**
     * Metoda vrací maximální počet věcí, které lze přidat do kufru.
     * 
     * @return  -počet věcí
     */
    public int getMaxItems() {
        return MAX_VECI;
    }

}