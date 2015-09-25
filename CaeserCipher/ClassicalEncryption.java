
import java.util.Scanner;

import javax.xml.ws.Response;

public class ClassicalEncryption {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaeserCipher();
	}
	
	public static int mod26 (int ch) {
		 //recursion to prevent potential "too negative"
		return ch >= 0 ? ch % 26 : mod26(26 + ch);
	}
	
	public static void CaeserCipher() {
		//initialize a Scanner		
		Scanner in = new Scanner(System.in);
		//Summary
		System.out.println("This program encrypts and decrypts messages using the Caeser Cipher.");
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
		input = in.nextLine();
		for (int n = 0; n < 26; n++) {
			String output = "";
			for (int i = 0; i < input.length(); i++) {
				//decides whether encode or decode efficiently using "+" "-"
				output += (char) (mod26(input.charAt(i) + encodeSign * n - 'a') + 'a');
			}
			System.out.println("n = " + n + ": " + output);
		}
		in.close();
	}
}
