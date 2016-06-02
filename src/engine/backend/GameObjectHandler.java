package engine.backend;
import java.util.ArrayList;

/**
 * 
 * @author Thomas Hayden
 * @version 6/02/16
 */
public class GameObjectHandler {
	
	private static ArrayList<GameObject> gameObjects;
	
	public GameObjectHandler() {
		gameObjects = new ArrayList<GameObject>();
	}
	
	public static void registerGameObject(GameObject go) {
		gameObjects.add(go);
	}
	
	public static void updateGameObjects() {
		for(GameObject go : gameObjects) {
			try {
				go.update();
			} catch(Exception e) {
				System.out.println("From updateGameObjects()");
				e.printStackTrace();
			}
		}
	}
	
	public static void renderGameObjects(Renderer r) {
		for(GameObject go : gameObjects) {
			try {
				r.addToQueue(go.render());
			} catch(Exception e) {
				System.out.println("From renderGameObjects()");
				e.printStackTrace();
			}
		}
	}
}
