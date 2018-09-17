
import org.lwjgl.opengl.GL30;

public class VAO {
	
	/**
	 * Creamos el VAO y lo activamos (solo puede existir un VAO activo a la vez)
	 * @return
	 */
	public int createVAO() {
		int vaoID = GL30.glGenVertexArrays();
		// aqui FALTA meter el vaoID dentro de de la lista
		GL30.glBindVertexArray(vaoID);
		return vaoID;
	}
	
	private void unbindVAO() {
		GL30.glBindVertexArray(0);
	}
 
	
}
