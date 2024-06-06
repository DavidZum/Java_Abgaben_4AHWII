package state_pattern;

public class StateError implements NumberState {

	private Number num;
	public StateError(Number num) {
		this.num = num;
	}
	
	@Override
	public void isDigit() {
		num.setState(new StateError(num));
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
