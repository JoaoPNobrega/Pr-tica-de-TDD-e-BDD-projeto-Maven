package school.cesar.irpf;

import java.math.BigDecimal;

public class TabelaIrpf2025 implements TabelaIrpf {
	public BigDecimal obterAliquota(BigDecimal base) {
		if (base.compareTo(new BigDecimal("26963.20")) <= 0) { // base <= 26963.20
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
		if (base.compareTo(new BigDecimal("26963.20")) <= 0) { // base <= 26963.20
			return new BigDecimal("0.00");
		} else if (base.compareTo(new BigDecimal("33919.80")) <= 0) { // base <= 33919.81
			return new BigDecimal("2022.24");
		} else if (base.compareTo(new BigDecimal("45012.60")) <= 0) { // base <= 45012.61
			return new BigDecimal("4566.23");
		} else if (base.compareTo(new BigDecimal("55976.16")) <= 0) { // base <= 55976.16
			return new BigDecimal("7942.17");
		} else {
			return new BigDecimal("10740.98");
		}
	}
}