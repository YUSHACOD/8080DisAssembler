package ins_set_maker.actualInstruction;

import ins_set_maker.instruction.Instruction;

public class ActualInstruction extends Instruction {

	public ActualInstruction(Instruction i, int byte1, int byte2) {

	}

	public ActualInstruction(Instruction i, int byte1) {

	}

	public ActualInstruction(Instruction i) {

	}

	private String formatByte(int byt) {
		String s = Integer.toHexString(byt);
		if (s.length() == 1) {
			s = "0".concat(s);
		}
		return s;
	}
}
