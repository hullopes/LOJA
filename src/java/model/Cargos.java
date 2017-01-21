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
public class Cargos {
    private int CAR_ID;
    private String CAR_FUNCAO;

    public Cargos(int CAR_ID, String CAR_FUNCAO) {
        this.CAR_ID = CAR_ID;
        this.CAR_FUNCAO = CAR_FUNCAO;
    }

    public int getCAR_ID() {
        return CAR_ID;
    }

    public void setCAR_ID(int CAR_ID) {
        this.CAR_ID = CAR_ID;
    }

    public String getCAR_FUNCAO() {
        return CAR_FUNCAO;
    }

    public void setCAR_FUNCAO(String CAR_FUNCAO) {
        this.CAR_FUNCAO = CAR_FUNCAO;
    }
    
    
    
}
