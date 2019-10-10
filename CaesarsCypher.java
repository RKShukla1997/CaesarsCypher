import java.util.*;
import java.io.*;

public class CaesarsCypher{

	public static String encrypt(String str,int n){
		char[] ch = str.toCharArray();
		String final_string = "";
		for(int i=0;i<ch.length;i++){
			if(ch[i] >='A' && ch[i] <= 'Z'){
				final_string += (char)(((((int)ch[i] - 64)+n)%26)+64);
			}
			else if(ch[i] >='a' && ch[i] <= 'z'){
				final_string += (char)(((((int)ch[i] - 97)+n)%26)+97);
			}
			else if(ch[i] == ' '){
				final_string+=' ';
			}
			else{
				final_string+=ch[i];
			}
		}
		return final_string;
	}

	public static String decrypt(String str,int n){

		char[] ch = str.toCharArray();
		String final_string = "";
		for(int i=0;i<ch.length;i++){
			if(ch[i] >='A' && ch[i] <= 'Z'){
				//final_string += (char)(((((int)ch[i]+n)-64)%26)+64);
				final_string += (char)(((((int)ch[i] - 64)-n)%26)+64);
			}
			else if(ch[i] >='a' && ch[i] <= 'z'){
				final_string += (char)(((((int)ch[i] - 97)-n)%26)+97);
			}
			else if(ch[i] == ' '){
				final_string+=' ';
			}
			else{
				final_string+=ch[i];
			}
		}
		return final_string;
	}

	public static boolean check(File file_to_read,File file_to_write) throws Exception{
		if(!file_to_write.exists()){
			file_to_write.createNewFile();
		}
		else{
			return true;
		}

		if(!file_to_read.exists()){
			throw new Exception("Input file does not Exists");
		}
		else{
			return true;
		}
	}

	public static void encrypt_read_write(File file_to_read,File file_to_write,int n) throws Exception {
		String encrypted =  "";
		BufferedReader br = new BufferedReader(new FileReader(file_to_read));
		String x;
		FileWriter fw = new FileWriter(file_to_write);
		while((x=br.readLine()) != null)
			encrypted += CaesarsCypher.encrypt(x,n) + "\n";

		fw.write(encrypted + "\n");
		fw.close();

	}

	public static void decrypt_read_write(File file_to_read,File file_to_write,int n) throws Exception {
		String decrypted =  "";
		BufferedReader br = new BufferedReader(new FileReader(file_to_read));
		String x;
		FileWriter fw = new FileWriter(file_to_write);
		while((x=br.readLine()) != null)
			decrypted += CaesarsCypher.decrypt(x,n) + "\n";

		fw.write(decrypted + "\n");
		fw.close();

	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String inputFile = args[0];
		String outputFile = args[1];
		File file_to_read = new File(inputFile);
		File file_to_write = new File(outputFile);
		int n=1;

		if(check(file_to_read,file_to_write)){
            if(args.length == 2){
                CaesarsCypher.encrypt_read_write(file_to_read,file_to_write,n);
            }else if (args.length == 4) {
            	n = Integer.parseInt(args[3]);
                String operation = args[2];
                if(operation.equals("encrypt")) {
                    CaesarsCypher.encrypt_read_write(file_to_read,file_to_write,n);
                }else{
                    CaesarsCypher.decrypt_read_write(file_to_read,file_to_write,n);
                }
            }else if (args.length == 3) {
            	String operation = args[2];
                if(operation.equals("encrypt")) {
                    CaesarsCypher.encrypt_read_write(file_to_read,file_to_write,n);
                }else{
                    CaesarsCypher.decrypt_read_write(file_to_read,file_to_write,n);
                }
       }

    }

		// System.out.println("Enter the String to Encrypt: ");
		// String input_string = sc.nextLine();
		// System.out.println("Enter the number to shift: ");
		// int n = sc.nextInt();
		// String encrypted = CaesarsCypher.encrypt(input_string,n);
		// System.out.println(encrypted);
		// String decrypted = CaesarsCypher.decrypt(encrypted,n);
		// System.out.println(decrypted);

	}
} 