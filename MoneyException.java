package interfaceApplication;

public class MoneyException extends Exception{
	
	String message;
	public MoneyException(double d,double e) {
		message = "工资"+d+"是负数或少于学费，或学费"+e+"是负数，";
	}
	public String warnMess() {
		return message;
	}
}
