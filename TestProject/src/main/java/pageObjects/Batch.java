package pageObjects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Batch {

	private Properties properties;
	
	public Batch()
	{
	}
	
	public void createAndClearProperties(String fileName, String filePath) throws IOException
	{
		File folder = new File(filePath);
		File[] files = folder.listFiles();
		for(File file:files)
		{
			if(file.isFile() && file.getName().contains(fileName))
			{
				file.delete();
			}
		}
		File file = new File(filePath+fileName);
		file.createNewFile();
	}
	
	public void updateProperitesOfFile(String fileName, String filePath) throws IOException
	{
		String pnr = "CDD45S";
		String txnID = "45453524454332524";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		String time = dtf.format(now);
		System.out.println("PNR => " + pnr);
		System.out.println("TXN ID => "+ txnID);
		System.out.println("Current Time => " +time);
		properties = new Properties();
		properties.put("TransactionID", txnID);
		properties.put("PNR", pnr);
		properties.put("CurrentDate", time);
		FileOutputStream fr = new FileOutputStream(filePath+fileName);
		properties.store(fr, "Properties");
	}
}
