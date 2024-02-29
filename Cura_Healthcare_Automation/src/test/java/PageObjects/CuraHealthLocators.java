package PageObjects;

import org.openqa.selenium.By;

public class CuraHealthLocators 
{
	public static By btn_makeAppointment = By.xpath("//a[@id='btn-make-appointment']");
	public static By txt_header = By.xpath("//h1[text()='CURA Healthcare Service']");
	public static By txt_login = By.xpath("//h2[text()='Login']");
	public static By txt_user = By.xpath("//input[@name='username']");
	public static By txt_pass = By.xpath("//input[@name='password']");
	public static By btn_Login = By.xpath("//button[@id='btn-login']");
	public static By dropdown_facility = By.xpath("//select[@id='combo_facility']");
	public static By radio_recommendation = By.xpath("//input[@id='chk_hospotal_readmission']");
	public static By radio_HealthCare_Program(String text) {return By.xpath("//input[@value='"+text+"']");}
	public static By visit_date = By.xpath("//input[@name='visit_date']");
	public static By slt_day(int day) {return By.xpath("//div[@class='datepicker-days']//tr/td[@class='day' and text()='"+day+"']");}
	public static By txt_comment= By.xpath("//textarea[@placeholder='Comment']");
	public static By btn_bookAppnment = By.xpath("//button[@id='btn-book-appointment']");
	public static By txt_confrmation = By.xpath("//h2[text()='Appointment Confirmation']");
	public static By btn_toggleMenu = By.xpath("//a[@id='menu-toggle']");
	public static By btn_history= By.xpath("//a[text()='History']");
	public static By btn_logout = By.xpath("//a[text()='Logout']");
	public static By btn_nextMonth = By.xpath("//div[@class='datepicker-days']//th[@class='next']");
	

}
