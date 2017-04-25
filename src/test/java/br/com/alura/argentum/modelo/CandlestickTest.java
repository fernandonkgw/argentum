package br.com.alura.argentum.modelo;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		Candlestick candle = new CandleBuilder().comAbertura(10)
                .comFechamento(20).comMinimo(8).comMaximo(5).
                comVolume(100).comData(LocalDateTime.of(2016, 02, 25, 00, 23))
                .geraCandle();
	}
	
	@Test
	public void quandoAberturaIgualFechamentoEhAlta() {
		Candlestick candle = new CandleBuilder().comAbertura(20)
	            .comFechamento(20).comMinimo(8).comMaximo(15).comVolume(100)
	            .comData(LocalDateTime.of(2016, 02, 25, 00, 23)).geraCandle();
		
		assertTrue(candle.isAlta());
	}

}
