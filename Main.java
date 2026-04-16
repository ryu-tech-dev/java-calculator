import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            double a = readNumber(scanner, "1つ目の数字を入力してください：");
            double b = readNumber(scanner, "2つ目の数字を入力してください：");
        
            double c = calculate(scanner, a, b);
            
            showResult(c);

            if(!askToContinue(scanner)) {
                scanner.close();
                return;
            }
        }
    }

    public static double readNumber(Scanner scanner, String message) {
        while(true) {
            System.out.print(message);

            if(scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("無効な入力です。数字を入力してください。");
                scanner.next();
            }
        }
    }

    public static double calculate(Scanner scanner, double a, double b) {
        while(true) {
            System.out.print("演算子を入力してください (+, -, *, /) --> ");
            String op = scanner.next();

            switch(op) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    if(b == 0) {
                        System.out.println("0では割れません。");
                        continue;
                    }
                    return a / b;
                default:
                    System.out.println("無効な演算子です。");
            }
        }
    }

    public static void showResult(double c) {
        if(c == (int)c){
                System.out.println("結果：" + (int)c);
            } else {
                System.out.println("結果：" + c);
            }
    }

    public static boolean askToContinue(Scanner scanner) {
        while(true) {
            System.out.print("続けますか？ (y/n) -->");
            String answer = scanner.next();

            if(answer.equals("y")) {
                return true;
            } else if(answer.equals("n")) {
                return false;
            } else {
                System.out.println("無効な入力です。");
            }
        }
    }
}
