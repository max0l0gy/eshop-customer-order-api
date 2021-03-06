package ru.maxmorev.eshop.customer.order.api.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ru.maxmorev.eshop.customer.order.api.repository.ShoppingCartRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckShoppingCartIdValidator implements ConstraintValidator<CheckShoppingCartId, Long> {

    private final ShoppingCartRepository scr;


    public CheckShoppingCartIdValidator(@Autowired ShoppingCartRepository repo){
        this.scr = repo;
    }

    @Override
    public void initialize(CheckShoppingCartId constraintAnnotation) {
        //do nothing
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return scr.existsById(value);
    }
}
