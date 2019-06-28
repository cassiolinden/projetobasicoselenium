package br.rs.cassiolinden.test;

import org.junit.Test;

import br.rs.cassiolinden.core.BaseTest;
import br.rs.cassiolinden.core.Propriedades;
import br.rs.cassiolinden.pages.HomePage;

import org.junit.Assert;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	
	@Test
	public void testSaldoConta() {
		page.clicarHome();
		Assert.assertEquals("1000.00", page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
	}

}
