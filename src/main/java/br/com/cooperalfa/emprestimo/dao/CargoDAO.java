package br.com.cooperalfa.emprestimo.dao;

import java.util.List;


import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.cooperalfa.emprestimo.entidade.Cargo;
import br.com.cooperalfa.emprestimo.util.HibernateUtil;

public class CargoDAO extends GenericDAO<Cargo> {

	public List<Cargo> buscarPorSetor(Long codigoSetor) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
		    CriteriaQuery<Cargo> query = builder.createQuery(Cargo.class);
		    Root<Cargo> u = query.from(Cargo.class);
		    query.select(u);
		    query.where(builder.equal(u.get("setor"), codigoSetor));
		    query.orderBy(builder.asc(u.get("nome")));
		    
		    TypedQuery<Cargo> typedQuery = sessao.createQuery(query);
		    List<Cargo> cargos = typedQuery.getResultList();
		    return cargos;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}

	}
}
