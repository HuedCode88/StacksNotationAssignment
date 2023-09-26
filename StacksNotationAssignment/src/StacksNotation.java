import java.util.Scanner;
public class StacksNotation {
	 static Stack<Character> Postfix = new Stack<>();
	
	public static String Postfix(String infix) {
		String returnable = "";
		//if letter
		for(int i=0; i<infix.length();i++) {
			if(Character.isLetterOrDigit(infix.charAt(i))) {
				returnable+=infix.charAt(i);
			}
			
			if((infix.charAt(i)=='+')) {
				if((!Postfix.isEmpty())&&(Postfix.peek()=='*')) {
					while(!Postfix.isEmpty()) {
						returnable+=Postfix.peek().toString();
						Postfix.pop();
						}
					Postfix.push(infix.charAt(i));
					}
					else {
					Postfix.push(infix.charAt(i));
					}
				}
			//Plus^			
			if((infix.charAt(i)=='*')) {
				Postfix.push(infix.charAt(i));
				}
			//Mult^	
			if((infix.charAt(i)=='(')) {
				Postfix.push(infix.charAt(i));
				}
			
			if((infix.charAt(i)==')')) {
				if(!Postfix.isEmpty()) {
					while(!(Postfix.peek()=='(')) {
						returnable+=Postfix.peek().toString();
						Postfix.pop();
						}
					Postfix.pop();
					}
				}
		}
			
			while(!Postfix.isEmpty()) {
				returnable+=Postfix.peek().toString();
				Postfix.pop();
			}
		return returnable;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input the infix notation.");
		String infix =scan.next();
		System.out.println(Postfix(infix));
		
		
	}

}
