public class Main {
    public static void main(String[] args) {
        Cliente erick = new Cliente("Erick", "123.456.789-00");
        Cliente melissa = new Cliente("Melissa", "987.654.321-00");

        Conta cc = new ContaCorrente(erick);
        Conta poupanca = new ContaPoupanca(melissa);

        Banco banco = new Banco("Meu Banco");
        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.depositar(600.00);
        cc.sacar(1000);
        cc.imprimirSaldo();
        cc.transferir(200, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        Conta contaEncontrada = banco.buscarContaPorCpf("123.456.789-00");
        if (contaEncontrada != null) {
            System.out.println("Conta encontrada para CPF 123.456.789-00:");
            contaEncontrada.imprimirExtrato();
        } else {
            System.out.println("Conta não encontrada para CPF 123.456.789-00.");
        }
    }
}
