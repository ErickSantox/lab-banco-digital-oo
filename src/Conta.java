public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.SEQUENCIAL++;
        this.cliente = cliente;
    }

    public boolean sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Erro. Valor acima do saldo");
            return false;
        } else {
            saldo -= valor;
            System.out.println("O saque foi efetuado com sucesso!");
            return true;
        }
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro. Valor do depósito deve ser maior que 0,00");
        } else {
            saldo += valor;
            System.out.println("Valor depositado com sucesso");
        }
    }

    public boolean transferir(double valor, Conta contaDestino) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public void imprimirSaldo() {
        System.out.println(saldo);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void imprimirInfoComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public abstract void imprimirExtrato();
}
