package atm.mg.system.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atm.mg.system.dao.TransactionDAOInt;
import atm.mg.system.dto.TransactionDTO;
import atm.mg.system.exception.DuplicateRecordException;


@Service
public class TransactionServiceImpl implements TransactionServiceInt{
	
	@Autowired
	public TransactionDAOInt dao;
	

	@Override
	public long add(TransactionDTO dto) throws DuplicateRecordException {
	//	TransactionDTO exisBean = dao.FindByUserId(dto.getUserid());
//		if (exisBean != null){
//			throw new DuplicateRecordException("User is Already Exist");
//		}
		long pk = dao.add(dto);
		return pk;
	}

	@Override
	public TransactionDTO FindByUserId(long id) {
		TransactionDTO dto = dao.FindByUserId(id);
		return dto;
	}

	@Override
	@Transactional
	public void Delete(long id) {
		dao.Delete(id);		
	}

	@Override
	public List<TransactionDTO> list() {
		 List<TransactionDTO> list =  dao.list();
		  return list;
	}

	@Override
	public TransactionDTO FindByPk(long pk) {
		TransactionDTO dto = dao.FindByPk(pk);
		return dto;
	}

	@Override
	public List<TransactionDTO> usertransactionlist(long userid) {
		 List<TransactionDTO> list =  dao.usertransactionlist(userid);
			return list;
	}

	@Override
	public List<TransactionDTO> search(TransactionDTO dto) {
		 List<TransactionDTO> list =  dao.search(dto);
		 return list;
	}

}
