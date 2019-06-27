package br.rs.cassiolinden.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

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

}
