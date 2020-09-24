package eu.svenhartmann.springmediatrexample.commands.greet;


import io.jkratz.mediator.core.Request;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class GreetCommand implements Request<String> {

    @NotBlank
    @Getter
    private final String name;

    public GreetCommand(String name) {
        this.name = name;
    }

}
