package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features",
	glue = "steps",
	plugin = { "json:target/cucumber_report/cucumber.json" },
	monochrome = true,
	tags = "@challengeQA and @registrar"
)

public class Runner {
	
	@AfterClass
	public static void cleanDriver() {
		try {	
			BasePage.cerrarNavegador();
			String[] cmd = { "cmd.exe", "/c", "npm run report" };
	        Runtime.getRuntime().exec(cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
}
