package br.com.cooperalfa.emprestimo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.cooperalfa.emprestimo.dao.ParcelaDAO;
import br.com.cooperalfa.emprestimo.entidade.Parcela;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ParcelaBean implements Serializable {
	private Parcela parcela;
	private List<Parcela> parcelas;
	public Parcela getParcela() {
		return parcela;
	}
	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}
	public List<Parcela> getParcelas() {
		return parcelas;
	}
	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}
	
	@PostConstruct
	public void listar() {
		try {
			ParcelaDAO parcelaDAO = new ParcelaDAO();
			parcelas = parcelaDAO.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar exibir empréstimos");
			e.printStackTrace();
		}
	}
	
	
}