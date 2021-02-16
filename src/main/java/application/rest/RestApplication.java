package application.rest;

import application.Entities.*;
import application.services.ModificareDocumente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;


@ComponentScan("application")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class RestApplication {
	static void test_completare()
	{
		Facultate fac = new Facultate(1, "Matematica", "rpm", "rpr", "decan");
		CadruDidactic c = new CadruDidactic(1, "Ioana", "profesor", "0733258369", "1423", "Ioana@ubb", "Pass1234");
		Sectie s = new Sectie(1, "mate-info", "Secretara1", new ArrayList<>(), fac, c);
		Tutore t = new Tutore(1, "Gigel", "gigel@ubb", "123Gigi", "profesor", "0789456123", "12334");

		Firma f = new Firma(1, "Firma1", "Maria", "str1", "0325896547", "1223", "45236", "BRD", "1234567890", "Gigel", "firma1@firma", "74588", t);
		Student stud = new Student(1, "ion.popa@stud.ubbcluj.ro", "1234Parola1", "Popa Ion", "5000201070908", "ZV190831", "roman", "str. nr", "0745896321", "popa.ion@yhaoo.com", "turda", "romana", "323", f, s);

		ModificareDocumente m = new ModificareDocumente();
		m.completare("C:\\Users\\alexa\\Downloads\\Practica - 18.01\\GestiunePractica-RESTapi\\src\\main\\resources\\docNecompletate\\conventie.txt", stud);
	}
	public static void main(String[] args) {
		test_completare();
		//SpringApplication.run(RestApplication.class, args);
	}

}
