package steps;

import org.openqa.selenium.support.PageFactory;
import pages.*;

public class BaseStep extends BasePage {
	
	public BaseStep() {
		super(driver);
	}
	
	protected LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	protected RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
	
}
