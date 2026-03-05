package app;

public class Main {

    private static Session session = new Session();
    private static Maze maze = new Maze();

    public static void main(String[] args) {

        System.out.println(Config.WELCOME);

        int option = -1;

        while (option !=0) {
        	//Si no hay sesion, unlogged menu
        	if (!session.isLogged()) {
        		option = manageUnloggedMenu();
        	}
        	//Si hay sesion, logged menu
        	else {
        		option = manageLoggedMenu();
        	}
        }

        System.out.println(Config.GOODBYE);
    }
    
    public static int manageUnloggedMenu() {
        int op = Input.getInt(Config.UNLOGGED_MENU, true);

        if (op == 1) {
            session.login();
        } else if (op == 2) {
            session.signup();
        } else if (op == 0) {
            return 0; 
        } else {
            System.out.println("Opción no válida.");
        }
        return op;
    }

    public static int manageLoggedMenu() {
    	int op = Input.getInt(Config.LOGGED_MENU, true);

        if (op == 1) {
        	maze.reset();
            maze.loadMaze(); //Cargar
        } else if (op == 2) {
            maze.showMaze(); //Ver
        } else if (op == 3) {
            maze.setStartEnd(); //Coordenadas
        } else if (op == 4) {
            
            int opCaminos = -1;
            while (opCaminos != 0) {
                System.out.println("\nSelecciona un camino");
                System.out.println("------------------------");
                System.out.println("1 - El primer camino posible");
                System.out.println("2 - El camino mas corto");
                System.out.println("0 - Cancelar");
                
                opCaminos = Input.getInt("Elige una opción: ", true);

                if (opCaminos == 1) {
                    System.out.println("Buscando el primer camino posible...");
                    	maze.firstPath(); 
                } else if (opCaminos == 2) {
                    System.out.println("Buscando el camino mas corto...");
                    	maze.shortestPath();
                } else if (opCaminos == 0) {
                    System.out.println("Volviendo al menú principal...");
                } else {
                    System.out.println("Opción no válida.");
                }
            }
        } else if (op == 5) {
            session.showUser();
        } else if (op == 6) {
            session.logout();
            maze.reset();
        } else if (op == 0) {
            return 0; 
        } else {
            System.out.println("Opción no válida.");
        }
        return op;
    }
}