package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.dao.FornecedorDAO;
import sistema.modelos.Aluno;
import sistema.modelos.Fornecedor;
import sistema.modelos.Produto;

public class FornecedorService {

	private FornecedorDAO fornecedorDAO = new FornecedorDAO();

	public Fornecedor salvar(Fornecedor fornecedor) {

		fornecedor = fornecedorDAO.save(fornecedor);
		fornecedorDAO.closeEntityManager();
		return fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		List<Fornecedor> list = fornecedorDAO.getAll(Fornecedor.class);
		fornecedorDAO.closeEntityManager();
		return list;
	}

	public void alterar(Fornecedor fornecedor) {

		fornecedorDAO.save(fornecedor);
		fornecedorDAO.closeEntityManager();

	}

	public void remover(Fornecedor fornecedor) {

		fornecedor = fornecedorDAO.getById(Fornecedor.class, fornecedor.getCodigo());
		fornecedorDAO.remove(fornecedor);
		fornecedorDAO.closeEntityManager();
	}

	public Fornecedor pesquisar(Fornecedor fornecedor) {

		fornecedor = fornecedorDAO.getById(Fornecedor.class, fornecedor.getCodigo());
		fornecedorDAO.closeEntityManager();
		return fornecedor;
	}

	public List<Produto> pesquisarProdutosFornecedor(Fornecedor fornecedor) {

		List<Produto> produtos;

		fornecedor = fornecedorDAO.getById(Fornecedor.class, fornecedor.getCodigo());
		produtos = fornecedor.getProdutos();

		return produtos;
	}

}
