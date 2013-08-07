

public class ZShape extends Shape {
	
	public ZShape() {
		blocks = new Block[4][4];
		rotation = 0;
		color = "red";
		//initialize shape
		for (int i = 0; i < 2; ++i) {
			blocks[0][i] = new Block(color);
		}
		for (int i = 1; i < 3; ++i) {
			blocks[1][i] = new Block(color);
		}
		reset();
	}
}
