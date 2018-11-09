package modelo.mongodb;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	private final Properties properties = new Properties();

	@SuppressWarnings("unused")
	private String contrasenaRecuperacion, texto, asunto, mailReceptor;

	private Session session;

	public EmailSender(String tipo, String mailReceptor, String contrasenaRecuperacion) {
		this.contrasenaRecuperacion = contrasenaRecuperacion;
		this.texto = texto(tipo, contrasenaRecuperacion);
		this.asunto = asunto(tipo);
		this.mailReceptor = mailReceptor;
		try {
		sendEmail();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void init() {

		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.port","587");
		properties.setProperty("mail.smtp.user", "ejemplo@gmail.com");
		properties.setProperty("mail.smtp.auth", "true");

		session = Session.getDefaultInstance(properties);
		
		session.setDebug(true);
	}

	private String texto(String tipo, String contrasenaRecuperacion) {
		String mensaje = "";
		if(tipo.equalsIgnoreCase("recuperar credenciales"))
			mensaje = "Has realizado una petición para recuperar tu contraseña.\n"
					+ "Tu nueva contraseña generada automáticamente es: " + contrasenaRecuperacion
					+ ".\nCambie la contraseña por otra de su elección a la mayor brevedad posible.\n"
					+ "Atentamente,\nEl servicio técnico de Anvengers Live.";
		else if(tipo.equalsIgnoreCase("alta de empleado"))
			mensaje = "ya se hará";
		return mensaje;
	}

	private String asunto(String tipo) {
		String asunto = "";
		if(tipo.equalsIgnoreCase("recuperar credenciales"))
			asunto = "Recuperación de contraseña";
		else if(tipo.equalsIgnoreCase("alta de empleado"))
			asunto = "ya se verá";
		return asunto;
	}

	private void sendEmail(){

		init();
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("sirosiroguan@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailReceptor));
			message.setSubject(asunto);
			message.setText(texto);
			Transport t = session.getTransport("smtp");
			t.connect("sirosiroguan@gmail.com","contrasenaaplicacion");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (Exception e){
			System.out.println(e.getMessage());
			return;
		}

	}

}