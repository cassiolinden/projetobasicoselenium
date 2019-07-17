package br.rs.cassiolinden.test;

import org.junit.Assert;
import org.junit.Test;

import br.rs.cassiolinden.core.BaseTest;
import br.rs.cassiolinden.pages.HomePage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	
	@Test
	public void testSaldoConta() {
		page.clicarHome();
		Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
	}

}
