import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		String Name1= "", Name2 = "",  Chip1 = "", Chip2 = "";
		
		Functions a = new Functions();
		
		
		
		System.out.println("This is Score4 ");
		
		//EISAGWGH ONMOMATWN
		System.out.print("Please enter the name of the 1st player:");
	    Name1 = a.Names(Name1);
		System.out.print("Please enter the name of the 2nd player:");
		Name2 = a.Names(Name2);
		
		//EPILOGH CHIP
		boolean flag = true;
		while(flag)
		{
			
		    System.out.print( Name1 +", please select your chip:"  );
		    Chip1 = keyboard.nextLine();
		    if ( Chip1.equals("x") )
		    {
		       flag = false;
		       Chip2 = "o";
		    }
		    else if ( Chip1.equals("o"))
		    {
		    	flag = false;
		    	Chip2 = "x";
		    }
		    else
		    	 System.out.println("Not a valid chip ");
		       	       
		}
		System.out.println(Name2 + ", your chip is : "+ Chip2);
		
		
		int Rows = 0,Columns = 0;
		
		//ARITHMOS GRAMMWN	
		System.out.print("Please enter the number of rows:");
		Rows = a.Rows_Columns(Rows);
		
		//ARITHMOS STHLWN
		System.out.print("Please enter the number of columns:");
		Columns = a.Rows_Columns(Columns);
	   
       
		
		String [][] Board = new String [Rows][Columns];
		
		
	    
	    
	    //ARXIKOPOIHSH  PINAKA
	    for (int i = 0; i < Rows; i++)
		{
			for (int j = 0; j < Columns; j++)
				Board[i][j] = " -";
		}
	   
	    //EMFANISH ARXIKOU PINAKA
	    a.Display_Board(Rows, Columns, Board);
	    
	    int  Moves = Rows * Columns;
	    boolean Winner = false, Full = false;	
	    String Name = " ", Chip = " ";
	    
	    
	    //PARAGWGH TYXAIOY ARITHMOU METAXY 0-1
	    int max = 1, min = 0 ;
	    double value  = Math.random() * (max - min + 1) + min;
	    
	    //METATROPH DOUBLE SE INT
	    int Turn = (int)value;
	    
	    if (Turn == 0)
	    	Moves--;
	    
	    while(Winner == false && Turn <= Moves )
	    {
	    	do 
	    	{
	    	    //ENALLAGH SEIRAS
	    		if(Turn % 2 != 0)
	    		{
		    		Name = Name1;
	    		    Chip = Chip1;	    		    		
	    		}
		    	else 
		    	{
		    		Name  = Name2;
	    		    Chip = Chip2;
		    	}
	    		Turn++;	
	    		
	    	    System.out.print(Name + ", your turn. Select column:");
	    	    
	    	    boolean flag2  = true;
	    	    
	    	    int Play = keyboard.nextInt();
	    	    
	    	    //ELEGXOS GIA TO  AN YPARXEI AYTH H STHLH
	    	    while(flag2 )   	
	    	    {
	    	       if (Play >0 && Play <= Columns)
	    	       {   flag2 = false;
	    	           break;
	    	       }
	    	       else
	    	    	   System.out.print("This column doesn't exist. Please repeat the column:");
	    	       Play = keyboard.nextInt();       
	    	    }
	    	    
	    	    //ELEGXOS GIA TO AN EINAI GEMATH H STHLH
	    	    Full = a.FullBoard(Play-1, Board);
	    	    
	    	    if(Full == false)
	    	    {
	    	      System.out.print("The column is full. " + Name + " select a new  column:");
		    	  Play = keyboard.nextInt();
	    	    }
	    	   
	    	  
	    	   // RIJIMO TOU CHIP
	    	   for (int i = Board.length -1; i >= 0; i-- )
	    	   {
	    		
	    		 if(Board[i][Play-1] == " -")	
	    		 {
	        	     Board[i][Play-1] = Chip;	    		  	    			    		   
	    		     break;   
	    		 }
	    	  }
	    	  a.Display_Board(Rows, Columns, Board);
	    	}while(Full == false);
	    	
	    	
	    	Winner = a.is_Winner(Chip, Name, Board, Rows, Columns);
	    		
	    }
	    
	    if(Winner == false)
	    	System.out.print("GAME OVER. WE HAVE A DRAW");
		
	    
	    
	}	
}

