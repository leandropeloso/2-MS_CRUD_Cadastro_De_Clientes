package br.com.admclient.service;

import br.com.admclient.dto.AdmClientDTO;
import br.com.admclient.entity.AdmClientEntity;
import br.com.admclient.exception.AdmClientNotFoundException;
import br.com.admclient.exception.ClientConflictException;
import br.com.admclient.exception.ClientDataIntegrityException;
import br.com.admclient.repository.AdmClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class AdmClientService {
    @Autowired
    private AdmClientRepository clientRepository;

    public AdmClientEntity createClient(@NotNull AdmClientDTO dto) {
        try {
            Optional<AdmClientEntity> existingClient = clientRepository.findById(dto.getCnpj());
            if (existingClient.isPresent()) {
                throw new ClientConflictException("Já existe um cliente com este CNPJ.");
            }

            AdmClientEntity client = new AdmClientEntity();
            client.setCnpj(dto.getCnpj());
            client.setRazaoSocial(dto.getRazaoSocial());
            client.setNomeResponsavel(dto.getNomeResponsavel());
            client.setEmailContato(dto.getEmailContato());

            return clientRepository.save(client);

        } catch (DataIntegrityViolationException ex) {
            throw new ClientDataIntegrityException("Erro de integridade de dados ao criar o cliente.");
        }
    }

    public AdmClientEntity findClientByIdOrAll(String clientId) {
        if (clientId == null) {
            return null;
        } else {
            return clientRepository.findById(clientId)
                    .orElseThrow(() -> new AdmClientNotFoundException(clientId));
        }
    }

    public AdmClientEntity updateClient(String cnpj, AdmClientDTO dto) {
        AdmClientEntity existingClient = clientRepository.findById(cnpj).orElse(null);
        if (existingClient != null) {
            existingClient.setRazaoSocial(dto.getRazaoSocial());
            existingClient.setNomeResponsavel(dto.getNomeResponsavel());
            existingClient.setEmailContato(dto.getEmailContato());
            return clientRepository.save(existingClient);
        } else {
            return null;
        }
    }

    public void deleteClient(String cnpj) {
        clientRepository.deleteById(cnpj);
    }
}