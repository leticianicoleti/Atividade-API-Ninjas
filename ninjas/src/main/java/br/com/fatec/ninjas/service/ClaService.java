package br.com.fatec.ninjas.service;

import br.com.fatec.ninjas.model.Cla;
import br.com.fatec.ninjas.repository.ClaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClaService {

    @Autowired
    private ClaRepository claRepository;

    public Cla cadastrarCla(Cla cla) {
        return claRepository.save(cla);
    }

    public List<Cla> listarClas() {
        return claRepository.findAll();
    }

    public Cla pesquisarCla(Long id) {
        return claRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Clã não encontrado: " + id));
    }

    public List<Cla> pesquisarClaPorNome(String nome) {
        return claRepository.findByNome(nome);
    }

    public List<Cla> pesquisarClaPorDescricao(String descricao) {
        return claRepository.findByDescricaoContaining(descricao);
    }

    @Transactional
    public Cla atualizarCla(Long id, Cla claAtualizado) {
        Cla cla = pesquisarCla(id);
        cla.setNome(claAtualizado.getNome());
        cla.setDescricao(claAtualizado.getDescricao());
        cla.setHabilidade(claAtualizado.getHabilidade());
        return claRepository.save(cla);
    }

    @Transactional
    public void deletarCla(Long id) {
        Cla cla = pesquisarCla(id);
        claRepository.delete(cla);
    }
}
