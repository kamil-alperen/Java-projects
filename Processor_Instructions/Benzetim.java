import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// To run : java Benzetim program.txt ornek-config.txt
public class Benzetim {
	static List<InstructMemory> instruct_m;
	static Instruction ins = new Instruction(0,"");
	static int r1,i1,b1,s1,j1,frequency1,r2,i2,b2,s2,j2,frequency2;
	static int cycle1,cycle2;
	public Benzetim() {
		ins.initial();
		instruct_m = new ArrayList<>((int)Math.pow(2, 18));
	}
	public static int determine_Address(String address) {
		String hex_num = address.substring(address.indexOf("x")+1);
		int decimal = 0;
		int exponent = 0;
		for(int i = hex_num.length()-1;i >= 0;i--) {
			if(hex_num.charAt(i) > 96)decimal += (hex_num.charAt(i)-87) * Math.pow(16, exponent);
			else decimal += (hex_num.charAt(i)-'0') * Math.pow(16, exponent);
			exponent++;
		}
		return decimal;
	}
	public int execute(int signal,FileWriter fw) {
		String operation = "";
		int instruct_address = 0;
		int total = 0;
		InstructMemory mem = null;
		while(!operation.equals("SON")) {
			total++;
			mem = instruct_m.get(instruct_address);
			ins = new Instruction(mem.address,mem.instruction);
			switch(ins.type) {
				case 'R':
					cycle1 += r1;
					cycle2 += r2;
					break;
				case 'I':
					cycle1 += i1;
					cycle2 += i2;
					break;
				case 'B':
					cycle1 += b1;
					cycle2 += b2;
					break;
				case 'S':
					cycle1 += s1;
					cycle2 += s2;
					break;
				case 'J':
					cycle1 += j1;
					cycle2 += j2;
					break;
			}
			ins.execute_instruction();
			if(signal == 1)
				try {
					fw.write(ins.instruction+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(instruct_m.size() > instruct_address+1 && instruct_m.get(instruct_address+1).address == ins.program_counter) {
				instruct_address += 1;
			}
			else {
				for(int i = 0;i < instruct_m.size();i++) {
					if(instruct_m.get(i).address == ins.program_counter) {
						instruct_address = i;
						break;
					}
				}
			}
			operation = ins.operation;
		}
		return total;
	}
	public void print_registers(FileWriter f) {
		for(int i = 0;i < ins.regs.length;i++) {
			try {
				f.write(ins.regs[i].data+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Benzetim main = new Benzetim();
		File assembly = new File(args[0]);
		File file1 = new File(args[1]);
		File file2 = null;
		File result = new File("sonuclar.txt");
		File output = new File("cikti.txt");
		if(args.length > 2) {
			file2 = new File(args[2]);
		}
		try {
			result.createNewFile();
			output.createNewFile();
			Scanner scan = new Scanner(assembly);
			int idx = 0;
			while(scan.hasNextLine()) {
				String sentence = scan.nextLine();
				idx = sentence.indexOf(" ");
				if(idx != -1) {
					long address = determine_Address(sentence.substring(0, idx));
					String instruction = sentence.substring(idx+1);
					InstructMemory im = new InstructMemory(address,instruction);
					instruct_m.add(im);
				}
			}
			scan.close();
			scan = new Scanner(file1);
			scan.next();
			frequency1 = Integer.parseInt(scan.next());
			scan.nextLine();
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				char type = line.charAt(0);
				line = line.substring(line.indexOf(" ")+1);
				int bbc = Integer.parseInt(line);
				switch(type) {
					case 'R':
						r1  = bbc;
						break;
					case 'I':
						i1 = bbc;
						break;
					case 'B':
						b1 = bbc;
						break;
					case 'S':
						s1 = bbc;
						break;
					case 'J':
						j1 = bbc;
						break;
				}
			}
			scan.close();
			
			if(file2 != null) {
				scan = new Scanner(file2);
				scan.next();
				frequency2 = Integer.parseInt(scan.next());
				scan.nextLine();
				while(scan.hasNextLine()) {
					String line = scan.nextLine();
					char type = line.charAt(0);
					line = line.substring(line.indexOf(" ")+1);
					int bbc = Integer.parseInt(line);
					switch(type) {
						case 'R':
							r2  = bbc;
							break;
						case 'I':
							i2 = bbc;
							break;
						case 'B':
							b2 = bbc;
							break;
						case 'S':
							s2 = bbc;
							break;
						case 'J':
							j2 = bbc;
							break;
					}
				}
				
			}
			scan.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int total = main.execute(0,null);
		FileWriter fw;
		try {
			fw = new FileWriter(output);
			main.print_registers(fw);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BigDecimal bd_cycle1 = new BigDecimal(cycle1+"");
		BigDecimal bd_freq1 = new BigDecimal(frequency1 * 1000000+"");
		BigDecimal one = new BigDecimal("1");
		BigDecimal time1 = one.divide(bd_freq1);
		time1 = bd_cycle1.multiply(time1);
		if(file2 == null) {
			System.out.println("Toplam cevrim sayisi : " + cycle1);
			System.out.println("Toplam buyruk sayisi : " + (total - 1));
			System.out.println("Yurutme zamani : " + time1 + " saniye");
		}
		else {
			BigDecimal bd_cycle2 = new BigDecimal(cycle2+"");
			BigDecimal bd_freq2 = new BigDecimal(frequency2 * 1000000+"");
			BigDecimal time2 = one.divide(bd_freq2);
			time2 = bd_cycle2.multiply(time2);
			BigDecimal compare = time2.divide(time1);
			System.out.println("Islemci1’in basarimi Islemci2’nin basarimindan "+ compare +" kat daha yuksek.");
		}
		InstructMemory im;
		instruct_m.clear();
		ins.initial();
		/*
		 *  Immediate values are hexadecimal !
		 */
		im = new InstructMemory(0,"addi x4 x0 A");
		instruct_m.add(im);
		im = new InstructMemory(4,"jal x2 14");
		instruct_m.add(im);
		im = new InstructMemory(8,"addi x5 x0 3");
		instruct_m.add(im);
		im = new InstructMemory(12,"xori x13 x3 3");
		instruct_m.add(im);
		im = new InstructMemory(16,"beq x13 x5 A");
		instruct_m.add(im);
		im = new InstructMemory(20,"addi x14 x0 1");   
		instruct_m.add(im);
		im = new InstructMemory(24,"SON"); 
		instruct_m.add(im);
		im = new InstructMemory(36,"addi x14 x0 0"); 
		instruct_m.add(im);
		im = new InstructMemory(40,"SON"); 
		instruct_m.add(im);
		im = new InstructMemory(44,"addi x8 x0 1");
		instruct_m.add(im);
		im = new InstructMemory(48,"blt x4 x8 1E");
		instruct_m.add(im);
		im = new InstructMemory(52,"addi x9 x4 0");
		instruct_m.add(im);
		im = new InstructMemory(56,"subi x4 x4 1");
		instruct_m.add(im);
		im = new InstructMemory(60,"sw x9 x1 0");
		instruct_m.add(im);
		im = new InstructMemory(64,"addi x1 x1 4");
		instruct_m.add(im);
		im = new InstructMemory(68,"jal x10 -A");
		instruct_m.add(im);
		im = new InstructMemory(72,"subi x1 x1 4");
		instruct_m.add(im);
		im = new InstructMemory(76,"lw x11 x1 0");
		instruct_m.add(im);
		im = new InstructMemory(80,"addi x12 x3 0");
		instruct_m.add(im);
		im = new InstructMemory(84,"beq x11 x8 8");
		instruct_m.add(im);
		im = new InstructMemory(88,"add x3 x3 x12"); 
		instruct_m.add(im);
		im = new InstructMemory(92,"subi x11 x11 1"); 
		instruct_m.add(im);
		im = new InstructMemory(96,"bge x11 x8 -6"); 
		instruct_m.add(im);
		im = new InstructMemory(100,"beq x1 x0 A");
		instruct_m.add(im);
		im = new InstructMemory(104,"jalr x0 x10 0");
		instruct_m.add(im);
		im = new InstructMemory(108,"addi x3 x0 1");
		instruct_m.add(im);
		im = new InstructMemory(112,"beq x1 x0 4");
		instruct_m.add(im);
		im = new InstructMemory(116,"jalr x0 x10 0");
		instruct_m.add(im);
		im = new InstructMemory(120,"jalr x0 x2 0");
		instruct_m.add(im);
		FileWriter result_fw;
		try {
			result_fw = new FileWriter(result);
			result_fw.write("Sırasıyla çalışan buyruklar : \n");
			main.execute(1,result_fw);
			result_fw.write("\nSONUÇ (x14 yazmacındaki değer) = "+ins.regs[14].data+" \n\n");
			result_fw.write("Sırasıyla register'daki değerler : \n");
			main.print_registers(result_fw);
			result_fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
