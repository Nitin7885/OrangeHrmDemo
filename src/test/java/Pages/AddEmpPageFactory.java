package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class AddEmpPageFactory {
		
		WebDriver driver;
		
		@FindBy(id="txtUsername")
		WebElement txtuname;
		
		@FindBy(id = "txtPassword")
		WebElement txtpwd;
		
		@FindBy(id="btnLogin")
		WebElement btnlogin;

		@FindBy(id="firstName")
		WebElement firstname;
		
		@FindBy(name="lastName")
		WebElement lastname;
		
		@FindBy(how = How.XPATH, using="//label[contains(text(),'Photograph')]")
		WebElement img_button;
		
		@FindBy(how=How.CSS, using ="#user_name")
		WebElement username;
		
		@FindBy(how = How.ID,using="user_password")
		WebElement password;
		
		@FindBy(how= How.XPATH, using="//input[@id='re_password']")
		WebElement re_password;
		
		@FindBy(how=How.CSS, using="#btnSave")
		WebElement btnsave;
		
		@FindBy(how=How.ID, using="chkLogin")
		WebElement chklogin;
		
		/*public WebElement getChklogin() {
			return chklogin;
		}*/
		public void setTxtuname() {
			txtuname.sendKeys("Admin");;
		}

		public void setTxtpwd() {
			txtpwd.sendKeys("admin123");;
		}

		public void setBtnlogin() {
			btnlogin.click();
		}


		public AddEmpPageFactory(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}

		/*public WebDriver getDriver() {
			return driver;
		}

		public void setDriver(WebDriver driver) {
			this.driver = driver;
		}*/
		
		public void setChklogin() {
			chklogin.click();
		}
		
		public WebElement getFirstname() {
			return firstname;
		}

		public void setFirstname(String fname) {
			firstname.sendKeys(fname);
		}

		public WebElement getLastname() {
			return lastname;
		}

		public void setLastname(String lname) {
			lastname.sendKeys(lname);
		}

		public WebElement getImg_button() {
			return img_button;
		}

		public void setImg_button() {
			img_button.click();
		}

		public WebElement getUsername() {
			return username;
		}

		public void setUsername(String uname) {
			username.sendKeys(uname);
		}

		public WebElement getPassword() {
			return password;
		}

		public void setPassword(String pass) {
			password.sendKeys(pass);
		}

		public WebElement getRe_password() {
			return re_password;
		}

		public void setRe_password(String re_pass) {
			re_password.sendKeys(re_pass);
		}

		/*public WebElement getBtnsave() {
			return btnsave;
		}*/

		public void setBtnsave() {
			btnsave.click();
		}
		
		

}
