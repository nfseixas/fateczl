package br.sceweb.teste;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Convenio;
import br.sceweb.modelo.ConvenioDAO;

public class UC05CadastrarConvenio {

	static Convenio convenio;
	static ConvenioDAO convenioDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 convenioDAO = new ConvenioDAO();
		 convenio = new Convenio("a","b","c");
	}

	@Test
	public void test() {
		assertEquals(1,convenioDAO.adiciona(convenio));
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

}
