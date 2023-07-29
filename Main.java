import ins_set_maker.instruction.Instruction;
import binaryReader.BinaryReader;
import ins_set_maker.InsSetMaker;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) {
		ArrayList<Instruction> list = InsSetMaker.getInstructionList();

		InsSetMaker.printInstructionList(list);
		BinaryReader br = new BinaryReader("./invaders.h");
		br.printBytelist();
	}
}
