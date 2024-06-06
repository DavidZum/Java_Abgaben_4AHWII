package state_pattern;

import java.util.Scanner;

public class Number {
	private String number;
	private NumberState state;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public NumberState getState() {
		return state;
	}

	public void setState(NumberState state) {
		this.state = state;
	}
	
	public Number(String number) {
		this.number = number;
		this.state = new State0(this);
	}

	void checkNumber() {
		char[] c = number.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '.') {
				state.isDot();
			} else if (Character.isDigit(c[i])) {
				state.isDigit();
			} else if (c[i] == 'E' || c[i] == 'e') {
				state.isE();
			} else if (c[i] == '+' || c[i] == '-') {
				state.isPlusOrMinus();
			} else {
				state = new StateError(this);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Eine Zahl eingeben: ");
		
		Number num = new Number(s.nextLine());
		num.checkNumber();
		System.out.println(num.getState().getClass());
		s.close();
	}
}
