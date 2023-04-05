package bg.softuni.armory.exceptionHandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ArmoryControllerAdvice {

    @ExceptionHandler({Exception.class})
    public String handleError() {
        return "redirect:/error";
    }
}
