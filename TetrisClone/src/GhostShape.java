
public class GhostShape extends Shape {
	
	public GhostShape(Shape other) {
		copy(other);
	}
	
	public void copy(Shape other) {
		blocks = new Block[4][4];
		rotation = other.getRotation();
		color = "ghost";
		this.x = other.getX();
		this.y = other.getY();
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				if (other.getBlocks()[i][j] != null)
					blocks[i][j] = new Block("ghost");
			}
		}
	}
}
