import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.MemoryUtil;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;

public class VBO {
		/**
		 * 
		 * 
		 * @param numAttribute 
		 * The number of the attribute of the VAO where the data is tobe stored.
		 * @param vertices
		 * Posiciones de los vertices
		 * @return
		 */
		public void createVBO(int numAttribute, float[] vertices) {
			int vboID = GL15.glGenBuffers();
			// Aqui FALTA añadir a lista de VBOs
			
			// Activamos el VBO vboID del tipo GL_ARRAY_BUFFER que contendrá posicion de vertice
			GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
			
			// LLamamos a metodo privado para crear FloatBuffer
			FloatBuffer bufferVertices = createBuffer(vertices);
			
			//4.Con glBufferData copiamos los vertices de FloatBuffer en el buffer activo 
			GL15.glBufferData(GL15.GL_ARRAY_BUFFER, bufferVertices, GL15.GL_STATIC_DRAW);
			
			
			// associate 0th vertex attribute with active buffer. . Define la estructura de nuestros datos 
			//y los almacena en uno de los atributos de la lista de VAO.
			// Asocia el buffer a uno de los atributos del VAO ??
			
			/*
			 * 
			 * The parameters are:
index: Specifies the location where the shader expects this data.
size: Specifies the number of components per vertex attribute (from 1 to 4). In this case,
we are passing 3D coordinates, so it should be 3.
type: Specifies the type of each component in the array, in this case a float.
normalized: Specifies if the values should be normalized or not.
stride: Specifies the byte offset between consecutive generic vertex attributes. (We will
explain it later).
offset: Specifies an offset to the first component in the buffer.
After we are finished with our VBO we can unbind it and the VAO (bind them to 0)

			 * 
			 */
			 
			GL20.glVertexAttribPointer(numAttribute,3,GL11.GL_FLOAT,false,0,0);
			
			
			// Desactivamos el buffer que está activo
			GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
			
			//return vboID;
			
		}
		
		private static FloatBuffer createBuffer(float[] vertices) {
			//3.	Copiamos los vértices en el FloatBuffer
			// 3.1 Lo siguiente en version LWJGL 3:
			//FloatBuffer verticesBuffer = MemoryUtil.memAllocFloat(vertices.length);
			//verticesBuffer.put(vertices).flip();
			
			// 3.2 En version LWJGL 2 (en teoria menos eficiente):
			FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices.length);
			verticesBuffer.put(vertices).flip();
			return verticesBuffer;
			
		}
}
