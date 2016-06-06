package other;
import java.util.ArrayList;

import engine.backend.GameObjectHandler;
import engine.backend.Renderer;
import engine.frontend.Renderable;


public class Main {
	
	private static boolean running;
	
	/*
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
	*/
	
	public static void main(String[] args) {
		Renderer r = new Renderer(1, 1000, 700);
		GameObjectHandler goh = new GameObjectHandler();
		Farm farm = new Farm();
		goh.registerGameObject(farm);
		while(true) {
			r.setQueue(new ArrayList<Renderable>());
			goh.updateGameObjects();
			goh.renderGameObjects(r);
			control(r);
		}
	}
	
	private static void control(Renderer r) {
		r.refreshQueue();
		r.repaint();
		r.revalidate();
		r.setVisible(true);
	}
	
	
}
