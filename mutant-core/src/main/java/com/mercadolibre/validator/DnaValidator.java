package com.mercadolibre.validator;

import com.mercadolibre.domain.DnaRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jesus.leon on 27/05/18.
 */
public class DnaValidator implements ConstraintValidator<DnaInRange, DnaRequest> {
    @Override
    public void initialize(DnaInRange constraintAnnotation) {
    }

    @Override
    public boolean isValid(DnaRequest value, ConstraintValidatorContext context) {
        Pattern p = Pattern.compile("[^ATCG]");

        if ((value != null) && (value.getDna() != null)) {
            for (String seq : value.getDna()) {
                Matcher m = p.matcher(seq);

                if (m.find()) {
                    return false;
                }

                if (value.getDna().length != seq.length()) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }
}
