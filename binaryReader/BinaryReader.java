package binaryReader;

import java.util.ArrayList;
import java.io.*;

public class BinaryReader {
	public static ArrayList<Integer> list = new ArrayList<Integer>();

	public BinaryReader(String path) {
		Start(path);
	}

	private static void Start(String path) {
		System.out.println("Hello world");
		try {
			File f = new File(path);
			FileInputStream fr = new FileInputStream(f);
			CreateByteArray(fr);
		} catch (FileNotFoundException e) {
			System.out.println("File not found bitch..." + e);
		}
	}

	private static void CreateByteArray(FileInputStream fr) {
		int i;
		try {
			while ((i = fr.read()) != -1) {
				list.add(i);
			}
		} catch (Exception e) {
			System.out.println("Got problem while reading the file..." + e);
		}
	}

	public void printBytelist() {
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
