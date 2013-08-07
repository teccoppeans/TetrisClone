


public class IShape extends Shape {

	public IShape() {
		blocks = new Block[4][4];
		rotation = 0;
		color = "cyan";
		//initialize shape
		for (int i = 0; i < 4; ++i) {
			blocks[1][i] = new Block(color);
		}
		reset();
	}
}
