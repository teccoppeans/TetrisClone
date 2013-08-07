

public class OShape extends Shape{
	
	public OShape() {
		blocks = new Block[4][4];
		rotation = 0;
		color = "yellow";
		//initialize shape
		for (int i = 1; i < 3; ++i) {
			for (int j = 1; j < 3; ++j) {
				blocks[i][j] = new Block(color);
			}
		}
		reset();
	}
}
