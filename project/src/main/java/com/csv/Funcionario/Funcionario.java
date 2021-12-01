package com.csv.Funcionario;

public class Funcionario {
    private int id;
    private double salario;
    private int numFihos;


    public Funcionario(int id, double salario, double d) {
        this.id = id;
        this.salario = salario;
        this.numFihos = d;
    }

    public int getId() {
        return id;
    }

    public double getSalario() {
        return salario;
    }

    public int getNumFihos() {
        return numFihos;
    }

}
