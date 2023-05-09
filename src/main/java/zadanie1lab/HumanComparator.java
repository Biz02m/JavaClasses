package zadanie1lab;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        int comparison;
        comparison = o1.getLevel().compareTo(o2.getLevel());
        if (comparison != 0) return comparison;
        comparison = o1.getName().compareTo(o2.getName());
        if (comparison != 0) return comparison;
        return o1.getPower().compareTo(o2.getPower());
    }
}
