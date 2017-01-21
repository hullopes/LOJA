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
public class Login {
    private int LOG_ID; 
    private String LOG_EMAIL;
    private String LOG_SENHA; 
    private int USUARIO_USU_ID;

    public Login(int LOG_ID, String LOG_EMAIL, String LOG_SENHA, int USUARIO_USU_ID) {
        this.LOG_ID = LOG_ID;
        this.LOG_EMAIL = LOG_EMAIL;
        this.LOG_SENHA = LOG_SENHA;
        this.USUARIO_USU_ID = USUARIO_USU_ID;
    }

    public int getLOG_ID() {
        return LOG_ID;
    }

    public void setLOG_ID(int LOG_ID) {
        this.LOG_ID = LOG_ID;
    }

    public String getLOG_EMAIL() {
        return LOG_EMAIL;
    }

    public void setLOG_EMAIL(String LOG_EMAIL) {
        this.LOG_EMAIL = LOG_EMAIL;
    }

    public String getLOG_SENHA() {
        return LOG_SENHA;
    }

    public void setLOG_SENHA(String LOG_SENHA) {
        this.LOG_SENHA = LOG_SENHA;
    }

    public int getUSUARIO_USU_ID() {
        return USUARIO_USU_ID;
    }

    public void setUSUARIO_USU_ID(int USUARIO_USU_ID) {
        this.USUARIO_USU_ID = USUARIO_USU_ID;
    }

     
    
}
