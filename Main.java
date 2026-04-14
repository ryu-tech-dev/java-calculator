import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mainLoop:
        while(true) {
            double a;
            while(true) {
                System.out.print("1つ目の数字を入力してください：");

                if(scanner.hasNextDouble()) {
                    a = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("無効な入力です。数字を入力してください。");
                    scanner.next();
                }
            }
            double b;
            while(true) {
                System.out.print("2つ目の数字を入力してください：");
                if(scanner.hasNextDouble()) {
                    b = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("無効な入力です。数字を入力してください。");
                    scanner.next();
                }
            }
                
            

            double c;
            while(true) {
                System.out.print("演算子を入力してください (+, -, *, /) --> ");
                String op = scanner.next();

                switch (op) {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        if(b == 0) {
                            System.out.println("0では割れません。");
                            continue mainLoop;
                        } 
                        c = a / b;
                        break; 
                    default:
                        System.out.println("無効な演算子です。");
                        continue;
                }

                break;
            }

            if(c == (int)c) {
                System.out.println("結果：" + (int)c);
            } else{
                System.out.println("結果：" + c);
            }

            while(true) {
                System.out.print("続けますか？ (y/n) --> ");
                String answer = scanner.next();

                if(answer.equals("y")) {
                    break;
                } else if(answer.equals("n")) {
                    scanner.close();
                    return;
                } else {
                    System.out.println("無効な入力です。");
                }
            }
        }
    }
}