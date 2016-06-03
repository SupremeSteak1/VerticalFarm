package other;
import engine.backend.GameObjectHandler;
import engine.backend.Renderer;
import engine.frontend.Renderable;
import engine.input.Keyboard;

import java.util.ArrayList;


public class Main {
	
	private static boolean running;
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		running = true;
		Renderer r = new Renderer(1);
		Renderer mainMenu = new Renderer(2);
		TestRenderObject john = new TestRenderObject(2);
		TestRenderObject wiley = new TestRenderObject(1);
		GameObjectHandler goh = new GameObjectHandler();
		goh.registerGameObject(john);
		goh.registerGameObject(wiley);
		while(running) {
			r.setQueue(new ArrayList<Renderable>());
			mainMenu.setQueue(new ArrayList<Renderable>());
			//r.addToQueue(u.update());
			goh.updateGameObjects();
			goh.renderGameObjects(r);
			goh.renderGameObjects(mainMenu);
			control(r);
			control(mainMenu);
		}
	}
	
	private static void control(Renderer r) {
		r.refreshQueue();
		r.repaint();
		r.revalidate();
		r.setVisible(true);
	}
	
	
}
