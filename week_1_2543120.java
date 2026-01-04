import java.awt.*;
import java.awt.event.*;

public class week_1_2543120
 extends Frame implements ActionListener {
    Label lbl1, lbl2, lbl3;
    TextField tf1, tf2, tf3;
    Button btnAdd, btnSub, btnMult, btnDiv;
    

    double num1, num2, result;

    week_1_2543120
    () {
    
        setTitle("Safe Calculator (AWT)");
        setSize(400, 350);
        setLayout(new FlowLayout());
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        lbl1 = new Label("Number 1:");
        tf1 = new TextField(15);
        lbl2 = new Label("Number 2:");
        tf2 = new TextField(15);
        lbl3 = new Label("Result:");
        tf3 = new TextField(15);
        tf3.setEditable(false); 

        btnAdd = new Button("+");
        btnSub = new Button("-");
        btnMult = new Button("*");
        btnDiv = new Button("/");

        
        add(lbl1);
        add(tf1);
        add(lbl2);
        add(tf2);
        add(btnAdd);
        add(btnSub);
        add(btnMult);
        add(btnDiv);
        add(lbl3);
        add(tf3);

    
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMult.addActionListener(this);
        btnDiv.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
        
            num1 = Double.parseDouble(tf1.getText());
            num2 = Double.parseDouble(tf2.getText());

            String command = ae.getActionCommand();

            if (command.equals("+")) {
                result = num1 + num2;
                tf3.setText(String.valueOf(result));
            } else if (command.equals("-")) {
                result = num1 - num2;
                tf3.setText(String.valueOf(result));
            } else if (command.equals("*")) {
                result = num1 * num2;
                tf3.setText(String.valueOf(result));
            } else if (command.equals("/")) {
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                result = num1 / num2;
                tf3.setText(String.valueOf(result));
            }

        } catch (NumberFormatException e) {
            tf3.setText("Invalid input");
        } catch (ArithmeticException e) {
            tf3.setText("Error: " + e.getMessage());
        } catch (Exception e) {

            tf3.setText("An error occurred");
        }
    }

    public static void main(String[] args) {
        new week_1_2543120
        ();
    }
}