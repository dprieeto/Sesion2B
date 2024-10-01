package empleado;

/**
 * Esta clase contiene dos metodos para el calculo de la nomina bruta y neta de un empleado.
 * @author Prieto
 *
 */
public class Empleado {
	/**
	 * Tipo de empleado.
	 */
	public enum TipoEmpleado {
		Vendedor, Encargado
	};
	
	private float salariobase;
	
	private float primas;
	
	private float extras;
	
	public Empleado() {
		salariobase = primas = extras = 0;
		
	}
	
	/**
	 * Calculo de la nomina bruta de un empleado.
	 * @param tipo
	 * @param ventasMes
	 * @param horasExtra
	 * @return
	 */
	public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		//float salariobase = 0, primas = 0, extras = 0;
		final int PRECIO_HE = 30;	
				
		//determinacion salario base:
		if(tipo == TipoEmpleado.Vendedor)
			salariobase = 2000;
		else if (tipo == TipoEmpleado.Encargado)
			salariobase =2500;
		//determinacion prima:
		if(ventasMes >= 1500)
			primas = 200;
		else if (ventasMes >= 1000)
			primas = 100;
		//determinacion extras
		extras = horasExtra*PRECIO_HE;
				
		return salariobase + primas + extras;
	}
	
	/**
	 * Calculo del salario neto del empleado.
	 * @param nominaBruta
	 * @return
	 */
	public float calculoNominaNeta(float nominaBruta) {
		if(nominaBruta <0)
			nominaBruta = 0;
		float salarioNeto = 0, retencion = 0;
		if(nominaBruta <= 2100)
			retencion = 0;
		else if(nominaBruta > 2100 && nominaBruta < 2500)
			retencion = (float) 0.15;
		else if(nominaBruta >= 2500)
			retencion = (float) 0.18;
		salarioNeto = nominaBruta*(1-retencion);
		return salarioNeto;
	}	
}
