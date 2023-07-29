package ins_set_maker.instruction;

public class Instruction {
	String Opcode;
	String Mnemonic;
	String Length;
	String Flags;
	public String Instruction;
	String Function;
	static String Space = "                    ";

	public Instruction(String Opcode, String Mnemonic, String Length, String Flags, String Function) {
		this.Opcode = Opcode;
		this.Mnemonic = Mnemonic;
		this.Length = Length;
		this.Flags = Flags;
		this.Function = Function;
		try {
			makeInstruction();
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
