package other;

import java.util.ArrayList;

import engine.backend.GameObject;
import engine.frontend.Renderable;
import engine.frontend.RenderableImage;
import engine.input.Mouse;

public class MainMenu implements GameObject {

	@Override
	public ArrayList<Renderable> render() {

		RenderableImage mm = new RenderableImage("res/mainmenu-hd.png", 0, 0, 1);

		ArrayList<Renderable> toRender = new ArrayList<>();
		toRender.add(mm);

		return toRender;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		double x = Mouse.getRecentClickLocationOnScreen().getX();
		double y = Mouse.getRecentClickLocationOnScreen().getY();
		// start button
		if(x >= 240 && x <= 375 && y >= 811 && y <= 872) {
			System.out.println("START");
		}
		// exit button
		if(x >= 632 && x <= 759 && y >= 817 && y <= 886) {
			System.out.println("EXIT");
		}
	}

}
