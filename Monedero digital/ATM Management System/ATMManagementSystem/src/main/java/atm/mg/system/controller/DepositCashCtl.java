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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import atm.mg.system.dto.TransactionDTO;
import atm.mg.system.dto.UserDTO;
import atm.mg.system.exception.DuplicateRecordException;
import atm.mg.system.form.TransactionForm;
import atm.mg.system.service.TransactionServiceInt;

@Controller
public class DepositCashCtl extends BaseCtl {

	@Autowired
	private TransactionServiceInt service;

	@GetMapping({ "/deposit" })
	public String deposit(@ModelAttribute("form") TransactionForm form, Model model) {
		return "Depositcash";
	}

	@PostMapping("/depositemoney")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") TransactionForm form,
			BindingResult bindingResult, Model model, HttpSession session, HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			return "Depositcash";
		}

		TransactionDTO bean = (TransactionDTO) populateDTO(form.getDTO(), request);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date1 = new Date();
		UserDTO uDto = (UserDTO) session.getAttribute("user");
		bean.setId(0);
		bean.setUserid(uDto.getId());
		bean.setUsername(uDto.getUserName());
		bean.setAccountnumber(uDto.getAccountnumber());
		bean.setTransactiontype("Deposit");
		bean.setDate(date1);
		//bean.setTotalbalance(bean.getTransaction());
	    List<TransactionDTO> list = service.usertransactionlist(uDto.getId());
	    model.addAttribute("list", list);
	    Iterator<TransactionDTO> it = list.iterator();
	    long balance = 0;
	    while (it.hasNext()) {
	    	TransactionDTO txBean = (TransactionDTO) it.next();
			 balance =  txBean.getTotalbalance();
		}
	    long amount = form.getTransaction() + balance;
        bean.setTotalbalance(amount);
        System.out.println("Totalbalance :"+bean.getTotalbalance());
	    System.out.println("Transaction :"+form.getTransaction());
	    System.out.println("Transaction22 :"+bean.getTransaction());
        System.out.println("amount :"+amount);
		try {
			System.out.println(bean.toString());
			service.add(bean);
			model.addAttribute("success", "Dinero ingresado con exito !!");
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
		return "Depositcash";
	}
	
	@RequestMapping(value = "/transactionlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String TransactionList(@ModelAttribute("form") TransactionForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/transactionlist";
		}
		
		if (OP_SEARCH.equalsIgnoreCase(form.getOperation())) {
			TransactionDTO dto = (TransactionDTO) form.getDTO();
		     List<TransactionDTO> list = service.search(dto);
			 model.addAttribute("list", list);
			return "transactionlist";
		}
		UserDTO uDto = (UserDTO) session.getAttribute("user");
		long roleid = uDto.getRoleid();
		if (roleid == 2) {
			try {
				List<TransactionDTO> list = service.usertransactionlist(uDto.getId());
				model.addAttribute("list", list);
				if (list.size() == 0) {
					model.addAttribute("error", "Record not found");
				}
				return "transactionlist";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else{
		List<TransactionDTO> list = service.list();
		model.addAttribute("list", list);
		if (list.size() == 0) {
			model.addAttribute("error", "Record not found");
		}
		}
		return "transactionlist";
	}
	
	@GetMapping("/transaction/Delete")
	public String Delete(@ModelAttribute("form") TransactionForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		service.Delete(id);
		model.addAttribute("success", "Deleted Successfully!!!");
		List<TransactionDTO> list = service.list();
		model.addAttribute("list", list);
		return "transactionlist";
	}
	

	

	@GetMapping({ "/balance" })
	public String balance(@ModelAttribute("form") TransactionForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		UserDTO uDto = (UserDTO) session.getAttribute("user");
		long roleid = uDto.getRoleid();
		if (roleid == 2) {
			try {
				List<TransactionDTO> list = service.usertransactionlist(uDto.getId());
				model.addAttribute("list", list);
				return "totalbalance";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else{
		List<TransactionDTO> list = service.list();
		model.addAttribute("list", list);
		}
		return "totalbalance";
	}

}
