

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

/**
 * This class contains all the methods needed to set-up, maintain, and close a LWJGL display.
 * 
 * @author Karl
 *
 */
public class DisplayManager {

	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private static final int FPS_CAP = 60;
	private static final String TITLE = "Our First Display";

	/**
	 * Creates a display window on which we can render our game. The dimensions
	 * of the window are determined by setting the display mode. By using
	 * "glViewport" we tell OpenGL which part of the window we want to render
	 * our game onto. We indicated that we want to use the entire window.
	 * 
	 * 
	 * * Crea una ventana de visualizaci�n en la que podemos renderizar nuestro juego. Las dimensiones
* de la ventana se determinan configurando el modo de visualizaci�n. Mediante el uso
* "glViewport" le decimos a OpenGL qu� parte de la ventana queremos mostrar
* nuestro juego en. Indicamos que queremos usar toda la ventana.
* 
* 
	 */
	public static void createDisplay() {
		ContextAttribs attribs = new ContextAttribs(3, 2).withForwardCompatible(true).withProfileCore(true);
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle(TITLE);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}

	/**
	 * This method is used to update the display at the end of every frame. When
	 * we have set up a rendering process this method will display whatever
	 * we've been rendering onto the screen. The "sync" method is used here to
	 * cap the frame rate. Without this the computer would just try to run the
	 * game as fast as it possibly can, doing more work than it needs to.
	 * 
	 * 
	 *  Este m�todo se usa para actualizar la pantalla al final de cada cuadro. Cuando
* hemos configurado un proceso de renderizado; este m�todo mostrar� lo que sea
* hemos estado renderizando en la pantalla. El m�todo de "sincronizaci�n" se usa aqu� para
* limitar la velocidad de cuadros. Sin esto, la computadora simplemente tratar�a de ejecutar el
* juego tan r�pido como sea posible, haciendo m�s trabajo de lo necesario.
	 */
	public static void updateDisplay() {
		Display.sync(FPS_CAP);
		Display.update();
	}

	/**
	 * This closes the window when the game is closed.
	 */
	public static void closeDisplay() {
		Display.destroy();
	}

}
