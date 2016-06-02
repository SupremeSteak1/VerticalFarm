import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class handles mouse actions and allows for easier access to mouse events
 * @author Joshua
 *
 */
public class Mouse implements MouseListener{

	private static Point recentClick;
	private static long recentClickTime;
	
	public Mouse() {
		recentClick = new Point(0,0);
		recentClickTime = 0;
	}
	
	/**
	 * @return the point where the moust recent click occurred
	 */
	public static Point getRecentClickLocationOnScreen(){
		return recentClick;
	}
	
	public static long getLastClickTime() {
		return recentClickTime;
	}
	
	public void mouseClicked(MouseEvent e) {
		
		recentClick = e.getPoint();
		recentClickTime = System.currentTimeMillis();
		
		System.out.println("Click at " + recentClick.toString());
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

}
