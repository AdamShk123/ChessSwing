import java.awt.Image;
import java.util.ArrayList;

public class Rook extends Piece
{
    public Rook(int c, Image i, Square s) 
    {
        super(c,i,s);
    }

    public ArrayList<Integer> getPossibleMoves(Board b) 
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        Square[][] board = b.getBoard();

        //up
        for(int i = getSquare().getX() - 1; i > -1; i--) 
        {
            if(!board[i][getSquare().getY()].isOccupied()) 
            {
                arr.add(i);
                arr.add(getSquare().getY());
            }
            else if(board[i][getSquare().getY()].getPiece().getColor() != getColor()) 
            {
                arr.add(i);
                arr.add(getSquare().getY());
                break;
            }
            else
            {
                break;
            }
        }

        //down
        for(int i = getSquare().getX() + 1; i < 8; i++) 
        {
            if(!board[i][getSquare().getY()].isOccupied()) 
            {
                arr.add(i);
                arr.add(getSquare().getY());
            }
            else if(board[i][getSquare().getY()].getPiece().getColor() != getColor()) 
            {
                arr.add(i);
                arr.add(getSquare().getY());
                break;
            }
            else 
            {
                break;
            }
        }

        //right
        for(int i = getSquare().getY() + 1; i < 8; i++) 
        {
            if(!board[getSquare().getX()][i].isOccupied()) 
            {
                arr.add(getSquare().getX());
                arr.add(i);
            }
            else if(board[getSquare().getX()][i].getPiece().getColor() != getColor()) 
            {
                arr.add(getSquare().getX());
                arr.add(i);
                break;
            }
            else 
            {
                break;
            }
        }

        //left
        for(int i = getSquare().getY() - 1; i > -1; i--) 
        {
            if(!board[getSquare().getX()][i].isOccupied()) 
            {
                arr.add(getSquare().getX());
                arr.add(i);
            }
            else if(board[getSquare().getX()][i].getPiece().getColor() != getColor()) 
            {
                arr.add(getSquare().getX());
                arr.add(i);
                break;
            }
            else 
            {
                break;
            }
        }

        return arr;
    }
}