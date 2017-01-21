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
public class Cidade {
    private int CID_ID;
    private String CID_NOME;
    private String CID_UF;

    public Cidade(int CID_ID, String CID_NOME, String CID_UF) {
        this.CID_ID = CID_ID;
        this.CID_NOME = CID_NOME;
        this.CID_UF = CID_UF;
    }

    public int getCID_ID() {
        return CID_ID;
    }

    public void setCID_ID(int CID_ID) {
        this.CID_ID = CID_ID;
    }

    public String getCID_NOME() {
        return CID_NOME;
    }

    public void setCID_NOME(String CID_NOME) {
        this.CID_NOME = CID_NOME;
    }

    public String getCID_UF() {
        return CID_UF;
    }

    public void setCID_UF(String CID_UF) {
        this.CID_UF = CID_UF;
    }
    
}
