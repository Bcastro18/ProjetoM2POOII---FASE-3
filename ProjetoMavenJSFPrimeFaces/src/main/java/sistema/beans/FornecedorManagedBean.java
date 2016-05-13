package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import sistema.beans.datamodel.FornecedorDataModel;
import sistema.modelos.Aluno;
import sistema.modelos.Fornecedor;
import sistema.modelos.Produto;
import sistema.service.FornecedorService;

@ManagedBean
@ViewScoped
public class FornecedorManagedBean {

	private Fornecedor fornecedor = new Fornecedor();
	private Fornecedor fornecedorSelecionado;
	private FornecedorService servico = new FornecedorService();
	private List<Fornecedor> fornecedores;

	/**
	 * @return the fornecedorSelecionado
	 */
	public Fornecedor getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	/**
	 * @param fornecedorSelecionado
	 *            the fornecedorSelecionado to set
	 */
	public void setFornecedorSelecionado(Fornecedor fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}

	public void salvar() {
		fornecedor = servico.salvar(fornecedor);

		if (fornecedores != null)
			fornecedores.add(fornecedor);

		fornecedor = new Fornecedor();

	}

	public DataModel<Fornecedor> getFornecedores() {
		if (fornecedores == null)
			fornecedores = servico.getFornecedores();

		return new FornecedorDataModel(fornecedores);
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void remove(Fornecedor fornecedor) {
		if (servico.pesquisarProdutosFornecedor(fornecedor).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover fornecedor",
					"Fornecedor possui produtos!"));
		} else {
			servico.remover(fornecedor);
			fornecedores.remove(fornecedor);
		}
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Produto> getProdutosFornecedor() {
		if (fornecedorSelecionado != null) {
			return servico.pesquisarProdutosFornecedor(fornecedorSelecionado);
		} else
			return null;
	}

	public void onRowEdit(RowEditEvent event) {

		Fornecedor f = ((Fornecedor) event.getObject());
		servico.alterar(f);
	}

}
