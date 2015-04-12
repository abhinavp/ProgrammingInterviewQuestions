package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class LastNLinesOfFile{
	public static void main(String [] args){
		try {
			printByRandomAcessFile(new File(""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	private static void printByRandomAcessFile(File file) throws FileNotFoundException, IOException{
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile = new RandomAccessFile(file, "r");
			int lines = 0;
			StringBuilder builder = new StringBuilder();
			long length = file.length();
			length--;
			randomAccessFile.seek(length);
			for(long seek = length; seek >= 0; --seek){
				randomAccessFile.seek(seek);
				char c = (char)randomAccessFile.read();
				builder.append(c);
				if(c == '\n'){
					builder = builder.reverse();
					System.out.println(builder.toString());
					lines++;
					builder = null;
					builder = new StringBuilder();
					if (lines == 5){
						break;
					}
				}

			}
		}finally{
			randomAccessFile.close();
		}
	}
}