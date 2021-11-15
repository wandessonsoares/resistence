package dev.wandesson.resistence.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer quantidade;

    @Column(length = 50)
    private String nome;

    private Integer pontos;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rebelde rebelde;

    public Recurso(String nome, Integer pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }
}
