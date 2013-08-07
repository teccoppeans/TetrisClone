import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SlickException {
		// TODO Auto-generated method stub
		AppGameContainer app = new AppGameContainer(new Game("Java Tetris"));
		
		app.setDisplayMode(400, 600, false);
		
		app.setTargetFrameRate(60);
		app.setShowFPS(false);
		app.setUpdateOnlyWhenVisible(true);
		app.start();
		

	}
	
}
