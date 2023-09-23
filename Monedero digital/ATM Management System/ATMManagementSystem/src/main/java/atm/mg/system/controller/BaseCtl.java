package atm.mg.system.controller;
import javax.servlet.http.HttpServletRequest;

import atm.mg.system.dto.BaseDTO;
import atm.mg.system.dto.UserDTO;
import atm.mg.system.util.DataUtility;
import atm.mg.system.util.DataValidator;


public class BaseCtl {

	protected static final String OP_SAVE = "Save";
	protected static final String OP_NEW="New";
	protected static final String OP_DELETE="Delete";
	
	protected static final String OP_UPDATE="Update";
	protected static final String OP_CANCEL="Cancel";
	protected static final String OP_ERROR="Error";
	protected static final String OP_NEXT="Next";
	protected static final String OP_PREVIOUS="Previous";
	protected static final String OP_LOGOUT="Logout";
	protected static final String OP_VOTE="Vote";
	protected static final String OP_GET="Get";
	protected static final String OP_RESET="Reset";
	protected static final String OP_SUBMIT="Submit";
	protected static final String OP_SEARCH="Search";
	
	
	protected BaseDTO populateDTO(BaseDTO dto, HttpServletRequest request) {
		
		String createdBy = request.getParameter("createdBy");
		String modifiedBy = null;

		UserDTO userbean = (UserDTO) request.getSession().getAttribute("user");

		if (userbean == null) {
			// If record is created without login
			createdBy = "root";
			modifiedBy = "root";
		} else {

			modifiedBy = userbean.getEmail();

			// Si se crea por primera vez (repasar)
			if ("null".equalsIgnoreCase(createdBy)|| DataValidator.isNull(createdBy)) {
				createdBy = modifiedBy;
			}

		}

		///dto.setCreatedBy(createdBy);
		//dto.setModifiedBy(modifiedBy);

		long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));

		if (cdt > 0) {
			//dto.setCreatedDatetime(DataUtility.getTimestamp(cdt));
		} else {
			//dto.setCreatedDatetime(DataUtility.getCurrentTimestamp());
		}

		//dto.setModifiedDatetime(DataUtility.getCurrentTimestamp());
		
		return dto;
	}
}
