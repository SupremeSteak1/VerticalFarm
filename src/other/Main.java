package other;
import java.util.ArrayList;

import engine.backend.GameObjectHandler;
import engine.backend.Renderer;
import engine.frontend.Renderable;


public class Main {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Renderer r = new Renderer(1, 1000, 950);
		GameObjectHandler goh = new GameObjectHandler();
		Farm farm = new Farm();
		MainMenu mm = new MainMenu();
		goh.registerGameObject(farm);
		goh.registerGameObject(farm.getInfoPanel());
		goh.registerGameObject(farm.getMarketPanel());
		goh.registerGameObject(mm);
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
