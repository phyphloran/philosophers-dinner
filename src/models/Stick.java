package models;


import java.util.Objects;


public class Stick {

    private String name;


    public Stick(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stick stick = (Stick) o;
        return Objects.equals(name, stick.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Stick{" +
                "name='" + name + '\'' +
                '}';
    }
}
