package br.com.alura.argentum.reader;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import br.com.alura.argentum.modelo.Negociacao;

public class LeitorXMLTest {

	@Test
	public void deveCarregarXmlComUmaNegociacao() {
		String xmlDeTeste = "<list>\n"
				+ "  <negociacao>\n"
				+ "    <preco>40.5</preco>\n"
				+ "    <quantidade>100</quantidade>\n"
				+ "    <data>\n"
				+ "      <time>1459479600000</time>\n"
				+ "      <timezone>America/Sao_Paulo</timezone>\n"
				+ "    </data>\n"
				+ "  </negociacao>\n"
				+ "</list>";
		
		Negociacao negocicaoEsperada = new Negociacao(40.5, 100, LocalDateTime.of(2016, 04, 01, 00, 00));
		
		LeitorXML leitor = new LeitorXML();
		
		ByteArrayInputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		assertEquals(1, negociacoes.size());
		assertEquals(negocicaoEsperada, negociacoes.get(0));
	}

}
