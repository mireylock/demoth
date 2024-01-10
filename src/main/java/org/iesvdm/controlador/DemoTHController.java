package org.iesvdm.controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.iesvdm.modelo.Libro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//En el controlador hay unos métodos que llevan a la vista
@Controller
public class DemoTHController {

	@GetMapping("/demoth1")
	//model es como request.setAttribute, donde se meten los atributos para que estén disponibles en la vista
	//es un objeto que ya da el framework
	//su ámbito es sólo la petición
	public String demoTH(Model model) {
		
		String textoParrafo2 = "Esto es el texto que irá dentro del párrafo...";
		model.addAttribute("parrafo2", textoParrafo2);
		
		
		List<String> books = new ArrayList<>();
		books.add("El Quijote");
		books.add("Crimen y Castigo");
		books.add("Oliver Twist");
		
		model.addAttribute(books); //Equivalente a model.addAttribute("books", books)
		
		List<String> listUsers = Arrays.asList("Paco González", "Pepe Domingo Castaño", "Manolo Lama"); 
		model.addAttribute("users", listUsers);
		
		return "demoth1";//esto es la vista demoth1.html
		//Tiene que estar siempre en resources, templates porque ahí es donde lo espera el framework
		//si se scambia el nnombre da whitelabel error page porque no encuentra la plantilla
	}


	@GetMapping("/demoth2")
	public String demoth2(Model model) {

		List<Libro> libros = new ArrayList<>();

		libros.add(new Libro(1,"El Quijote", "Miguel Cervantes", "Anaya"));
		libros.add(new Libro(2,"Crimen y Castigo", "Fedor Dostoievski", "Santillana"));
		libros.add(new Libro(3,"Oliver Twist", "Charles Dickens", "Tusquests"));

		model.addAttribute(libros); //Equivalente a model.addAttribute("libroList", books)
		//en la plantilla se espera libroList y viene porque libros es una lista de libro
		//en demoth1 hemos puesto el nombre que queremos, que es mejor que dejar quye lo haga solo

		return "demoth2";
	}

	//Session entre distintas peticiones, pervive mientras la sesión esté activa
	@GetMapping("/demoth3")
	public String demoth3(Model model, HttpSession session) {

		String variable = "Hola, mundo!";

		model.addAttribute("unaVariable", variable);

		String variableSesion = "Esto es una variable de sesión...";

		session.setAttribute("unaVariableDeSesion", variableSesion);

		Libro libro = new Libro(1,"El Quijote", "Miguel Cervantes", "Anaya");
		session.setAttribute("ElQuijote", libro);

		return "demoth3";
	}

	@GetMapping("/demoth4")
	public String demoth4(Model model) {

		Libro libro = new Libro(1,"El Quijote", "Miguel Cervantes", "Anaya");

		model.addAttribute("libro", libro);

		return "demoth4";
	}


	@GetMapping("/demoth5")
	public String demoth5(Model model) {

		Libro libro = new Libro(1,"El Quijote", "Miguel Cervantes", "Anaya");

		model.addAttribute("libro", libro);

		return "demoth5";
	}


	@GetMapping("/demoth6")
	public String demoth6(Model model) {

		Libro libro = new Libro(1, "El Quijote", "Miguel Cervantes", "Anaya");

		model.addAttribute("libro", libro);

		return "demoth6";
	}

	//No hace falta pasarle el model porque no queremos inyectar objetos que la template acceda a ellos
	@GetMapping("/demoth7")
	public String demoth7() {

		return "demoth7";
	}








}
