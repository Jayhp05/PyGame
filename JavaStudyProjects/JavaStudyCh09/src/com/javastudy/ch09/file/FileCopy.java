package com.javastudy.ch09.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 파일 복사하기
public class FileCopy {

	public static void main(String[] args) {
		
		String inPath = "src/copy/";
		String outPath = "src/destination/";
		File inFile = new File(inPath + "zipcode.txt");
		File outFile = new File(outPath + inFile.getName());
		System.out.println(inFile.getPath());
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;		
		
		try {
			
			fis = new FileInputStream(inFile);
			fos = new FileOutputStream(outFile);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int input = 0;
			byte[] buf = new byte[16384];
			
			if(inFile.exists()) {
				
				// 버퍼를 사용하지 않으면 15초 이상 소요된다.
				/*
				long start = System.currentTimeMillis();
				while((input = fis.read()) != -1) {
					fos.write(input);
				}
				long end = System.currentTimeMillis();				
				System.out.println("복사시간(버퍼x) : " + (end - start));
				*/
							
				// 버퍼의 크기에 따라서 파일 복사 시간이 약간씩 차이가 난다.
				long start = System.currentTimeMillis();
				while((input = bis.read(buf)) != -1) {					
					bos.write(buf, 0, input);
				}
				long end = System.currentTimeMillis();				
				System.out.println("복사시간(buffered) : " + (end - start));
				
			}
			
		} catch(IOException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(fos != null) fos.close();
				if(fis != null) fis.close();
			} catch(IOException e) { }
		}
	}
}
