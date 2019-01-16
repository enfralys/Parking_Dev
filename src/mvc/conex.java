package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import views.RegistroVehiculo;

public class conex {
   private Connection conn;
	private PreparedStatement pstmt;
        
            
        
        
	// Metodo para conectar a Bd
	public void conectarMSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/prg2","root","");
		} catch (Exception e) {
			System.out.println("Error de conexion con la BD");
			//e.printStackTrace();
		}
	}
        //Metodo para cerrar conexion a BD
	public void conectarSQLITE() {
            try {
                 //para sqlite
                //Class.forName("org.sqlite.jdbc");
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection( "jdbc:sqlite:BD.sqlite");
                System.out.print("Conexion realizada");
            } catch (Exception e) {e.printStackTrace();}        
        }
        public void desconectar() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
        public void BorrarTabla() {
            String sql;
            try {
                sql="DROP TABLE parking";
                pstmt= conn.prepareStatement(sql);
                pstmt.execute();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al borrsr tabla en Base de Datos",null,0);
            }
        }
        public void CrearTabla() {
            String sql;
            try {
                sql="CREATE TABLE parking ( placa varchar(45) NOT NULL, visitante varchar(45) NOT NULL, puesto int(10) NOT NULL,  apart varchar(12) NOT NULL)";
                pstmt= conn.prepareStatement(sql);
                pstmt.execute();
                //JOptionPane.showMessageDialog(null,"Base de datos creado con exito");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al crear tabla en Base de Datos",null,0);
            }
        }
        public void guardar(RegistroVehiculo reg, int puesto) {
            try {
            pstmt=conn.prepareStatement("insert into parking (placa, visitante, puesto, apart) values (?,?,?,?)");
            pstmt.setString(1, reg.getTxtPlaca().getText());
            pstmt.setString(2, reg.getTxtNombreVisitante().getText());
            pstmt.setInt(3, puesto);
            pstmt.setString(4, reg.getTxtApartamento().getText());
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
            
        }
        public registro consultar(int puesto) {
        registro est=new registro();
        ResultSet rs;
        try {
            pstmt=conn.prepareStatement("select * from  parking where puesto=?");
            pstmt.setInt(1, puesto);
            rs=pstmt.executeQuery();
            while (rs.next()){
                est.setApto(rs.getString("apart"));
                est.setNombre_invitado(rs.getString("visitante"));
                est.setPlaca(rs.getString("placa"));
                est.setPuesto(rs.getInt("puesto"));
            }
        } catch (SQLException e) {  e.printStackTrace();}
        return est;
    }
    /*public ResultSet consultarTodo() {
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement("select * from  libro");
            rs=pstmt.executeQuery();
             
        } catch (SQLException e) {  e.printStackTrace();}
        return rs;
    }
    public boolean actualizar(libros Datos) {
        boolean exito=true;
        try {
            pstmt=conn.prepareStatement("update libro set autor=?, titulo=?, tipo=?, vendido=?  where cota=?");
            pstmt.setInt(5, Datos.getCota());
            pstmt.setString(1, Datos.getAutor());
            pstmt.setString(2, Datos.getTitulo());
            pstmt.setInt(3, Datos.getTipo());
            pstmt.setInt(4, Datos.getVendido());
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace(); exito=false;}
        return exito;
         
    }
 
    public void eliminar(int cota) {
    try {
        pstmt=conn.prepareStatement("delete from libro where cota=?");
        pstmt.setInt(1, cota);
        pstmt.execute();
    } catch (SQLException e) {  e.printStackTrace();}
         
    }
   
    public void desconecta(){
        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
        */
//private Modelo mod;
//	public static void main(String[] args) {
	//	Conexion BD= new Conexion();
		//BD.conectar();
		//BD.borrarTabla();
		//BD.crearTabla();
		//BD.insertarDatos(4, 11, "AA", "BB");
		//BD.eliminarRegistro(1);
		//BD.modificaDatos(3,13849641, "Jose", "Perez");
		//BD.buscarDato(2);
		//BD.buscarTodo();
		//BD.desconectar();

	//public Modelo getMod() { return mod;	}
	//public void setMod(Modelo mod){ this.mod = mod; }
	//}
	
        /*
	public void crearTabla(){
		try {
			pstmt= conn.prepareStatement("CREATE TABLE personas (id int(11) NOT NULL, ced int(11) NOT NULL,nombre varchar(65) NOT NULL, apellido varchar(65) NOT NULL )");
			pstmt.execute();
			System.out.println("Creada tabla persona exito");
		} catch (SQLException e) { System.out.println("Tabla personas ya fue creada");
			//e.printStackTrace();
		}
	}
	public void borrarTabla(){
		try {
			pstmt= conn.prepareStatement("DROP TABLE personas");
			pstmt.execute();
		} catch (SQLException e) { System.out.println("Tabla personas NO EXISTE");
			//e.printStackTrace();
		}
	}
/*	public void insertarDatos(Modelo obj){
		try {
			pstmt=conn.prepareStatement("INSERT INTO personas(ced, nombre, apellido) VALUES (?,?,?)");
			//pstmt.setInt(1, obj.getID());
			System.out.println("Ced: "+obj.getCed());
			pstmt.setInt(1, obj.getCed());
			pstmt.setString(2, obj.getNombre());
			pstmt.setString(3, obj.getApellido());
			pstmt.execute();
			System.out.println("Insercion Exitosa");
		} catch (SQLException e) {e.printStackTrace();}
	}
	public boolean eliminarRegistro(int ced){
		boolean exito=false;
		try{
			pstmt=conn.prepareStatement("delete from personas where ced=?");
			pstmt.setInt(1, ced);
			
			exito=pstmt.execute();
			
			
		} catch (SQLException e) {e.printStackTrace();}
		return exito;
	}
	public void  modificaDatos(Modelo obj){
		try {
			pstmt=conn.prepareStatement("Update personas set nombre=?, apellido=? where ced=?");
		    pstmt.setInt(3, obj.getCed());
			pstmt.setString(1, obj.getNombre());
			pstmt.setString(2, obj.getApellido());
		
			pstmt.execute();
			System.out.println("Registro Modificado");
		} catch (SQLException e) {e.printStackTrace();}
}	
	public void buscarDato(int ced){
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement("select * from personas where ced=?");
			pstmt.setInt(1, ced);
			rs=pstmt.executeQuery();
			while (rs.next()){
				System.out.println("Cedula: "+rs.getInt("ced"));
				System.out.println("Nombre Completo: "+rs.getString("nombre")+" "+rs.getString("apellido"));
			}
		} catch (SQLException e) {e.printStackTrace();}
	}
	public boolean existe(int ced){
		boolean existe=false;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement("select * from personas where ced=?");
			pstmt.setInt(1, ced);
			rs=pstmt.executeQuery();
			if (rs.next()){ existe=true; }
			
		} catch (SQLException e) {e.printStackTrace();}
		return existe;
	}
	public void buscarTodo(){
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement("select * from personas");
			rs=pstmt.executeQuery();
			while (rs.next()){
				System.out.println("Cedula: "+rs.getInt("ced"));
				System.out.println("Nombre Completo: "+rs.getString("nombre")+" "+rs.getString("apellido"));
			}
		} catch (SQLException e) {e.printStackTrace();}
	}*/

    
}
