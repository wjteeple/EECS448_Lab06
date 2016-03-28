import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class SafeConverter 
{
    private JPanel panel;
    private JButton button;
    private JTextField text;
    private JLabel label;
    private ButtonGroup radioButtons;
    private JRadioButton FtoC;
    private JRadioButton FtoK;
    private JRadioButton CtoF;
    private JRadioButton CtoK;
    private JRadioButton KtoF;
    private JRadioButton KtoC;

    public SafeConverter()
    {
        panel = new JPanel();
        button = new JButton("Convert");
        
        text = new JTextField(3);//3 cols, not 20 chars
        label = new JLabel("Enter a temperature.");

        //Load the listener
        button.addActionListener(buttonListener());
        
        //add radio buttons
        radioButtons = new ButtonGroup();
        FtoC = new JRadioButton("F to C");
        FtoC.setSelected(true);
        FtoK = new JRadioButton("F to K");
        CtoF = new JRadioButton("C to F");
        CtoK = new JRadioButton("C to K");
        KtoF = new JRadioButton("K to F");
        KtoC = new JRadioButton("K to C");
        radioButtons.add(FtoC);
        radioButtons.add(FtoK);
        radioButtons.add(CtoF);
        radioButtons.add(CtoK);
        radioButtons.add(KtoF);
        radioButtons.add(KtoC);

        //load the panel
        panel.add(text);
        panel.add(button);
        panel.add(label);        
        panel.add(FtoC);   
        panel.add(FtoK); 
        panel.add(CtoF); 
        panel.add(CtoK); 
        panel.add(KtoF); 
        panel.add(KtoC); 
    }

    public Component getContent()
    {
        return (panel);
    }
    
    
    public static boolean isNumeric(String str) //assisted code form StackOverflow, ---->
    //url: http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
    {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    
    private ActionListener buttonListener()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = text.getText();
                String newText = "";
                
                if (!isNumeric(input))
                {
                    newText = "Value entered is empty or not a number.";
                }
                else
                {
                    double temp = Double.parseDouble(input);
                    double convTemp = 0;
                    
                    if (FtoC.isSelected())
                    {
                        convTemp = (temp-32)*(5.0/9.0); //convert F to C
                    }
                    else if (FtoK.isSelected())
                    {
                        convTemp = (temp-32)*(5.0/9.0) + 273.15; //convert F to K
                    }
                    else if (CtoF.isSelected())
                    {
                        convTemp = (temp*(9.0/5.0) + 32); //convert C to F
                    }
                    else if (CtoK.isSelected())
                    {
                        convTemp = temp + 273.15; //convert C to K
                    }
                    else if (KtoF.isSelected())
                    {
                        convTemp = ((temp-273.15)*(9.0/5.0) + 32); //convert K to F
                    }
                    else if (KtoC.isSelected())
                    {
                        convTemp = temp - 273.15; //convert K to C
                    }   
                    
                    newText = "Converted temp is: " + String.format("%.2f", convTemp);
                }               
                label.setText(newText);
                System.out.println(newText);
            }
    };

    return listener;
    }
}