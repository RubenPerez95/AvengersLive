package dominio.mongodb;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class DAOEmpleado {

	DBBroker db;

	public DAOEmpleado() {
		db = new DBBroker();
	}

	/******************************LYDIA************************************/

	public String contrasenaDeEmpleado(String emailEmpleado) {
		Document documentoEmail = null;
		String contrasenaEmpleado = null;
		documentoEmail = documentoEmpleado(emailEmpleado);
		if(documentoEmail != null)
			return contrasenaEmpleado = documentoEmail.get("contrasena").toString();
		return "";
	}
	
	public String dniEmpleado(String emailEmpleado) {
		Document documentoEmail = null;
		documentoEmail = documentoEmpleado(emailEmpleado);	
		return documentoEmail.get("_id").toString();
	}
	
	public String rolEmpleado(String emailEmpleado) {
		Document documentoEmail = null;
		documentoEmail = documentoEmpleado(emailEmpleado);	
		return documentoEmail.get("rol").toString();
	}	
	
	public String nombreEmpleado(String emailEmpleado) {
		Document documentoEmail = documentoEmpleado(emailEmpleado);
		return documentoEmail.get("nombre").toString();
	}
	
	public Document documentoEmpleado(String emailEmpleado) {
		MongoCollection<Document> coleccion= db.devolverColeccion("Empleados");
		return db.devolverDocumento(coleccion, "email", emailEmpleado);
	}

	/*****************************************ANA**************************************/

	public boolean crearEmpleado(Empleado p) {
		return db.crearEmpleado(p);
	}

	public boolean existeEmail(String email) {
		return db.existeEmail(email);
	}

	public boolean existeContrasena(String contrasena) {
		return db.existeContrasena(contrasena);
	}

	public boolean login(Empleado e) throws Exception {
		return db.login(e);
	}

	public boolean borrarEmpleado(Empleado e) {
		return db.borrarEmpleado(e);
	}

	public boolean actualizarEmpleado(Empleado e) {
		return db.actualizarEmpleado(e);
	}

	public Empleado getEmpleado(String nombre) {
		return db.getEmpleado(nombre);
	}

	

}
