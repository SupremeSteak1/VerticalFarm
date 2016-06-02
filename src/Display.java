import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

<<<<<<< HEAD
@SuppressWarnings("serial")
=======
>>>>>>> d4e7b8e97cf4ce38a02777dc77c50c4e9766830e
public class Display extends JPanel {
	
	private ArrayList<Renderable> renderQueue = new ArrayList<Renderable>();
	
	public Display() {
		
	}
	
	public void setQueue(ArrayList<Renderable> newRenderQueue) {
		renderQueue = newRenderQueue;
	}
	
	public void addToQueue(ArrayList<Renderable> a) {
		renderQueue.addAll(a);
	}
	
	public synchronized ArrayList<Renderable> getRenderQueue() {
		return renderQueue;
	}
	
	protected synchronized void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		@SuppressWarnings("unchecked")
		ArrayList<Renderable> renderQueueCopy = (ArrayList<Renderable>) getRenderQueue().clone();
		
		for(Renderable r : renderQueueCopy) {
			r.render(g2d);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
}
