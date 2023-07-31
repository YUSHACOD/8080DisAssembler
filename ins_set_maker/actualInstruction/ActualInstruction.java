package ins_set_maker.actualInstruction;

import ins_set_maker.instruction.Instruction;

public class ActualInstruction extends Instruction {

	public ActualInstruction(Instruction i, int byte1, int byte2) {
		this.Opcode = i.Opcode;
		try {
			this.Mnemonic = resolve(i.Mnemonic, byte1, byte2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.Flags = i.Flags;
		this.Function = i.Function;
		this.Length = i.Length;
		try {
			makeInstruction();
		} catch (Exception e) {
			System.out.println("Error in making Instruction : " + e);
		}
	}

	public ActualInstruction(Instruction i, int byt) {
		this.Opcode = i.Opcode;
		try {
			this.Mnemonic = resolve(i.Mnemonic, byt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.Flags = i.Flags;
		this.Function = i.Function;
		this.Length = i.Length;
		try {
			makeInstruction();
		} catch (Exception e) {
			System.out.println("Error in making Instruction : " + e);
		}
	}

	public ActualInstruction(Instruction i) {
		this.Opcode = i.Opcode;
		this.Mnemonic = i.Mnemonic;
		this.Flags = i.Flags;
		this.Function = i.Function;
		this.Length = i.Length;
		try {
			makeInstruction();
		} catch (Exception e) {
			System.out.println("Error in making Instruction : " + e);
		}
	}

	private void makeInstruction() {
		Instruction = Opcode.concat(Space.substring(0, Space.length() - Opcode.length()))
				+ Mnemonic.concat(Space.substring(0, Space.length() - Mnemonic.length()))
				+ Flags.concat(Space.substring(0, Space.length() - Flags.length()))
				+ Function;
	}

	private String resolve(String s, int byte1, int byte2) throws Exception {
		if (s.contains("D16")) {
			return s.replace("D16", ("#0x" + formatByte(byte2) + formatByte(byte1)));
		} else if (s.contains("adr")) {
			return s.replace("adr", ("$" + formatByte(byte2) + formatByte(byte1)));
		} else {
			throw new Exception("Error from resolving");
		}
	}

	private String resolve(String s, int byt) throws Exception {
		if (s.contains("D8")) {
			return s.replace("D8", ("#0x" + formatByte(byt)));
		} else {
			throw new Exception("Error from resolving");
		}
	}

	private String formatByte(int byt) {
		String s = Integer.toHexString(byt);
		if (s.length() == 1) {
			s = "0".concat(s);
		}
		return s;
	}
}
