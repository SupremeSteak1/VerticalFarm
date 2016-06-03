package other;
import engine.backend.GameObject;
import engine.frontend.Renderable;
import engine.frontend.RenderableImage;

import java.util.ArrayList;


public class TestRenderObject implements GameObject  {
	//This is like a plant
	private int a = 0;
	private long time = 0;
	private int a2 = 0;
	private long time2 = 0;
	private int level;
	
	public TestRenderObject(int level) {
		this.level = level;
	}
	
	public ArrayList<Renderable> render() {
		ArrayList<Renderable> list = new ArrayList<Renderable>();
		list.add(new RenderableImage("res/kimoon.jpg",0,0,level));
		if(System.currentTimeMillis()-1000>time2) {
			System.out.println("FPS:" + a2);
			time2 = System.currentTimeMillis();
			a2 = 0;
		}
		a2++;
		return list;
	}
	
	public void update() {
		if(System.currentTimeMillis()-1000>time) {
			System.out.println(a);
			time = System.currentTimeMillis();
			a = 0;
		}
		a++;
	}
}
