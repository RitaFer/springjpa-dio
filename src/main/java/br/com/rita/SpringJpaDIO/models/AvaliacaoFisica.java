package br.com.rita.SpringJpaDIO.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AvaliacaoFisica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Aluno_id", referencedColumnName = "id")
    private Aluno aluno;
    private LocalDate dataAvaliacao = LocalDate.now();
    @Column(name = "peso_atual")
    private Double peso;
    @Column(name = "altura_atual")
    private Double altura;
}
