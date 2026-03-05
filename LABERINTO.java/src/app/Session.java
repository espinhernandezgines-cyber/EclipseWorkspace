package app;

import java.io.*; //leer y escribir ficheros

public class Session {
    private User user;
    private boolean logged;

    private static final String USERS_FILE = Config.USERS_PATH + "users.txt";
    
    public Session() {
        this.logged = false;
    }
    
    public boolean isLogged() {
        return logged;
    }
    
    public void login() {
        String username = Input.getString("Nombre de usuario: ");
        String password = Input.getString("Contraseña: ");
        
        File file = new File(USERS_FILE);
        if (!file.exists()) {
            System.out.println("Error: No existe el archivo en " + Config.USERS_PATH);
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("#");
                
                if (data[0].equals(username) && data[1].equals(password)) {

                	this.user = new User(data[0], data[2], data[3], data[4], data[5], data[6], "USER");
                    this.logged = true;
                    System.out.println("Sesión iniciada correctamente");
                    return;
                }
            }
            System.out.println("Usuario y/o contraseña no son válidos.");
        } catch (IOException e) {
            System.out.println("Error: no se pudo leer el archivo");
        }
    }
    
    public void signup() {
        
        String username = Input.getString("Introduce nombre de usuario: ");

        if (userExists(username)) {
            System.out.println("Error: El nombre de usuario ya existe.");
            return;
        }

        String pass = Input.getString("Contraseña: ");
        String name = Input.getString("Nombre completo: ");
        String nif = Input.getString("NIF: ");
        String email = Input.getString("Email: ");
        String address = Input.getString("Dirección: ");
        String birth = Input.getString("Fecha nacimiento: ");
        
        File dir = new File(Config.USERS_PATH);
        if (!dir.exists()) dir.mkdirs();

        // FileWriter(ruta, true) -> El 'true' hace que escriba al final sin borrar nada
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            String record = username + "#" + pass + "#" + name + "#" + nif + "#" + email + "#" + address + "#" + birth;
            bw.write(record);
            bw.newLine();
            System.out.println("Registro completado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }
    
    private boolean userExists(String username) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("#");
                if (data[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) { 
            return false; 
        }
        return false;
    }

    public void showUser() {
        if (user != null) {
            System.out.println("\n--- INFORMACIÓN DEL USUARIO ACTUAL ---");
            System.out.println("Usuario: " + user.getUsername());
            System.out.println("Nombre Completo: " + user.getName());
            System.out.println("NIF: " + user.getNif());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Dirección: " + user.getAddress());
            System.out.println("Fecha de Nacimiento: " + user.getBirthdate());
        }
    }

    public void logout() {
        System.out.println("Cerrando sesión...");
        this.logged = false;
        this.user = null;
    }
}