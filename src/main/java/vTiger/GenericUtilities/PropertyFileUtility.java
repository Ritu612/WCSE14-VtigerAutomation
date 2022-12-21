package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *   This class contains generic methods related to property file
 * @author Ritu
 *
 */
public class PropertyFileUtility 
{
   /**
    * This generic method will read the key from property file and return the value
    * @param key
    * @return
    * @throws IOException
    */
	public String readDataFromPropertyFile(String key) throws IOException
    {
    	FileInputStream fis=new FileInputStream(IConstantUtility.PropertyFilePath);
    	Properties p=new Properties();
    	p.load(fis);
    	String value=p.getProperty(key);
    	return value;
    	
    }
}
