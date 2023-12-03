package com.vanbora.vanbora.services;


import java.util.Optional;

import com.vanbora.vanbora.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vanbora.vanbora.repositories.UsuarioRepository;


import jakarta.transaction.Transactional;


@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    
    


    public Usuario findById(Long cpf) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(cpf);
        return usuario.orElseThrow(() -> new RuntimeException(
            "Objeto não encontrado! Id: " + cpf + ", Tipo: " + Usuario.class.getName()));
    }


    @Transactional
    public Usuario create(Usuario usuario) {
        
        return this.usuarioRepository.save(usuario);
    }


@Transactional
    public Usuario update(Usuario usuario) {
        Usuario novUsuario = this.findById(usuario.getCPF());
        novUsuario.setNome(usuario.getNome());
        novUsuario.setEmail(usuario.getEmail());
        novUsuario.setMetodoPagamento(usuario.getMetodoPagamento());
        return this.usuarioRepository.save(novUsuario);
    }

    @Transactional

    public void delete(Long cpf) {
        findById(cpf);
        try{
            this.usuarioRepository.deleteById(cpf);}
        catch (Exception e){
            throw new RuntimeException("Não foi possível deletar o usuário");
        }
    }
}
