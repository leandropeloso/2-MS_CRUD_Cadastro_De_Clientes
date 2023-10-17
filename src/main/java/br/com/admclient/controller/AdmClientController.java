package br.com.admclient.controller;

import br.com.admclient.dto.AdmClientDTO;
import br.com.admclient.entity.AdmClientEntity;
import br.com.admclient.exception.ClientConflictException;
import br.com.admclient.repository.AdmClientRepository;
import br.com.admclient.service.AdmClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class AdmClientController {
    @Autowired
    private AdmClientService clientService;

    @Autowired
    private AdmClientRepository clientRepository;

    @PostMapping
    public AdmClientEntity createClient(@RequestBody @org.jetbrains.annotations.NotNull AdmClientDTO dto) {
        Optional<AdmClientEntity> existingClient = clientRepository.findById(dto.getCnpj());
        if (existingClient.isPresent()) {
            throw new ClientConflictException("Já existe um cliente com este CNPJ.");
        }
        return clientService.createClient(dto);
    }

    @GetMapping
    public ResponseEntity<?> findClientByIdOrAll(@RequestParam(required = false) String clientId) {
        AdmClientEntity client = clientService.findClientByIdOrAll(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/{cnpj}")
    public AdmClientEntity updateClient(@PathVariable String cnpj, @RequestBody AdmClientDTO dto) {
        return clientService.updateClient(cnpj, dto);
    }

    @DeleteMapping("/{cnpj}")
    public void deleteClient(@PathVariable String cnpj) {
        clientService.deleteClient(cnpj);
    }
}