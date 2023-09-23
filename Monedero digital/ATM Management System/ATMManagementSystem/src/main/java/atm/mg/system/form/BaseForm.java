package atm.mg.system.form;


import atm.mg.system.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public abstract class BaseForm {

	protected long id;

	private String operation;

	public abstract BaseDTO getDTO();

	public abstract void populate(BaseDTO bDto);

}
