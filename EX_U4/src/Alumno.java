
public class Alumno {
	private String nombre;
	private String apellidos;
	private String gmail;
	private String direccion;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		if(nombre != null && nombre.length()>0) {
			this.nombre = nombre;
		}
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		if(apellidos != null && apellidos.length()>0) {
			this.apellidos = apellidos;
		}
	}
	
	public String getGmail() {
		return gmail;
	}
	
	public void setGmail(String gmail) {
		if(gmail != null && gmail.length()>0) {
			this.gmail = gmail;
		}
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		if(direccion != null && direccion.length()>0) {
			this.direccion = direccion;
		}
	}
	
	public Alumno() {}
	public Alumno(String nombre, String apellidos, String gmail, String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.gmail = gmail;
		this.direccion = direccion;
	}
	
	public String info() {
		return "ALUMNO:\n" + nombre +"//"+apellidos+"//"+gmail+"//"+direccion+".";
	}
	
}
