package binaryReader;

import java.util.ArrayList;
import java.io.*;

public class BinaryReader {
	private ArrayList<Integer> list = new ArrayList<Integer>();

	public BinaryReader(String path) {
		Start(path);
	}

	private void Start(String path) {
		try {
			File f = new File(path);
			FileInputStream fr = new FileInputStream(f);
			CreateByteArray(fr);
		} catch (FileNotFoundException e) {
			System.out.println("Binary Reader : File not found bitch..." + e);
		}
	}

	private void CreateByteArray(FileInputStream fr) {
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

	public ArrayList<Integer> getByteList() {
		list.trimToSize();
		return this.list;
	}
}
