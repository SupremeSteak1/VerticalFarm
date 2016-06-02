import java.util.ArrayList;

import javax.swing.JFrame;


<<<<<<< HEAD
@SuppressWarnings("serial")
/**
 * 
 * @author Joshua n Thomas
 * This class is the JFrame that displays all the images.
 */
=======
>>>>>>> d4e7b8e97cf4ce38a02777dc77c50c4e9766830e
public class Renderer extends JFrame {
	
	private Display display;
	private ArrayList<Renderable> queue;
	
	public Renderer() {
		addKeyListener(new Keyboard());
<<<<<<< HEAD
		addMouseListener(new Mouse());
=======
>>>>>>> d4e7b8e97cf4ce38a02777dc77c50c4e9766830e
		display = new Display();
		add(display);
		setSize(600, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		queue = new ArrayList<Renderable>();
	}
	
	public void setQueue(ArrayList<Renderable> newRenderQueue) {
		queue = newRenderQueue;
	}
	
	public void addToQueue(ArrayList<Renderable> a) {
		queue.addAll(a);
	}
	
	public void refreshQueue() {
		display.setQueue(queue);
		queue = new ArrayList<Renderable>();
	}
}
