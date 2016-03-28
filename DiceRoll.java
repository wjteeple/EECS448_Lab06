import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.*;

public class DiceRoll
{
    private JPanel panel;
    private JButton button;
    private JTextField text;
    private JLabel label;
    
    public DiceRoll()
    {
        panel = new JPanel();
        button = new JButton("Roll");
        text = new JTextField(3);
        label = new JLabel("Enter dice sides (minimum 6).");
        
        //load listener
        button.addActionListener(rollButtonListener());
        
        //load panel
        panel.add(text);
        panel.add(button);
        panel.add(label);       
    }
    
    public Component getContent()
    {
        return (panel);
    }
    
    private ActionListener rollButtonListener()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = text.getText();
                int sides = Integer.parseInt(input);
                
                if (sides > 5)
                {                   
                    Random rand = new Random();
                    int roll = rand.nextInt(sides) + 1;
                    String newText = "You have rolled a " + String.format("%d", roll) + ".";
                    label.setText(newText);
                    System.out.println(newText);
                }
                else
                {
                    String newText = "Cannot roll a " + String.format("%d", sides) + "-sided die.";
                    label.setText(newText);
                    System.out.println(newText);
                }
            }
        };
        
        return listener;
    }
}