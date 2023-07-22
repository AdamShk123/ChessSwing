import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CheckmateDetector 
{
    private Board b;

    private ArrayList<Piece> wp;
    private ArrayList<Piece> bp;

    private King kWhite;
    private King kBlack;

    public CheckmateDetector(Board b, ArrayList<Piece> wp, ArrayList<Piece> bp, King kWhite, King kBlack) 
    {
        this.b = b;
        this.wp = wp;
        this.bp = bp;
        this.kWhite = kWhite;
        this.kBlack = kBlack;
    }

    public ArrayList<Piece> whiteCheck() 
    {
        ArrayList<Piece> threats = new ArrayList<Piece>();

        int x = kWhite.getSquare().getX();
        int y = kWhite.getSquare().getY();

        for(int i = 0; i < bp.size(); i++) 
        {
            ArrayList<Integer> moves = bp.get(i).getPossibleMoves(b);
            for(int z = 0; z < moves.size(); z += 2) 
            {
                if(x == moves.get(z) && y == moves.get(z + 1)) 
                {
                    threats.add(bp.get(i));
                }
            }
        }

        return threats;

    }

    public ArrayList<Piece> blackCheck() 
    {
        ArrayList<Piece> threats = new ArrayList<Piece>();

        int x = kBlack.getSquare().getX();
        int y = kBlack.getSquare().getY();

        for(int i = 0; i < wp.size(); i++) 
        {
            ArrayList<Integer> moves = wp.get(i).getPossibleMoves(b);
            for(int z = 0; z < moves.size(); z += 2) 
            {
                if(x == moves.get(z) && y == moves.get(z + 1)) 
                {
                    threats.add(wp.get(i));
                    break;
                }
            }
        }

        return threats;

    }

    public boolean whiteCheckmate() 
    {
        ArrayList<Integer> total = new ArrayList<Integer>();
        for(int i = 0; i < wp.size(); i++) 
        {
            total.addAll(legalMoves(wp.get(i)));
        }

        if(whiteCheck().size() > 0 && total.size() == 0)
        {
            System.out.println("Checkmate! White Lost.");
            System.exit(0);
            return true;
        }
        return false;
    }

    public boolean blackCheckmate() 
    {
        ArrayList<Integer> total = new ArrayList<Integer>();
        for(int i = 0; i < wp.size(); i++) 
        {
            total.addAll(legalMoves(wp.get(i)));
        }
        
        if(blackCheck().size() > 0 && total.size() == 0)
        {
            System.out.println("Checkmate! Black Lost.");
            System.exit(0);
            return true;
        }
        return false;
    }

    public ArrayList<Integer> legalMoves(Piece p) 
    {
        ArrayList<Integer> a = null;
        if(p instanceof Pawn) 
        {
            a = p.getPossibleMoves(b);
        }
        else 
        {
            a = p.getPossibleMoves(b);
        }
        if(a.size() > 0) 
        {
            int x = p.getSquare().getX();
            int y = p.getSquare().getY();
            b.getBoard()[x][y].setPiece(null);
            for(int i = 0; i < a.size(); i += 2) 
            {
                int c = a.get(i);
                int d = a.get(i + 1);
                if(b.getBoard()[c][d].isOccupied()) 
                {
                    continue;
                }
                else 
                {
                    b.getBoard()[c][d].setPiece(p);
                    p.setSquare(b.getBoard()[c][d]);
                    if(b.getP() % 2 == 0) 
                    {
                        if(whiteCheck().size() > 0) 
                        {
                            a.remove(i);
                            a.remove(i);
                            i -= 2;
                        }
                    }
                    else 
                    {
                        if(blackCheck().size() > 0) 
                        {
                            a.remove(i);
                            a.remove(i);
                            i -= 2;
                        }   
                    }
                    b.getBoard()[c][d].setPiece(null);
                }
            }
            b.getBoard()[x][y].setPiece(p);
            p.setSquare(b.getBoard()[x][y]);
        }
        return a;
    }
}