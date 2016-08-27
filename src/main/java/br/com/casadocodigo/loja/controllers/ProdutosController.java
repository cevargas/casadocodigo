package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoLivro;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author CarlosEduardode
 */
@Controller
@Transactional
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView list() {
        System.out.println("Listando produtos");        
        ModelAndView modelAndView = new ModelAndView("produtos/list");
        modelAndView.addObject("produtos", produtoDAO.list());
        return modelAndView;  
    }

    @RequestMapping(method=RequestMethod.POST)
    public String save(Produto produto, RedirectAttributes redirectAttributes) {
        System.out.println("Cadastrando o produto " + produto);
        produtoDAO.save(produto);
        
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
        return "redirect:produtos";    
    }

    @RequestMapping("/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoLivro.values());
        return modelAndView;
    }
}