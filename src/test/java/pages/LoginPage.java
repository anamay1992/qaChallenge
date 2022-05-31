package pages;

import io.cucumber.datatable.DataTable;

public class LoginPage extends BasePage {
	
	public LoginPage() {
		super(driver);
	}
	
	public boolean iniciarSesion(DataTable dataLogin) {
		return login(dataLogin);
	}
	
}
