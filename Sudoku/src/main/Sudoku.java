package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Sudoku 
{
	private static ArrayList<Cell> cells = new ArrayList<Cell>();
	private static int REMOVE_CELL_NUM = 7;
	private static int SIZE = 4;
	
	public Sudoku()
	{
	}
	
	public static void main (String[] args)
	{
		initCells();
		generaliseCompleteBoard();
		generaliseSudoku();
		printSudoku();		
	} 
	
	/*
	 * initialise cells with 0, assign row id, column id and block id to each cell
	 */
	public static void initCells()
	{
		outer: for (int rowID = 0, colID = 0; ; colID++)
		{
			int blockID = 0;
			
			if (colID == SIZE)
			{
				rowID++;
				if (rowID == SIZE)
					break outer;
				colID = 0;
			}
			
			if ((rowID == 0 || rowID == 1) && (colID == 2 || colID == 3))
				blockID = 1;
			if ((rowID == 2 || rowID == 3) && (colID == 0 || colID == 1))
				blockID = 2;
			if ((rowID == 2 || rowID == 3) && (colID == 2 || colID == 3))
				blockID = 3;
			
			Cell c = new Cell(0, rowID, colID, blockID, (rowID * SIZE) + colID);
			cells.add(c);
		}		
	}
	
	/*
	 * generate a complete sudoku board
	 */
	public static void generaliseCompleteBoard()
	{
		//initArray contains: 1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4
		ArrayList<Integer> intArray = new ArrayList<Integer>();		
		int count = 0;
		for (int i = 1; i <= SIZE;)
		{
			intArray.add(i);
			count++;
			if (count == SIZE)
			{
				i++;
				count = 0;
			}
		}
		
		// shuffle the initArray till it meets the requirements of the sudoku game
		outer: while (true)
		{
			Collections.shuffle(intArray);
			
			for (int i = 0; i < SIZE * SIZE; i++)
			{
				Cell c = cells.get(i);
				c.setValue(intArray.get(i)); 
			}

			for (int i = 1; i <= 4; i++)
			{
				if (Cell.isDuplicatedID(Cell.getCellByValue(cells, i)))
					continue outer;			
			}
			
			break;
		}
		
	}
	
	/*
	 * randomly assign 0 to 7 cells to generate the sudoku game
	 */
	public static void generaliseSudoku()
	{
		Random random = new Random();
		
		for  (int i = 0; i < REMOVE_CELL_NUM;)
		{
			int num = random.nextInt(SIZE*SIZE) + 1;		
			for (Cell c : cells)
			{
				if (c.getCellID() == num && c.getValue() != 0)
				{
					c.setValue(0);
					i++;
					break;
				}
			}
		}		
	}
	
	/*
	 * print out the sudoku game
	 */
	public static void printSudoku()
	{
		for (int row = 0; row < SIZE; row++)
		{			
			for (Cell c : Cell.getCellByRowID(row, cells))
				System.out.print(c.getValue() + " ");
			System.out.println();
		}		
	}
}

