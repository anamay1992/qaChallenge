package steps;

import io.cucumber.java.en.*;
import utils.Constantes;

import org.junit.Assert;
import io.cucumber.datatable.DataTable;

public class LoginStep extends BaseStep {
	
	@Given("como usuario del sistema ingreso al login")
	public void comoUsuarioDelSistemaIngresoAlLogin() {
		navegar(Constantes.WEB_LOGIN_DEFAULT);
	}

	@When("ingresar mis datos")
	public void ingresarMisDatos(DataTable dataLogin) {
		Assert.assertTrue(loginPage.iniciarSesion(dataLogin));
	}

}
