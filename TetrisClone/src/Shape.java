import java.util.Random;

import LinkedQueue.LinkedQueue;





public abstract class Shape {

	protected Block[][] blocks;
	protected int x;
	protected int y;
	protected int rotation;
	protected String color;
	protected static Game game;
	
	public Block[][] getBlocks() {
		return blocks;
	}

	public void setBlocks(Block[][] blocks) {
		this.blocks = blocks;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	
	public static Game getGame() {
		return game;
	}

	public static void setGame(Game game) {
		Shape.game = game;
	}

	public void draw() {
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; j++) {
				if (blocks[i][j] != null)
					if (y + i > 1)
					//draw the block
						blocks[i][j].getImage().draw((x + j) * game.getColumnWidth(), 
													(y + i - 2) * game.getRowHeight());
			}
		}
	}
	
	public void rotateCW() {
		++rotation;
		rotation = rotation % 4;
		Block[][] copyListBlocks = new Block[4][4];
		//copy the current shape
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				copyListBlocks[i][j] = blocks[i][j];
			}
		}
		//rotate clockwise
    	for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				blocks[i][j] = copyListBlocks[3-j][i];
			}
    	}
    	//shift blocks
    	shiftBlocksUpLeft();
	}
	
	private void shiftBlocksUpLeft() {
		if (!(this instanceof IShape || this instanceof OShape))
		switch (rotation) {
		case 0 :
			++y;
			break;
		case 1 :
			--x;
			break;
		case 2 :
			--y;
			break;
		case 3 :
			++x;
			break;
		}
	}

	public void rotateCCW() {
		for (int i = 0; i < 3; ++i)
			rotateCW();
	}
	


	public void reset() {
		//reset rotation
		while (rotation > 0)
		{
			rotateCCW();
			rotation--;
		}
	 
		while (rotation < 0)
		{
			rotateCW();
			rotation++;
		}
		// start in the center, just above the grid
		if (!(this instanceof OShape)) {
			x = 3;
			y = 0;
		}
		//set OShape 1 higher than the rest
		else {
			x = 3;
			y = -1;
		}
	}
	
	//returns y position of the highest block
	public int getTop() {
		for (int i = 0; i < 4; ++i){
			for (int j = 0; j < 4; ++j) {
				if (blocks[i][j] != null)
					return y + i;
			}
		}
		return -1;
	}
	
	//returns y position of the lowest block
	public int getBottom() {
		for (int i = 3; i >= 0; --i){
			for (int j = 0; j < 4; ++j) {
				if (blocks[i][j] != null)
					return y + i;
			}
		}
		return -1;
	}
	
	//returns x position of the leftmost block
	public int getLeft() {
		for (int j = 0; j < 4; ++j){
			for (int i = 0; i < 4; ++i) {
				if (blocks[i][j] != null)
					return x + j;
			}
		}
		return -1;
	}
	
	//returns x position of the rightmost block
	public int getRight() {
		for (int j = 3; j >= 0; --j){
			for (int i = 0; i < 4; ++i) {
				if (blocks[i][j] != null)
					return x + j;
			}
		}
		return -1;
	}
	
	
	
	public static LinkedQueue<Shape> generate() {
		LinkedQueue<Shape> upcoming = new LinkedQueue<Shape>();
		Random rand = new Random();
		//array containing one of each shape
		Shape[] bag = {new IShape(), new JShape(), new LShape(), new OShape(), new SShape(), new TShape(), new ZShape()};
		
		//randomize order of shapes
		for (int i = bag.length - 1; i >= 0; --i) {
			Shape temp;
			int j = rand.nextInt(i + 1);
			//swap
			temp = bag[j];
			bag[j] = bag[i];
			bag[i] = temp;
		}
		
		for (int i = 0; i < bag.length; ++i) {
			upcoming.add(bag[i]);
		}
		
		return upcoming;
	}
}
