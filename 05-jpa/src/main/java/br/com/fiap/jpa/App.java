package br.com.fiap.jpa;

import java.time.LocalDate;

import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.Curso;
import br.com.fiap.jpa.entity.Disciplina;
import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.entity.Matricula;
import br.com.fiap.jpa.service.impl.AlunoServiceImpl;
import br.com.fiap.jpa.service.impl.CursoServiceImpl;
import br.com.fiap.jpa.service.impl.DisciplinaServiceImpl;
import br.com.fiap.jpa.service.impl.MatriculaServiceImpl;

public class App {

	public static void main(String[] args) {
		AlunoServiceImpl alunoService = AlunoServiceImpl.getInstance();
		DisciplinaServiceImpl disciplinaService = DisciplinaServiceImpl.getInstance();
		CursoServiceImpl cursoService = CursoServiceImpl.getInstance();
		MatriculaServiceImpl matriculaService = MatriculaServiceImpl.getInstance();

		Aluno aluno3 = new Aluno("Aluno3", "33333", "333.333.333-33", LocalDate.of(1980, 1, 1));
		alunoService.inserir(new Aluno("Aluno1", "11111", "111.111.111-11", LocalDate.of(1980, 1, 1)));
		alunoService.inserir(new Aluno("Aluno2", "22222", "222.222.222-22", LocalDate.of(1980, 1, 1)));

		Endereco endereco = new Endereco("Av.Paulista", 777, "5 andar ", "Bela Vista", "São Paulo", "SP", "04566-333");

		alunoService.inserirComEndereco(aluno3, endereco);

		Aluno aluno = alunoService.obter(3L);

		System.out.println(aluno);

		Curso curso = new Curso("TDS");
		cursoService.inserir(curso);

		cursoService.listar().forEach(System.out::println);
		
		Disciplina disciplina = new Disciplina ("EAD", 60, curso);
		disciplinaService.inserir(disciplina);
		disciplinaService.listar().forEach(System.out::println);
		
		//alunoService.matricular(aluno.getId(),curso.getId());
		
		Matricula matricula = new Matricula();
		matricula.setAluno(aluno3);
		matricula.setCurso(curso);
		matricula.setDataMatricula(LocalDate.now());
		matriculaService.inserir(matricula);
	}
}
