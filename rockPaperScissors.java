/******************************************************************************
 *  Compilation:  javac rockPaperScissors.java
 *  Execution:    java rockPaperScissors
 *
 *  Plays Rock Paper Scissors
 *
 *  User Story:
 *
 *  Title: Waste an Hour Having Fun   
 *  As a frequent games player, I'd like to play rock, paper, scissors
 *  so that I can spend an hour of my day having fun.
 * 
 *  Acceptance Criteria:
 *    - Can I play Player vs Computer?
 *    - Can I play Computer vs Computer?  
 *    - Can I play a different game each time?  
 *
 ******************************************************************************/

import java.io.*;
import java.util.Scanner;

class rockPaperScissors
{
	public static void main (String args[])
	{
		 String weapon[] = {"paper", "rock", "scissors"};
		 int resultat[] = {0, 2, 1};

		 String gamingMode[] = {"Player vs Computer", "Computer vs Computer"};
		 
		 int playerScore = 0;
		 int computerScore = 0;

		 // game mode menu displayed
		 // user is asked to select one mode
		 System.out.println("\tSelect the game mode:");
		 for (int cpt1=0;cpt1<2;cpt1++){
		 	System.out.println("\t"+cpt1 + ") " + gamingMode[cpt1]);
		 }

		 // we test the value of the user input
		 // if it differs from gamingMode array we prompt the user to re-enter proper value
		 int modeChoice = -1;
		 do{ 
		 	try{modeChoice = (new InputStreamReader(System.in)).read() - 48;}
		 		catch(IOException ioe){
		   			ioe.printStackTrace();
		   			System.exit(0);
		 			}
		 	if (modeChoice<0 || modeChoice>=2){System.out.println("\tYour choice for the game mode is wrong!!! \r\n\tPlease enter a correct value.");}
		 }while(modeChoice<0 || modeChoice>=2);

		 // the user plays against the computer
		 if ( modeChoice==0 ) 
		 {
		 	boolean play = true;

		 	do{
		 		Scanner input = new Scanner(System.in);
		 		String cont="y";

				 	System.out.println("\tPlayer vs Computer");
				 	System.out.println("\r\n\t\tSelect now your weapon :");
				 	
				 	for (int cpt2=0;cpt2<3;cpt2++){
				 		System.out.println("\t\t"+ cpt2 + ") " + weapon[cpt2]);
				 		}

				 	// the user choose the weapon
				 	// we test the value of the user input
				 	// if it differs from the weapons array we prompt the user to re-enter proper value
				 	int playerChoice = -1;
				 	do{ 
				 		try{playerChoice = (new InputStreamReader(System.in)).read() - 48;}
				 			catch(IOException ioe){
				   				ioe.printStackTrace();
				   				System.exit(0);
				 			}
				 		if (playerChoice<0 || playerChoice>2){System.out.println("\t\tYour choice for the weapon is wrong!!! \r\n\t\tPlease enter a correct value." );}
				 		else {System.out.println("\t\tYour choice is : " + weapon[playerChoice] );}
				 	}while(playerChoice<0 || playerChoice>2);

					// here is the computer choice for the weapon
				 	// random value generation within a range
					 int computerChoice = (int)(Math.random()*3);
					 System.out.println("\t\tComputer's choice is : " + weapon[computerChoice]);
					 
					 int cpt3 = playerChoice + computerChoice -1;
					 
					 if ((cpt3>=0) && (cpt3<=2) && (playerChoice != computerChoice))
					 {
						 if (playerChoice == resultat[cpt3]) 
						 {
						 	playerScore = playerScore+1;
						 	System.out.println("\t\tPlayer wins!!!" );
						 } else {
						 	computerScore = computerScore+1;
						 	System.out.println("\t\tComputer wins!!!" );
						 }
					}

					 if ( playerChoice == computerChoice )
					 { 
					 		playerScore = playerScore+1;
					 		computerScore = computerScore+1;
					 		System.out.println("\t\tIt's a draw!!!\r\n" );
					 }

					 System.out.println("\t\tGame Score : " + "Player " + "[" + playerScore + "]" + " - [" + computerScore + "]" + " Computer ");


					// now the user is prompted to continue or to end the game
					System.out.println("\r\n\t\tDo you wish to continue? (y/n) ");
					cont = input.next();

					if(cont.equalsIgnoreCase("n"))
					{
					    System.out.println("\r\n\t\tThat's all folks.");
					    System.out.println("\t\tFinal Score : " + "Player " + "[" + playerScore + "]" + " - [" + computerScore + "]" + " Computer ");
					    System.out.println();
					    play=false;
					}else if (cont.equalsIgnoreCase("y"))
					{
						play=true;
					}
					else 
					{	
						do
						{
						    System.out.println("\r\n\t\tInvalid option.");
						    System.out.println("\t\tEnter valid option: (y/n)");
						    cont = input.next();

							if(cont.equalsIgnoreCase("n"))
							{
							    System.out.println("\r\n\t\tThat's all folks.");
							    System.out.println("\t\tFinal Score : " + "Player " + "[" + playerScore + "]" + " - [" + computerScore + "]" + " Computer ");
							    System.out.println();
							    play=false;
							}

						}while( (!cont.equalsIgnoreCase("n")) && (!cont.equalsIgnoreCase("y")) );

					}
						
			}while(play == true);

		// the user decides to play a game between 2 computers
		// he decides then when to stop the game
		// auto-generation of weapon choice for both computers
		}else if ( modeChoice==1 ) 
		{
			int computer1Score = 0;
			int computer2Score = 0;
			boolean playagain = true;

		 	do{
		 		Scanner inputagain = new Scanner(System.in);
		 		String contagain="y";

				System.out.println("\t\tComputer vs Computer");

				 // computer 1 choice
				 int computer1Choice = (int)(Math.random()*3);
				 System.out.println("\r\n\t\tComputer1's choice is : " + weapon[computer1Choice]);
				 
				 // computer 2 choice
				 int computer2Choice = (int)(Math.random()*3);
				 System.out.println("\t\tComputer2's choice is : " + weapon[computer2Choice]);
				 
				 int cpt4 = computer1Choice + computer2Choice -1;
				 
				if ((cpt4>=0) && (cpt4<=2) && (computer1Choice != computer2Choice))
				{					 
					if (computer2Choice == resultat[cpt4]) 
					{
						computer2Score = computer2Score+1;
					 	System.out.println("\t\tComputer2 wins!!!" );
					}else 
					{
					 	computer1Score = computer1Score+1;
					 	System.out.println("\t\tComputer1 wins!!!" );
					}
				}

				 if ( computer1Choice == computer2Choice )
				 {
				 		computer1Score = computer1Score+1;
				 		computer2Score = computer2Score+1;
				 		System.out.println("\r\n\t\tIt's a draw!!!" );
				 }

				 System.out.println("\r\n\t\tGame Score : " + "Computer1 " + "[" + computer1Score + "]" + " - [" + computer2Score + "]" + " Computer2 ");


				System.out.println("\r\n\t\tDo you wish to continue? (y/n) ");
				contagain = inputagain.next();
				if(contagain.equalsIgnoreCase("n"))
				{
				    System.out.println("\r\n\t\tThat's all folks.");
				    System.out.println("\r\n\t\tFinal Score : " + "Computer1 " + "[" + computer1Score + "]" + " - [" + computer2Score + "]" + " Computer2 ");
				    System.out.println();
				    playagain=false;
				}else if (contagain.equalsIgnoreCase("y"))
				{
					playagain=true;
				}
				else 
				{	
					do
					{
					    System.out.println("\r\n\t\tInvalid option.");
					    System.out.println("\t\tEnter valid option: (y/n)");
					    contagain = inputagain.next();
						if(contagain.equalsIgnoreCase("n"))
						{
						    System.out.println("\r\n\t\tThat's all folks.");
						    System.out.println("\r\n\t\tFinal Score : " + "Computer1 " + "[" + computer1Score + "]" + " - [" + computer2Score + "]" + " Computer2 ");
						    System.out.println();
						    playagain=false;
						}
					}while( (!contagain.equalsIgnoreCase("n")) && (!contagain.equalsIgnoreCase("y")) );
				}

			}while(playagain == true);
		}

	} // end main

} // end class
