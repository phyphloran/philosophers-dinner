package models;


import java.util.Objects;


public class PhilosopherDeadlock extends Thread {

    private Stick leftStick;

    private Stick rightStick;

    public PhilosopherDeadlock(String name, Stick left, Stick right) {
        super(name);
        this.leftStick = left;
        this.rightStick = right;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                synchronized (leftStick) {
                    System.out.println(Thread.currentThread().getName() + " take left stick " + leftStick.getName());
                    Thread.sleep(100);
                    synchronized (rightStick) {
                        System.out.println(Thread.currentThread().getName() + " take right stick " + rightStick.getName());
                        eat();

                    }
                }
            }
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
        PhilosopherDeadlock that = (PhilosopherDeadlock) o;
        return Objects.equals(leftStick, that.leftStick) && Objects.equals(rightStick, that.rightStick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftStick, rightStick);
    }

    @Override
    public String toString() {
        return "PhilosopherDeadlock{" +
                "leftStick=" + leftStick +
                ", rightStick=" + rightStick +
                '}';
    }
}
