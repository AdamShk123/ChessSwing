import java.awt.Image;
import java.util.ArrayList;
import java.awt.Graphics;

public abstract class Piece
{
    private int color;
    private Image img;
    private Square square;

    public Piece(int c, Image i, Square s) 
    {
        color = c;
        img = i;
        square = s;
    }

    public void drawImage(Graphics g) 
    {
        g.drawImage(img, square.getY() * 75 + (75 - img.getWidth(null)) / 2, square.getX() * 75 + (75 - img.getWidth(null)) / 2, null);
    }

    public void setSquare(Square s) 
    {
        square = s;
    }

    public Square getSquare() 
    {
        return square;
    }

    public ArrayList<Integer> getPossibleMoves(Board b) 
    {
        return null;
    }

    public int getColor() 
    {
        return color;
    }



}