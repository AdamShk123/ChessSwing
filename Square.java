import javax.swing.JComponent;

import java.awt.Graphics;

public class Square extends JComponent
{
    private int x;
    private int y;

    private Piece p;

    public Square(int x, int y, Piece p) 
    {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.fillRect(x * 75, y * 75, 75, 75);
    }

    public int getX() 
    {
        return x;
    }

    public int getY() 
    {
        return y;
    }

    public void setPiece(Piece p) 
    {
        this.p = p;
    }

    public Piece getPiece() 
    {
        return p;
    }

    public boolean isOccupied() 
    {
        if(p != null) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}