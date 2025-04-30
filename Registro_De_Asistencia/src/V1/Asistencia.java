package V1;
import Clase.Estudiante;
import Clase.Registro;

import java.awt.EventQueue;
import javax.swing.JOptionPane;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Asistencia extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TxtCode;
	private JTextField TxtNom;
	private JButton btnNewButton;
	private JTextArea TxtS;
	private JRadioButton rbtnAsistio;
	private JRadioButton rbtnTardanza;
	private JRadioButton rbtnFalto;
	private JButton btnRegistroTotal;
	private JButton btnEliminar;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Asistencia frame = new Asistencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Asistencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Código del Estudiante:");
		lblNewLabel_1.setBounds(26, 39, 114, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(36, 64, 66, 14);
		contentPane.add(lblNewLabel);
		
		TxtCode = new JTextField();
		TxtCode.setColumns(10);
		TxtCode.setBounds(150, 36, 114, 20);
		contentPane.add(TxtCode);
		
		TxtNom = new JTextField();
		TxtNom.setColumns(10);
		TxtNom.setBounds(150, 61, 114, 20);
		contentPane.add(TxtNom);
		
		btnNewButton = new JButton("Procesar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(288, 35, 106, 23);
		contentPane.add(btnNewButton);
		
		rbtnAsistio = new JRadioButton("Asistió");
		rbtnAsistio.setBounds(26, 103, 71, 23);
		contentPane.add(rbtnAsistio);
		
		rbtnTardanza = new JRadioButton("Tardanza ");
		rbtnTardanza.setBounds(99, 103, 78, 23);
		contentPane.add(rbtnTardanza);
		
		rbtnFalto = new JRadioButton("Faltó");
		rbtnFalto.setBounds(189, 103, 66, 23);
		contentPane.add(rbtnFalto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 135, 235, 104);
		contentPane.add(scrollPane);
		
		TxtS = new JTextArea();
		scrollPane.setViewportView(TxtS);
		
		btnRegistroTotal = new JButton("Registro total");
		btnRegistroTotal.addActionListener(this);
		btnRegistroTotal.setBounds(288, 60, 106, 23);
		contentPane.add(btnRegistroTotal);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(288, 164, 106, 23);
		contentPane.add(btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(288, 137, 106, 23);
		contentPane.add(btnLimpiar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistroTotal) {
			do_btnRegistroTotal_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	
	private Registro registro = new Registro();
	
	 int contadorAsistio = 0;
     int contadorTardanza = 0;
     int contadorFalto = 0;

	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		try {
			
		    String codigo = TxtCode.getText();
	        String nombre = TxtNom.getText();
	        String estado = "";
	        
	 
	        if (codigo.isEmpty() || nombre.isEmpty()) {
	        	JOptionPane.showMessageDialog(this, "Debe ingresar el código y el nombre.");
	            return;
	        }

	      
	        if (registro.codigoDuplicado(codigo)) {
	            JOptionPane.showMessageDialog(this, "Código duplicado: " + codigo);
	            return;
	        }

	        if (registro.nombreDuplicado(nombre)) {
	            JOptionPane.showMessageDialog(this, "Nombre duplicado: " + nombre);
	            return;
	        }
	        
	        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
	            JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras y espacios.");
	            return;
	        }
	        
	        {
	      
	        if (rbtnAsistio.isSelected()) {
	            estado = "Asistió";
	        
	            contadorAsistio++;
	            
	        } else if (rbtnTardanza.isSelected()) {
	            estado = "Tardanza";
	            
	            contadorTardanza++;
	            
	        } else if (rbtnFalto.isSelected()) {
	            estado = "Faltó";
	           
				contadorFalto++;
	            
	        } 
	        
	        else {
	        	
	            JOptionPane.showMessageDialog(this, "Debe seleccionar un estado.");
	            return;
	          }
	        
	        } 
	        
	        Estudiante estudiante = new Estudiante(nombre, codigo, estado);  
	        registro.agregarEstudiante(estudiante);
	
	        TxtS.append("---------------\n");
	        TxtS.append("Código : " + codigo + "\n");
	        TxtS.append("Nombre : " + nombre + "\n");
	        TxtS.append("Estado : " + estado + "\n");
	        TxtS.append("---------------\n");
	        
	     
	    	} catch (Exception ex) {
	    		
	            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar: " + ex.getMessage());
	            ex.printStackTrace();
	    	}
	       
	} 
        
	protected void do_btnRegistroTotal_actionPerformed(ActionEvent e) {
		
		    int asistieron = registro.contarPorEstado("Asistió");
	        int tardaron = registro.contarPorEstado("Tardanza");
	        int faltaron = registro.contarPorEstado("Faltó");

	        TxtS.append("\n--- Totalización ---\n");
	        TxtS.append("Asistieron: " + asistieron + "\n");
	        TxtS.append("Tardaron: " + tardaron + "\n");
	        TxtS.append("Faltaron: " + faltaron + "\n");
	        TxtS.append("");
	}
	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		
		    TxtCode.setText("");
	        TxtNom.setText("");
	        TxtS.setText("");
	}
	
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		
		 String codigo = TxtCode.getText();
		    
		    if (codigo.isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Debe ingresar el código del estudiante a eliminar.");
		        return;
		    }

		    Estudiante eliminado = registro.eliminarYDevolverPorCodigo(codigo);

		    if (eliminado != null) {
		    	
		    	String estado = eliminado.getAsistencia();

		         // Restar al contador correspondiente
		    	
		         if (estado.equals("Asistió")) contadorAsistio--;
		         else if (estado.equals("Tardanza")) contadorTardanza--;
		         else if (estado.equals("Faltó")) contadorFalto--;
		    	
		        JOptionPane.showMessageDialog(this, "El estudiante ha saido eliminado");
		        TxtS.append("Estudiante con código " + codigo + " eliminado.\n");
		        
		    } else {
		    	
		        JOptionPane.showMessageDialog(this, "No se encontró un estudiante con ese código.");
		    }

		    TxtCode.setText("");
		    TxtNom.setText("");
	}
}
