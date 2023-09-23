package atm.mg.system.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "AMOUNT_TRANSACTION")
public class TransactionDTO extends BaseDTO{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "accountnumber",length = 200)
	private String accountnumber;
	
	@Column(name = "userid",length = 200)
	private long userid;
	
	@Column(name = "username",length = 200)
	private String username;
	
	@Column(name = "transaction_Amount",length = 200)
	private long transaction;
	
	@Column(name = "transactiontype",length = 200)
	private String transactiontype;
	
	@Column(name = "totalbalance",length = 200)
	private long totalbalance;

	@Column(name = "Date")
	private Date date;
	
	

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return username;
	}

	@Override
	public String toString() {
		return "TransactionDTO [id=" + id + ", accountnumber=" + accountnumber + ", userid=" + userid + ", username="
				+ username + ", transaction=" + transaction + ", transactiontype=" + transactiontype + ", totalbalance="
				+ totalbalance + ", date=" + date + "]";
	}

	
	
}
