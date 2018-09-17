import org.lwjgl.opengl.Display;

public class Main {

	private static int vao1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisplayManager.createDisplay();
		VAO vao1 = new VAO();
		VBO vbo1 = new VBO();
		
		float[] vertices= {
				// Left bottom triangle
				-0.5f, 0.5f, 0f,
				-0.5f, -0.5f, 0f,
				0.5f, -0.5f, 0f,
				// Right top triangle
				0.5f, -0.5f, 0f,
				0.5f, 0.5f, 0f,
				-0.5f, 0.5f, 0f
		};
		
		
		
		int vao_num_1 = vao1.createVAO();
		//int vbo_num_1 = vbo1.createVBO(0, vertices);
		vbo1.createVBO(0, vertices);
		
		Render renderDraw = new Render();	
		
		
		while (!Display.isCloseRequested()) {
			
			renderDraw.deleteDisplay();
			renderDraw.render(vao_num_1);	
			DisplayManager.updateDisplay();
		}
		DisplayManager.closeDisplay();
		}
}

