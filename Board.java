import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

public class Board extends JPanel implements MouseListener
{
    CheckmateDetector c;

    private int player = 0;

    private int x;
    private int y;

    private Image pw = new ImageIcon("pw.png").getImage();
    private Image pb = new ImageIcon("pb.png").getImage();
    private Image rw = new ImageIcon("rw.png").getImage();
    private Image rb = new ImageIcon("rb.png").getImage();
    private Image nw = new ImageIcon("nw.png").getImage();
    private Image nb = new ImageIcon("nb.png").getImage();
    private Image bw = new ImageIcon("bw.png").getImage();
    private Image bb = new ImageIcon("bb.png").getImage();
    private Image kw = new ImageIcon("kw.png").getImage();
    private Image kb = new ImageIcon("kb.png").getImage();
    private Image qw = new ImageIcon("qw.png").getImage();
    private Image qb = new ImageIcon("qb.png").getImage();

    private Square[][] board;

    private ArrayList<Piece> bp;
    private ArrayList<Piece> wp;

    private Piece piece;
    private Square square;

    private King kWhite;
    private King kBlack;

    private ArrayList<Integer> moves;

    public Board() 
    {
        setBoard();
        addMouseListener(this);
        setPreferredSize(new Dimension(600,600));
        c = new CheckmateDetector(this, wp, bp, kWhite, kBlack);
    }

    public King getW() 
    {
        return kWhite;
    }

    public King getB() 
    {
        return kBlack;
    }
    
    public int getP() 
    {
        return player;
    }

    public ArrayList<Piece> getWP() 
    {
        return wp;
    }

    public ArrayList<Piece> getBP() 
    {
        return bp;
    }

    private void setBoard() 
    {
        board = new Square[8][8];

        bp = new ArrayList<Piece>();
        wp = new ArrayList<Piece>();

        for(int i  = 0; i < board.length; i++) 
        {
            for(int z = 0; z < board.length; z++) 
            {
                board[i][z] = new Square(i,z,null);
            }
        }

        board[0][0].setPiece(new Rook(1,rb,board[0][0]));
        board[0][7].setPiece(new Rook(1,rb,board[0][7]));
        board[0][1].setPiece(new Knight(1,nb,board[0][1]));
        board[0][6].setPiece(new Knight(1,nb,board[0][6]));
        board[0][2].setPiece(new Bishop(1,bb,board[0][2]));
        board[0][5].setPiece(new Bishop(1,bb,board[0][5]));
        board[0][4].setPiece(new King(1,kb,board[0][4]));
        board[0][3].setPiece(new Queen(1,qb,board[0][3]));

        //bp.add(board[0][3].getPiece());

        kBlack = (King)board[0][4].getPiece();

        for(int i = 0; i < board.length; i++) 
        {
            bp.add(board[0][i].getPiece());
        }

        for(int i = 0; i < board.length; i++)
        {
            Pawn p = new Pawn(1,pb,board[1][i]);
            board[1][i].setPiece(p);
            bp.add(p);
        }

        board[7][0].setPiece(new Rook(0,rw,board[7][0]));
        board[7][7].setPiece(new Rook(0,rw,board[7][7]));
        board[7][1].setPiece(new Knight(0,nw,board[7][1]));
        board[7][6].setPiece(new Knight(0,nw,board[7][6]));
        board[7][2].setPiece(new Bishop(0,bw,board[7][2]));
        board[7][5].setPiece(new Bishop(0,bw,board[7][5]));
        board[7][4].setPiece(new King(0,kw,board[7][4]));
        board[7][3].setPiece(new Queen(0,qw,board[7][3]));

        kWhite = (King)board[7][4].getPiece();

        for(int i = 0; i < board.length; i++) 
        {
            wp.add(board[7][i].getPiece());
        }

        for(int i = 0; i < board.length; i++)
        {
            Pawn p = new Pawn(0,pw,board[6][i]);
            board[6][i].setPiece(p);
            wp.add(p);
        }
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        for (int i = 0; i < board.length; i++) 
        {
            for (int z = 0; z < board.length; z++) 
            {
                if (i % 2 == 0) 
                {
                    if (z % 2 == 0) 
                    {
                        g.setColor(Color.WHITE.darker());
                        board[i][z].paintComponent(g);
                    } 
                    else 
                    {
                        g.setColor(new Color(0, 128, 255));
                        board[i][z].paintComponent(g);          
                    }
                } 
                else 
                {
                    if (z % 2 == 0) 
                    {
                        g.setColor(new Color(0, 128, 255));
                        board[i][z].paintComponent(g);
                    } 
                    else 
                    {
                        g.setColor(Color.WHITE.darker());
                        board[i][z].paintComponent(g);
                    }
                }
            }
        }

        if(x != 0 && y != 0)
        {
            g.setColor(Color.BLACK);
            g.fillRect(x / 75 * 75, y / 75 * 75, 75, 75);
            g.setColor(Color.RED);
            g.fillRect(x / 75 * 75 + 5, y / 75 * 75 + 5, 65, 65);
        }

        if(moves != null) 
        {
            for(int i = 0; i < moves.size(); i += 2) 
            {
                g.setColor(Color.BLACK);
                g.fillRect(moves.get(i + 1) * 75, moves.get(i) * 75, 75, 75);
                g.setColor(Color.RED);
                g.fillRect(moves.get(i + 1) * 75 + 5, moves.get(i) * 75 + 5, 65, 65);
            }
        }

        for(int i = 0; i < bp.size(); i++) 
        {
            bp.get(i).drawImage(g);
        }

        for(int i = 0; i < wp.size(); i++) 
        {
            wp.get(i).drawImage(g);
        }
    }

    public Square[][] getBoard() 
    {
        return board;
    }

    public void mouseClicked(MouseEvent e) 
    {

    }

    public void mousePressed(MouseEvent e) 
    {
        x = e.getX();
        y = e.getY();
        square = ((Board)getComponentAt(x, y)).getBoard()[y / 75][x / 75];
        if(player == 0) 
        {
            if(square.getPiece() != null && square.getPiece().getColor() == 0) 
            {
                piece = square.getPiece();
                moves = c.legalMoves(piece);
                repaint();
            }
        }
        else 
        {
            if(square.getPiece() != null && square.getPiece().getColor() == 1) 
            {
                piece = square.getPiece();
                moves = c.legalMoves(piece);
                repaint();
            }
        }
    }

    public void mouseEntered(MouseEvent e) 
    {
        
    }

    public void mouseExited(MouseEvent e) 
    {
       
    }
    
    public void mouseReleased(MouseEvent e) 
    {
        x = e.getX();
        y = e.getY();
        Square s = ((Board)getComponentAt(x, y)).getBoard()[y / 75][x / 75];
        if(piece != null && moves != null) 
        {
            for(int i = 0; i < moves.size(); i += 2) 
            {
                if(s.getX() == moves.get(i) && s.getY() == moves.get(i + 1)) 
                {
                    if(board[s.getX()][s.getY()].isOccupied()) 
                    {
                        if(s.getPiece().getColor() == 0) 
                        {
                            wp.remove(board[s.getX()][s.getY()].getPiece());
                        }
                        else
                        {
                            bp.remove(board[s.getX()][s.getY()].getPiece());
                        }
                    }
                    if(square != s) 
                    {
                        s.setPiece(piece);
                        piece.setSquare(s);
                        square.setPiece(null);
                        if(player == 0) 
                        {
                            player++;
                        }
                        else 
                        {
                            player--;
                        }
                        break;
                    }
                        
                }   
            }
        }
        c.whiteCheckmate();
        c.blackCheckmate();
        x = 0;
        y = 0;
        piece = null;
        moves = null;
        repaint();
    }
}