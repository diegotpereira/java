package br.com.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.java.exception.ResourceNotFoundException;
import br.com.java.model.Funcionario;
import br.com.java.repository.FuncionarioRepository;

// @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioRepository repository;

    @GetMapping("/funcionarios")
    public List<Funcionario> buscarTodosFuncionarios() {

        return repository.findAll();
    }

    @PostMapping("/funcionarios")
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {

        return repository.save(funcionario);
    }

    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable Long id) {
        Funcionario funcionario = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Funcionário não existe com id :" + id));

        return ResponseEntity.ok(funcionario);
    }

    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> alterarFuncioonario(@PathVariable Long id, @RequestBody Funcionario funcionarioDetalhes) {
        Funcionario funcionario = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Funcionário não existe com id ;" + id ));

        funcionario.setNome(funcionarioDetalhes.getNome());
        funcionario.setSobreNome(funcionarioDetalhes.getSobreNome());
        funcionario.setEmailId(funcionarioDetalhes.getEmailId());

        Funcionario alteraFuncionario = repository.save(funcionario);

        return ResponseEntity.ok(alteraFuncionario);
    }

    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<Map<String, Boolean>>  deletarFuncionario(@PathVariable Long id) {

        Funcionario funcionario = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Funcionário não existe com id :" + id));

        repository.delete(funcionario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("excluído", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
