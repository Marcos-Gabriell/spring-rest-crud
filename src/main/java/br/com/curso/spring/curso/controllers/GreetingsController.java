package br.com.curso.spring.curso.controllers;

import br.com.curso.spring.curso.model.Usuario;
import br.com.curso.spring.curso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String retornaOlaMundo(@PathVariable String nome) {
        Usuario usuario = new Usuario();

        // Set the name of the Usuario object using the setNome method
        usuario.setNome(nome);

        // Save the Usuario object to the repository
        usuarioRepository.save(usuario);

        return "Olá mundo " + nome;
    }

}
