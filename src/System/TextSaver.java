package System;
import java.io.*;
public class TextSaver {

	static private TextSaver textSaver;
	private TextSaver()
	{}
	static public void save(String headout,String[] texts)
	{   if(textSaver==null) {textSaver=new TextSaver();}
		String fileName=headout+".txt";
		
		try {
			FileWriter writer =new FileWriter(fileName);
			writer.write(headout);
			writer.write('\r');
			writer.write('\n');
			for(String text :texts)
			{
				writer.write(text);
				writer.write('\r');
				writer.write('\n');
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
