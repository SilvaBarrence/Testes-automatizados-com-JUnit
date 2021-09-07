package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		assertThrows(IllegalArgumentException.class ,() -> service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(), new BigDecimal("25000"))));

//		try {
//			service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(), new BigDecimal("25000")));
//			fail("Não deu exception!");
//		} catch (Exception e) {
//			assertEquals("Funcionario com salario maior do que R$10.000,00 não pode receber bonus", e.getMessage());
//		}
	}

	@Test
	void bonusDeveriaSerDezPorCentoDoSario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(), new BigDecimal("3000")));

		assertEquals(new BigDecimal("300.0"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSarioDeDezMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.0"), bonus);
	}

}
