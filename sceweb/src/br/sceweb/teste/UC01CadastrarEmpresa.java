package br.sceweb.teste;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {

	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setCNPJ("894242332000180");
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
			
	}

	
	@Test
	public void CT01UC01CadastrarEmpresaComSucesso() {
		assertEquals(1,empresaDAO.adiciona(empresa));
		empresaDAO.exclui("894242332000180");
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
}
