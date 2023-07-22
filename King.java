import java.awt.Image;
import java.util.ArrayList;

public class King extends Piece
{
    public King(int c, Image i, Square s) 
    {
        super(c,i,s);
    }

    public ArrayList<Integer> getPossibleMoves(Board b) 
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        Square[][] board = b.getBoard();

        //up
        if(getSquare().getX() - 1 > -1 && !board[getSquare().getX() - 1][getSquare().getY()].isOccupied()) 
        {
            arr.add(getSquare().getX() - 1);
            arr.add(getSquare().getY());
        }
        else if(getSquare().getX() - 1 > -1 && board[getSquare().getX() - 1][getSquare().getY()].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() - 1);
            arr.add(getSquare().getY());
        }

        //down
        if(getSquare().getX() + 1 < 8 && !board[getSquare().getX() + 1][getSquare().getY()].isOccupied()) 
        {
            arr.add(getSquare().getX() + 1);
            arr.add(getSquare().getY());
        }
        else if(getSquare().getX() + 1 < 8 && board[getSquare().getX() + 1][getSquare().getY()].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() + 1);
            arr.add(getSquare().getY());
        }

        //right
        if(getSquare().getY() + 1 < 8 && !board[getSquare().getX()][getSquare().getY() + 1].isOccupied()) 
        {
            arr.add(getSquare().getX());
            arr.add(getSquare().getY() + 1);
        }
        else if(getSquare().getY() + 1 < 8 && board[getSquare().getX()][getSquare().getY() + 1].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX());
            arr.add(getSquare().getY() + 1);
        }

        //left
        if(getSquare().getY() -1 > -1 && !board[getSquare().getX()][getSquare().getY() - 1].isOccupied()) 
        {
            arr.add(getSquare().getX());
            arr.add(getSquare().getY() - 1);
        }
        else if(getSquare().getY() -1 > -1 && board[getSquare().getX()][getSquare().getY() - 1].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX());
            arr.add(getSquare().getY() - 1);
        }

        //up-right
        if(getSquare().getX() - 1 > -1 && getSquare().getY()  + 1 < 8 && !board[getSquare().getX() - 1][getSquare().getY() + 1].isOccupied()) 
        {
            arr.add(getSquare().getX() - 1);
            arr.add(getSquare().getY() + 1);
        }
        else if(getSquare().getX() - 1 > -1 && getSquare().getY()  + 1 < 8 && board[getSquare().getX() - 1][getSquare().getY() + 1].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() - 1);
            arr.add(getSquare().getY() + 1);
        }

        //up-left
        if(getSquare().getX() - 1 > -1 && getSquare().getY() -1 > -1 && !board[getSquare().getX() - 1][getSquare().getY() - 1].isOccupied()) 
        {
            arr.add(getSquare().getX() - 1);
            arr.add(getSquare().getY() - 1);
        }
        else if(getSquare().getX() - 1 > -1 && getSquare().getY() -1 > -1 && board[getSquare().getX() - 1][getSquare().getY() - 1].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() - 1);
            arr.add(getSquare().getY() - 1);
        }

        //down-right
        if(getSquare().getX() + 1 < 8 && getSquare().getY()  + 1 < 8 && !board[getSquare().getX() + 1][getSquare().getY() + 1].isOccupied()) 
        {
            arr.add(getSquare().getX() + 1);
            arr.add(getSquare().getY() + 1);
        }
        else if(getSquare().getX() + 1 < 8 && getSquare().getY()  + 1 < 8 && board[getSquare().getX() + 1][getSquare().getY() + 1].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() + 1);
            arr.add(getSquare().getY() + 1);
        }


        // down-left
        if(getSquare().getX() + 1 < 8 && getSquare().getY() -1 > -1 && !board[getSquare().getX() + 1][getSquare().getY() - 1].isOccupied()) 
        {
            arr.add(getSquare().getX() + 1);
            arr.add(getSquare().getY() - 1);
        }
        else if(getSquare().getX() + 1 < 8 && getSquare().getY() -1 > -1 && board[getSquare().getX() + 1][getSquare().getY() - 1].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() + 1);
            arr.add(getSquare().getY() - 1);
        }
        
        return arr;
    }
}