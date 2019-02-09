package KnightsTour;
import java.util.Scanner;
public class KnightsTour{
    static int[][] chessboard;
    static int size = 4;
    static int[][] moves = {{1,2},{2,1},{-1,-2},{-2,-1},
                            {-1,2},{-2,1},{1,-2},{2,-1}};

    public static void set_chessboard(){
        int i,j;
        chessboard = new int[size][size];
        for(i=size-1;i>=0;i--){
            for(j=size-1;j>=0;j--){
                chessboard[i][j] = -1;
            }
        }
    }
    
    public static void print_chessboard(){
        int i,j;
        System.out.println("Chess Board:");
        for(i=0;i<size;i++){
            for(j=0;j<size;j++){
                System.out.print(""+chessboard[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static boolean move_knight(int x, int y, int step, int[][] chessboard){
        chessboard[y][x] = step;
        print_chessboard();
        if(Math.pow(size, 2) == step){
            return true;
        }
        int next_x,next_y;
        for(int i=moves.length; i>0; i--){
            next_x = x+moves[i-1][0];
            next_y = y+moves[i-1][1];
            if((0<=next_x)&&(next_x<=size-1)&&
                    (0<=next_y)&&(next_y<=size-1)&&
                    (chessboard[next_y][next_x] == -1)&&
                    move_knight(next_x,next_y,step+1,chessboard)){
                    return true;
            }
        }
        chessboard[y][x] = -1;
        print_chessboard();
        return false;
    }
    
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
    	size = scan.nextInt();
        set_chessboard();
        scan.close();
        if(!move_knight(0, 0, 1, chessboard)){
            System.out.println("No Path Found from Here");
        }else{
            print_chessboard();
        }
    }
}