package br.sceweb.teste;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Convenio;
import br.sceweb.modelo.ConvenioDAO;
import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC05CadastrarConvenio {
	static ConvenioDAO convenioDAO;
	static Convenio convenio;
	static Convenio novoConvenio;
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	static String cnpj;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("81965361000174");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		empresaDAO.adiciona(empresa);
		convenioDAO = new ConvenioDAO();
		convenio = new Convenio("81965361000174","03/05/2016", "20/05/2016");
	}
	@Test
	public void CT01UC05CadastrarConvenio_com_sucesso() {
		assertEquals(1,convenioDAO.adiciona(convenio));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void CT06UC05A3CadastrarConvenio_cnpj_invalido() {
		cnpj = "11111";
		convenio.setCNPJ(cnpj);
	}
	@Test
	public void CT03UC05A2Cadastrar_convenio_dti_invalida(){
		assertFalse(convenio.validaData("42/05/2016"));
	}
	@Test
	public void CT02UC05A1Cadastrar_convenio_ja_cadastrado(){
		DateTime di = new DateTime(2016, 4, 5, 0, 0);
		DateTime df = new DateTime(2016, 5, 1, 0, 0);
		assertEquals (4, convenio.convenioJaCadastrado(df,di));
	}

	@
	AfterClass
	public static void tearDownAfterClass() throws Exception {
		convenioDAO.exclui("81965361000174");
		empresaDAO.exclui("81965361000174");
	}
}

