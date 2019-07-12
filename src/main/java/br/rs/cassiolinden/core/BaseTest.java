package br.rs.cassiolinden.core;
import static br.rs.cassiolinden.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.rs.cassiolinden.pages.LoginPage;

public class BaseTest {
	@Rule
	public TestName testname = new TestName();
	
	public static LoginPage page = new LoginPage();
	
	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		page.logar("cassio@linden", "cassiao");
	}
	
//	@After
//	public void finaliza() {
//		DriverFactory.killDriver();
//	}
	
	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target"+File.separator+"screenshot"+File.separator+testname.getMethodName()+".jpg"));
		
		if(Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}
		
	}
}
