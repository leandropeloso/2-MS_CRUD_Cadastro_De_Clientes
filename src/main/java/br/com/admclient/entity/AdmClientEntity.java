package br.com.admclient.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AdmClientEntity {
    @Id
    private String cnpj;
    private String razaoSocial;
    private String nomeResponsavel;
    private String emailContato;
}
