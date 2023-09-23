package atm.mg.system.service;

import java.util.List;

import atm.mg.system.dto.UserDTO;
import atm.mg.system.exception.DuplicateRecordException;


public interface UserServiceInt {
	
	public long add(UserDTO dto) throws DuplicateRecordException;
	
	public void Update(UserDTO dto) throws DuplicateRecordException;
	
	public void Delete(long id);

	public List<UserDTO> list();
	
	public UserDTO FindByPk(long pk);
	
	public UserDTO FindByEmail(String email);
	
	public UserDTO FindByAccountnumber(String accountnumber);
	
	public UserDTO Authentication(UserDTO dto);
	
	public List<UserDTO> search(UserDTO dto);
	
	public boolean changePassword(Long id, String oldPassword, String newPassword);

	
}
