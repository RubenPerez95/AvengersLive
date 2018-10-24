package dominio.mongodb;

public class Empleado {

		private String email, contrasena, contrasenaOriginal, nombre, rol;
		DAOempleado dao;
	
	    public Empleado(){
	    	
	    }
	    
	    public Empleado (String email, String contrasena) {
	    	this.email=email;
	    	this.contrasena=contrasena;
	    }
	    
	    public Empleado (String contrasena) {
	    	this.contrasenaOriginal=contrasena;
	    }

	    public Empleado(String n, String e, String c, String rol) {
	    	try {
		    	this.email=e;
		    	this.contrasena=c;
		    	this.contrasenaOriginal=c;
		    	this.nombre=n;
		    	this.rol=rol;
	    	} catch (Exception e1) {
	    		e1.printStackTrace();
	    	}
	    }
	    
	    public boolean credencialesCorrectas(String emailEmpleado, String contrasenaIntroducida) {
	    	String contrasenaReal = dao.contrasenaDeEmpleado(emailEmpleado);
	    	if(contrasenaReal == contrasenaIntroducida)
	    		return true;    	
	    	
	    	return false;
	    }

		
		private boolean esNumero(char n) {
			return (n>='0'&&n<='9');
		}
		
		private boolean esMayuscula(char n) {
			boolean check = false;
			if(n>='A'&&n<='Z')
				check = true;
			
			return check;
		}
		
		private boolean esMinuscula(char n) {
			if(n>='a'&&n<='z')return true;
			else return false;
		}
		
		public boolean requisitosPassword() {
			boolean size=false, numeros=false, minuscula=false, mayuscula=false;
			if(this.contrasenaOriginal.length()>=8) {
				size=true;
			}
			for(int j=0; j<this.contrasenaOriginal.length(); j++) {
				if(esNumero(this.contrasenaOriginal.charAt(j)))numeros=true;
			}
			for(int j=0; j<this.contrasenaOriginal.length(); j++) {
				if(esMayuscula(this.contrasenaOriginal.charAt(j)))mayuscula=true;
			}
			for(int j=0; j<this.contrasenaOriginal.length(); j++) {
				if(esMinuscula(this.contrasenaOriginal.charAt(j)))minuscula=true;
			}
			return size&&numeros&&mayuscula&&minuscula;
		}
		
		public String getNombre() {
			return nombre;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getContrasena() {
			return contrasena;
		}
		
		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}
	
		public String getRol() {
			return rol;
		}
		
		public void setRol(String rol) {
			this.rol = rol;
		}
	

	
}
