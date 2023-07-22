import java.awt.Image;
import java.util.ArrayList;

public class Knight extends Piece
{
    public Knight(int c, Image i, Square s) 
    {
        super(c,i,s);
    }

    public ArrayList<Integer> getPossibleMoves(Board b) 
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        Square[][] board = b.getBoard();

        //up-right
        if(getSquare().getX() - 2 > -1 && getSquare().getY() + 1 < 8 && !board[getSquare().getX() - 2][getSquare().getY() + 1].isOccupied()) 
        {
            arr.add(getSquare().getX() - 2);
            arr.add(getSquare().getY() + 1);
        }
        else if(getSquare().getX() - 2 > -1 && getSquare().getY() + 1 < 8 && board[getSquare().getX() - 2][getSquare().getY() + 1].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() - 2);
            arr.add(getSquare().getY() + 1);
        }

        //up-left
        if(getSquare().getX() - 2 > -1 && getSquare().getY() - 1 > -1 && !board[getSquare().getX() - 2][getSquare().getY() - 1].isOccupied()) 
        {
            arr.add(getSquare().getX() - 2);
            arr.add(getSquare().getY() - 1);
        }
        else if(getSquare().getX() - 2 > -1 && getSquare().getY() - 1 > -1 && board[getSquare().getX() - 2][getSquare().getY() - 1].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() - 2);
            arr.add(getSquare().getY() - 1);
        }
        

        //down-right
        if(getSquare().getX() + 2 < 8 && getSquare().getY() + 1 < 8 && !board[getSquare().getX() + 2][getSquare().getY() + 1].isOccupied()) 
        {
            arr.add(getSquare().getX() + 2);
            arr.add(getSquare().getY() + 1);
        }
        else if(getSquare().getX() + 2 < 8 && getSquare().getY() + 1 < 8 && board[getSquare().getX() + 2][getSquare().getY() + 1].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() + 2);
            arr.add(getSquare().getY() + 1);
        }
        

        //down-left
        if(getSquare().getX() + 2 < 8 && getSquare().getY() - 1 > -1 && !board[getSquare().getX() + 2][getSquare().getY() - 1].isOccupied()) 
        {
            arr.add(getSquare().getX() + 2);
            arr.add(getSquare().getY() - 1);
        }
        else if(getSquare().getX() + 2 < 8 && getSquare().getY() - 1 > -1 && board[getSquare().getX() + 2][getSquare().getY() - 1].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() + 2);
            arr.add(getSquare().getY() - 1);
        }


        //right-up
        if(getSquare().getX() - 1 > -1 && getSquare().getY() + 2 < 8 && !board[getSquare().getX() - 1][getSquare().getY() + 2].isOccupied()) 
        {
            arr.add(getSquare().getX() - 1);
            arr.add(getSquare().getY() + 2);
        }
        else if(getSquare().getX() - 1 > -1 && getSquare().getY() + 2 < 8 && board[getSquare().getX() - 1][getSquare().getY() + 2].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() - 1);
            arr.add(getSquare().getY() + 2);
        }


        //right-down
        if(getSquare().getX() + 1 < 8 && getSquare().getY() + 2 < 8 && !board[getSquare().getX() + 1][getSquare().getY() + 2].isOccupied()) 
        {
            arr.add(getSquare().getX() + 1);
            arr.add(getSquare().getY() + 2);
        }
        else if(getSquare().getX() + 1 < 8 && getSquare().getY() + 2 < 8 && board[getSquare().getX() + 1][getSquare().getY() + 2].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() + 1);
            arr.add(getSquare().getY() + 2);
        }

        
        //left-up
        if(getSquare().getX() - 1 > -1 && getSquare().getY() - 2 > -1 && !board[getSquare().getX() - 1][getSquare().getY() - 2].isOccupied()) 
        {
            arr.add(getSquare().getX() - 1);
            arr.add(getSquare().getY() - 2);
        }
        else if(getSquare().getX() - 1 > -1 && getSquare().getY() - 2 > -1 && board[getSquare().getX() - 1][getSquare().getY() - 2].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() - 1);
            arr.add(getSquare().getY() - 2);
        }


        //left-down
        if(getSquare().getX() + 1 < 8 && getSquare().getY() - 2 > -1 && !board[getSquare().getX() + 1][getSquare().getY() - 2].isOccupied()) 
        {
            arr.add(getSquare().getX() + 1);
            arr.add(getSquare().getY() - 2);
        }
        else if(getSquare().getX() + 1 < 8 && getSquare().getY() - 2 > -1 && board[getSquare().getX() + 1][getSquare().getY() - 2].getPiece().getColor() != getColor())
        {
            arr.add(getSquare().getX() + 1);
            arr.add(getSquare().getY() - 2);
        }
        

        return arr;
    }
}