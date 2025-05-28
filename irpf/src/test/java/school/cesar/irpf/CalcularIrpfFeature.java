package school.cesar.irpf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalcularIrpfFeature {
	private DecimalFormat formatador;
	private TabelaIrpf tabela;
	private String calculado;

	public CalcularIrpfFeature() {
		var localizacao = Locale.forLanguageTag("pt-BR");

		var simbolos = new DecimalFormatSymbols(localizacao);
		simbolos.setCurrencySymbol("R$");
		simbolos.setGroupingSeparator('.');
		simbolos.setDecimalSeparator(',');

		formatador = new DecimalFormat("¤ #,##0.00", simbolos);
		formatador.setParseBigDecimal(true);
	}

	@Given("O ano de exercício é {int}")
	public void o_ano_de_exercício_é_2024(int ano) {
		switch (ano) {
		case 2024:
			tabela = new TabelaIrpf2024();
			break;
		case 2025:
			tabela = new TabelaIrpf2025();
			break;
		default:
			throw new IllegalArgumentException("Ano não suportado: " + ano);
		}
	}

	@When("A base de cálculo é de {string}")
	public void a_base_de_cálculo_é_de(String base) throws ParseException {
		var baseBigDecimal = (BigDecimal) formatador.parse(base);
		var calculadora = new CalculadoraIrpf(tabela);
		var calculadoBigDecimal = calculadora.calcularIrpf(baseBigDecimal);
		calculado = formatador.format(calculadoBigDecimal);
	}

	@Then("O imposto devido é de {string}")
	public void o_imposto_devido_é_de(String esperado) {
		assertEquals(esperado, calculado);
	}
}