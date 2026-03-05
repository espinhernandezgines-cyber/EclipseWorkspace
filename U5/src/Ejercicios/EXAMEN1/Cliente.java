package Ejercicios.EXAMEN1;

public class Cliente {
	private String nombre;
    private String apellidos;
    private String nif;
    private String direccion;
    private String email;
    private String fechaAlta;
    private String tipo;
    private String descuento;
    
 // 2. Constructor: Para crear el objeto con todos sus datos de golpe
    public Cliente(String nombre, String apellidos, String nif, String direccion, 
                   String email, String fechaAlta, String tipo, String descuento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.tipo = tipo;
        this.descuento = descuento;
    }
    
 // 3. Getters y Setters: Necesarios para leer y modificar los datos desde otras clases
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getNif() { return nif; }
    public void setNif(String nif) { this.nif = nif; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFechaAlta() { return fechaAlta; }
    public void setFechaAlta(String fechaAlta) { this.fechaAlta = fechaAlta; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescuento() { return descuento; }
    public void setDescuento(String descuento) { this.descuento = descuento; }
}
