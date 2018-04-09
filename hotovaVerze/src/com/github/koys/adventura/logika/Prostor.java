package com.github.koys.adventura.logika;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Samuel Koyš
 * @version 19.05.2017
 */
public class Prostor {
    private boolean jeZavreny;
    private String nazev;
    private String popis;
    private Set<Prostor> vychody;   // obsahuje sousední místnosti
    private Map<String, Vec> veci;
    private List<Postava> postavy;
    private Vec klic; 
    private double x;
    private double y;

    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     */
    public Prostor(String nazev, String popis, double x, double y) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new HashSet<>();
        this.veci = new HashMap<>();
        this.postavy = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
    @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů. 
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

        return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;       
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return popis + ".\n"
        + popisVychodu()+ "\n"
        + popisVeci() + "\n"
        + popisPostav();
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hala ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    private String popisVychodu() {
        String vracenyText = "Vychody:";
        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
            if (sousedni.jeZavreny()) {
                vracenyText += "(zavreny)";
            }
        }
        return vracenyText;
    }

    /**
     * Metoda popisVeci
     *
     * @return popis věcí v daném prostoru
     */
    private String popisVeci()
    {
        String vracenyText = "Veci:";
        for (String nazev : veci.keySet()) {
            vracenyText += " " + nazev;
        }
        return vracenyText;
    }

    /**
     * Metoda popisPostav
     *
     * @return popis postav v určitém prostoru 
     */
    private String popisPostav()
    {
        String vracenyText = "Postavy:";
        for (Postava i : postavy) {
            vracenyText += " " + i.getJmeno();
        }
        return vracenyText;
    }

    /**
     * Metoda vlozPostavu
     *
     * @param postava splnující parametre přidaná do určitého prostoru
     */
    public void vlozPostavu(Postava postava){
        postavy.add(postava);
    }

    /**
     * Metoda najdiPostavu
     *
     * @param jmeno Parametr
     * @return Návratová hodnota
     */
    public Postava najdiPostavu(String jmeno){
        for (Postava i : postavy){
            if (i.getJmeno().equals(jmeno)){
                return i;
            }
        }
        return null;
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory = 
            vychody.stream()
            .filter(  sousedni -> sousedni.getNazev().equals(nazevSouseda))
        .collect(Collectors.toList());
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }

    /**
     * Metoda vlozVec
     *
     * @param neco vloží věc do určitého prostoru
     */
    public void vlozVec(Vec neco)
    {
        veci.put(neco.getNazev(), neco);
    }

    /**
     * Metoda odeberVec
     *
     * @param nazev odobere věc z prostoru
     * @return null, jestli věc v takom prostoru nebyla
     */
    public Vec odeberVec(String nazev)
    {
        return veci.remove(nazev);
    }

    /**
     * Metoda setJeZavreny
     *
     * @param jeZavreny Parametr
     */
    public void setJeZavreny(boolean jeZavreny){
        this.jeZavreny = jeZavreny;
    }

    /**
     * Metoda jeZavreny
     *
     * @return Návratová hodnota
     */
    public boolean jeZavreny(){
        return jeZavreny;
    }

    /**
     * Metoda setKey
     *
     * @param klic Parametr
     */
    public void setKey(Vec klic) {
        this.klic = klic;
    }

    /**
     * Metoda getKey
     *
     * @return Návratová hodnota
     */
    public Vec getKey() {
        return this.klic;
    }
    
    
    public double getX() 
    {
	return x;
    }

    public double getY() 
    {
	return y;
    }
        
    public String seznamVychodu() 
    {
        String vracenyText = "vychody:";
        for (Prostor sousedni : vychody) 
        {
             vracenyText += " " + sousedni.getNazev();
        }
        return vracenyText;
    }

    public Map<String, Vec> getVeci() {
        return veci;
    }
}
