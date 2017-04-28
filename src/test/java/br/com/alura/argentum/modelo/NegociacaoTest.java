package br.com.alura.argentum.modelo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;



public class NegociacaoTest {

	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(10, 5, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComPrecoNegativo() {
		LocalDateTime hoje = LocalDateTime.now();
		new Negociacao(-20, 2, hoje);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComQuantidadeZero() {
		LocalDateTime hoje = LocalDateTime.now();
		new Negociacao(20, 0, hoje);
	}

	@Test
	public void mesmoSegundoEhDoMesmoDia() {
		
		LocalDateTime agora = LocalDateTime.now();
		LocalDateTime mesmoMomento = agora;
		
		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
	@Test
	public void comHorariosDiferentesEhNoMesmoDia() {
		
		LocalDateTime manha = LocalDateTime.of(2016, 02, 25, 8, 30);
		LocalDateTime tarde = LocalDateTime.of(2016, 02, 25, 15, 30);
		
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		assertTrue(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
		
		LocalDateTime fevereiro = LocalDateTime.of(2016, 02, 25, 8, 30);
		LocalDateTime marco = LocalDateTime.of(2016, 03, 25, 15, 30);
		
		Negociacao negociacao = new Negociacao(40.0, 100, fevereiro);
		assertFalse(negociacao.isMesmoDia(marco));
	}
	
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() {
		
		LocalDateTime ano2016 = LocalDateTime.of(2016, 02, 25, 8, 30);
		LocalDateTime ano2015 = LocalDateTime.of(2015, 02, 25, 15, 30);
		
		Negociacao negociacao = new Negociacao(40.0, 100, ano2016);
		assertFalse(negociacao.isMesmoDia(ano2015));
	}
}
