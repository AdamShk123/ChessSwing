import java.awt.Image;
import java.util.ArrayList;

public class Queen extends Piece 
{
    public Queen(int c, Image i, Square s) 
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

        //up-right
        for(int i = getSquare().getX() - 1; i > -1; i--) 
        {
            if(getSquare().getY() + (getSquare().getX() - i) < 8 && !board[i][getSquare().getY() + (getSquare().getX() - i)].isOccupied()) 
            {
                arr.add(i);
                arr.add(getSquare().getY() + (getSquare().getX() - i));
            }
            else if(getSquare().getY() + (getSquare().getX() - i) < 8 && board[i][getSquare().getY() + (getSquare().getX() - i)].getPiece().getColor() != getColor()) 
            {
                arr.add(i);
                arr.add(getSquare().getY() + (getSquare().getX() - i));
                break;
            }
            else
            {
                break;
            }
        }

        //up-left
        for(int i = getSquare().getX() - 1; i > -1; i--) 
        {
            if(getSquare().getY() - (getSquare().getX() - i) > -1 && !board[i][getSquare().getY() - (getSquare().getX() - i)].isOccupied()) 
            {
                arr.add(i);
                arr.add(getSquare().getY() - (getSquare().getX() - i));
            }
            else if(getSquare().getY() - (getSquare().getX() - i) > -1 && board[i][getSquare().getY() - (getSquare().getX() - i)].getPiece().getColor() != getColor()) 
            {
                arr.add(i);
                arr.add(getSquare().getY() - (getSquare().getX() - i));
                break;
            }
            else 
            {
                break;
            }
        }

        //down-right
        for(int i = getSquare().getX() + 1; i < 8; i++) 
        {
            if(getSquare().getY() + (i - getSquare().getX()) < 8 && !board[i][getSquare().getY() + (i - getSquare().getX())].isOccupied()) 
            {
                arr.add(i);
                arr.add(getSquare().getY() + (i - getSquare().getX()));
            }
            else if(getSquare().getY() + (i - getSquare().getX()) < 8 && board[i][getSquare().getY() + (i - getSquare().getX())].getPiece().getColor() != getColor()) 
            {
                arr.add(i);
                arr.add(getSquare().getY() + (i - getSquare().getX()));
                break;
            }
            else 
            {
                break;
            }
        }

        // down-left
        for(int i = getSquare().getX() + 1; i < 8; i++) 
        {
            if(getSquare().getY() - (i - getSquare().getX()) > -1 && !board[i][getSquare().getY() - (i - getSquare().getX())].isOccupied()) 
            {
                arr.add(i);
                arr.add(getSquare().getY() - (i - getSquare().getX()));
            }
            else if(getSquare().getY() - (i - getSquare().getX()) > -1 && board[i][getSquare().getY() - (i - getSquare().getX())].getPiece().getColor() != getColor()) 
            {
                arr.add(i);
                arr.add(getSquare().getY() - (i - getSquare().getX()));
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