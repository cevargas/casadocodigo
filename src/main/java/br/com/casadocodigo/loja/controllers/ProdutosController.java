package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoLivro;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.MultipartFile;

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
    
    @Autowired
    private FileSaver fileSaver;
    
    //nao precisa mais desse validato pq esta sendo validado via annotations no Model
    /*@InitBinder
        protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ProdutoValidator());
    }*/

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView list() {
        System.out.println("Listando produtos");        
        ModelAndView modelAndView = new ModelAndView("produtos/list");
        modelAndView.addObject("produtos", produtoDAO.list());
        return modelAndView;  
    }

    @RequestMapping(method=RequestMethod.POST, name="saveProduto")
    public ModelAndView save(MultipartFile sumario, @Valid Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        System.out.println(sumario.getName() + ";"  +sumario.getOriginalFilename());
        if(bindingResult.hasErrors()){
            return form(produto);
        }
        
        System.out.println("Cadastrando o produto " + produto);
        
        String webPath = fileSaver.write("uploaded-images", sumario);
        produto.setSumarioPath(webPath);        
        
        produtoDAO.save(produto);
        
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
        return new ModelAndView("redirect:produtos");  
    }

    @RequestMapping("/form")
    public ModelAndView form(Produto produto) {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoLivro.values());
        return modelAndView;
    }
}