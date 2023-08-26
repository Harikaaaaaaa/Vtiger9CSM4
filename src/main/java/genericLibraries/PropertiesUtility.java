package genericLibraries;
/**
 * This class contains reusable methods to perform operations on properties file
 * @author DELL
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility 
{
	private Properties property;
	/**
	 * This method is used to read data from properties
	 * @param filepath
	 * @param key
	 * @return
	 */


	
		public void propertiesInitialiation(String filepath)
		{
			FileInputStream fis=null;
			try
			{
				fis=new FileInputStream(filepath);
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
                property=new Properties();
			try
			{
				property.load(fis);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		/**
		 * 
		 * @param Key
		 * @return
		 */
			public String readFromProperties(String Key)
			{
			return property.getProperty(Key);
		}

	}


