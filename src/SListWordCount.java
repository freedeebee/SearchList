import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.medieninf.ads.ADSTool;

/**
 * Testet die SList Implementierungen SearchList
 * und SmartSearchList. Einfach nur benutzen.
 * Um nur eine implementierung zu testen, kommentieren
 * Sie den jeweils anderen Aufruf in Zeile 124/126 aus.
 * @author pb
 */
public class SListWordCount {

    // Datei, die verwendet werden ohne Kommandozeilenparameter
    private static String[] DATEIEN = {
            "texte/Woerter.txt",
            "texte/RomeoAndJuliet.txt",
            "texte/RAJSorted.txt",
            "texte/ShakespeareComplete.txt",
    };

    final static String splitregex = "[ \t\n,:.]+";
    final static int NAME_OFFSET = 24;

    private static String getBaseName(String path) {
        File file = new File(path);
        return file.getName();
    }

    /**
     * Testen einer Implementierung von SList
     * @param zeilen String[], die zu verarbeitenden Zeilen
     * @param sl SList<String>, die zu verwendende Instanz von SList,
     *           sollte leer und neu sein
     * @return true gdw alles ok
     */
    public static boolean test(String[] zeilen, SList<String> sl) {
        int count = 0;
        Map<String, Integer> hm = makeMap(zeilen); // Zum Gegentesten
        ADSTool.resetTime();
        for (String zeile : zeilen) {
            for (String wort : zeile.split(splitregex)) {
                sl.add(wort);
                count++;
            }
        }
        String insTime = ADSTool.stringTime();
        System.out.format("%6d   %8d%8s", sl.noWords(), sl.noOccurences(), insTime);
        System.out.flush();
        ADSTool.resetTime();
        for (String s : sl) {
            count -= sl.count(s);
        }
        String itTime = ADSTool.stringRTime();
        System.out.format("%8s", itTime);
        if (count != 0) {
            System.out.format("\nFehler: Anzahl der Einträge %d\n", count);
            return false;
        }
        for (Entry<String, Integer> entry : hm.entrySet()) {
            String s = entry.getKey();
            int hmcount = entry.getValue();
            if (hmcount != sl.count(s)) {
                System.out.format("\nFehler: Anzahl der Vorkommen bei %s\n", s);
                System.out.format("  Es sollten %d sein, sind aber %d\n",
                        hmcount, sl.count(s));
                return false;
            }
        }
        String lookupTime = ADSTool.stringRTime();
        System.out.format("%8s", lookupTime);
        for (String s : hm.keySet()) {
            sl.remove(s);
            if (sl.count(s) != 0) {
                System.out.format("\nFehler: Element %s nicht gelÃ¶scht\n", s);
                return false;
            }
        }
        String removeTime = ADSTool.stringRTime();
        System.out.format("%8s", removeTime);
        if (sl.noOccurences() != 0 || sl.noWords() != 0) {
            System.out.format("\nFehler: SList nicht leer\n");
            return false;
        }
        System.out.println();
        return true;
    }

    // HashMap, die dasselbe macht wie SearchList;
    // wird nur zum Testen gemacht, kommt spÃ¤ter noch
    // als Thema (nicht daran aufhalten)
    public static Map<String, Integer> makeMap(String[] zeilen) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for (String zeile : zeilen) {
            for (String wort : zeile.split(splitregex)) {
                Integer count = hm.getOrDefault(wort, Integer.valueOf(0));
                hm.put(wort, count+1);
            }
        }
        return hm;
    }

    public static void main(String[] args) {
        String[] dateien = DATEIEN;
        if (args.length != 0) {
            dateien = args;
        }
        for (String datei : dateien) {
            String[] zeilen = ADSTool.readStringArray(datei);
            datei = getBaseName(datei);
            if (datei.length() > NAME_OFFSET) {
                System.out.format("%s\n", datei);
                datei = datei.substring(datei.length()-NAME_OFFSET);
            }
            String fmt = "%-"+NAME_OFFSET+"s";
            String header = " Worte  Vorkommen    insert   iterate    lookup    remove\n";
            System.out.format(fmt + header, datei);
            System.out.format(fmt, "  SearchLis");
            test(zeilen, new SearchList<String>());
            //System.out.format(fmt, "  SmartSearchList");
            //test(zeilen, new SmartSearchList<String>());
        }
    }

}