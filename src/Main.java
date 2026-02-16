import services.Service;
import services.impl.ServiceImpl;
import java.util.Scanner;


public class Main {

    private static final Service service = new ServiceImpl();

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("1. Correct realization" + "\n2. Deadlock realization");
        boolean flag = true;
        while (flag) {
            String input = scanner.nextLine();
            service.process(input);
            flag = false;
        }
    }

}