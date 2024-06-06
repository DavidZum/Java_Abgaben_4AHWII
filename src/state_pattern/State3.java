package state_pattern;

public class State3 implements NumberState {

	private Number num;
	public State3(Number num) {
		this.num = num;
	}
	
	@Override
	public void isDigit() {
		num.setState(new State3(num));
	}

	@Override
	public void isDot() {
		num.setState(new StateError(num));
	}

	@Override
	public void isE() {
		num.setState(new State4(num));
	}

	@Override
	public void isPlusOrMinus() {
		num.setState(new StateError(num));
	}

}
