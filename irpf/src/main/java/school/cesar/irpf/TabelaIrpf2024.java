package school.cesar.irpf;

import java.math.BigDecimal;

public class TabelaIrpf2024 implements TabelaIrpf {
	public BigDecimal obterAliquota(BigDecimal base) {
		if (base.compareTo(new BigDecimal("24511.92")) <= 0) { // base <= 24511.93
			return new BigDecimal("0.00");
		} else if (base.compareTo(new BigDecimal("33919.80")) <= 0) { // base <= 33919.81
			return new BigDecimal("0.075");
		} else if (base.compareTo(new BigDecimal("45012.60")) <= 0) { // base <= 45012.61
			return new BigDecimal("0.15");
		} else if (base.compareTo(new BigDecimal("55976.16")) <= 0) { // base <= 55976.16
			return new BigDecimal("0.225");
		} else {
			return new BigDecimal("0.275");
		}
	}

	public BigDecimal obterDeducao(BigDecimal base) {
		if (base.compareTo(new BigDecimal("24511.92")) <= 0) { // base <= 24511.93
			return new BigDecimal("0.00");
		} else if (base.compareTo(new BigDecimal("33919.80")) <= 0) { // base <= 33919.81
			return new BigDecimal("1838.39");
		} else if (base.compareTo(new BigDecimal("45012.60")) <= 0) { // base <= 45012.61
			return new BigDecimal("4382.38");
		} else if (base.compareTo(new BigDecimal("55976.16")) <= 0) { // base <= 55976.16
			return new BigDecimal("7758.32");
		} else {
			return new BigDecimal("10557.13");
		}
	}
}