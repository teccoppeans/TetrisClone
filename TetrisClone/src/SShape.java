

public class SShape extends Shape{
	
	public SShape() {
		blocks = new Block[4][4];
		rotation = 0;
		color = "green";
		//initialize shape
		for (int i = 1; i < 3; ++i) {
			blocks[0][i] = new Block(color);
		}
		for (int i = 0; i < 2; ++i) {
			blocks[1][i] = new Block(color);
		}
		reset();
	}
}
