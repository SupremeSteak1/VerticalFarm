import java.util.ArrayList;


public class TestRenderObject implements GameObject  {
	//This is like a plant
	int a = 0;
	long time = 0;
	int a2 = 0;
	long time2 = 0;
	public ArrayList<Renderable> render() {
		ArrayList<Renderable> list = new ArrayList<Renderable>();
		//TODO: Change this out when working on a different computer
		list.add(new RenderableImage("res/kimoon.jpg",0,0));
		//list.add(new RenderableImage("C:/Users/17haydent/Desktop/test.png",0,0));
		if(System.currentTimeMillis()-1000>time2) {
			System.out.println("FPS:"+a2);
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
