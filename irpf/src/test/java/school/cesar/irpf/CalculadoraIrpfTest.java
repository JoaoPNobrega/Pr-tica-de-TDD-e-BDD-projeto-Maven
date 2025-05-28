package school.cesar.irpf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class CalculadoraIrpfTest {
	@Test
	public void base40000() {
		BigDecimal esperado = new BigDecimal("1617.62");

		var tabela = new TabelaIrpf2024();
		var calculadora = new CalculadoraIrpf(tabela);

		BigDecimal base = new BigDecimal("40000.00");
		BigDecimal calculado = calculadora.calcularIrpf(base);

		assertEquals(esperado, calculado);
	}

	@Test
	public void base40000Mock() {
		BigDecimal esperado = new BigDecimal("1617.62");

		BigDecimal base = new BigDecimal("40000.00");

		var tabela = new Base40000Mock();
		var calculadora = new CalculadoraIrpf(tabela);
		BigDecimal calculado = calculadora.calcularIrpf(base);

		assertEquals(esperado, calculado);
	}

	@Test
	public void base40000Mockito() {
		BigDecimal esperado = new BigDecimal("1617.62");

		BigDecimal base = new BigDecimal("40000.00");

		var tabela = mock(TabelaIrpf.class);
		when(tabela.obterAliquota(base)).thenReturn(new BigDecimal("0.15"));
		when(tabela.obterDeducao(base)).thenReturn(new BigDecimal("4382.38"));

		var calculadora = new CalculadoraIrpf(tabela);
		BigDecimal calculado = calculadora.calcularIrpf(base);

		assertEquals(esperado, calculado);
	}
}

class Base40000Mock extends TabelaIrpf2024 {
	@Override
	public BigDecimal obterAliquota(BigDecimal base) {
		return new BigDecimal("0.15");
	}

	@Override
	public BigDecimal obterDeducao(BigDecimal base) {
		return new BigDecimal("4382.38");
	}
}