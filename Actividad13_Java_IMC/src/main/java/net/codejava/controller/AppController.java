package net.codejava.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.codejava.Usuario;
import net.codejava.entity.IMC_Data;
import net.codejava.services.IMCService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    /*@Autowired
    private TriangleService service;*/
    
    @Autowired
    private IMCService service;
    

    @RequestMapping("/")
    public String viewHomePage(HttpSession session, Model model) {

        if (session.getAttribute("mySessionAttribute") != null) {
            List<IMC_Data> imcList = service.listAll();
            model.addAttribute("imcList", imcList);
            return "index";
        } else {
            model.addAttribute("usuario", new Usuario());
            return "login";
        }
    }

    @RequestMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("mySessionAttribute", "sasas");
        return "redirect:/";
    }
    
    @RequestMapping("/new")
    public String showNewIMCPage(Model model) {
        IMC_Data imc = new IMC_Data();
        model.addAttribute("imc", imc);

        return "new_imc";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveIMC(@ModelAttribute("imc") IMC_Data imc) {
        service.save(imc);

        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditIMCPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_imc");
        IMC_Data imc = service.get(id);
        mav.addObject("imc", imc);

        return mav;
    }

    
    @RequestMapping("/delete/{id}")
    public String deleteIMC(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
