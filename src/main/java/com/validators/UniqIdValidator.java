package com.validators;

import org.apache.log4j.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.service.PersonService.getById;

public class UniqIdValidator implements ConstraintValidator<UniqId, String> {

    private Logger logger = Logger.getLogger(UniqIdValidator.class);

    @Override
    public boolean isValid(String persId, ConstraintValidatorContext context) {
        logger.info("Start validation");
        return !getById(persId)
                .filter(pers -> pers.getId().equals(persId))
                .isPresent();
    }
}
