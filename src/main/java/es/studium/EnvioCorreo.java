package es.studium;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvioCorreo {

	public static void main(String[] args) {

		String destinatario = "jorge@grupostudium.com";
		String asunto = "Correo de prueba enviado desde java";
		String cuerpo = "<h1>package es.studium;\r\n"
				+ "\r\n"
				+ "import java.util.Properties;\r\n"
				+ "\r\n"
				+ "import javax.mail.Message;\r\n"
				+ "import javax.mail.MessagingException;\r\n"
				+ "import javax.mail.Session;\r\n"
				+ "import javax.mail.Transport;\r\n"
				+ "import javax.mail.internet.InternetAddress;\r\n"
				+ "import javax.mail.internet.MimeMessage;\r\n"
				+ "\r\n"
				+ "public class EnvioCorreo {\r\n"
				+ "\r\n"
				+ "	public static void main(String[] args) {\r\n"
				+ "\r\n"
				+ "		String destinatario = \"jorge@grupostudium.com\";\r\n"
				+ "		String asunto = \"Correo de prueba enviado desde java\";\r\n"
				+ "		String cuerpo = \"<h1>Esto es un mensaje de LLYTOMAN DIOS</h1>\";\r\n"
				+ "		enviarCorreo(destinatario, asunto, cuerpo);\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "	private static void enviarCorreo(String destinatario, String asunto, String cuerpo)\r\n"
				+ "	{\r\n"
				+ "		String remitente = \"curso20192020@grupostudium.com\";\r\n"
				+ "		Properties props = System.getProperties();\r\n"
				+ "		props.put(\"mail.smtp.ssl.trust\", \"grupostudium-com.correoseguro.dinaserver.com\");\r\n"
				+ "		props.put(\"mail.smtp.user\", remitente);\r\n"
				+ "\r\n"
				+ "		// Usar autenticación mediante usuario y clave\r\n"
				+ "		props.put(\"mail.smtp.auth\", \"true\");\r\n"
				+ "\r\n"
				+ "		// Para conectar de manera segura al servidor SMTP\r\n"
				+ "		props.put(\"mail.smtp.starttls.enable\", \"true\");\r\n"
				+ "\r\n"
				+ "		props.put(\"mail.smtp.port\", \"587\"); //El puerto SMTP seguro\r\n"
				+ "		Session session = Session.getDefaultInstance(props);\r\n"
				+ "		MimeMessage mensaje = new MimeMessage(session);\r\n"
				+ "		try\r\n"
				+ "		{\r\n"
				+ "			mensaje.setFrom(new InternetAddress(remitente));\r\n"
				+ "			mensaje.addRecipients(Message.RecipientType.TO, destinatario);\r\n"
				+ "			// Se podrían añadir varios de la misma manera\r\n"
				+ "			mensaje.setSubject(asunto);\r\n"
				+ "			mensaje.setText(cuerpo,\"UTF-8\",\"html\"); // Para envío en formato HTML\r\n"
				+ "			Transport transport = session.getTransport(\"smtp\");\r\n"
				+ "			transport.connect(\"grupostudium-com.correoseguro.dinaserver.com\", remitente, \"Studium2020;\");\r\n"
				+ "			transport.sendMessage(mensaje, mensaje.getAllRecipients());\r\n"
				+ "			transport.close();\r\n"
				+ "			System.out.println(\"Mensaje enviado correctamente!\");\r\n"
				+ "		}\r\n"
				+ "		catch (MessagingException me)\r\n"
				+ "		{\r\n"
				+ "			me.printStackTrace(); //Si se produce un error\r\n"
				+ "		}\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "</h1>";
		enviarCorreo(destinatario, asunto, cuerpo);
	}

	private static void enviarCorreo(String destinatario, String asunto, String cuerpo)
	{
		String remitente = "curso20192020@grupostudium.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.ssl.trust", "grupostudium-com.correoseguro.dinaserver.com");
		props.put("mail.smtp.user", remitente);

		// Usar autenticación mediante usuario y clave
		props.put("mail.smtp.auth", "true");

		// Para conectar de manera segura al servidor SMTP
		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.port", "587"); //El puerto SMTP seguro
		Session session = Session.getDefaultInstance(props);
		MimeMessage mensaje = new MimeMessage(session);
		try
		{
			mensaje.setFrom(new InternetAddress(remitente));
			mensaje.addRecipients(Message.RecipientType.TO, destinatario);
			// Se podrían añadir varios de la misma manera
			mensaje.setSubject(asunto);
			mensaje.setText(cuerpo,"UTF-8","html"); // Para envío en formato HTML
			Transport transport = session.getTransport("smtp");
			transport.connect("grupostudium-com.correoseguro.dinaserver.com", remitente, "Studium2020;");
			transport.sendMessage(mensaje, mensaje.getAllRecipients());
			transport.close();
			System.out.println("Mensaje enviado correctamente!");
		}
		catch (MessagingException me)
		{
			me.printStackTrace(); //Si se produce un error
		}
	}

}
