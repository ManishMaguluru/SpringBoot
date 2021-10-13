package com.example.demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Exception.ItemException;
import com.example.demo.Model.Item;
import com.example.demo.Service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService iservice;

	@GetMapping({ "", "/", "/home" })
	public ModelAndView ShowHomeAction() {
		List<Item> items = iservice.getAll();
		return new ModelAndView("home-page", "itemsList", items);
	}

	@RequestMapping("header")
	public String header() {
		return "header-page";
	}

	@RequestMapping("footer")
	public String footer() {
		return "footer-page";
	}

	@GetMapping("/addItem")
	public ModelAndView showEmployeeFormAction() {
		return new ModelAndView("add-item-page", "item", new Item());
	}

	@PostMapping("/addItem")
	public ModelAndView addEmployeeAction(@ModelAttribute("item") @Valid Item item, BindingResult validationResults)
			throws ItemException {

		ModelAndView mv = null;

		if (validationResults.hasErrors()) {
			mv = new ModelAndView("add-item-page", "item", item);
		} else {
			iservice.addItem(item);
			mv = new ModelAndView("redirect:/home");
		}

		return mv;
	}

	@GetMapping("/editItem/{icode}")
	public ModelAndView showEmployeeFormAction(@PathVariable("icode") Long icode) throws ItemException {
		Item item = iservice.getById(icode);

		if (item == null)
			throw new ItemException("No Such Item found To Edit");

		return new ModelAndView("add-item-page", "item", item);
	}

	@PostMapping("/editItem/{icode}")
	public ModelAndView editEmployeeAction(@ModelAttribute("item") @Valid Item item, BindingResult validationResults)
			throws ItemException {
		ModelAndView mv = null;

		if (validationResults.hasErrors()) {
			mv = new ModelAndView("add-item-page", "item", item);
		} else {
			iservice.update(item);
			mv = new ModelAndView("redirect:/home");
		}
		return mv;
	}

	@GetMapping("/deleteItem/{icode}")
	public String deleteEmployeeAction(@PathVariable("icode") Long icode) throws ItemException {
		iservice.deleteById(icode);
		return "redirect:/home";
	}

}
