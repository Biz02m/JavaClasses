package zadanie1lab;

import java.util.*;

public class App {
    public static void main(String[] args) {
        String mode = args[0];
        Set<Human> Mages = new HashSet<>();
        Map<Human, Integer> stats = new HashMap<>();
        switch (mode) {
            case "noSorting" -> {
                Mages = new HashSet<>();
                stats = new HashMap<>();
            }
            case "naturalSort" ->{
                Mages = new TreeSet<>();
                stats = new TreeMap<>();
            }
            case "alternativeSort" -> {
                Mages = new TreeSet<>(new HumanComparator());
                stats = new TreeMap<>(new HumanComparator());
            }
        }

        Human bindon = new Human("bindon", 69, 69.0, mode);
        Human pundon = new Human("Samuran the Stinky", 12, 25.0, mode);
        pundon.AppendApprentice(new Human("babiszon", 4, 11.2, mode));
        pundon.AppendApprentice(new Human("malpiszon", 11, 2.0, mode));
        pundon.AppendApprentice(new Human("Samuran the Silly", 2, 12.0, mode));
        bindon.AppendApprentice(pundon);

        Human JoeBiden = new Human("Joe Bidome", 1,1.0, mode);
        Human TrumpPump = new Human("Ramparapam", 42, 6.9, mode);
        Human JoeMama = new Human("Ligma", 999, 99.9, mode);
        JoeMama.AppendApprentice(new Human("Balls", 9999,99.9, mode));

        Mages.add(bindon);
        Mages.add(pundon);
        Mages.add(JoeBiden);
        Mages.add(TrumpPump);
        Mages.add(JoeMama);

        for (Human mage: Mages
             ) {
            mage.printMe();
        }

        int numberOfChildren;
        for (Human mage: Mages
             ) {
            Human.numberOfChildren = 0;
            stats.put(mage, mage.CountApprentices());
        }

        System.out.println(stats);

    }
}
