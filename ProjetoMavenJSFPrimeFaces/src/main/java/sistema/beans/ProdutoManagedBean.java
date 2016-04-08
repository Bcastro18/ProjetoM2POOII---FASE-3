package sistema.beans;


import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Fornecedor;
import sistema.modelos.Produto;
import sistema.service.FornecedorService;
import sistema.service.ProdutoService;




@ManagedBean(name="produtoManagedBean")
@ViewScoped
public class ProdutoManagedBean {

	private Produto produto = new Produto();
	private Fornecedor fornecedor;
    private ProdutoService prodService = new ProdutoService();
    private FornecedorService fornService = new FornecedorService();
    private List <Produto> produtos;
    
	
	public void salvar()
	{
		fornecedor.addProduto(produto);
		produto.setFornecedor(fornecedor);
		produtos.add(produto);
		
		prodService.salvar(produto);
		
		produto = new Produto();
		fornecedor = null;
		
	}
	
	
	
	public List <Fornecedor> getFornecedores()
	{
		return fornService.getFornecedores();
		
	}
	
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void remove(Produto produto)
	{
		produtos.remove(produto);
		prodService.remover(produto);
		
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getProdutos() {
		if(produtos == null)
			produtos = prodService.getProdutos();
		
		return produtos;
	}
	
	
	public void onRowEdit(RowEditEvent event) {

		Produto p = ((Produto) event.getObject());
		prodService.alterar(p);
	}

	
	
	
}
