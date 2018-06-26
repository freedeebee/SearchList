import java.util.Iterator;

/**
 * Schnittstelle zum ZÃ¤hlen von Vorkommen von
 * vergleichbaren Elementen
 * @author barth
 */
public interface SList<T extends Comparable<T>> extends Iterable<T> {

    /**
     * HinzufÃ¼gen eines T.
     * Falls schon vorhanden wird Anzahl Vorkommen um eins erhÃ¶ht
     * Falls noch nicht vorhanden wird Anzahl Vorkommen auf eins gesetzt.
     * @param t hinzuzufÃ¼gendes T
     */
    void add(T t);

    /**
     * Wie hÃ¤ufig kommt ein T vor.
     * @param t zu suchendes T
     * @return Anzahl der Vorkommen von t, 0 wenn nicht vorhanden
     */
    int count(T t);

    /**
     * Entfernen aller Vorkommen eines T.
     * @param t Zu entfernendes T
     * @return true gdw t kam vorher vor
     */
    boolean remove(T t);

    /**
     * Summe der Anzahl der Vorkommen aller T berechnen.
     * @return Summe der Anzahl der Vorkommen aller T
     */
    int noOccurences();

    /**
     * Anzahl der unterschiedlichen T berechnen.
     * @return Anzahl der unterschiedlichen T
     */
    int noWords();

    /**
     * Iterator Ã¼ber alle vorkommenden T zurÃ¼ckgeben
     * @return
     */
    Iterator<T> iterator();

}