import ins_set_maker.instruction.Instruction;
import ins_set_maker.actualInstruction.ActualInstruction;
import binaryReader.BinaryReader;
import ins_set_maker.InsSetMaker;
import java.util.ArrayList;
import java.util.Iterator;

class Main {
	public static void main(String[] args) {

		ArrayList<Instruction> instructionList = InsSetMaker.getInstructionList();
		BinaryReader br = new BinaryReader(args[0]);
		ArrayList<Integer> byteList = br.getByteList();
		Iterator<Integer> pc = byteList.iterator();
		int counter = 0;

		ArrayList<ActualInstruction> disAssembledInstructions = new ArrayList<>();

		while (pc.hasNext()) {
			Instruction inst = instructionList.get(pc.next());
			if (inst.Mnemonic.contains("D8")) {
				int byte1 = pc.next();
				disAssembledInstructions.add(new ActualInstruction(inst, byte1));
			} else if (inst.Mnemonic.contains("D16")) {
				int byte1 = pc.next();	
				int byte2 = pc.next();	
				disAssembledInstructions.add(new ActualInstruction(inst, byte1, byte2));
			} else if (inst.Mnemonic.contains("adr")) {
				int byte1 = pc.next();	
				int byte2 = pc.next();	
				disAssembledInstructions.add(new ActualInstruction(inst, byte1, byte2));
			} else {
				disAssembledInstructions.add(new ActualInstruction(inst));
			}
		}

		disAssembledInstructions.trimToSize();
		for (ActualInstruction actualInstruction : disAssembledInstructions) {
			String s = Integer.toHexString(counter);
			String space = "      ";
			System.out.println(s.concat(space.substring(0, space.length() - s.length())) 
					+ " : " + actualInstruction.Instruction);
			counter += Integer.parseInt(actualInstruction.Length);
		}
	}
}
