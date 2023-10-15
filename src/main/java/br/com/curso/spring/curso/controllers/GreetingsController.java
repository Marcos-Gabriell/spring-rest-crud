package br.com.curso.spring.curso.controllers;

import br.com.curso.spring.curso.model.Usuario;
import br.com.curso.spring.curso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "listatodos")
    @ResponseBody
    public ResponseEntity<List<Usuario>> listaUsuario() {

        List<Usuario> usuarios =  usuarioRepository.findAll();

        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }

    @PostMapping(value = "salvar")
    @ResponseBody
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {

      Usuario user =  usuarioRepository.save(usuario);

      return  new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long id) {
        usuarioRepository.deleteById(id);
        return new ResponseEntity<String>("Usuário deletado com sucesso", HttpStatus.OK);
    }



}
