package Stuff;

//contains the model of the crossword puzzle
public class Maze {
	
	//The crossword grid
	private boolean blackSquares[][] = {
			{false, false, false, true, false, false, false, false, false, false}, 
			{false, true, false, true, false, false, false, false, true, false}, 
			{false, true, false, true, false, false, true, true, true, true}, 
			{true, true, true, true, false, true, false, false, true, false}, 
			{false, true, false, true, false, true, false, false, true, false}, 
			{true, true, true, true, true, true, true, true, true, false}, 
			{false, true, false, true, false, true, false, true, false, false}, 
			{false, true, false, false, false, false, false, true, false, false}, 
			{false, true, false, true, true, true, true, true, true, true}, 
			{false, true, false, false, false, false, false, false, false, false} 
	};
	
	//returns true if blackSquares[r][c] should be labeled with a number as it is the start of a word
	private boolean toBeLabeled (int r,int c){
			return((blackSquares[r][c])&&(r==0||c==0||((!blackSquares[r-1][c])&&(blackSquares[r+1][c]))||((!blackSquares[r-1][c])&&(!blackSquares[r][c-1]))));
	}
	
	//returns a 2D string array representing the squares of the crossword board
	public String[][] Crossword(){
		int x = 1;
		String[][] Map= new String[10][10];
		for(int i = 0; i<blackSquares.length; i++){
			for(int j = 0; j < blackSquares.length; j++){
				String xx = new String("");
				xx+=x;
				if(toBeLabeled(i,j)){
					Map[i][j] = xx + "     ";
					x++;
				}
				else if(blackSquares[i][j]){
					Map[i][j] = "O     ";
				}
				else{
					Map[i][j] = "X     ";
				}
			}
		}
		return Map;
	}
	
	//returns a printable string visually representing the board.
	public String CrossString(){
			String blank = new String("");
			for(int i = 0; i<10; i++){
				for(int j = 0; j < 10; j++){
					blank += Crossword()[i][j];
				}
				blank += "\n";
			}
			return blank;
	}
	
	//constructs the object and calls the Crossword() method.
	public Maze(){
		Crossword();
	}
}
