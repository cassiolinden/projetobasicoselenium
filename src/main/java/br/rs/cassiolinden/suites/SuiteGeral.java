package br.rs.cassiolinden.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.rs.cassiolinden.core.DriverFactory;
import br.rs.cassiolinden.pages.LoginPage;
import br.rs.cassiolinden.test.ContaTest;
import br.rs.cassiolinden.test.MovimentacaoTest;
import br.rs.cassiolinden.test.RemoverMovimentacaoContaTest;
import br.rs.cassiolinden.test.ResumoTest;
import br.rs.cassiolinden.test.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	public static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		page.logar("cassio@linden", "cassiao");
	}
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}
}
