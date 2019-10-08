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

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String to Encrypt: ");
		String input_string = sc.nextLine();
		System.out.println("Enter the number to shift: ");
		int n = sc.nextInt();
		String encrypted = CaesarsCypher.encrypt(input_string,n);
		System.out.println(encrypted);
		String decrypted = CaesarsCypher.decrypt(encrypted,n);
		System.out.println(decrypted);

	}
} 