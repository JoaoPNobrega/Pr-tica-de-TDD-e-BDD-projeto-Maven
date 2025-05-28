package school.cesar.irpf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class TabelaIrpfTest {
	@Test
	public void base40000() {
		var tabela = new TabelaIrpf2024();

		var esperado = new BigDecimal("0.15");

		var base = new BigDecimal("40000.00");
		var calculado = tabela.obterAliquota(base);

		assertEquals(esperado, calculado);
	}

	@Test
	public void deducao40000() {
		var tabela = new TabelaIrpf2024();

		var esperado = new BigDecimal("4382.38");

		var base = new BigDecimal("40000.00");
		var calculado = tabela.obterDeducao(base);

		assertEquals(esperado, calculado);
	}
}