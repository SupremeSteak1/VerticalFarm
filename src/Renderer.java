import java.util.ArrayList;

import javax.swing.JFrame;


public class Renderer extends JFrame {
	
	private Display display;
	private ArrayList<Renderable> queue;
	
	public Renderer() {
		addKeyListener(new Keyboard());
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
