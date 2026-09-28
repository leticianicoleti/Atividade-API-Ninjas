package br.com.fatec.ninjas.model;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data; //cria o construtor
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name = "ninja")
@Valid
public class Ninja {
    @Id //chave primária
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id_ninja;

    @Column(name = "nome_ninja", nullable = false)
    @NotBlank(message = "Nome é obrigatório!")
    @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres.")
    private String nome;


    @Column(name = "cpf_ninja", nullable = false, unique = true)
    @CPF
    private String cpf;

    @Column(name = "email_ninja", nullable = false, unique = true)
    @Email(message = "Email inválido(email@email.com)")
    private String email;
}


