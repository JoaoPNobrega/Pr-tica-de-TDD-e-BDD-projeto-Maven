Feature: Calcular IRPF

	Scenario: Ano exercício 2024 e base de cálculo é "R$ 40.000,00"
		Given O ano de exercício é 2024
		When  A base de cálculo é de "R$ 40.000,00"
		Then  O imposto devido é de "R$ 1.617,62"
		
	Scenario: Ano exercício 2025 e base de cálculo é "R$ 40.000,00"
		Given O ano de exercício é 2025
		When  A base de cálculo é de "R$ 40.000,00"
		Then  O imposto devido é de "R$ 1.433,77"