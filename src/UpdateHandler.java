import java.util.ArrayList;
import java.util.Random;


public class UpdateHandler {
	
	private ArrayList<Renderable> renderQueue;
<<<<<<< HEAD
	@SuppressWarnings("unused")
	private int x;
	@SuppressWarnings("unused")
	private int y;
	
	//Defecated 6/1/16
	//For future reference, yes we know its deprecated.
=======
	private int x;
	private int y;
	
	//Defecated 6/1/16
>>>>>>> d4e7b8e97cf4ce38a02777dc77c50c4e9766830e
	
	public UpdateHandler() {
		renderQueue = new ArrayList<Renderable>();
		x = 0;
		y = 0;
	}
	
	public synchronized ArrayList<Renderable> update() {
		renderQueue = new ArrayList<Renderable>();
		if(Keyboard.isKeyPressed('w')) {
			y-=10;
		}
		if(Keyboard.isKeyPressed('s')) {
			y+=10;
		}
		if(Keyboard.isKeyPressed('d')) {
			x+=10;
		}
		if(Keyboard.isKeyPressed('a')) {
			x-=10;
		}
		//System.out.println(x);
		
		Random rand = new Random();
		for(int i = 0; i < 50; i++){
			renderQueue.add(new RenderableOval(rand.nextInt(800),rand.nextInt(600), rand.nextInt(50),rand.nextInt(60)));			
		}
		//renderQueue.add(new RenderableImage("C:\\Users\\17haydent\\Desktop\\test2.png",x,y));
		return renderQueue;
	}
	
}
