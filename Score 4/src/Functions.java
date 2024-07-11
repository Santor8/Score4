import java.util.Scanner;

public class Functions {
	
	public  String  Names(String Name)
	{
		Scanner keyboard = new Scanner(System.in);
		
		boolean flag =true;
				
		while(flag) 
		{
			
		    Name = keyboard.nextLine();
		    if ( Name.length() == 0)
			    System.out.println("Incorrect input, Please repeat the name of the player:");
		    else
			    flag = false;
		
		}
		
		return Name;	
	}
	
	
	public  int Rows_Columns(int Num) 
	{
		Scanner keyboard = new Scanner(System.in);
		
        boolean flag = true;
        
		while(flag)
		{
			Num = keyboard.nextInt();
			if(Num >= 4 && Num <= 15)
				flag = false;
			else 
				System.out.print("Incorrect input. Please repeat the number:");
		}
		
		return Num;

	
	}
	
	public void Display_Board(int Rows , int Columns,String  Board[][])
	{
		
		for ( int i = 0; i < Rows; i++)
	    {
			System.out.print("|");
	        for ( int j = 0; j <Columns ; j++)        
	            System.out.printf("%2s ", Board[i][j]);
	        
	        System.out.print(" |");
	        System.out.println();
	    }
		
		
		for (int i = 0; i < Columns+1; i++)
			System.out.print("---");
		
		
		System.out.println();
		for (int i = 0; i < Columns; i++)
		{
			
			System.out.printf("%3s",i+1);
		}
		System.out.println();
	}
	
	public boolean FullBoard(int Col, String [][] Board)
	{
		if(Board[0][Col] != " -" )
			return false;
		
		return true;
	}
	
	public boolean is_Winner(String Chip, String Name, String[][] Board, int Rows, int Columns)
	{
		//ORIZONTIA NIKH
		for(int i = 0; i < Rows; i++){
			for (int j = 0;j < Columns - 3;j++){
				if (Board[i][j] == Chip  && 
					Board[i][j+1] == Chip &&
					Board[i][j+2] == Chip  &&
					Board[i][j+3] == Chip){		
					System.out.print("GAME OVER. THE WINNER IS "+ Name);
					return true;
				}
			}			
		}
		
		//KA8ETH NIKH
		for(int i = 0; i < Rows - 3; i++){
			for(int j = 0; j < Columns; j++){
				if (Board[i][j] == Chip   && 
					Board[i+1][j] == Chip &&
					Board[i+2][j] == Chip &&
					Board[i+3][j] == Chip){
					System.out.print("GAME OVER. THE WINNER IS "+ Name);
					return true;
				}
			}
		}
		
		//DIAGWNIA-PANW NIKH
		for(int i = 3; i < Rows; i++){
			for(int j = 0; j < Columns - 3; j++){
				if (Board[i][j] == Chip   && 
					Board[i-1][j+1] == Chip &&
					Board[i-2][j+2] == Chip &&
					Board[i-3][j+3] == Chip){
					System.out.print("GAME OVER. THE WINNER IS "+ Name);
					return true;
				}
			}
		}
		
		//DIAGWNIA-KATW NIKH
		for(int i = 0; i < Rows - 3; i++){
			for(int j = 0; j < Columns - 3; j++){
				if (Board[i][j] == Chip   && 
					Board[i+1][j+1] == Chip &&
					Board[i+2][j+2] == Chip &&
					Board[i+3][j+3] == Chip){
					System.out.print("GAME OVER. THE WINNER IS "+ Name);
					return true;
				}
			}
		}
		
		return false;
		
	}


	
}
