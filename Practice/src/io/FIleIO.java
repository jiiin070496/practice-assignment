package io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class FIleIO {
	public void testFile() {
		
		String path = "D:/data2/test";
		String fileName = "Hello World.txt";
		
		new File(path).mkdir();
		File f1 = new File(path, fileName);
		FileWriter fw = null;
		try {
			f1.createNewFile();
			fw = new FileWriter(f1);
			fw.write("Hello, World!");
			fw.flush();
			return;
		}catch(IOException e){
			System.out.println("파일 생성 못함");
			e.printStackTrace();
		}finally {
			try {
				if(fw != null)
					fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void testFileReadData() {
		String filePath = "D:/data2/test/Hello World.txt";
		try(
			BufferedInputStream br = null;
			FileInputStream fis = null;
			InputStreamReader isr = null;
			){
			String str = null;
			
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
}

















}
