import java.awt.Image;
import java.util.ArrayList;

public class Pawn extends Piece
{
    private int start;

    public Pawn(int c, Image i, Square s) 
    {
        super(c,i,s);
        start = getSquare().getX();
    }

    public ArrayList<Integer> getPossibleMoves(Board b) 
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        Square[][] board = b.getBoard();

        if(getColor() == 0)
        {
            if(start == getSquare().getX() && !board[getSquare().getX() - 2][getSquare().getY()].isOccupied()) 
            {
                arr.add(getSquare().getX() - 2);
                arr.add(getSquare().getY());
            }
            if(getSquare().getX() - 1 > -1 && !board[getSquare().getX() - 1][getSquare().getY()].isOccupied())
            {
                arr.add(getSquare().getX() - 1);
                arr.add(getSquare().getY());
            }
            if(getSquare().getX() - 1 > -1 && getSquare().getY() + 1 < 8 && board[getSquare().getX() - 1][getSquare().getY() + 1].isOccupied() && board[getSquare().getX() - 1][getSquare().getY() + 1].getPiece().getColor() != getColor()) 
            {
                arr.add(getSquare().getX() - 1);
                arr.add(getSquare().getY() + 1);
            }
            if(getSquare().getX() - 1 > -1 && getSquare().getY() - 1 > -1 && board[getSquare().getX() - 1][getSquare().getY() - 1].isOccupied() && board[getSquare().getX() - 1][getSquare().getY() - 1].getPiece().getColor() != getColor()) 
            {
                arr.add(getSquare().getX() - 1);
                arr.add(getSquare().getY() - 1); 
            }
        }
        else 
        {
            if(start == getSquare().getX() && !board[getSquare().getX() + 2][getSquare().getY()].isOccupied()) 
            {
                arr.add(getSquare().getX() + 2);
                arr.add(getSquare().getY());
            }
            if(getSquare().getX() + 1 < 8 && !board[getSquare().getX() + 1][getSquare().getY()].isOccupied())
            {
                arr.add(getSquare().getX() + 1);
                arr.add(getSquare().getY());
            }
            if(getSquare().getX() + 1 < 8 && getSquare().getY() + 1 < 8 && board[getSquare().getX() + 1][getSquare().getY() + 1].isOccupied() && board[getSquare().getX() + 1][getSquare().getY() + 1].getPiece().getColor() != getColor()) 
            {
                arr.add(getSquare().getX() + 1);
                arr.add(getSquare().getY() + 1);
            }
            if(getSquare().getX() + 1 < 8 && getSquare().getY() - 1 > -1 && board[getSquare().getX() + 1][getSquare().getY() - 1].isOccupied() && board[getSquare().getX() + 1][getSquare().getY() - 1].getPiece().getColor() != getColor()) 
            {
                arr.add(getSquare().getX() + 1);
                arr.add(getSquare().getY() - 1); 
            }
        }

        return arr;
    }

    public ArrayList<Integer> specialMoves(Board b) 
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        Square[][] board = b.getBoard();

        if(getColor() == 0)
        {
            if(start == getSquare().getX() && !board[getSquare().getX() - 2][getSquare().getY()].isOccupied()) 
            {
                arr.add(getSquare().getX() - 2);
                arr.add(getSquare().getY());
            }
            if(getSquare().getX() - 1 > -1 && !board[getSquare().getX() - 1][getSquare().getY()].isOccupied())
            {
                arr.add(getSquare().getX() - 1);
                arr.add(getSquare().getY());
            }
            if(getSquare().getX() - 1 > -1 && getSquare().getY() + 1 < 8 ) 
            {
                arr.add(getSquare().getX() - 1);
                arr.add(getSquare().getY() + 1);
            }
            if(getSquare().getX() - 1 > -1 && getSquare().getY() - 1 > -1 ) 
            {
                arr.add(getSquare().getX() - 1);
                arr.add(getSquare().getY() - 1); 
            }
        }
        else 
        {
            if(start == getSquare().getX() && !board[getSquare().getX() + 2][getSquare().getY()].isOccupied()) 
            {
                arr.add(getSquare().getX() + 2);
                arr.add(getSquare().getY());
            }
            if(getSquare().getX() + 1 < 8 && !board[getSquare().getX() + 1][getSquare().getY()].isOccupied())
            {
                arr.add(getSquare().getX() + 1);
                arr.add(getSquare().getY());
            }
            if(getSquare().getX() + 1 < 8 && getSquare().getY() + 1 < 8) 
            {
                arr.add(getSquare().getX() + 1);
                arr.add(getSquare().getY() + 1);
            }
            if(getSquare().getX() + 1 < 8 && getSquare().getY() - 1 > -1 ) 
            {
                arr.add(getSquare().getX() + 1);
                arr.add(getSquare().getY() - 1); 
            }
        }

        return arr;
    }
}