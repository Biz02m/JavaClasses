package zadanie1lab;

import java.util.*;

public class Human implements Comparable<Human> {
    private final String Name;
    private final Integer level;
    private final Double power;
    private Set<Human> Apprentices;
    public static int depth;
    public static int numberOfChildren;

    public String getName(){
        return this.Name;
    }

    public Integer getLevel() {
        return this.level;
    }

    public Double getPower(){
        return this.power;
    }

    public Set<Human> getApprentices() {
        return this.Apprentices;
    }

    public Human(String name, int level, Double power, String sorting){
        this.Name = name;
        this.level = level;
        this.power = power;
        depth = 0;
        switch (sorting) {
            case "noSorting" -> this.Apprentices = new HashSet<>();
            case "naturalSort" -> this.Apprentices = new TreeSet<>();
            case "alternativeSort" -> this.Apprentices = new TreeSet<>(new HumanComparator());
        }
    }

    public void AppendApprentice(Human app){
        this.Apprentices.add(app);
    }

    public int CountApprentices(){
        for (Human mage: this.getApprentices()
             ) {
            numberOfChildren++;
            mage.CountApprentices();
        }
        return numberOfChildren;
    }

    public void printMe(){
        depth +=1;
        System.out.println(this);
        for (Human app:this.getApprentices()
             ) {
            app.printMe();
        }
        depth -=1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Human other = (Human) obj;
        if (!this.Name.equals(other.getName())) return false;
        if (!Objects.equals(this.level, other.getLevel())) return false;
        if (!Objects.equals(this.power, other.getPower())) return false;
        return this.Apprentices.equals(other.getApprentices());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.Name == null) ? 0 : this.Name.hashCode());
        long temp;
        temp = Double.doubleToLongBits((this.level + this.power));
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    @Override
    public int compareTo(Human other) {
        int comparison;
        comparison = this.Name.compareTo(other.getName());
        if (comparison != 0) return comparison;
        comparison = this.level.compareTo(other.getLevel());
        if (comparison != 0) return comparison;
        return this.power.compareTo(other.getPower());
    }

    @Override
    public String toString(){
        String retStr = "-".repeat(depth);
        retStr = retStr + "Mage{name= "+ this.Name + " , level= " + this.level +" , power= " + this.power +"}";
        return retStr;
    }
}
