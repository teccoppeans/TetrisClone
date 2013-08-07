

public class TShape extends Shape {

	public TShape() {
		blocks = new Block[4][4];
		rotation = 0;
		color = "purple";
		//initialize shape
		blocks[0][1] = new Block(color);
		for (int i = 0; i < 3; ++i) {
			blocks[1][i] = new Block(color);
		}
		reset();
	}
}
