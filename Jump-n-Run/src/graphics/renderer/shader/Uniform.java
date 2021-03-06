package graphics.renderer.shader;

import org.lwjgl.opengl.GL20;

/**
 * 
 * @author james_000
 *
 *	Uniform variable from shader
 */
public abstract class Uniform
{

	protected static final int NOT_FOUND = -1;
	
	//Name of the uniform in the shader
	protected String name;
	//Id of the uniform
	private int location;
	
	/**
	 * @param name - Uniform name
	 */
	protected Uniform(String name)
	{
		this.name = name;
	}
	
	/**
	 * 
	 * @param programID - Shader ID
	 * 
	 * Gets the uniform location from the shader. The shader must be started before.
	 */
	protected void storeUniformLocation(int programID)
	{
		location = GL20.glGetUniformLocation(programID, this.name);
		if (location == NOT_FOUND)
			System.err.println("Could not find Uniform " + name);
	}
	
	/**
	 * 
	 * @return Uniform location
	 */
	protected int getLocation()
	{
		return location;
	}
	
}
