package pattern.decorator;

public abstract class WindowDecorator implements Window{
	private Window window;

	public WindowDecorator(Window window) {
		this.window = window;
	}

	public void draw() {
		window.draw();
	}

	public void getDescription() {
		window.getDescription();
	}
}
