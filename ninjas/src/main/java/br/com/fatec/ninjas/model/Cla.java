package br.com.fatec.ninjas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "cla")
public class Cla {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cla")
    private Long id;

    @Column(name = "nome_cla", nullable = false, length = 50)
    @NotBlank(message = "Nome é obrigatório!")
    @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres.")
    private String nome;

    @Column(name = "descricao_cla", nullable = false)
    @NotBlank(message = "Descrição é obrigatória!")
    private String descricao;

    @Column(name = "habilidade_cla", nullable = false)
    @NotBlank(message = "Habilidade é obrigatória!")
    private String habilidade;
}