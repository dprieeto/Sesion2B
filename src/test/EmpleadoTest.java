package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import empleado.Empleado;

/**
 * Clase de prueba para la clase Empleado.
 * Las pruebas unitarias se utilizan para el calculo de la nomina bruta y neta de los tipos de empleado.
 * @author Prieto
 *
 */
class EmpleadoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("->Ejecutando Before all: configuracion antes de todas las pruebas");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("->Ejecutando After all: limpieza despues de todas las pruebas");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("->Ejecutando Before each: configuracion antes de cada prueba");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("->Ejecutando After each: limpieza despues de cada prueba");
	}
	
	@Test
	@DisplayName("Prueba de un empleado vendedor con 0€ ventas al mes y 0 horas extra")
	void testCalculoNominaBrutaVendedor(TestInfo info) { // al ponerlo como parametro junit le proporciona la informacion de la prueba que se esta ejecutando
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 2000;
		Empleado e = new Empleado();
		float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 0, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Prueba de un empleado encargado con 0€ ventas al mes y 0 horas extra")
	void testCalculoNominaBrutaEncargado(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 2500;
		Empleado e = new Empleado();
		float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 0, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Prueba de un empleado vendedor con 1345€ ventas al mes y 0 horas extra")
	void testCalculoNominaBrutaVendedorPrima100(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 2100;
		Empleado e = new Empleado();
		float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 1345, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Prueba de un empleado vendedor con 1501€ ventas al mes y 0 horas extra")
	void testCalculoNominaBrutaVendedorPrima200(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 2200;
		Empleado e = new Empleado();
		float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 1501, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Prueba de un empleado encargado con 1345€ ventas al mes y 0 horas extra")
	void testCalculoNominaBrutaEncargadoPrima100(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 2600;
		Empleado e = new Empleado();
		float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 1501, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Prueba de un empleado encargado con 1501€ ventas al mes y 0 horas extra")
	void testCalculoNominaBrutaEncargadoPrima200(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 2700;
		Empleado e = new Empleado();
		float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 1501, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Prueba de un empleado vendedor con 1345€ ventas al mes y 30 horas extra")
	void testCalculoNominaBrutaVendedorExtras(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 2460;
		Empleado e = new Empleado();
		float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 1345, 12);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Prueba de un empleado encargado con 2300€ ventas al mes y 17 horas extra")
	void testCalculoNominaBrutaEncargadoExtra(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 3210;
		Empleado e = new Empleado();
		float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 2300, 17);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Prueba de un empleado encargado con -2300€ ventas al mes y -17 horas extra")
	void testCalculoNominaBrutaEncargadoExtraNegativo(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 2500;
		Empleado e = new Empleado();
		float actual = e.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, -2300, -17);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Prueba de un empleado vendedor con nomina bruta < 2100€. Retencion 0%")
	void testCalculoNominaNetaRetencion0(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 2000;
		Empleado e = new Empleado();
		float actual = e.calculoNominaNeta(2000);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Prueba de un empleado vendedor con nomina bruta > 2100€ y < 2500€. Retencion 15%")
	void testCalculoNominaNetaRetencion15(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 2091;
		Empleado e = new Empleado();
		float actual = e.calculoNominaNeta(2460);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Prueba de un empleado vendedor con nomina bruta > 2500€")
	void testCalculoNominaNetaRetencion18(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 2665;
		Empleado e = new Empleado();
		float actual = e.calculoNominaNeta(3250);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Prueba de un empleado vendedor con nomina bruta negativa")
	void testCalculoNominaNetaRetencion0Negativa(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		float expected = 2050;
		Empleado e = new Empleado();
		float actual = e.calculoNominaNeta(-2050);
		assertEquals(expected, actual);
	}
}
