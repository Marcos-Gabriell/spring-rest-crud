package br.com.curso.spring.curso.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.spring.curso.model.Usuario;
import br.com.curso.spring.curso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;


@RestController
public class GreetingsController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "listatodos")
    @ResponseBody /* Retorna os dados para o corpo da resposta */
    public ResponseEntity<List<Usuario>> listaUsuario() {

        List<Usuario> usuarios = usuarioRepository.findAll(); /*executa a consulta no BD*/

        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);/* Retorna a lista em JSON */
    }

    @PostMapping(value = "salvar") /*Mapeia a URL*/
    @ResponseBody/*Descrição da resposta*/
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){ /* Recebe os dados para salvar*/

        Usuario user = usuarioRepository.save(usuario);

        return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "delete") /*Mapeia a URL*/
    @ResponseBody /*Descrição da resposta*/
    public ResponseEntity<String> delete(@RequestParam Long iduser){ /* Recebe os dados para Deletar*/

        usuarioRepository.deleteById(iduser);

        return new ResponseEntity<String>("User deletado com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping(value = "buscaruserid") /*Mapeia a URL*/
    @ResponseBody /*Descrição da resposta*/
    public ResponseEntity<Usuario> buscaruserid(@RequestParam(name = "iduser") Long iduser){ /* Recebe os dados para Consultar*/

        Usuario usuario = usuarioRepository.findById(iduser).get();

        return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
    }

    @PutMapping(value = "atualizar") /*Mapeia a URL*/
    @ResponseBody /*Descrição da resposta*/
    public ResponseEntity<?> atualizar(@RequestBody Usuario usuario){ /* Recebe os dados para Atualizar*/

        if (usuario.getId() == null) {

            return new ResponseEntity<String>("Id não foi informado, para atualização.", HttpStatus.OK);
        }

        Usuario user = usuarioRepository.saveAndFlush(usuario);

        return new ResponseEntity<Usuario>(user, HttpStatus.OK);
    }

    @GetMapping(value = "buscarPorNome") /*Mapeia a URL*/
    @ResponseBody /*Descrição da resposta*/
    public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam(name = "name") String name){ /* Recebe os dados para Consultar*/

        List<Usuario> usuario = usuarioRepository.buscarPorNome(name.trim().toUpperCase());

        return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.CREATED);
    }




}