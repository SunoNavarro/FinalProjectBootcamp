package atm.mg.system.service;

import java.util.List;

import atm.mg.system.dto.TransactionDTO;
import atm.mg.system.dto.UserDTO;
import atm.mg.system.exception.DuplicateRecordException;

public interface TransactionServiceInt {
	
	public long add(TransactionDTO dto) throws DuplicateRecordException;
	
	public TransactionDTO FindByUserId(long id);
	
	public void Delete(long id);

	public List<TransactionDTO> list();
	
	public List<TransactionDTO> usertransactionlist(long userid);
	
	public TransactionDTO FindByPk(long pk);
	
	public List<TransactionDTO> search(TransactionDTO dto);

}
