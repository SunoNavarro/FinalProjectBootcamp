package atm.mg.system.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import atm.mg.system.dto.BaseDTO;
import atm.mg.system.dto.TransactionDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionForm extends BaseForm {

	
	private String accountnumber;

	private long userid;

	private String username;

	//@NotEmpty(message = "Amount is Required")
	@Min(value = 1,message = "Amount is required")
	private long transaction;

	private String transactiontype;

	private long totalbalance;

	private Date date;

	@Override
	public BaseDTO getDTO() {
		TransactionDTO dto = new TransactionDTO();
		dto.setId(id);
		dto.setUserid(userid);
		dto.setUsername(username);
		dto.setAccountnumber(accountnumber);
		dto.setTransaction(transaction);
		dto.setTransactiontype(transactiontype);
		dto.setTotalbalance(totalbalance);
		dto.setDate(date);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		TransactionDTO bean = (TransactionDTO) bDto;
      id = bean.getId();
      userid = bean.getUserid();
      username = bean.getUsername();
      accountnumber = bean.getAccountnumber();
      transaction = bean.getTransaction();
      transactiontype = bean.getTransactiontype();
      totalbalance = bean.getTotalbalance();
      date= bean.getDate();
	}


}
