package br.rs.cassiolinden.suites;

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
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		page.setEmail("cassio@linden");
		page.setSenha("cassiao");
		page.entrar();
		page.resetar();
		DriverFactory.killDriver();
	}
	
}
