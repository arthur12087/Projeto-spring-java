package br.iesp.edu.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String NomeCompleto;

    @Column(unique = true)
    private String userName;

    private String DataNascimento;

    @Column(unique=true)
    private String email;

    private String senha;
    private String confirmarSenha;

    @Column(unique=true)
    private String cpf;

    @OneToOne
    @JoinColumn(name = "cartao_id")
    private Cartao cartao;
}
