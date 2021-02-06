package week08;

public class AbstractExampleDriver {
	public static void main(String[] args) {
		SalariedEmployee sally = new SalariedEmployee(1,"Sally May",120000.56);
		HourlyEmployee joe = new HourlyEmployee(2,"Joe Cat",36.50,40);
		Payroll payroll = new Payroll();
		payroll.cutWeeklyCheck(sally);payroll.cutWeeklyCheck(joe);
		}
	}
