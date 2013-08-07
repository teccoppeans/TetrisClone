
public class GameGrid {

	final int ROWS = 22;
	final int COLUMNS = 10;
	
	protected Game game;
	
	private Block nullBlock = new Block("black");
	private Cell[][] grid;
	
	public GameGrid(Game game) {
		this.game = game;
		grid = new Cell[ROWS][COLUMNS];
		for (int i = 0; i < ROWS ; ++i)
			for (int j = 0; j < COLUMNS; j++)
				grid[i][j] = new Cell();
		
	}

	public Cell[][] getGrid() {
		return grid;
	}

	public void draw() {
		for (int i = ROWS - 1; i > 1; --i) {
			for (int j = 0; j < COLUMNS; j++) {
				if (grid[i][j].getBlock() != null)
					//draw the block
					grid[i][j].getBlock().getImage().draw(j * game.getColumnWidth(), 
							(i - 2) * game.getRowHeight());
				else
					//draw null block
					nullBlock.getImage().draw(j * game.getColumnWidth(), 
							(i - 2) * game.getRowHeight());
			}
		}
	}
	
	public void embedShape(Shape shape) {
		int startY = shape.getY();
		int startX = shape.getX();
		
		for (int y = 0; y < 4; ++y) {
			for (int x = 0; x < 4; ++x) {
				if (shape.getBlocks()[y][x] != null) {
					grid[y + startY][x + startX].setBlock(shape.getBlocks()[y][x]);
				}
			}
		}
	}
	
	//returns lines to be cleared
	public int[] linesToClear() {
		int lines[] = new int[4];
		int index = 0;
		for (int i = 2; i < ROWS; ++i) {
			boolean clearLine = true;
			for (int j = 0; j < COLUMNS; ++j) {
				if (grid[i][j].isEmpty())
					clearLine = false;
			}
			if (clearLine) {
				lines[index] = i;
				++index;
			}
		}
		return lines;
	}
	
	//precondition: lines contains line numbers to be cleared in ascending order
	public int clearLines(int[] lines) {
		int cleared = 0;
		for (int i = 0; i < 4; ++i) {
			if (lines[i] != 0) {
				clearAndShiftLines(lines[i]);
				++cleared;
			}
		}
		return cleared;
	}
	
	//shifts blocks above lineIndex down one
	public void clearAndShiftLines(int lineIndex) {
		for (int i = lineIndex; i > 0; --i) {
			for (int j = 0; j < COLUMNS; j++) {
					grid[i][j].setBlock(grid[i - 1][j].getBlock());
			}
		}
	}


	
	public boolean isLose() {
		//check rows 0 and 1 for blocks
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < COLUMNS; ++j) {
				if (!grid[i][j].isEmpty())
					return true;
			}
		}
		
		return false;
	}
}
