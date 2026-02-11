import services.Service;
import services.impl.ServiceImpl;
import java.util.Scanner;


public class Main {

    private static final Service SERVICE_IMPL = new ServiceImpl();

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("1. Correct realization" + "\n2. Deadlock realization");
        while (true) {
            String input = scanner.nextLine();
            SERVICE_IMPL.process(input);
        }
    }

}