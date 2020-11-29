package interfaceApplication;

public class DoctoralCandidate implements StudentManagement,TeacherManagement {
	
	String name;     //姓名
	String sex;      //性别
	int age;         //年龄
	double tuition;     //每学期学费
	double salary;      //每月薪水
	double revenue;  //实际税收 
    double account;  //账户余额
    void setTuition(int tuition) {
		this.tuition = tuition;	
	}
	double getTuition() {
		return tuition;	
	}
	void setSalary(int salary) {
		this.salary =salary;	
	}
	double getSalary() {
		return salary;	
	}
	
	public void payTuition(double tuition) {
		account=account-tuition;
		System.out.println("操作成功！");
		System.out.println("账户余额："+account);
	}

	public void searchTuition(double tuition) {
		tuition=tuition-buzhu;
		System.out.println("本学期学费："+tuition);
		System.out.println("本学年学费："+2*tuition);
	}
	
	public void searchSalary(double salary,double revenue) {                       //必须在发放工资以后才能显示
		System.out.println("税收："+revenue);
		System.out.println("工资："+(salary-revenue));
		System.out.println("年实际工资："+12*(salary-revenue));
	}
	
	public void giveSalary(double salary,double revenue) {
		account=account+(salary-revenue);
		System.out.println("操作成功！");
		System.out.println("账户余额："+account);
		
	}

}