package eu.svenhartmann.springmediatrexample.commands.greet;

import io.jkratz.mediator.core.Event;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class UserGreetEvent implements Event {
    @NotBlank
    @Getter
    private final String name;

    public UserGreetEvent(String name) {
        this.name = name;
    }
}
