package pages;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import utils.Constantes;

public class BasePage {
	
	protected static WebDriver driver;
	private static WebDriverWait wait;
	private static Actions action;
	
	static {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	}
	
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public static void navegar(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void cerrarNavegador() {
		driver.quit();
	}
	
	private WebElement find(String locator) {
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void click(String locator) {
		try { find(locator).click(); } catch (Exception e) { }
	}
	
	public void escribir(String locator, String textToWrite) {
		find(locator).clear();
		find(locator).sendKeys(textToWrite);
	}
	
	public String obtenerTexto(String locator) {
		return find(locator).getText();
	}
	
	public void seguimiento(String tipo, String accion, String idElemento) {
		if (tipo.equals("INF")) {
			System.out.println("[" + tipo + "] " + accion + " en el elemento con id: " + idElemento);
		} else if (tipo.equals("ERR")) {
			System.out.println("[" + tipo + "] Razon: " + accion);
		} else if (tipo.equals("MSG")) {
			System.out.println("[" + tipo + "] Detalle: " + accion);
		}
		
	}
	
	// Funcion para iniciar sesión
	protected boolean login(DataTable dataLogin) {
		try {
			List<List<String>> filas = dataLogin.cells();
			List<List<String>> filasSinCabecera = filas.subList(1, filas.size());
			filasSinCabecera.forEach(fila -> {
				String[] arregloFila = fila.get(0).toString().split("\\.");
				String idElemento = arregloFila[0];
				String tipoElemento = arregloFila[1];
				String valor = fila.get(1).toString();
				switch (tipoElemento) {
					case "input" :
						escribir(Constantes.INPUT_POR_ID.replace("element", idElemento), valor);
						seguimiento("INF", Constantes.INPUT_ACCION_ESCRIBIR, idElemento);
						break;
					case "button":
						click(Constantes.BUTTON_POR_ID.replace("element", idElemento));
						seguimiento("INF", Constantes.BUTTON_ACCION_CLICK, idElemento);
						break;
					case "label":
						seguimiento("MSG",obtenerTexto(Constantes.MENSAJE_POR_ID.replace("element", idElemento)), "");
						break;
				}
			});
			cerrarNavegador();
			return true;
		} catch (Exception e) {
			seguimiento("ERR", e.getMessage(), "");
			return false;
		}		
	}
	
	// Funcion para registrarse
	protected boolean registrar(DataTable dataRegistro) {
		try {
			List<List<String>> filas = dataRegistro.cells();
			List<List<String>> filasSinCabecera = filas.subList(1, filas.size());
			filasSinCabecera.forEach(fila -> {
				String[] arregloFila = fila.get(0).toString().split("\\.");
				String idElemento = arregloFila[0];
				String tipoElemento = arregloFila[1];
				String valor = fila.get(1).toString();
				switch (tipoElemento) {
					case "input" :
						escribir(Constantes.INPUT_POR_ID.replace("element", idElemento), valor);
						seguimiento("INF", Constantes.INPUT_ACCION_ESCRIBIR, idElemento);
						break;
					case "button":
						click(Constantes.BUTTON_POR_ID.replace("element", idElemento));
						seguimiento("INF", Constantes.BUTTON_ACCION_CLICK, idElemento);
						break;
					case "label":
						seguimiento("MSG",obtenerTexto(Constantes.MENSAJE_POR_ID.replace("element", idElemento)), "");
						break;
				}
			});
			cerrarNavegador();
			return true;
		} catch (Exception e) {
			seguimiento("ERR", e.getMessage(), "");
			return false;
		}		
	}
	
}
