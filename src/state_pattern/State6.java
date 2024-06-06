package state_pattern;

public class State6 implements NumberState {

	private Number num;
	public State6(Number num) {
		this.num = num;
	}
	
	@Override
	public void isDigit() {
		num.setState(new State6(num));
	}

	@Override
	public void isDot() {
		num.setState(new StateError(num));
	}

	@Override
	public void isE() {
		num.setState(new StateError(num));
	}

	@Override
	public void isPlusOrMinus() {
		num.setState(new StateError(num));
	}

}
