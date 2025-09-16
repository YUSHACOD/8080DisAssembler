# 8080DisAssembler

A tiny Intel 8080 disassembler written in Java. It reads a binary file (e.g., a ROM image) and prints a linear disassembly to stdout using an instruction table.

## Features
- Reads a binary stream into memory
- Decodes bytes using an instruction set loaded from `ins_set_maker/source/insSetReadable.txt`
- Resolves immediate operands: `D8`, `D16`, and `adr` (addresses)
- Outputs annotated lines with program counter and formatted instruction fields

## Project structure
```
E:/github-backup/8080DisAssembler/
├─ Main.java                            # Entry point: linear disassembly loop
├─ binaryReader/
│  └─ BinaryReader.java                 # File→byte list reader
├─ ins_set_maker/
│  ├─ InsSetMaker.java                  # Loads instruction metadata from text file
│  ├─ instruction/
│  │  └─ Instruction.java               # Instruction metadata (opcode, mnemonic, flags, etc.)
│  └─ actualInstruction/
│     └─ ActualInstruction.java         # Resolves mnemonic placeholders with actual bytes
├─ ins_set_maker/source/
│  └─ insSetReadable.txt                # Human-readable instruction set description
└─ invaders.h                           # Sample ROM include (not required to run)
```

## Prerequisites
- Java 8+ (JDK) installed and on PATH
- A binary file to disassemble (e.g., `invaders.rom`). The program expects a path to a file as the first argument.

## Build
From the project root, compile all sources:
```bash
javac Main.java binaryReader/BinaryReader.java ins_set_maker/InsSetMaker.java ins_set_maker/instruction/Instruction.java ins_set_maker/actualInstruction/ActualInstruction.java
```
This produces `.class` files alongside the sources.

## Run
Pass the path to a binary file:
```bash
java Main path/to/binary.rom
```
Example on Windows PowerShell (from project root):
```powershell
java Main .\samples\invaders.rom
```

## Output format
Each line shows the current program counter (hex), a colon, and the formatted instruction fields.
Example (illustrative):
```
0      : 00                  NOP                 Z...    —
1      : 3E                  MVI A,#0x42         .....   —
3      : C3                  JMP $1234           .....   —
```
Notes:
- `D8` and `D16` placeholders in mnemonics are resolved to `#0xNN` and `#0xNNNN` respectively.
- `adr` placeholders are resolved to `$NNNN` (little-endian byte order in source).
- The instruction table controls `Flags`, `Function`, and `Length` fields.

## Data source: instruction set
The decoder loads records from `ins_set_maker/source/insSetReadable.txt`, expecting 5 fields separated by `##` per line:
```
Opcode##Mnemonic##Length##Flags##Function
```
Lines not matching this format are reported and skipped.

## Notes and limitations
- The disassembler performs a simple linear pass; it does not follow control flow or distinguish code from data.
- The PC shown increments by the instruction `Length` parsed from the table.
- File errors and malformed entries are printed to stdout by current implementation.
