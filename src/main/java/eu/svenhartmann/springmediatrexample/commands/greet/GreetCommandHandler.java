package eu.svenhartmann.springmediatrexample.commands.greet;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

@Component
public class GreetCommandHandler implements RequestHandler<GreetCommand, String> {

    @Autowired
    Validator validator;
    @Autowired
    private Mediator mediator;

    @Override
    public String handle(@NotNull @Valid GreetCommand greetCommand) {
        val violations = validator.validate(greetCommand);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        // this.mediator.emit(new UserGreetEvent(greetCommand.getName()));
        val greet = String.format("Hi, nice to meet you %s!", greetCommand.getName());
        return greet;
    }
}
