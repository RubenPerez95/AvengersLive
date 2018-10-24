package dominio.mongodb;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class DBBroker {

	MongoClient cliente = null;
	MongoDatabase bd = null;
	
	MongoCollection<Document> bdUsuarios;
	MongoCursor<Document> elementos;
	Document documento;
	

	public DBBroker() {

		if(cliente == null) {
			String acceso = "mongodb://usuarioGeneral:usuarioGeneral2018@ds233763.mlab.com:33763/avengerslive";
			MongoClientURI uri = new MongoClientURI(acceso);
			cliente = new MongoClient(uri);
		}	
		bd = cliente.getDatabase("avengerslive");
	}
	/*************************************LYDIA****************************************/
	
	public MongoCollection<Document> devolverColeccion(String nombreColeccion) {
		MongoCollection<Document> coleccion = bd.getCollection(nombreColeccion);
		return coleccion;
		
	}
	
	public Document devolverDocumento(MongoCollection<Document> coleccion, String campo, String parametro) {
		elementos = coleccion.find().iterator();
		while(elementos.hasNext()) {
			documento = elementos.next();
			if(documento.get(campo).toString().equalsIgnoreCase(parametro))
				return documento;
		}
		
		return null;
	}
	
	/*****************************************ANA*****************************************/
	/*

	public boolean crearEmpleado(Empleado p) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existeEmail(String email) {
		boolean existe=false;
		bd=cliente.getDatabase("avengerslive");
		bdUsuarios = bd.getCollection("usuarios");
		elementos = bdUsuarios.find().iterator();
		while(elementos.hasNext()) {
			documento = elementos.next();
			if(documento.get("email").toString().equalsIgnoreCase(email)) {
				existe = true;
			}
		}
		return existe;
	}

	public boolean existeContrasena(String contrasena) {
		boolean existe=false;
		bd=cliente.getDatabase("avengerslive");
		bdUsuarios = bd.getCollection("usuarios");
		elementos = bdUsuarios.find().iterator();
		while(elementos.hasNext()) {
			documento = elementos.next();
			if(documento.get("contraseña").toString().equalsIgnoreCase(contrasena)) {
				existe = true;
			}
		}
		return existe;
	}

	public boolean login(Empleado e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean borrarEmpleado(Empleado e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean actualizarEmpleado(Empleado e) {
		// TODO Auto-generated method stub
		return false;
	}

	public Empleado getEmpleado(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
*/

}
