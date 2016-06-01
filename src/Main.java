import java.util.ArrayList;


public class Main {
	
	private static boolean running;
	
	public static void main(String[] args) {
		running = true;
		Renderer r = new Renderer();
		UpdateHandler u = new UpdateHandler();
		TestRenderObject john = new TestRenderObject();
		GameObjectHandler goh = new GameObjectHandler();
		goh.registerGameObject(john);
		while(running) {
			r.setQueue(new ArrayList<Renderable>());
			//r.addToQueue(u.update());
			goh.updateGameObjects();
			goh.renderGameObjects(r);
			r.refreshQueue();
			r.repaint();
			r.revalidate();
			r.setVisible(true);
		}
	}
	
	
}
