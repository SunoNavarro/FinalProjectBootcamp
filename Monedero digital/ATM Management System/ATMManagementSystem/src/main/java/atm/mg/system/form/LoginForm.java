package atm.mg.system.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import atm.mg.system.dto.BaseDTO;
import atm.mg.system.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginForm extends BaseForm{

	@NotEmpty(message = "Account No Is Required")
	private String accountnumber;
	
	@NotEmpty(message = "Pin is Required")
	private String pin;
	
	@Override
	public BaseDTO getDTO() {
		UserDTO bean = new UserDTO();
		bean.setAccountnumber(accountnumber);
		bean.setPin(pin);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		UserDTO bean = (UserDTO)getDTO();
		accountnumber = bean.getAccountnumber();
		pin = bean.getPin();
	}

}
