package app;

import java.io.*;
import java.util.LinkedList; 
import java.util.Queue;
import java.util.ArrayList;

public class Maze {

	//Va guardando los carácteres(#) que forman el laberinto
	private char[][] map;
	//Boolean q comprueba si la matrixMaze se ha cargado correctamente
	private boolean loaded;
	//Casilla de salida
	private int startI;
	private int startJ;
	//Casilla de meta
	private int endI;
	private int endJ;
	private final String MAZES_PATH = "src/mazes";
	private ArrayList<Coordinate> path;
	
	
	public Maze() {
		this.reset();
		this.path = new ArrayList<>();
	}
	
	public void loadMaze() {
		File[] files = this.listDirectory();
		
		if (files == null || files.length == 0) {
			System.out.println("No se encontraron laberintos en " + Config.MAZES_PATH);
			return;
		}
		
		System.out.println("\n----- LABERINTOS DISPONIBLES -----\n");
		for(int i = 0; i < files.length; i++) {
			System.out.println((i+1) + ". " + files[i].getName());
		}
		
		int choice = Input.getInt("Seleccione un laberinto: ", true);
		
		if(choice > 0 && choice <= files.length) {
			this.fillMatrix(files[choice-1]);
		} else {
			System.out.println("La opción no es válida.");
		}
	}
	
	private File[] listDirectory() {
		File directory = new File(Config.MAZES_PATH);
		return directory.listFiles();
	}
	
	private void fillMatrix(File file) {
		String fileName = file.getName();
		
        try {
            //Saber tamaño del maze
            BufferedReader readerCount = new BufferedReader(new FileReader(file));
            int rows = 0;
            int cols = 0;
            String line;
            
            while ((line = readerCount.readLine()) != null) {
            	if(line.length() > cols) {
            		cols = line.length();
            	}
               rows++;
            }
            readerCount.close();

            //Construir matrix
            this.map = new char[rows][cols];

            // Rellenamos
            BufferedReader readerData = new BufferedReader(new FileReader(file));
            for (int i = 0; i < rows; i++) {
                line = readerData.readLine();
                for (int j = 0; j < cols; j++) {
                    // Guardamos # de la posición j
                    if(j < line.length()) {
                    	this.map[i][j] = line.charAt(j);
                    } else {
                    	this.map[i][j] = '#';
                    }
                }
            }
            readerData.close();

            // Marcamos el laberinto como cargado y guardamos su nombre
            this.loaded = true;
            System.out.println("¡Laberinto '" + fileName + "' cargado con éxito!");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }
	
	public void showMaze() {
        if (!loaded) {
            System.out.println("No hay ningún laberinto cargado. Usa la opción 1.");
            return;
        }

        int rows = map.length;
        int cols = map[0].length;

        System.out.print("    ");
        for (int j = 0; j < cols; j++) {
            System.out.print(j / 10 + " ");
        }
        System.out.println();

        System.out.print("    ");
        for (int j = 0; j < cols; j++) {
            System.out.print(j % 10 + " ");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.printf("%2d  ", i);
            for (int j = 0; j < cols; j++) {
                if (i == startI && j == startJ) System.out.print("I ");
                else if (i == endI && j == endJ) System.out.print("F ");
                else System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	public void setStartEnd() {
		if (!loaded) {
            System.out.println("Error: Primero debes cargar un laberinto.");
            return;
        }

        System.out.println("--- ESTABLECER CASILLAS (Fila y Columna) ---");
        
        // Coordenadas de Inicio con validación
        int sI = Input.getInt("Fila Inicio: ", true);
        int sJ = Input.getInt("Columna Inicio: ", true);
        if (!isValid(sI, sJ)) {
        	return; 
        }

        // Coordenadas de Fin con validación
        int eI = Input.getInt("Fila Fin: ", true);
        int eJ = Input.getInt("Columna Fin: ", true);
        
        if (!isValid(eI, eJ)) {
            return;
        }
        
        if (sI == eI && sJ == eJ) {
            System.out.println("No pueden ser las mismas coordenadas.");
            return;
        }
        
        this.startI = sI;
        this.startJ = sJ;
        this.endI = eI;
        this.endJ = eJ;
        System.out.println("Posiciones guardadas correctamente.");
    }

    private boolean isValid(int r, int c) {
        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) {
            System.out.println("Error, limite de la matriz.");
            return false;
        }
        if (map[r][c] == '#') {
            System.out.println("Es una pared.");
            return false;
        }
        return true;
    }
    
    public void firstPath() {
        if (!loaded || startI == -1) {
            System.out.println("Error: Falta cargar laberinto o definir inicio/fin.");
            return;
        }

        this.path.clear();
        char[][] solveMap = copyMap();

        if (findRecursive(startI, startJ, solveMap, "Inicio", 'I')) {
            showSolution(solveMap); 
            showPathList();         
        } else {
            System.out.println("No se ha encontrado un camino.");
        }
    }
    
    private void showSolution(char[][] solution) {
    	printCustomMap(solution);
    }
    
    private boolean findRecursive(int i, int j, char[][] tempMap, String dirTxt, char icon) {
        if (i < 0 || i >= tempMap.length || j < 0 || j >= tempMap[0].length || 
            tempMap[i][j] == '#' || tempMap[i][j] == 'v' || tempMap[i][j] == '^' || 
            tempMap[i][j] == '>' || tempMap[i][j] == '<') {
            return false;
        }

        if (i == endI && j == endJ) {

            path.add(new Coordinate(i, j, "Fin"));
            return true;
        }

        path.add(new Coordinate(i, j, dirTxt));
        if (!(i == startI && j == startJ)) tempMap[i][j] = icon;

        if (findRecursive(i - 1, j, tempMap, "Arriba",    '^')) return true;
        if (findRecursive(i, j + 1, tempMap, "Derecha",   '>')) return true;
        if (findRecursive(i + 1, j, tempMap, "Abajo",     'v')) return true;
        if (findRecursive(i, j - 1, tempMap, "Izquierda", '<')) return true;

        path.remove(path.size() - 1);
        if (!(i == startI && j == startJ)) tempMap[i][j] = ' ';
        return false;
    }
    
    public void shortestPath() {
        System.out.println("\n[SISTEMA] Iniciando búsqueda del camino más corto...");
        
        if (!loaded || startI == -1) {
            System.out.println("Error: Configura el laberinto primero.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];

        queue.add(new Node(startI, startJ, null));
        visited[startI][startJ] = true;

        Node targetNode = null;

        while (!queue.isEmpty()) {
            Node current = queue.poll(); 

            if (current.r == endI && current.c == endJ) {
                targetNode = current;
                break;
            }

            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int[] d : dirs) {
                int newR = current.r + d[0];
                int newC = current.c + d[1];

                if (isValidShortest(newR, newC) && !visited[newR][newC]) {
                    visited[newR][newC] = true;
                    queue.add(new Node(newR, newC, current));
                }
            }
        }

        //Dibujar y mostrar solución
        if (targetNode != null) {
            renderAndShow(targetNode);
        } else {
            System.out.println("No hay camino posible.");
        }
    }
    
    private boolean isValidShortest(int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[0].length && map[r][c] != '#';
    }
    
    private char[][] copyMap() {
        if (this.map == null) return null;
        char[][] copy = new char[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, copy[i], 0, map[i].length);
        }
        return copy;
    }

    private void renderAndShow(Node endNode) {
        char[][] solveMap = copyMap();
        this.path.clear();

        Node current = endNode;
        while (current != null) {
            String dir = "Fin";
            char icon = 'F';

            if (current.parent != null) {
                
                int dr = current.r - current.parent.r;
                int dc = current.c - current.parent.c;

                if (dr == -1) { dir = "Arriba";    icon = '^'; }
                else if (dr == 1) { dir = "Abajo"; icon = 'v'; }
                else if (dc == 1) { dir = "Derecha"; icon = '>'; }
                else if (dc == -1) { dir = "Izquierda"; icon = '<'; }
            } else {
                dir = "Inicio";
                icon = 'I';
            }

            path.add(0, new Coordinate(current.r, current.c, dir));
            
            if (current.parent != null) {
                int pr = current.parent.r;
                int pc = current.parent.c;
                if (!(pr == startI && pc == startJ)) {
                    solveMap[pr][pc] = icon;
                }
            }
            current = current.parent;
        }

        System.out.println("\n--- CAMINO MÁS CORTO ENCONTRADO ---");
        printCustomMap(solveMap);
        showPathList(); 
    }

    private void printCustomMap(char[][] matrix) {
        
    	if (!loaded) {
            System.out.println("No hay ningún laberinto cargado. Usa la opción 1.");
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.print("    "); // Margen para las filas
        for (int j = 0; j < cols; j++) {
            System.out.print(j / 10 + " "); // Decenas + espacio
        }
        System.out.println();

        System.out.print("    ");
        for (int j = 0; j < cols; j++) {
            System.out.print(j % 10 + " "); // Unidades + espacio
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.printf("%2d  ", i);
            for (int j = 0; j < cols; j++) {
                if (i == startI && j == startJ) System.out.print("I ");
                else if (i == endI && j == endJ) System.out.print("F ");
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private void showPathList() {
        System.out.println("\nPasos: " + path.size());
        System.out.println();

        for (Coordinate c : path) {
            System.out.println("(" + c.getI() + "," + c.getJ() + ") " + c.getDirection());
        }
    }
    
    public void reset() {
        this.map = null;
        this.loaded = false;
        this.startI = -1;
        this.startJ = -1;
        this.endI = -1;
        this.endJ = -1;
        this.path = new ArrayList<>();
    }
}
