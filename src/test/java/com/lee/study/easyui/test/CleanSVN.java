package com.lee.study.easyui.test;
import java.io.File;

public class CleanSVN {
	/**
	 * @param file
	 * @return
	 */
	public boolean isSVNFolder(File file) {
		return file == null ? false : file.isDirectory()
				&& ".svn".equalsIgnoreCase(file.getName());
	}

	/**
	 * @param file
	 * @return
	 */
	public boolean removeFile(File file) {
		if (file == null)
			return false;
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			boolean rt = true;
			for (int i = 0; files != null && i < files.length; i++) {
				rt = rt && removeFile(files[i]);
			}
			rt = rt && file.delete();
			return rt;
		} else {
			return file.delete();
		}
	}

	/**
	 * @param file
	 */
	public void cleanSVN(File file) {
		if (file == null)
			return;
		if (this.isSVNFolder(file)) {
			boolean rt = this.removeFile(file);
			if (rt)
				logElimilatedSVN(file.getAbsolutePath());
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; files != null && i < files.length; i++) {
				cleanSVN(files[i]);
				files[i] = null;
			}
		}
	}

	/**
	 * @param fileName
	 */
	public void executeCleaning(String fileName) {
		if (fileName == null || fileName.trim().length() <= 0)
			return;
		File file = new File(fileName);
		if (file.isDirectory()) {
			this.cleanSVN(file);
		}
	}

	/**
	 * @param fileName
	 */
	public void logElimilatedSVN(String fileName) {
		System.out.println(fileName);
	}

	/**
	 * 
	 */
	public CleanSVN() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CleanSVN clean = new CleanSVN();
		String fileName = args == null || args.length == 0 ? null : args[0];
		fileName = "C:\\Users\\lee\\Desktop\\keta-security-1.1.0";
		System.out.println(fileName);
		clean.executeCleaning(fileName);
	}

}
