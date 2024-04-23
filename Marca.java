package Repositório.TrabalhoEDI;

public class Marca{
    private String marca;
    private int identificador;
    public Marca(){}
    public Marca(String marca, int identificador){
        this.marca = marca;
        this.identificador = identificador;
    }
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public int getIdentificador(){
        return identificador;
    }
    public void setIdentificador(){
        this.identificador = identificador;
    }
    @Override
    public String toString(){
        return "Marca: " + getMarca() + "|" + "Identificador" + getIdentificador();
    }
}
