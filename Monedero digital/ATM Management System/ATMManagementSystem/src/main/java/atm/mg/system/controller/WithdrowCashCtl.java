package atm.mg.system.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import atm.mg.system.dto.TransactionDTO;
import atm.mg.system.dto.UserDTO;
import atm.mg.system.exception.DuplicateRecordException;
import atm.mg.system.form.TransactionForm;
import atm.mg.system.service.TransactionServiceInt;

@Controller
public class WithdrowCashCtl extends BaseCtl {
	

	@Autowired
	private TransactionServiceInt service;
	
	@GetMapping({"/withdrow"})
	public String withdrow(@ModelAttribute("form") TransactionForm form, Model model){
		return "Withdrowcash";
	}
	
	@PostMapping("/withdrowmoney")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") TransactionForm form,
			BindingResult bindingResult, Model model, HttpSession session, HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			return "Withdrowcash";
		}

		TransactionDTO bean = (TransactionDTO) populateDTO(form.getDTO(), request);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date1 = new Date();
		UserDTO uDto = (UserDTO) session.getAttribute("user");
		bean.setUserid(uDto.getId());
		bean.setUsername(uDto.getUserName());
		bean.setAccountnumber(uDto.getAccountnumber());
		bean.setTransactiontype("Withdrow");
		bean.setDate(date1);
//		bean.setTotalbalance(form.getTransaction());
		 List<TransactionDTO> list = service.usertransactionlist(uDto.getId());
		    model.addAttribute("list", list);
		    Iterator<TransactionDTO> it = list.iterator();
		    long balance = 0;
		    while (it.hasNext()) {
		    	TransactionDTO txBean = (TransactionDTO) it.next();
				 balance =  txBean.getTotalbalance();
			}
		    long amount =  balance - form.getTransaction();
	        bean.setTotalbalance(amount);
	        System.out.println("Totalbalance :"+bean.getTotalbalance());
		    System.out.println("Transaction :"+form.getTransaction());
	        System.out.println("amount :"+amount);
		if (amount > 0) {
		try {
			service.add(bean);
			model.addAttribute("success", "Dinero retirado con éxito !!");
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
		}else {
			model.addAttribute("error", "Saldo insuficiente");
		}

		return "Withdrowcash";
	}

}
