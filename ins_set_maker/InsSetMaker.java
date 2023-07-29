package ins_set_maker;

import ins_set_maker.instruction.Instruction;
import java.util.ArrayList;
import java.io.*;

public class InsSetMaker {
	public static void printInstructionList(ArrayList<Instruction> ls) {
		System.out.println("here is the instruction list....");
		for (Instruction instruction : ls) {
			System.out.println(instruction.Instruction);
		}
	}

	public static ArrayList<Instruction> getInstructionList() {
		ArrayList<Instruction> list = new ArrayList<>();
		String line;
		String[] data;

		System.out.println("Creating the instruction list...");
		try {
			File file = new File("./ins_set_maker/source/insSetReadable.txt");
			FileReader fr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);

			while ((line = buffer.readLine()) != null) {
				data = line.split("##");
				if (data.length == 5) {
					String Opcode = data[0];
					String Mnemonics = data[1];
					String Length = data[2];
					String Flags = data[3];
					String Function = data[4];
					try {
						Instruction inst = new Instruction(Opcode, Mnemonics, Length, Flags, Function);
						list.add(inst);
					} catch (Exception e) {
						System.out.println("Problem in instruction object creation..." + e);
					}
				} else {
					System.out.println("Invalid data format: " + line);
				}
			}
		} catch (FileNotFoundException fe) {
			System.out.println("File not found bitch..." + fe);
		} catch (Exception e) {
			System.out.println("Instruction List Not created..." + e);
		}

		System.out.println("Instruction List created.");
		return list;
	}
}
