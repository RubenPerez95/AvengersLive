package com.avengers.proyecto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import modelo.mongodb.Empleado;
import modelo.mongodb.Fichaje;

@Controller
public class loginController {
	Empleado empleado = new Empleado();
	Calendar calendario = new GregorianCalendar();
	Fichaje fichaje = new Fichaje();

	@RequestMapping("login.htm")
	public ModelAndView redireccion() {
		ModelAndView MV= new ModelAndView();
		MV.setViewName("login");
		return MV;
	}

	@RequestMapping(value = "home.htm", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, ModelMap model)throws Exception{
		String email, contrasena;
		email = request.getParameter("inputEmail");
		contrasena = DigestUtils.md5Hex(request.getParameter("inputPassword"));		
		if(empleado.credencialesCorrectas(email, contrasena)) {
			empleado = new Empleado(email, contrasena);
			model.addAttribute("email", empleado.getEmail());
			if (empleado.getRol().equals("usuario"))
				return new ModelAndView("home");
			else return new ModelAndView("admin");

		}else {

			return new ModelAndView("login","error","Usuario o contraseña incorrectos");
		} 	
	}
	
	@RequestMapping(value = "recuperarContrasena.htm", method = RequestMethod.POST)
	public ModelAndView recuperarContrasena() {
		return new ModelAndView("recuperarContrasena");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "enviarPeticionContrasena.htm")
	public ModelAndView enviarPeticionContrasena(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {		
		String mensaje, email;
		email = request.getParameter("inputEmail");
		if(empleado.recuperarContrasena(email))
			mensaje = "Te hemos enviado una nueva contraseña al correo introducido";
		else
			mensaje = "No existe un usuario con el correo introducido";

		return new ModelAndView("recuperarContrasena", "mensaje", mensaje);
	}

	@RequestMapping(method = RequestMethod.POST, value = "abrirFichaje.htm")
	public ModelAndView abrirFichaje(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		String mensaje;
		DateFormat hora = new SimpleDateFormat("HH:mm:ss");
		DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		model.addAttribute("email", empleado.getEmail());
		if(!fichaje.comprobarFichaje(empleado.getDni(), fecha.format(new Date())) == true)
			mensaje = "Ya tienes un fichaje abierto hoy";
		else {
			mensaje = "Fichaje Abierto";
			fichaje = new Fichaje(empleado.getDni(), fecha.format(new Date()), hora.format(new Date()));
		}
		return new ModelAndView("home", "mensaje", mensaje);
	} 

	@RequestMapping(method = RequestMethod.POST, value = "cerrarFichaje.htm")
	public ModelAndView cerrarFichaje(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		String mensaje;
		DateFormat hora = new SimpleDateFormat("HH:mm:ss");
		DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		model.addAttribute("email", empleado.getEmail());
		if(!fichaje.comprobarCierre(empleado.getDni(), fecha.format(new Date()), "Abierto"))
			mensaje = "No puedes cerrar ningún fichaje";
		else {
			mensaje = "Fichaje Cerrado";
			fichaje.cerrarFichaje(hora.format(new Date()), empleado);
		}
		return new ModelAndView("home", "mensaje", mensaje);
	} 

	@RequestMapping(value = "vistaCambiarContrasena.htm", method = RequestMethod.POST)
	public ModelAndView redireccionarContrasena() {
		return new ModelAndView("contrasena");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "cambiarContrasena.htm")
	public ModelAndView cambiarContrasena(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		String mensaje, email, contrasena, contrasenaNueva1, contrasenaNueva2;
		email = empleado.getEmail();
		contrasena = DigestUtils.md5Hex(request.getParameter("inputContrasena"));	
		contrasenaNueva1 = request.getParameter("inputContrasenaNueva1");
		contrasenaNueva2 = request.getParameter("inputContrasenaNueva2");
		if(!empleado.credencialesCorrectas(email, contrasena))
			mensaje = "Error al introducir tu contraseña actual";
		else if(!empleado.requisitosPassword(contrasenaNueva1))
			mensaje = "La nueva contraseña introducida debe contener al menos una mayúscula, una minúscula "
					+ "un número y 8 caracteres";
		else if(!empleado.contrasenaCoincide(contrasenaNueva1, contrasenaNueva2))
			mensaje = "Las contraseñas no coinciden";
		else {
			empleado.cambiarContrasena(email, contrasenaNueva1);
			mensaje = "Contraseña cambiada con éxito";
		}
		return new ModelAndView("contrasena", "mensaje", mensaje);
	} 

	@RequestMapping(method = RequestMethod.POST, value = "consulta.htm")
	public ModelAndView consulta(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {		
		String idEmpleado = empleado.getDni();
		List<Document> listaFichajes = new ArrayList<Document>();
		listaFichajes = fichaje.fichajesEmpleado(idEmpleado);
		model.addAttribute("fichajes", listaFichajes);

		return new ModelAndView("consulta", "fichajes", listaFichajes);
	} 

}
