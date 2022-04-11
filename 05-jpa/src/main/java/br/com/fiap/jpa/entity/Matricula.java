package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_matricula")
@SequenceGenerator(name = "matricula", sequenceName = "SQ_TB_MATRICULA", allocationSize = 1)
public class Matricula implements Serializable {

	private static final long serialVersionUID = -3835511267673238010L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricula")
	private Long id;

	@Column(name = "dt_matricula", nullable = false)
	private LocalDate dataMatricula;

	@Column(name = "st_ativo")
	private Boolean ativo;

	@Column(name = "dt_cadastro")
	private LocalDateTime dataCadastro;

	@Column(name = "dt_atualizacao")
	private LocalDateTime dataAtualizacao;

	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="curso_id")
	private Curso curso;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
}
