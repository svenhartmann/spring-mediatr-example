package eu.svenhartmann.springmediatrexample.adapter.rest;

import eu.svenhartmann.springmediatrexample.commands.greet.GreetCommand;
import io.jkratz.mediator.core.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class ExampleController {
    private final Mediator mediator;

    @Autowired
    public ExampleController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("/greet")
    public CompletableFuture<ResponseEntity<String>> greetCommand(@RequestParam String name) {
        return this.mediator.dispatchAsync(new GreetCommand(name))
                .thenApply(ResponseEntity::ok);

    }
}
