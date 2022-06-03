package Stuff;

import javax.swing.JOptionPane;

//displays and accepts input for the game
public class Viewcon {
	private Maze mayz = new Maze();
	private String namez = new String("namez");
	private int triez = 0;
	private String blankz = mayz.CrossString();
	private String[] wordz = new String[]{"Gaggles", "Guarantee", "Bible", "Grip", "Gang", "Holy", "Satellite", "Tram", "Minimum"};
	private boolean[] solvz = {false, false, false, false, false, false, false, false, false, true};
	private String[] hintz = new String[]{"Multiple flocks of geese", "An assurance often promising 'or your money back'", "Often preceded by 'Holy' or 'King James'", "To crush an apple in your palm requires this strength of the hand", "Comes after 'street' or before 'violence'", "Often comes before impure words, ironic given that it means the opposite", "Orbits a planet, or gives you XM radio", "A streetcar or trolley", "in Java, its -2e+31; the opposite of maximum" }; 
	
	//displays the crossword puzzle and accepts input to display a hint for a number
	private int C(){
		while(true){
			String c = JOptionPane.showInputDialog(blankz + "\n" + "Select a number:" + "\n");
			if(Integer.valueOf(c)>=1 && Integer.valueOf(c)<=9){
				return Integer.valueOf(c);
			}
		}
	}
	
	//displays a hint and accepts a guess, unless the debug name is used.
	private void solvzed(){
		int cc = C();
		String mezzage = new String("The word is:");
		if(namez.equalsIgnoreCase("rico")){
			mezzage = "The answer is " + wordz[cc-1];
			triez=0;
		}
		String s = JOptionPane.showInputDialog(hintz[cc-1] + "\n" + mezzage + "\n");
			if (s.equalsIgnoreCase(wordz[cc-1])){
				solvz[cc-1] = true;
				JOptionPane.showMessageDialog(null, "Correct!");
			}
			else if(s.equalsIgnoreCase("rico")){
				namez="rico";
				JOptionPane.showMessageDialog(null, "Hello Rico!");
			}
			else{
				triez++;
				String z = new String("Incorrect! You have ");
				z+= 6-triez;
				z+=" tries left";
				JOptionPane.showMessageDialog(null, z);
			}
	}
	
	//runs the gameloop while the player has taken less than 6 tries.
	public void blankzUpdate(){
		while(true){
			solvzed();
			boolean winz = true;
			blankz = "";
			for(int i = 0; i<10; i++){
				for(int j = 0; j < 10; j++){
					blankz += mayz.Crossword()[i][j];
				}
				blankz += "\n";
				if(!solvz[i]){
					winz=false;
				}
			}
			if(triez>5){
				JOptionPane.showMessageDialog(null, "You lose!");
				break;
			}
			else if(winz){
				JOptionPane.showMessageDialog(null, "You win!");
				break;
			}
		}
	}
	
	//creates the controller and starts the game loop
	public Viewcon(){
		blankzUpdate();
	}
}
