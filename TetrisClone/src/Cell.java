
public class Cell {

	Block block;
	private boolean isEmpty;
	
	public Cell() {
		block = null;
		setEmpty(true);
	}
	
	public Cell(Block block) {
		this.block = block;
		setEmpty(false);
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
		if (block != null)
			this.isEmpty = false;
		else
			this.isEmpty = true;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
}
