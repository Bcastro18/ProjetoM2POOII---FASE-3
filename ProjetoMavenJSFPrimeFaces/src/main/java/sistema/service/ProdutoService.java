package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.dao.ProdutoDAO;
import sistema.modelos.Aluno;
import sistema.modelos.Produto;

public class ProdutoService {

	ProdutoDAO produtoDAO = new ProdutoDAO();

	public Produto salvar(Produto produto) {
		produto = produtoDAO.save(produto);
		produtoDAO.closeEntityManager();
		return produto;

	}

	public List<Produto> getProdutos() {
		List<Produto> list = produtoDAO.getAll(Produto.class);
		produtoDAO.closeEntityManager();
		return list;
	}

	public void alterar(Produto produto) {
		produtoDAO.save(produto);
		produtoDAO.closeEntityManager();
	}

	public void remover(Produto produto) {

		produto = produtoDAO.getById(Produto.class, produto.getCodigo());
		produtoDAO.remove(produto);
		produtoDAO.closeEntityManager();
	}

}
