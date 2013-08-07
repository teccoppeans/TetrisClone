

public class JShape extends Shape {
	
	public JShape() {
		blocks = new Block[4][4];
		rotation = 0;
		color = "blue";
		//initialize shape
		blocks[0][0] = new Block(color);
		for (int i = 0; i < 3; ++i) {
			blocks[1][i] = new Block(color);
		}
		reset();
	}
}
