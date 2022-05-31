package pages;

import io.cucumber.datatable.DataTable;

public class RegisterPage extends BasePage {

	public RegisterPage() {
		super(driver);
	}
	
	public boolean registrarse(DataTable dataRegistro) {
		return registrar(dataRegistro);
	}
	
}
