package models;


import java.util.Objects;


public class Philosopher extends Thread {

    private Stick leftStick;

    private Stick rightStick;

    public Philosopher(String name, Stick left, Stick right) {
        super(name);
        this.leftStick = left;
        this.rightStick = right;
    }

    @Override
    public void run() {
        try {
            int foodCycle = 1;
            for (int i = 0; i < foodCycle; i++) {
                think();

                if ("philosopher-1".equals(getName())) {
                    synchronized (rightStick) {
                        System.out.println(getName() + " take right stick " + rightStick.getName());
                        Thread.sleep(100);
                        synchronized (leftStick) {
                            System.out.println(getName() + " take left stick " + leftStick.getName());
                            eat();
                        }
                    }
                } else {
                    synchronized (leftStick) {
                        System.out.println(getName() + " take left stick " + leftStick.getName());
                        Thread.sleep(100);
                        synchronized (rightStick) {
                            System.out.println(getName() + " take right stick " + rightStick.getName());
                            eat();
                        }
                    }
                }
            }

            System.out.println(getName() + " finished eating.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void think() throws InterruptedException {
        Thread.sleep(500);
    }

    private void eat() throws InterruptedException {
        System.out.println("philosopher " + Thread.currentThread().getName() + " eating");
        Thread.sleep(500);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Philosopher that = (Philosopher) o;
        return Objects.equals(leftStick, that.leftStick) && Objects.equals(rightStick, that.rightStick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftStick, rightStick);
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "leftStick=" + leftStick +
                ", rightStick=" + rightStick +
                '}';
    }
}
