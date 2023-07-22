import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.EventQueue;

public class Window extends JFrame
{
    public Window() 
    {
        EventQueue.invokeLater(() -> {
            initUi();
            setVisible(true);
        });
    }

    private void initUi() 
    {
        add(new Board());

        pack();
        setTitle("Chess");
        setIconImage(new ImageIcon("kb.png").getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}