import javax.swing.JFrame;


public class VotingSystemDriver 
{
    private static void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("Voting System");
        VotingSystem demo = new VotingSystem();

        frame.getContentPane().add(demo.getContent());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        createAndDisplayGUI();
    }
}