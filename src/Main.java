import java.util.ArrayList;


public class Main {
	
	private static boolean running;
	
<<<<<<< HEAD
	@SuppressWarnings({ "static-access", "unused" })
=======
>>>>>>> d4e7b8e97cf4ce38a02777dc77c50c4e9766830e
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
