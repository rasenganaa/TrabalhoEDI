import java.util.Date;

public class Locacao {
    private String CNHCliente;
    private String placaVeiculo;
    private Date dataRetirada;
    private Date dataDevolucao;
    private double valorPago;
    private Locacao proximo;

    public Locacao(String CNHCliente, String placaVeiculo, Date dataRetirada, Date dataDevolucao, double valorPago) {
        this.CNHCliente = CNHCliente;
        this.placaVeiculo = placaVeiculo;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.valorPago = valorPago;
        this.proximo = null;
    }

    // Getters e Setters

    public String getCNHCliente() {
        return CNHCliente;
    }

    public void setCNHCliente(String CNHCliente) {
        this.CNHCliente = CNHCliente;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Locacao getProximo() {
        return proximo;
    }

    public void setProximo(Locacao proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "CNH Cliente: " + CNHCliente + ", Placa Veículo: " + placaVeiculo +
                ", Data Retirada: " + dataRetirada + ", Data Devolução: " + dataDevolucao +
                ", Valor Pago: " + valorPago;
    }

}
