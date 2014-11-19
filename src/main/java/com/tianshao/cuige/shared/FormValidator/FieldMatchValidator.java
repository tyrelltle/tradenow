package com.tianshao.cuige.shared.FormValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>
{
    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation)
    {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context)
    {	boolean ret=false;
    	final Object firstObj;
    	final Object secondObj;
        try
        {
             firstObj = BeanUtils.getProperty(value, firstFieldName);
             secondObj = BeanUtils.getProperty(value, secondFieldName);

            ret= firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ignore)
        {
            // ignore
        }
        if(!ret)
                addConstraintViolation(context, " fields do not match",secondFieldName);
            
        return ret;
    }
    
    private void addConstraintViolation(ConstraintValidatorContext context, String message, String field) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addNode(field).addConstraintViolation();
    }
}