import javax.swing.*;
import java.awt.*;

public class Main {    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("計算機アプリ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel label1 = new JLabel("1つ目の数字");
        JTextField field1 = new JTextField();

        JLabel label2 = new JLabel("2つ目の数字");
        JTextField field2 = new JTextField();

        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");

        JLabel resultLabel = new JLabel("結果：");

        addButton.addActionListener(e -> calculateAndShow(field1, field2, resultLabel, "+"));
        subButton.addActionListener(e -> calculateAndShow(field1, field2, resultLabel, "-"));
        mulButton.addActionListener(e -> calculateAndShow(field1, field2, resultLabel, "*"));
        divButton.addActionListener(e -> calculateAndShow(field1, field2, resultLabel, "/"));

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(label1);
        panel.add(field1);
        panel.add(label2);
        panel.add(field2);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);

        frame.setLayout(new BorderLayout(10,10));
        frame.add(panel, BorderLayout.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void calculateAndShow(JTextField field1, JTextField field2, JLabel resultLabel, String op) {
        try {
            double a = Double.parseDouble(field1.getText());
            double b = Double.parseDouble(field2.getText());

            double result = calculate(a, b, op);
            
            if(result == (int) result) {
                resultLabel.setText("結果：" + (int) result);
            } else {
                resultLabel.setText("結果：" + result);
            }

        } catch (NumberFormatException e) {
            resultLabel.setText("結果：数字を入力してください");
        } catch (ArithmeticException e) {
            resultLabel.setText("結果：" + e.getMessage());
        }
    }

    public static double calculate(double a, double b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if(b == 0) {
                    throw new ArithmeticException("0では割れません");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("無効な演算子です");
        }
    }
}
