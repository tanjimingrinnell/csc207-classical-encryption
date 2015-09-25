
import java.util.Scanner;

public class VigenèreCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(codeChar(2, 1, "ews", "x"));
		VigenereCipher();
	}
	
	public static int mod26 (int ch) {
		 //recursion to prevent potential "too negative"
		return ch >= 0 ? ch % 26 : mod26(26 + ch);
	}
	
	//encode/decode a single character
	public static char codeChar (int i, int encodeSign, String str, String key) {
		return (char) (mod26((str.charAt(i) + encodeSign * (key.charAt(i % key.length()) - 'a')) - 'a') + 'a');
	}
	
	public static void VigenereCipher() {
		//initialize a Scanner		
		Scanner in = new Scanner(System.in);
		//Summary
		System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher.");
		//encode or decode
		System.out.println("Would you like to encode or decode a message?");
		String input = in.nextLine();
		//This will decide encode or decode
		int encodeSign = 1;
		if (input.equals("encode")) {
			encodeSign = 1;
		} else if (input.equals("decode")){
			encodeSign = -1;
		} else {
			System.out.println("Invalid input, program terminated");
			in.close();
			return;
		}
		//choose a string
		System.out.println("Enter the string to " + (encodeSign == 1 ? "encode" : "decode") + ":");
		String str = in.nextLine();
		//choose a key
		System.out.println("Enter the key:");
		String key = in.nextLine();
		String output = "";
		for (int i = 0; i < str.length(); i++) {
			//encode/decode each character individually 
			output += codeChar(i, encodeSign, str, key);
		}
		System.out.println(output);
		in.close();
	}

}
