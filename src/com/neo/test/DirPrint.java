package com.neo.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.neo.dto.NeoDirectory;
import com.neo.dto.NeoFile;

public class DirPrint {

	public static void main(String[] args) {
		File currentDir = new File("D:\\finnone-webapp\\"); // current directory
		long startTime = System.currentTimeMillis();
		long stopTime;
		long elapsedTime;
		NeoDirectory RootDir = new NeoDirectory("Root");
		try (PrintWriter out = new PrintWriter("D:\\testdata1.txt")) {

			displayDirectoryContents(currentDir, out, RootDir);
			stopTime = System.currentTimeMillis();
			elapsedTime = stopTime - startTime;
			out.append("Total time : " + elapsedTime);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("resource")
	public static void setJarFile(String path,NeoDirectory jarDir,PrintWriter out) throws IOException{
		JarFile file = new JarFile(path);
		Enumeration<JarEntry> entries = file.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			if (!entry.isDirectory()){
				NeoFile neoFile = new NeoFile(entry.getName(), "",entry.toString());
				jarDir.addNewFile(neoFile);
				out.append("++++++file:" + entry.getName()
						+ "  " + entry + " \n");
			}
		}
	}

	public static void displayDirectoryContents(File dir, PrintWriter out,
			NeoDirectory parentDir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					out.append("directory:" + file.getCanonicalPath() + "\n");
					NeoDirectory childDir = new NeoDirectory(file.getName());
					childDir.setIndent(parentDir.getIndent() + 1);
					parentDir.addNewDirectory(childDir);
					displayDirectoryContents(file, out, childDir);
				} else {
					if (file.getName().contains(".jar")) {
						out.append("-----jar:" + file.getCanonicalPath() + "\n");
						setJarFile(file.getCanonicalPath(), new NeoDirectory(), out);
					}else{
						out.append("++++++file:" + file.getCanonicalPath()
								+ "  " + file.getName() + " \n");

						NeoFile neoFile = new NeoFile(file.getName(), "",
								file.getCanonicalPath());
						neoFile.setIndent(parentDir.getIndent());
						parentDir.addNewFile(neoFile);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}