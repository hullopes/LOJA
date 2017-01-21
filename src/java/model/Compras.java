/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author JM7087-Notbook
 */
public class Compras {
    private int COM_ID; 
    private int COM_NUMERO_PEDIDO;
    private String COM_SITUACAO;
    private String COM_FORMA_PAGQAMENTO;
    private int USUARIO_USU_ID;

    public Compras(int COM_ID, int COM_NUMERO_PEDIDO, String COM_SITUACAO, String COM_FORMA_PAGQAMENTO, int USUARO_USU_ID) {
        this.COM_ID = COM_ID;
        this.COM_NUMERO_PEDIDO = COM_NUMERO_PEDIDO;
        this.COM_SITUACAO = COM_SITUACAO;
        this.COM_FORMA_PAGQAMENTO = COM_FORMA_PAGQAMENTO;
        this.USUARIO_USU_ID = USUARO_USU_ID;
    }

    public int getCOM_ID() {
        return COM_ID;
    }

    public void setCOM_ID(int COM_ID) {
        this.COM_ID = COM_ID;
    }

    public int getCOM_NUMERO_PEDIDO() {
        return COM_NUMERO_PEDIDO;
    }

    public void setCOM_NUMERO_PEDIDO(int COM_NUMERO_PEDIDO) {
        this.COM_NUMERO_PEDIDO = COM_NUMERO_PEDIDO;
    }

    public String getCOM_SITUACAO() {
        return COM_SITUACAO;
    }

    public void setCOM_SITUACAO(String COM_SITUACAO) {
        this.COM_SITUACAO = COM_SITUACAO;
    }

    public String getCOM_FORMA_PAGQAMENTO() {
        return COM_FORMA_PAGQAMENTO;
    }

    public void setCOM_FORMA_PAGQAMENTO(String COM_FORMA_PAGQAMENTO) {
        this.COM_FORMA_PAGQAMENTO = COM_FORMA_PAGQAMENTO;
    }

    public int getUSUARIO_USU_ID() {
        return USUARIO_USU_ID;
    }

    public void setUSUARIO_USU_ID(int USUARIO_USU_ID) {
        this.USUARIO_USU_ID = USUARIO_USU_ID;
    }

}
