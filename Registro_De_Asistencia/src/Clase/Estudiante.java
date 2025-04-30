package Clase;

public class Estudiante {
	
	private String nombre;
    private String codigo;
    private String asistencia;
    

    public Estudiante(String nombre, String codigo, String asistencia) {
		
		this.nombre = nombre;
		this.codigo = codigo;
		this.asistencia = asistencia;

	}

     public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}


	//Sobre carga de metodos
	public String mostrarInformacion() {
	
    	
        return "Código: " + codigo + ", Nombre: " + nombre + ", Asistencia: " + asistencia;
    }

    public String mostrarInformacion(boolean enLinea) {
        if (enLinea) {
        	
            return codigo + " | " + nombre + " | " + asistencia;
            
        } else {
        	
            return mostrarInformacion();
        }
    }

    public String getAsistencia() {
        return asistencia;
    }
}

