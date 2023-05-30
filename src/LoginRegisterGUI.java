import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LoginRegisterGUI extends JFrame {
    private Map<String, String> userCredentials;

    private JTextField usernameTextField;
    private JPasswordField passwordField;

    public LoginRegisterGUI() {
        userCredentials = new HashMap<>();

        setTitle("Login and Register Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Login Form
        JLabel usernameLabel = new JLabel("Username:");
        add(usernameLabel);
        usernameTextField = new JTextField(15);
        add(usernameTextField);

        JLabel passwordLabel = new JLabel("Password:");
        add(passwordLabel);
        passwordField = new JPasswordField(15);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        add(loginButton);

        // Register Form
        JLabel registerLabel = new JLabel("Not registered yet?");
        add(registerLabel);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        add(registerButton);

        setVisible(true);
    }

    private void login() {
        String username = usernameTextField.getText();
        String password = new String(passwordField.getPassword());

        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }

    private void register() {
        String username = JOptionPane.showInputDialog(this, "Enter a username:");

        if (userCredentials.containsKey(username)) {
            JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different username.");
            return;
        }

        String password = JOptionPane.showInputDialog(this, "Enter a password:");
        userCredentials.put(username, password);

        JOptionPane.showMessageDialog(this, "Registration successful!");
    }

}