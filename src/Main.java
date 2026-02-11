public class Main {

    public static void main(String[] args) {
        Stick[] sticks = new Stick[5];
        for (int i = 0; i < sticks.length; i++) {
            sticks[i] = new Stick("stick-" + i);
        }
        System.out.println(sticks[1]);

        for (int i = 0; i < sticks.length; i++) {
            Stick leftStick = sticks[i];
            Stick right = sticks[(i + 1) % 5];

            Thread philosopher = new Philosopher("philosopher-" + i, leftStick, right);
            philosopher.start();
        }
    }

}