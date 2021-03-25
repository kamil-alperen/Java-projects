
public class Instruction {
	long address; // buyruk adresi
	String instruction; // buyruk adresinden sonraki kisim
	String operation; // hangi islem
	char type; // buyruk turu
	static Registers[] regs = new Registers[32]; // her biri 32 bit
	static DataMemory[] ram = new DataMemory[(int)Math.pow(2, 18)]; // her biri 32 bit(4 adrese sahip)
	static int program_counter = 0; // program sayaci
	public Instruction(long adress,String instruction) {
		this.address = adress;
		this.instruction = instruction;
		determine_type();
	}
	public void initial() {
		for(int i = 0;i < 32;i++) {
			regs[i] = new Registers();
			regs[i].data = 0;
		}
		for(int i = 0;i < ram.length;i++) {
			ram[i] = new DataMemory();
			ram[i].data = 0;
		}
		program_counter = 0;
	}
	public static int convert_immediate(String imm) {
		int total = 0;
		int count = 0;
		for(int i = imm.length()-1;i >= 1;i--) {
			if(imm.charAt(i) > 64)total += (imm.charAt(i)-55) * Math.pow(16, count);
			else total += (imm.charAt(i)-'0') * Math.pow(16, count);
			count++;
		}
		if(imm.charAt(0) == '-')total = 0 - total;
		else {
			if(imm.charAt(0) > 64)total += (imm.charAt(0)-55) * Math.pow(16, count);
			else total += (imm.charAt(0)-'0') * Math.pow(16, count);
		}
		return total;
	}
	public void execute_instruction() {
		if(type == 'R')execute_register();
		else if(type == 'I')execute_immediate();
		else if(type == 'B')execute_branch();
		else if(type == 'S')execute_store();
		else if(type == 'J')execute_jump();
		regs[0].data = 0;
	}
	public void execute_register() {
		String parameters = instruction.substring(instruction.indexOf(" ")+1);
		String s_rd = parameters.substring(0,parameters.indexOf(" "));
		parameters = parameters.substring(parameters.indexOf(" ")+1);
		String s_sc1 = parameters.substring(0,parameters.indexOf(" "));
		parameters = parameters.substring(parameters.indexOf(" ")+1);
		String s_sc2 = parameters;
		s_rd = s_rd.replace("x", "");
		s_sc1 = s_sc1.replace("x", "");
		s_sc2 = s_sc2.replace("x", "");
		int rd_address = Integer.parseInt(s_rd);
		int sc1_address = Integer.parseInt(s_sc1);
		int sc2_address = Integer.parseInt(s_sc2);
		if(operation.equals("add")) {
			regs[rd_address].data = regs[sc1_address].data + regs[sc2_address].data;
		}
		else if(operation.equals("sub")) {
			regs[rd_address].data = regs[sc1_address].data - regs[sc2_address].data;
		}
		else if(operation.equals("xor")) {
			regs[rd_address].data = regs[sc1_address].data ^ regs[sc2_address].data;
		}
		else if(operation.equals("and")) {
			regs[rd_address].data = regs[sc1_address].data & regs[sc2_address].data;
		}
		else if(operation.equals("srl")) {
			regs[rd_address].data = regs[sc1_address].data >>> regs[sc2_address].data;
		}
		else if(operation.equals("sra")) {
			regs[rd_address].data = regs[sc1_address].data >> regs[sc2_address].data;
		}
		program_counter += 4;
	}
	public void execute_immediate() {
		String parameters = instruction.substring(instruction.indexOf(" ")+1);
		String s_rd = parameters.substring(0,parameters.indexOf(" "));
		parameters = parameters.substring(parameters.indexOf(" ")+1);
		String s_sc = parameters.substring(0,parameters.indexOf(" "));
		parameters = parameters.substring(parameters.indexOf(" ")+1);
		String s_immediate = parameters;
		s_rd = s_rd.replace("x", "");
		s_sc = s_sc.replace("x", "");
		int rd_address = Integer.parseInt(s_rd);
		int sc_address = Integer.parseInt(s_sc);
		int immediate = convert_immediate(s_immediate);
		if(operation.equals("addi")) {
			regs[rd_address].data = regs[sc_address].data + immediate; 
			program_counter += 4;
		}
		else if(operation.equals("subi")) {
			regs[rd_address].data = regs[sc_address].data - immediate;
			program_counter += 4;
		}
		else if(operation.equals("lw")) {
			regs[rd_address].data = ram[regs[sc_address].data + immediate].data;
			program_counter += 4;
		}
		else if(operation.equals("lb")) {
			int memory_data = ram[regs[sc_address].data >> 24 + immediate].data >> 24;
			String binary_memory_data = Integer.toBinaryString(memory_data);
			int reg_data = regs[rd_address].data;
			String binary_reg_data = Integer.toBinaryString(reg_data);
			String changed = binary_reg_data.substring(0,24) + binary_memory_data.substring(24);
			regs[rd_address].data = Integer.parseInt(changed);
			program_counter += 4;
		}
		else if(operation.equals("xori")) {
			regs[rd_address].data = regs[sc_address].data ^ immediate;
			program_counter += 4;
		}
		else if(operation.equals("jalr")) {
			program_counter = regs[sc_address].data + immediate;
		}
		else if(operation.equals("slti")) {
			if(regs[sc_address].data < immediate) regs[rd_address].data = 1;
			else regs[rd_address].data = 0;
			program_counter += 4;
		}
		else if(operation.equals("srai")) {
			regs[rd_address].data = regs[sc_address].data >> immediate;
			program_counter += 4;
		}
	}
	public void execute_branch() {
		String parameters = instruction.substring(instruction.indexOf(" ")+1);
		String s_sc1 = parameters.substring(0,parameters.indexOf(" "));
		parameters = parameters.substring(parameters.indexOf(" ")+1);
		String s_sc2 = parameters.substring(0,parameters.indexOf(" "));
		parameters = parameters.substring(parameters.indexOf(" ")+1);
		String s_immediate = parameters;
		s_sc1 = s_sc1.replace("x", "");
		s_sc2 = s_sc2.replace("x", "");
		int sc1_address = Integer.parseInt(s_sc1);
		int sc2_address = Integer.parseInt(s_sc2);
		int immediate = convert_immediate(s_immediate);
		if(operation.equals("beq")) {
			if(regs[sc1_address].data == regs[sc2_address].data)program_counter += immediate * 2;
			else program_counter += 4;
		}
		else if(operation.equals("bge")) {
			if(regs[sc1_address].data >= regs[sc2_address].data)program_counter += immediate * 2;
			else program_counter += 4;
		}
		else if(operation.equals("blt")) {
			if(regs[sc1_address].data < regs[sc2_address].data)program_counter += immediate * 2;
			else program_counter += 4;
		}
	}
	public void execute_store() {
		String parameters = instruction.substring(instruction.indexOf(" ")+1);
		String s_sc1 = parameters.substring(0,parameters.indexOf(" "));
		parameters = parameters.substring(parameters.indexOf(" ")+1);
		String s_sc2 = parameters.substring(0,parameters.indexOf(" "));
		parameters = parameters.substring(parameters.indexOf(" ")+1);
		String s_immediate = parameters;
		s_sc1 = s_sc1.replace("x", "");
		s_sc2 = s_sc2.replace("x", "");
		int sc1_address = Integer.parseInt(s_sc1);
		int sc2_address = Integer.parseInt(s_sc2);
		int immediate = convert_immediate(s_immediate);
		if(operation.equals("sw")) {
			ram[regs[sc2_address].data + immediate].data = regs[sc1_address].data;
		}
		else if(operation.equals("sb")) {
			int reg_data = regs[sc1_address].data >> 24;
			String binary_reg_data = Integer.toBinaryString(reg_data);
			int memory_data = ram[regs[sc2_address].data + immediate].data;
			String binary_memory_data = Integer.toBinaryString(memory_data);
			String changed = binary_memory_data.substring(0,24) + binary_reg_data.substring(24);
			ram[regs[sc2_address].data + immediate].data = Integer.parseInt(changed);
		}
		program_counter += 4;
	}
	public void execute_jump() {
		String parameters = instruction.substring(instruction.indexOf(" ")+1);
		String s_rd = parameters.substring(0,parameters.indexOf(" "));
		parameters = parameters.substring(parameters.indexOf(" ")+1);
		String s_immediate = parameters;
		s_rd = s_rd.replace("x", "");
		int rd_address = Integer.parseInt(s_rd);
		int immediate = convert_immediate(s_immediate);
		regs[rd_address].data = program_counter + 4;
		program_counter += immediate * 2;
	}
	public void determine_type() {
		String operate = "";
		if(instruction.equals(""))return;
		if(!instruction.equals("SON"))operate = instruction.substring(0,instruction.indexOf(" "));
		else operate = instruction;
		switch(operate) {
			case "add":
				type = 'R';
				operation = "add";
				break;
			case "sub":
				type = 'R';
				operation = "sub";
				break;
			case "xor":
				type = 'R';
				operation = "xor";
				break;
			case "and":
				type = 'R';
				operation = "and";
				break;
			case "srl":
				type = 'R';
				operation = "srl";
				break;
			case "sra":
				type = 'R';
				operation = "sra";
				break;
			case "addi":
				type = 'I';
				operation = "addi";
				break;
			case "subi":
				type = 'I';
				operation = "subi";
				break;
			case "lw":
				type = 'I';
				operation = "lw";
				break;
			case "lb":
				type = 'I';
				operation = "lb";
				break;
			case "xori":
				type = 'I';
				operation = "xori";
				break;
			case "jalr":
				type = 'I';
				operation = "jalr";
				break;
			case "slti":
				type = 'I';
				operation = "slti";
				break;
			case "srai":
				type = 'I';
				operation = "srai";
				break;
			case "beq":
				type = 'B';
				operation = "beq";
				break;
			case "bge":
				type = 'B';
				operation = "bge";
				break;
			case "blt":
				type = 'B';
				operation = "blt";
				break;
			case "sw":
				type = 'S';
				operation = "sw";
				break;
			case "sb":
				type = 'S';
				operation = "sb";
				break;
			case "jal":
				type = 'J';
				operation = "jal";
				break;
			case "SON" :
				type = ' ';
				operation = "SON";
				break;
			default:
				break;
		}
	}
}
