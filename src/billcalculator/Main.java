package billcalculator;

public class Main {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		double interest = calculator.calculator("2017-09-04", "2018-09-04", 20000,0.0005);
		//������/������/����/����
		System.out.println(interest);
	}

}
