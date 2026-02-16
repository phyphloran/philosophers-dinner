package services.impl;


import models.Stick;
import models.Philosopher;
import models.PhilosopherDeadlock;
import services.Service;


public class ServiceImpl implements Service {

    private boolean philosophersStarted = false;

    @Override
    public void process(String input) {
        if (philosophersStarted) {
            System.out.println("Philosophers already started. Please restart program to run again.");
            return;
        }

        Stick[] sticks;
        switch (input) {
            case "1":
                sticks = new Stick[5];
                for (int i = 0; i < sticks.length; i++) {
                    sticks[i] = new Stick("stick-" + i);
                }
                Thread[] philosophers = new Thread[5];
                for (int i = 0; i < sticks.length; i++) {
                    Stick leftStick = sticks[i];
                    Stick right = sticks[(i + 1) % 5];

                    philosophers[i] = new Philosopher("philosopher-" + i, leftStick, right);
                    philosophers[i].start();
                }
                philosophersStarted = true;
                for (Thread philosopher : philosophers) {
                    try {
                        philosopher.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("All philosophers have finished eating. Program ends.");
//                System.exit(0);

                break;
            case "2":
                sticks = new Stick[5];
                for (int i = 0; i < sticks.length; i++) {
                    sticks[i] = new Stick("stick-" + i);
                }
                for (int i = 0; i < sticks.length; i++) {
                    Stick leftStick = sticks[i];
                    Stick right = sticks[(i + 1) % 5];

                    Thread philosopher = new PhilosopherDeadlock("philosopher-" + i, leftStick, right);
                    philosopher.start();
                }
                philosophersStarted = true;
                break;
            default:
                throw new RuntimeException("Incorrect input");
        }
    }

}
