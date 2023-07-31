package ins_set_maker.instruction;

public class Instruction {
	public String Opcode;
	public String Mnemonic;
	public String Length;
	public String Flags;
	public String Instruction;
	public String Function;
	public static String Space = "                    ";

	public Instruction() {
	}

	public Instruction(String Opcode, String Mnemonic, String Length, String Flags, String Function) {
		this.Opcode = Opcode;
		this.Mnemonic = Mnemonic;
		this.Length = Length;
		this.Flags = Flags;
		this.Function = Function;
		try {
			makeInstruction();
		} catch (Exception e) {
			System.out.println("Error in making Instruction : " + e);
		}
	}

	private void makeInstruction() {
		Instruction = Opcode.concat(Space.substring(0, Space.length() - Opcode.length()))
				+ Mnemonic.concat(Space.substring(0, Space.length() - Mnemonic.length()))
				+ Length.concat(Space.substring(0, Space.length() - Length.length()))
				+ Flags.concat(Space.substring(0, Space.length() - Flags.length()))
				+ Function;
	}
}
