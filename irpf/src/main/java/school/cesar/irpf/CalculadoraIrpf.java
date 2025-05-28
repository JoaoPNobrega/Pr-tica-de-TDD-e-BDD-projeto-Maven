package school.cesar.irpf;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class CalculadoraIrpf {
	private TabelaIrpf tabela;

	public CalculadoraIrpf(TabelaIrpf tabela) {
		this.tabela = Objects.requireNonNull(tabela);
	}

	public BigDecimal calcularIrpf(BigDecimal base) {
		Objects.requireNonNull(base);

		var aliquota = tabela.obterAliquota(base);
		var deducao = tabela.obterDeducao(base);

		// base * aliquota - deducao
		return base.multiply(aliquota).subtract(deducao).setScale(2, RoundingMode.HALF_UP);
	}
}