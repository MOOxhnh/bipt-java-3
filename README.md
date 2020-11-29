# 计192 2019311380 徐昊
# Java 实验
Java课程作业项目仓库
# 阅读程序
## 实验目的
1.掌握Java中抽象类和抽象方法的定义；
2.掌握Java中接口的定义，熟练掌握接口的定义形式以及接口的实现方法;
3.了解异常的使用方法，并在程序中根据输入情况做异常处理;
## 实验内容
某学校为了给学生提供勤工俭学机会，也减轻授课教师的部分压力，准许博士研究生参与课程的助教工作。此时，该博士研究生有双重身份：学生和助教教师。
1.设计两个管理接口：学生管理接口和教师管理接口。学生接口必须包括缴纳学费、查学费的方法；教师接口包括发放薪水和查询薪水的方法。
2.设计博士研究生类，实现上述的两个接口，该博士研究生应具有姓名、性别、年龄、每学期学费、每月薪水等属性。（其他属性及方法，可自行发挥）
3.编写测试类，并实例化至少两名博士研究生，统计他们的年收入和学费。根据两者之差，算出每名博士研究生的年应纳税金额（国家最新工资纳税标准，请自行检索）。
## 实验要求
1.在博士研究生类中实现各个接口定义的抽象方法;
2.对年学费和年收入进行统计，用收入减去学费，求得纳税额；
3.国家最新纳税标准（系数），属于某一时期的特定固定值，与实例化对象没有关系，考虑如何用static final修饰定义。
4.实例化研究生类时，可采用运行时通过main方法的参数args一次性赋值，也可采用Scanner类实现运行时交互式输入。
5.根据输入情况，要在程序中做异常处理。
## 实验过程
1.首先创建一个package：interfaceApplication。
2.在包中创建两个接口StudentManagement和TeacherManagement，分别设定博士研究生作为学生和助教的两类行为标准。 3.并在包中实例化一个类DoctoralCandidate来实现上述两个接口。实例化一个MoneyException异常类来进行对收税金的判断。实例化主类Test_JavaProgram对用户输入进行存储和操作。
4.StudentManagement类中：
(a)定义常量buzhu
(b)设计两个方法：缴纳学费和查询学费
5.TeacherManagement类中：
(a)定义常量sanxianyijin
(b)设计两个方法：查询工资和发放工资
6.DoctoralCandidate类中：
(a)定义基本信息变量
(b)实现两个接口四个方法
7.Test_JavaProgram类中：
(a)首先定义全局变量和录入数组
(b)设计三个循环：第一个循环依次录入个人信息，第二个循环判断录入工资和学费是否正确，第三个循环执行方法操作
(c)设计税收算法方法
(d)设计异常抛出方法
8.MoneyException类中：
(a)创建 MoneyException类为Exception类子类
(b)创建 warnMess方法用来返回错误提示
9.在实验类中创建DoctoralCandidate的对象Doctor，创建TeacherManagement的对象tea，创建StudentManagement的对象Stu,通过接口回调对实现接口的方法进行调用
## 核心方法  

1.revenue税收计算方法
```
public final static double giveRevenue(double salary,double tuition) {
		tuition=tuition/6;                                                             
		revenue=TeacherManagement.sanxianyijin+StudentManagement.buzhu-tuition; 
		if(revenue<=5000.00) {                           
			return revenue*0.03;
		}
		else if(revenue>5000.00 && revenue<=12000.00) {  
			return (revenue-5000)*0.1+1500;
		}
		else if(revenue>12000.00 && revenue<=25000.00) { 
			return (revenue-12000)*0.2+2200;
		}
		else if(revenue>25000.00 && revenue<=35000.00) { 
			return (revenue-25000)*0.25+4800;
		}
		else if(revenue>35000.00 && revenue<=55000.00) { 
			return (revenue-35000)*0.3+7300;
		}
		else if(revenue>55000.00 && revenue<=80000.00) { 
			return (revenue-55000)*0.35+13300;
		}
		else if(revenue>80000.00) {                      
			return (revenue-80000)*0.45+22050;
		}
		return 0;
	}

``` 
2.异常处理调用和返回方法
```
public static void giveSalary(double d,double e) throws MoneyException{
		if(d<0||e<0||d<e) {
			throw new MoneyException(d,e);
		}
	}
public MoneyException(double d,double e) {
		message = "工资"+d+"是负数或少于学费，或学费"+e+"是负数，";
	}
public String warnMess() {
		return message;
	}
``` 
3.学费缴费方法
```
public void payTuition(double tuition) {
		account=account-tuition;
		System.out.println("操作成功！");
		System.out.println("账户余额："+account);
	}
``` 
4.学费查询方法
``` 
public void searchTuition(double tuition) {
		tuition=tuition-buzhu;
		System.out.println("本学期学费："+tuition);
		System.out.println("本学年学费："+2*tuition);
	}
``` 
5.工资查询方法
``` 
public void searchSalary(double salary,double revenue) {                       
		System.out.println("工资："+(salary-revenue));
		System.out.println("年实际工资："+12*(salary-revenue));
	}
``` 
6.工资发放方法
``` 
public void giveSalary(double salary,double revenue) {
		account=account+(salary-revenue);
		System.out.println("操作成功！");
		System.out.println("账户余额："+account);
	}
``` 
## 实验结果
1:
![1](https://github.com/MOOxhnh/bipt-java-3/blob/main/1.png)  
2:
![2](https://github.com/MOOxhnh/bipt-java-3/blob/main/2.png)
## 实验感想  
通过本次实验，我学会了接口和方法的使用，回顾了数组的声明和使用：
首先创建接口来定义一些抽象方法，然后再通过实例化类来实现这些方法，在实验类中构造接口对象来实现接口回调，调用属于接口定义的原方法。
实验中，通过数组存储数据，并对存储的数据进行计算和操作来实现实验目的。
最后，在输入数据的方法使用try-catch进行异常处理。 本次实验不足：
1.异常处理的覆盖面不够全面
2.系统还差一些细节不够完善，会在日后维护中进行改进
