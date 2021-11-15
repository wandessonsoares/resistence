package dev.wandesson.resistence.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Rebelde {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rebelde")
    private Integer id;

    @Column(length = 100)
    private String nome;

    private Integer idade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_localizacao")
    private Localizacao localizacao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_recurso")
    private List<Recurso> recursos = new ArrayList<Recurso>();

    @JsonIgnore
    private Boolean traidor = false;

    @JsonIgnore
    private Integer indicacoes = 0;

}
