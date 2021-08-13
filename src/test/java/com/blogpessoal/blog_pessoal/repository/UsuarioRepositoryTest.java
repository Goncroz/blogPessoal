package com.blogpessoal.blog_pessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.blogpessoal.blog_pessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {
		Usuario usuario = new Usuario(0L, "Layla Gonçalves", "layla@email.com", "123456");

		if (!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);

		usuario = new Usuario(0L, "Ceiça Gonçalves", "ceica@email.com", "123456");

		if (!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);

		usuario = new Usuario(0L, "Rayssa Gonçalves", "rayssa@email.com", "123456");

		if (!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);

		usuario = new Usuario(0L, "Rayane Jesus", "jady@email.com", "123456");

		if (!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
	}
	
	@Test
	@DisplayName("🔛 Retorna Nome")
	public void findByRetornaNome()
	{
		Usuario usuario = usuarioRepository.findByNome("Ceiça Gonçalves");
		assertTrue(usuario.getNome().equals("Ceiça Gonçalves"));
	}
	
	@Test
	@DisplayName("❤ Retorna 3 Usuários")
	public void findAllByNomeContainingIgnoreCaseRetornaTresUsuarios()
	{
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Gonçalves");
		assertEquals(3, listaDeUsuarios.size());
	}
	
	@AfterAll
	public void end()
	{
		System.out.println("Teste Finalizado!");
	}

}
