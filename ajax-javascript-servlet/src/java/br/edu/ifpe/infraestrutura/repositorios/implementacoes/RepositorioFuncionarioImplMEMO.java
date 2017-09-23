/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.infraestrutura.repositorios.implementacoes;

import br.edu.ifpe.infraestrutura.repositorios.interfaces.RepositorioGenerico;
import br.edu.ifpe.negocio.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class RepositorioFuncionarioImplMEMO implements RepositorioGenerico<Funcionario> {

    private List<Funcionario> funcionarios;

    public RepositorioFuncionarioImplMEMO() {
	funcionarios = new ArrayList<>();
    }

    @Override
    public void inserir(Funcionario t) {
	funcionarios.add(t);
    }

    @Override
    public void alterar(Funcionario t) {
	for (Funcionario funcionario : funcionarios) {
	    if (funcionario.getCodigo() == t.getCodigo()) {
		funcionario.setFuncao(t.getFuncao());
		funcionario.setNome(t.getNome());
		break;
	    }
	}
    }

    @Override
    public Funcionario recuperar(int codigo) {
	for (Funcionario funcionario : funcionarios) {
	    if (funcionario.getCodigo() == codigo) {
		return funcionario;
	    }
	}
	return null;
    }

    @Override
    public void deletar(Funcionario t) {
	funcionarios.remove(t);
    }

    @Override
    public List<Funcionario> recuperarTodos() {
	return funcionarios;
    }

}
