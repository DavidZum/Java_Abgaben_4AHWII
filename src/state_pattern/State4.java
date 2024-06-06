package state_pattern;

public class State4 implements NumberState {

	private Number num;
	public State4(Number num) {
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
		num.setState(new State5(num));
	}

}
