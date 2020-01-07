package guessthenumbergame;
/**
 *
 * @author lkh5155 Liuxuan Huang
 */
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.Random;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessTheNumberGame extends JFrame
{
    private int number;
    private JTextField TextField;
    private JLabel Text1;
    private JLabel Text2;
    private JLabel message;
    private final JButton newGame;

    public GuessTheNumberGame()
    {
        setLayout(new FlowLayout());
        Text1 = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
        add(Text1);
        Text1 = new JLabel("Please enter your first guess.");
        add(Text1);
        TextField = new JTextField(5);
        add(TextField);
        
        TextField.addActionListener(new GuessHandler());
        message = new JLabel("");
        add(message);
        newGame = new JButton("New Game");
        add(newGame);
        Random generator = new Random();
        number = generator.nextInt(1001);
        newGame.addActionListener
        (new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    TextField.setText("");
                    Random generator = new Random();//generate a new random number everytime
                    number = generator.nextInt(1001);
                    message.setText("");
                    TextField.setEditable(true);//set the JTextField to be editable
                    getContentPane().setBackground(Color.WHITE);
                }
            }
        );
    }
     
    class GuessHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            int Guess = Integer.parseInt(TextField.getText());
            if (Guess < 0 || Guess > 1000)//throw exceptions
                message.setText("Out of Range.");
            else if (Guess > number)
            {
                getContentPane().setBackground(Color.RED);
                message.setText("Too High.");
            }
            else if (Guess < number)
            {
                getContentPane().setBackground(Color.BLUE);
                message.setText("Too Low.");
            }
            else if (Guess == number)
            {
                getContentPane().setBackground(Color.WHITE);
                message.setText("Correct!");
                TextField.setEditable(false);//set the field to be uneditable once correct
            }
        }
        
    }
    public static void main(String[] args) 
    {
        GuessTheNumberGame guessgame = new GuessTheNumberGame();
        guessgame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessgame.setSize(450, 200);
        guessgame.setVisible(true);
    }
}    