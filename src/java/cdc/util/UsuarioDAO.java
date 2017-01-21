package cdc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author JM7087-Notbook
 */
public class UsuarioDAO implements DAO {
    private Connection conn;
    
    public UsuarioDAO() throws Exception {
    
        try{
            this.conn = ConnectionDAO.getConnection();
        }catch(Exception e){
            throw new Exception("Erro de conexão:"+e.getMessage());
        }
        
    }
    

    @Override
    public void atualizar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listaTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List procura(Object ob) throws Exception {
        List<Usuario> list = new ArrayList<Usuario>();
          
        Usuario usuario = (Usuario) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if(usuario == null)
            throw new Exception("O valor passado não pode ser nulo");
        try{
            conn = ConnectionDAO.getConnection();
            String SQL = "SELECT * FROM USUARIO ";
            String where = "";
            boolean checa = false;
            if(usuario.getUSU_ID()!=0 || usuario.getUSU_NOME()!=null || usuario.getUSU_TELEFONE()!=null || usuario.getUSU_SEXO()!=null || usuario.getUSU_ENDERECO()!=null || usuario.getUSU_CEP()!=null || usuario.getUSU_CIDADE()!=null || usuario.getUSU_ENDERECO()!=null){
                where = "WHERE ";
                if(usuario.getUSU_ID()!=0){
                    where+= "USU_ID=? ";
                    checa = true;
                }
                if(usuario.getUSU_NOME()!=null){
                    if(checa) where+="AND";
                    where += " USU_NOME=? ";
                    checa = true;
                }
            }
            ps = conn.prepareStatement(SQL+where);
            int contaCampos=1;
            if(usuario.getUSU_ID()!=0 || usuario.getUSU_NOME()!=null || usuario.getUSU_TELEFONE()!=null ||  usuario.getUSU_SEXO()!=null || usuario.getUSU_ENDERECO()!=null || usuario.getUSU_CEP()!=null || usuario.getUSU_CIDADE()!=null || usuario.getUSU_ENDERECO()!=null){
                if (usuario.getUSU_ID()!=0){
                    ps.setInt(contaCampos,usuario.getUSU_ID());
                    contaCampos++;
                }
                if (usuario.getUSU_NOME()!=null){
                    ps.setString(contaCampos,usuario.getUSU_NOME());
                    contaCampos++;
                }
            }
//            ps = conn.prepareStatement("SELECT * FROM USUARIO WHERE USU_NOME=?");
//            ps.setString(1, usuario.getUSU_NOME());
            rs = ps.executeQuery();
            
            while(rs.next()){
                Integer usu_id = rs.getInt(1);
                String usu_nome = rs.getString(2);
                String usu_telefone = rs.getString(3);
                String usu_sexo = rs.getString(4);
                String usu_endreco = rs.getString(5);
                String usu_cep = rs.getString(6); 
                String usu_cidade = rs.getString(7);
                String usu_estado = rs.getString(8);
                list.add(new Usuario(usu_id,usu_nome,usu_telefone,usu_sexo,usu_endreco,usu_cep,usu_cidade,usu_estado));
            }
//            return list;
        }catch(SQLException sqle){
        //}catch(Exception e){
            throw new Exception("Erro SQL:" + sqle);
            //throw new Exception();
        }finally{
            ConnectionDAO.closeConnection(conn,ps,rs);
        }
          return list;
    }

    @Override
    public void salvar(Object ob) throws Exception {
        Usuario usuario;
        usuario = (Usuario) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (usuario == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }        
        try {
            //String SQL = "INSERT INTO USUARIO (usu_nome, usu_telefone, usu_sexo, usu_endereco, usu_cep, usu_cid_id) VALUES (?,?,?,?,?,1)"; 
            //String SQL = "INSERT INTO  `Loja-Online`.`USUARIO` (`USU_ID`,`USU_NOME`,`USU_TELEFONE`,`USU_SEXO`,`USU_ENDERECO`,`USU_CEP`,"
            //        + "`USU_CIDADE`,`USU_ESTADO´) VALUES (NULL, \"uala\", \"u\", '', '', '', '', '')";
            String SQL = "INSERT INTO `Loja-Online`.`USUARIO` (`USU_ID`, `USU_NOME`, `USU_TELEFONE`, `USU_SEXO`, `USU_ENDERECO`, `USU_CEP`, `USU_CIDADE`, "
                    + "`USU_ESTADO`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?);";

            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, usuario.getUSU_NOME());
            ps.setString(2, usuario.getUSU_TELEFONE());
            ps.setString(3, usuario.getUSU_SEXO());
            ps.setString(4, usuario.getUSU_ENDERECO());
            ps.setString(5, usuario.getUSU_CEP());
            ps.setString(6, usuario.getUSU_CIDADE());
            ps.setString(7, usuario.getUSU_ESTADO());
            ps.executeUpdate();  
        } catch (SQLException sqle) {
        throw new Exception("Erro ao inserir dados do usuario: \n"+sqle);

      } finally{
            ConnectionDAO.closeConnection(conn,ps);
        }
    }
    
   
}