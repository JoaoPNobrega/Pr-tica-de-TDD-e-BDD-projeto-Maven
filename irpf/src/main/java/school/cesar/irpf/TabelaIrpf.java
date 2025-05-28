package school.cesar.irpf;

import java.math.BigDecimal;

public interface TabelaIrpf {
	BigDecimal obterAliquota(BigDecimal base);

	BigDecimal obterDeducao(BigDecimal base);
}