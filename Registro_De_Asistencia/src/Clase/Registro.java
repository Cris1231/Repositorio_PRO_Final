package Clase;

import java.util.ArrayList;

public class Registro {
	commit 4
	    private ArrayList<Estudiante> listaEstudiantes;

	    public Registro() {
	        listaEstudiantes = new ArrayList<>();
	    }

	    public void agregarEstudiante(Estudiante estudiante) {
	        listaEstudiantes.add(estudiante);
	    }

	    public ArrayList<Estudiante> getListaEstudiantes() {
	        return listaEstudiantes;
	    }

	    public boolean codigoDuplicado(String codigo) {
	        return listaEstudiantes.stream().anyMatch(e -> e.getCodigo().equals(codigo));
	    }

	    public boolean nombreDuplicado(String nombre) {
	        return listaEstudiantes.stream().anyMatch(e -> e.getNombre().equalsIgnoreCase(nombre));
	    }

	    public int contarPorEstado(String estado) {
	        return (int) listaEstudiantes.stream()
	        		
	            .filter(e -> e.getAsistencia().equalsIgnoreCase(estado))
	            .count();
	    }
	    
	    public Estudiante eliminarYDevolverPorCodigo(String codigo) {
	    	
	        for (int i = 0; i < listaEstudiantes.size(); i++) 
	        {
	            Estudiante estudiante = listaEstudiantes.get(i);
	            
	            if (estudiante.getCodigo().equals(codigo))
	            {
	                listaEstudiantes.remove(i);
	                
	                return estudiante;
	            }
	        }
	        
	        return null;
	    }
}

