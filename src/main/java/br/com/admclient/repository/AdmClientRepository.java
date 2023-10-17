package br.com.admclient.repository;

import br.com.admclient.entity.AdmClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdmClientRepository extends CrudRepository<AdmClientEntity, String> {
}