package atm.mg.system.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import atm.mg.system.dto.TransactionDTO;
import atm.mg.system.exception.DuplicateRecordException;

@Repository
public class TransactionDAOImpl implements TransactionDAOInt{
	
    @Autowired
    public EntityManager entitymanger;

	@Override
	public long add(TransactionDTO dto) throws DuplicateRecordException {
		Session session = entitymanger.unwrap(Session.class);
		System.out.println("DAO:"+dto.getTotalbalance());
		System.out.println("Transaction:"+dto.getTransaction());
		long pk = (long) session.save(dto);
		return pk;
	}

	@Override
	public TransactionDTO FindByUserId(long id) {
		Session session = entitymanger.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TransactionDTO.class);
		criteria.add(Restrictions.eq("id", id));
		TransactionDTO dto =  (TransactionDTO) criteria.uniqueResult();
		return dto;
	}

	@Override
	public void Delete(long id) {
		Session session = (Session) entitymanger.unwrap(Session.class);
		Query<TransactionDTO> query = session.createQuery("delete from TransactionDTO where id= "+id+"");
	    query.executeUpdate();		
	}

	@Override
	public List<TransactionDTO> list() {
		Session session = entitymanger.unwrap(Session.class);
		Query<TransactionDTO> query = session.createQuery("from TransactionDTO", TransactionDTO.class);
		List<TransactionDTO> list = query.getResultList();
		return list;
	}

	@Override
	public TransactionDTO FindByPk(long pk) {
		Session session = entitymanger.unwrap(Session.class);
		TransactionDTO dto = session.get(TransactionDTO.class, pk);
		return dto;
	}

	@Override
	public List<TransactionDTO> usertransactionlist(long userid) {
		Session session = entitymanger.unwrap(Session.class);
		Query<TransactionDTO> query = session.createQuery("from TransactionDTO as b where b.userid = ?1 ", TransactionDTO.class);
		query.setParameter(1, userid);
		List<TransactionDTO> Rlist = query.getResultList();
		return Rlist;
	}

	@Override
	public List<TransactionDTO> search(TransactionDTO dto) {
		Session session = entitymanger.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TransactionDTO.class);
		if (dto != null) {
			if (dto.getId()>0) {
              criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getTransactiontype() != null && dto.getTransactiontype().length()>0) {
				criteria.add(Restrictions.like("transactiontype", dto.getTransactiontype() + "%"));
			}
		}
		return criteria.list();
	}

}
