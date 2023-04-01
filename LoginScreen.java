import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame {
   private JLabel usernameLabel;
   private JLabel passwordLabel;
   private JTextField usernameField;
   private JPasswordField passwordField;
   private JButton loginButton;
   private JButton cancelButton;

   public LoginScreen() {
      setTitle("Login Screen");
      setSize(300, 150);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new FlowLayout());

      usernameLabel = new JLabel("Username: ");
      add(usernameLabel);

      usernameField = new JTextField(20);
      add(usernameField);

      passwordLabel = new JLabel("Password: ");
      add(passwordLabel);

      passwordField = new JPasswordField(20);
      add(passwordField);

      loginButton = new JButton("Login");
      loginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.equals("admin") && password.equals("admin")) {
               JOptionPane.showMessageDialog(null, "Login successful!");
            } else {
               JOptionPane.showMessageDialog(null, "Invalid username or password.");
            }
         }
      });
      add(loginButton);

      cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });
      add(cancelButton);

      setVisible(true);
   }

   public static void main(String[] args) {
      new LoginScreen();
   }
}
