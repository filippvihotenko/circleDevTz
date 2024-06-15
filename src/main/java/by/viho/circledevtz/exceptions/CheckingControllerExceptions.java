package by.viho.circledevtz.exceptions;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class CheckingControllerExceptions
{
    public static void checkingErrors(BindingResult bindingResult) throws NotCreatedProductException
    {
        if(bindingResult.hasErrors()){
            StringBuilder str = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors)
            {
                str.append(error.getField()).append(" - ").append(error.getDefaultMessage());}
            throw new NotCreatedProductException(str.toString());
        }
    }
}
