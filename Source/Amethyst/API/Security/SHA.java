package Amethyst.API.Security;

import java.io.*;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.DigestInputStream;
import java.security.NoSuchAlgorithmException;

public final class SHA
{
    
	private final Charset UTF_8 = StandardCharsets.UTF_8;
	
    /**
    * This constructor is a stub.
    */
	public SHA()
	{
	}
	
	// -------------------------------------------------------------------------------------------------- //
	//                             COMMON BACKEND FOR HASHING FILE AND STRING                             //
	// -------------------------------------------------------------------------------------------------- //
	
	
	
	/**
	* Method which converts the raw bytes into hexadecimal values
	*/
    private final String bytesToHex(byte[] bytes) 
	{
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) 
		{
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }


	
	// -------------------------------------------------------------------------------------------------- //
	//                               SHA3-256-CHECKSUM FOR A GIVEN STRING                                 //
	// -------------------------------------------------------------------------------------------------- //
	
	
	/**
	* Method which gets the String in form of Bytes and instantiates the Java builtin SHA3-256 algorithm
	*/
    private final byte[] digest(byte[] input) 
	{
        MessageDigest md;
        try 
		{
            md = MessageDigest.getInstance("SHA3-256");
        } 
		catch (NoSuchAlgorithmException e) 
		{
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }

	/**
	* Method which will convert the plain text string to encoded string and return the value as a string.
	*
	* @param pp : Takes in the String which is to be encoded (Thank you Shreyas, please bear with me xD )
	* @return String : Returns the encoded string using SHA3-256 algorithm.
	*/
    public final String StringToSHA(String pp)throws Exception
    {
		try
		{
			return bytesToHex(digest(pp.getBytes(UTF_8)));
		}
		catch(Exception E)
		{
			System.out.println("Warning! A fatal error has occured. Please copy, then paste it and email the same to the developer to ascertain the issue.");
			E.printStackTrace();
			Thread.sleep(20000);
			System.out.println("Continuing exection...");
		}
		return null;
    }
	
	
	// -------------------------------------------------------------------------------------------------- //
	//                                 SHA3-256-CHECKSUM FOR A GIVEN FILE                                 //
	// -------------------------------------------------------------------------------------------------- //
	
	
	public final String FileToSHA(String pp)throws Exception
	{		
		//assert if the file exists before trying to hash it.
		File fp=new File(pp);
		if(fp.exists()==true)
		{
			//see checksum
			return bytesToHex(fileSHA(pp));
		}
		else
			System.out.println("Cannot find specified file.");
		return null;
	}
	
	private byte[] fileSHA(String filePath) {

        MessageDigest md;
        try
		{
            md = MessageDigest.getInstance("SHA3-256");
        } 
		catch (NoSuchAlgorithmException e) 
		{
            throw new IllegalArgumentException(e);
        }

        try (InputStream is = new FileInputStream(filePath);
             DigestInputStream dis = new DigestInputStream(is, md)) {
            while (dis.read() != -1) ; //empty loop to clear the data
            md = dis.getMessageDigest();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return md.digest();

    }
}