package Programa;

import Utilitarios.Utils;

public class Conta {

    private static int contadorDeContas = 1;
    private int numeroConta;
    private Pessoa pessoa;
    private double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas++;
    }

    public static int getContadorDeContas() {
        return contadorDeContas;
    }

    public static void setContadorDeContas(int contadorDeContas) {
        Conta.contadorDeContas = contadorDeContas;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "\nNúmero da Conta: " + this.getNumeroConta() +
                "\nNome: "            + this.pessoa.getNome() +
                "\nCPF: "             + this.pessoa.getCpf() +
                "\nEmail: "           + this.pessoa.getEmail() +
                "\nSaldo: "           + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar(Double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso!");
        }else{
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void sacar(Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque foi realizado com sucesso!");
        }else{
            System.out.println("Não foi possível realizar o saque!");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valorParaTransferir){
        if(valorParaTransferir > 0 && this.getSaldo() >= valorParaTransferir){
            setSaldo(getSaldo() - valorParaTransferir);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valorParaTransferir;
            System.out.println("Transferência realizada com sucesso!");
        }else{
            System.out.println("Não foi possível realizar a transferência!");
        }
    }
}
