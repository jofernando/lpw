/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controladores;

import br.edu.ifpe.infraestrutura.repositorios.implementacoes.RepositorioClienteImplMEMO;
import br.edu.ifpe.infraestrutura.repositorios.implementacoes.RepositorioFuncionarioImplMEMO;
import br.edu.ifpe.infraestrutura.repositorios.interfaces.RepositorioGenerico;
import br.edu.ifpe.negocio.Cliente;
import br.edu.ifpe.negocio.Funcionario;
import java.util.List;

/**
 *
 * @author 1860915
 */
public class Fachada {

    private static Fachada myself = null;

    RepositorioGenerico<Cliente> repositorioCliente = null;
    RepositorioGenerico<Funcionario> repositorioFuncionario = null;

    public static Fachada getInstance() {
	if (myself == null) {
	    myself = new Fachada();
	}

	return myself;
    }

    private Fachada() {
	repositorioCliente = new RepositorioClienteImplMEMO();
	repositorioFuncionario = new RepositorioFuncionarioImplMEMO();
    }

    public void inserir(Cliente c) {
	this.repositorioCliente.inserir(c);
    }

    public void alterar(Cliente c) {
	this.repositorioCliente.alterar(c);
    }

    public Cliente recuperarCliente(int codigo) {
	return this.repositorioCliente.recuperar(codigo);
    }

    public void deletar(Cliente c) {
	this.repositorioCliente.deletar(c);
    }

    public List<Cliente> recuperarTodosClientes() {
	return this.repositorioCliente.recuperarTodos();
    }

    public void inserir(Funcionario f) {
	this.repositorioFuncionario.inserir(f);
    }

    public Funcionario recuperarFuncionario(int codigo) {
	return repositorioFuncionario.recuperar(codigo);
    }

    public void deletar(Funcionario f) {
	this.repositorioFuncionario.deletar(f);
    }

    public void alterar(Funcionario f) {
	this.repositorioFuncionario.alterar(f);
    }

    public List<Funcionario> recuperarFuncionarios() {
	return this.repositorioFuncionario.recuperarTodos();
    }

}
