package steps;

import io.cucumber.java.en.*;
import utils.Constantes;

import org.junit.Assert;
import io.cucumber.datatable.DataTable;

public class RegisterStep extends BaseStep {

	@Given("como usuario del sistema ingreso al registro")
	public void como_usuario_del_sistema_ingreso_al_registro() {
		navegar(Constantes.WEB_REGISTER_DEFAULT);
	}

	@When("registrar mis datos")
	public void registrar_mis_datos(DataTable dataRegistro) {
		Assert.assertTrue(registerPage.registrarse(dataRegistro));
	}
	
}
