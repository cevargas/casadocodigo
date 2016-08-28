
package br.com.casadocodigo.loja.validations;

import br.com.casadocodigo.loja.models.Produto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author CarlosEduardode
 */
public class ProdutoValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
            return Produto.class.isAssignableFrom(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "field.required");
  
        Produto produto = (Produto) target;
        
        if(produto.getNumeroDePaginas() == 0) {
            errors.rejectValue("numeroDePaginas", "field.required");
        }        
    }
}
