package main;

import java.util.ArrayList;

public class Cell 
{
	private int value;
	private int rowID;
	private int colID;
	private int blockID;
	private int cellID;
	
	public Cell()
	{
	}

	public Cell(int v, int rID, int cID, int blkID, int cellID)
	{
		this.value = v;
		this.rowID = rID;
		this.colID = cID;
		this.blockID = blkID;
		this.cellID = cellID;
	}
	
	public void setValue(int v)
	{
		this.value = v;
	}
	public int getValue()
	{
		return this.value;
	}
	
	public void setRowID(int rID)
	{
		this.rowID = rID;
	}
	public int getRowID()
	{
		return this.rowID;
	}
	
	public void setColID(int cID)
	{
		this.colID = cID;
	}
	public int getColID()
	{
		return this.colID;
	}
	
	public void setBlkID(int blkID)
	{
		this.blockID = blkID;
	}
	public int getBlockID()
	{
		return this.blockID;
	}

	public void setCellID(int cID)
	{
		this.cellID = cID;
	}
	public int getCellID()
	{
		return this.cellID;
	}
	
	public static ArrayList<Cell> getCellByRowID(int rowID, ArrayList<Cell> cells)
	{
		ArrayList<Cell> result = new ArrayList<Cell>();
		
		for (Cell c : cells)
		{
			if (c.getRowID() == rowID)
				result.add(c);
		}
		return result;
	}	
	
	public static ArrayList<Cell> getCellByColID(int colID, ArrayList<Cell> cells)
	{
		ArrayList<Cell> result = new ArrayList<Cell>();
		
		for (Cell c : cells)
		{
			if (c.getColID() == colID)
				result.add(c);
		}
		return result;
	}
	
	public static ArrayList<Cell> getCellByBlockID(int blkID, ArrayList<Cell> cells)
	{
		ArrayList<Cell> result = new ArrayList<Cell>();
		
		for (Cell c : cells)
		{
			if (c.getBlockID() == blkID)
				result.add(c);
		}
		return result;
	}
	
	public static ArrayList<Integer> getCellValue(ArrayList<Cell> cells)
	{
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		for (Cell c : cells)
		{
			values.add(c.getValue());
		}
		return values;
	}
	
	public static ArrayList<Cell> getCellByValue(ArrayList<Cell> cells, int value)
	{
		ArrayList<Cell> result = new ArrayList<Cell>();
		for (Cell c : cells)
		{
			if (c.getValue() == value)
				result.add(c);
		}
		return result;		
	}
	
	public static boolean isDuplicatedID(ArrayList<Cell> cells)
	{
		ArrayList<Integer> rowIDs = new ArrayList<Integer>();
		ArrayList<Integer> colIDs = new ArrayList<Integer>();
		ArrayList<Integer> blockIDs = new ArrayList<Integer>();
		
		for (Cell c : cells)
		{
			if (rowIDs.contains(c.getRowID()))
				return true;
			rowIDs.add(c.getRowID());
			
			if (colIDs.contains(c.getColID()))
				return true;
			colIDs.add(c.getColID());
			
			if (blockIDs.contains(c.getBlockID()))
				return true;
			blockIDs.add(c.getBlockID());
		}
		return false;
	}
}
