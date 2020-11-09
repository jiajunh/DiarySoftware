import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HomePage {
    private static JFrame frame = new JFrame("HomePage");
    private static JPanel contentPanel = new JPanel();
    private static void createAndShowGUI() {
        //create a new frame
        //close the window when click "close"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set some properties
        //set x, y, width, height
        frame.setBounds(100,200, 800, 500);

        //create a panel
        contentPanel.setBorder(new EmptyBorder(0,0,800,600));
        contentPanel.setBackground(new Color(70,70,70));
        frame.setContentPane(contentPanel);
        //Manually Set Positions ****
        contentPanel.setLayout(null);

        //JLabel
        JLabel title = new JLabel("Diary Software HomePage");
        //x, y, w, h
        Rectangle frameBounds = frame.getBounds();
        title.setBounds(frameBounds.width/3, frameBounds.height/6, frameBounds.width/3, frameBounds.height/5);
        title.setFont(new Font ("Times New Roman", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        contentPanel.add(title);

        //add buttons
        JButton login = new JButton("Login");
        login.setBounds(150, 320, 100,40);
        contentPanel.add(login);
        //add mouse event, when clicking, do something
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                eventLogin(login);
;            }
        });

        JButton signUp = new JButton("Sign Up");
        signUp.setBounds(550, 320, 100,40);
        contentPanel.add(signUp);
        signUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                eventSignUp(signUp);
            }
        });

        //Display the window.
        frame.setVisible(true);
    }

    private static void eventLogin(JButton login) {
        login.setText(">_<");
    }

    private static void eventSignUp(JButton signUp) {
        signUp.setText("^_^");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

