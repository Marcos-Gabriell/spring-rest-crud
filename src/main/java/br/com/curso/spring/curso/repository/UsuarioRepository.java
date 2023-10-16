package br.com.curso.spring.curso.repository;

import br.com.curso.spring.curso.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(valeu = "select u from Usuario u where u.nome like %?1%")
    List<Usuario> bsucarPorNome(String nome);
}
