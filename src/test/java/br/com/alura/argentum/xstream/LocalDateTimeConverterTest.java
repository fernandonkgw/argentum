package br.com.alura.argentum.xstream;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.modelo.Negociacao;

public class LocalDateTimeConverterTest {

	@Test
	public void deveGeraroXmlComDataAdequada() {
		String resultadoEsperado = "<negociacao>\n"
				+ "  <preco>40.5</preco>\n"
				+ "  <quantidade>100</quantidade>\n"
				+ "  <data>\n"
				+ "    <time>1459479600000</time>\n"
				+ "    <timezone>America/Sao_Paulo</timezone>\n"
				+ "  </data>\n"
				+ "</negociacao>";
		
		Negociacao negociacao = new Negociacao(40.5, 100, LocalDateTime.of(2016, 4, 1, 0, 0));
		
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("negociacao", Negociacao.class);
		xStream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		String resultado = xStream.toXML(negociacao);
		
		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void deveGerarObjetoAdequadoDeUmXml() {
		String xml = "<negociacao>\n"
				+ "  <preco>40.5</preco>\n"
				+ "  <quantidade>100</quantidade>\n"
				+ "  <data>\n"
				+ "    <time>1459479600000</time>\n"
				+ "    <timezone>America/Sao_Paulo</timezone>\n"
				+ "  </data>\n"
				+ "</negociacao>";
		
		
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("negociacao", Negociacao.class);
		xStream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		Negociacao negociacaoGerada = (Negociacao) xStream.fromXML(xml);
		
		Negociacao negociacaoEsperada = new Negociacao(40.5, 100, LocalDateTime.of(2016, 4, 1, 0, 0));
		
		assertEquals(negociacaoEsperada, negociacaoGerada);
	}
	
}
