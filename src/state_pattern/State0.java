package state_pattern;

public class State0 implements NumberState {
	private Number num;
	public State0(Number num) {
		this.num = num;
	}

	@Override
	public void isDigit() {
		num.setState(new State1(num));
	}

	@Override
	public void isDot() {
		num.setState(new State2(num));
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
