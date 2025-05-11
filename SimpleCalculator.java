import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator {
    // Variables for components and calculations
    private static JTextField textField;
    private static double num1 = 0, num2 = 0, result = 0;
    private static char operator;

    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Calculator");
        frame.setSize(400, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Custom layout for manual positioning

        // Create the text field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false); // User cannot edit manually
        frame.add(textField);

        // Create function buttons
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton decButton = new JButton(".");
        JButton equButton = new JButton("=");
        JButton delButton = new JButton("Del");
        JButton clrButton = new JButton("Clr");

        // Create an array for number buttons (0-9)
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(new NumberAction());
        }

        // Function buttons action listeners
        addButton.addActionListener(e -> setOperator('+'));
        subButton.addActionListener(e -> setOperator('-'));
        mulButton.addActionListener(e -> setOperator('*'));
        divButton.addActionListener(e -> setOperator('/'));

        decButton.addActionListener(e -> textField.setText(textField.getText() + "."));
        equButton.addActionListener(e -> calculateResult());
        clrButton.addActionListener(e -> textField.setText(""));
        delButton.addActionListener(e -> deleteLastCharacter());

        // Add function buttons to an array for easier management
        JButton[] functionButtons = {addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton};

        // Disable focus on buttons
        for (JButton button : functionButtons) {
            button.setFocusable(false);
        }

        // Create a panel with a 4x4 grid layout for buttons
        JPanel panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add panel and other components to the frame
        frame.add(panel);
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);
        frame.add(delButton);
        frame.add(clrButton);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Helper method to set the operator
    private static void setOperator(char op) {
        num1 = Double.parseDouble(textField.getText());
        operator = op;
        textField.setText("");
    }

    // Helper method to calculate and display the result
    private static void calculateResult() {
        num2 = Double.parseDouble(textField.getText());
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        textField.setText(String.valueOf(result));
        num1 = result; // Store the result for further calculations
    }

    // Helper method to delete the last character from the text field
    private static void deleteLastCharacter() {
        String text = textField.getText();
        if (!text.isEmpty()) {
            textField.setText(text.substring(0, text.length() - 1));
        }
    }

    // Inner class to handle number button clicks
    static class NumberAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            textField.setText(textField.getText() + source.getText());
        }
    }
}
