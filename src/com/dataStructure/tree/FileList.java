package com.dataStructure.tree;

import java.io.File;

public class FileList {
	private void list(File f,int deep) {

		printFileName(f,deep);

		if(f.isDirectory()){
			for (File sonFile :f.listFiles()){
				list(sonFile,deep+1);
			}
		}

	}

	public void list(File f){
		list(f,0);
	}

	private void printFileName(File f,int deep) {

		for (int i = 0; i < deep; i++) {
			System.out.print("\t");
		}
		System.out.println(f.getName());
	}


	public static void main(String[] args) {
		File f = new File("C:\\adb");
		FileList fileList = new FileList();
		fileList.list(f);
	}
}
