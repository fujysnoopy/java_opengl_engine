import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;


public class Render {
	
	public void deleteDisplay() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glClearColor(1, 0, 0, 1);
	}
	
	/**
	 * Activamos el VAO para que pueda ser pintado
	 */
	public void render(int vaoID) {
		// Activamos el VAO
		GL30.glBindVertexArray(vaoID);
		GL20.glEnableVertexAttribArray(0);
		// Renderiza primitivas
		/*
		 * When glDrawArrays is called, it uses count sequential elements from each enabled array 
		 * to construct a sequence of geometric primitives, beginning with element first
		 */
		//GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, model.getVertexCount());
		
		
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 6);
		
		// Desactiva el VA
		GL20.glDisableVertexAttribArray(0);
		GL30.glBindVertexArray(0);
		
		
	}
}
