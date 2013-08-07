

public class LShape extends Shape {
	
	public LShape() {
		blocks = new Block[4][4];
		rotation = 0;
		color = "orange";
		//initialize shape
		blocks[0][2] = new Block(color);
		for (int i = 0; i < 3; ++i) {
			blocks[1][i] = new Block(color);
		}
		reset();
	}
}
