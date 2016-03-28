import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VotingSystem 
{
    private JPanel panel;
    private JButton button;
    private JTextField firstName;
    private JTextField lastName;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private ButtonGroup radioButtons;
    private JRadioButton candidate1;
    private JRadioButton candidate2;
    private JRadioButton candidate3;
    private JRadioButton candidate4;

    public VotingSystem()
    {
        panel = new JPanel();
        button = new JButton("Vote");
        
        firstName = new JTextField(5);//3 cols, not 20 chars
        lastName = new JTextField(5);//3 cols, not 20 chars
        label1 = new JLabel("First Name:");
        label2 = new JLabel("Last Name:");
        label3 = new JLabel("Cast your vote:");
        //Load the listener
        button.addActionListener(buttonListener());
        
        //add radio buttons
        radioButtons = new ButtonGroup();
        candidate1 = new JRadioButton("Orson Scott Card");
        candidate1.setSelected(true);
        candidate2 = new JRadioButton("Ray Bradbury");
        candidate3 = new JRadioButton("Jules Verne");
        candidate4 = new JRadioButton("William Gibson");
        radioButtons.add(candidate1);
        radioButtons.add(candidate2);
        radioButtons.add(candidate3);
        radioButtons.add(candidate4);

        //load the panel
        panel.add(label1);  
        panel.add(firstName);
        panel.add(label2);  
        panel.add(lastName);
        panel.add(label3);
        panel.add(candidate1);   
        panel.add(candidate2); 
        panel.add(candidate3); 
        panel.add(candidate4); 
        panel.add(button); 
    }

    public Component getContent()
    {
        return (panel);
    }
    
    private ActionListener buttonListener()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String first = firstName.getText();
                String last = lastName.getText();
                String fileName = last + "_" + first + "_" + "_ballot.txt";
                String message = "";
                File f = new File(fileName);
                FileWriter out;
                BufferedWriter outbw;
                
                if (candidate1.isSelected())
                {
                    try
                    {
                        if (!(f.exists()))
                        {
                            f.createNewFile();
                            out = new FileWriter(f.getAbsoluteFile());
                            outbw = new BufferedWriter(out);
                            
                            outbw.write("Voter: " + last + ", " + first);
                            outbw.newLine();
                            outbw.write("Vote: Orson Scott Card");
                            outbw.close();
                            message = "Your vote has been cast!";
                        }
                        else 
                        {
                            message = "This person has already voted.";
                        }     
                    }
                    catch (IOException ex) 
                    {
                        ex.printStackTrace();
                    }
                }
                else if (candidate2.isSelected())
                {
                    try 
                    {
                        if (!(f.exists()))
                        {
                            f.createNewFile();
                            out = new FileWriter(f.getAbsoluteFile());
                            outbw = new BufferedWriter(out);
                            
                            outbw.write("Voter: " + last + ", " + first);
                            outbw.newLine();
                            outbw.write("Vote: Ray Bradbury");
                            outbw.close();
                            message = "Your vote has been cast!";
                        }
                        else 
                        {
                            message = "This person has already voted.";
                        } 
                    }
                    catch (IOException ex) 
                    {
                        ex.printStackTrace();
                    }
                }
                else if (candidate3.isSelected())
                {
                    try 
                    {
                        if (!(f.exists()))
                        {
                            f.createNewFile();
                            out = new FileWriter(f.getAbsoluteFile());
                            outbw = new BufferedWriter(out);
                            
                            outbw.write("Voter: " + last + ", " + first);
                            outbw.newLine();
                            outbw.write("Vote: Jules Verne");
                            outbw.close();
                            message = "Your vote has been cast!";
                        }
                        else 
                        {
                            message = "This person has already voted.";
                        } 
                    }
                    catch (IOException ex) 
                    {
                        ex.printStackTrace();
                    }
                }
                else if (candidate4.isSelected())
                {
                    try 
                    {
                        if (!(f.exists()))
                        {
                            f.createNewFile();
                            out = new FileWriter(f.getAbsoluteFile());
                            outbw = new BufferedWriter(out);
                            
                            outbw.write("Voter: " + last + ", " + first);
                            outbw.newLine();
                            outbw.write("Vote: William Gibson");
                            outbw.close();
                            message = "Your vote has been cast!";
                        }
                        else 
                        {
                            message = "This person has already voted.";
                        } 
                    }
                    catch (IOException ex) 
                    {
                        ex.printStackTrace();
                    }
                }               

                label3.setText(message);
                System.out.println(message);
            }
    };

    return listener;
    }
}