import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Block {
	
	private Image image;

	public Block(String fName) {
		try {
			setImage(new Image("res/" + fName + "block.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Block(Image image) {
		setImage(image);
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
