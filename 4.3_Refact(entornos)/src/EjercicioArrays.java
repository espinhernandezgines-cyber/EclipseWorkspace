
import java.util.Arrays;
import java.util.List;

public class EjercicioArrays {
    
    public static void main(String[] args) {
        int numAlumnos = 40;
        //vector con las notas generadas
        int[] listaClase = new int[numAlumnos];
		int[] examen = new int [numAlumnos];
        int[] practicas = new int[numAlumnos];
        float[] calificaciones = new float[numAlumnos];
        
        //Genera notas random entre 1 y 10
        for(int i=0; i < numAlumnos; i++){
            listaClase[i] = i+1;
            examen[i] = (int) (Math.random() * 11);
            practicas[i] = (int) (Math.random() * 11);
            
            calificaciones[i] = (examen[i] + practicas[i])/2;
        }
        
        int minNota = 11;
        int maxNota = -1;
        int indMinNota = 0;
        int indMaxNota = 0;
        
        //buscamos al mayor
        for (int i = 0; i < examen.length; i++) {
        	if(examen[i]<minNota) {
        		minNota = examen[i];
        		indMinNota = i+1;
        	}
        }
            
        //buscamos al menor
        for (int i = 0; i < examen.length; i++) {
        	if(examen[i]>maxNota) {
        		maxNota = examen[i];
        		indMaxNota = i+1;
        	}
        }
           

        //Comprobamos el resultado del ejercicio   
        System.out.println("Mínimo es: " + minNota);
        System.out.println("Máximo es: " + maxNota);
        System.out.println("Indice del mínimo es : " + indMinNota);
        System.out.println("Indice del máximo es : " + indMaxNota);
        System.out.println("Lista de clase :" + Arrays.toString(listaClase));
        System.out.println("Array de Notas :" + Arrays.toString(examen));
        System.out.println("Prácticas      :" + Arrays.toString(practicas));
        System.out.println("Calificaciones :" + Arrays.toString(calificaciones));
        
        //Sacamos la estadística de calificaciones
        //hacemos un array de 10 para la estadística.
        float[] estadistica = new float[10];
        
        for (int i = 0; i < 10; i++){
            int count = 0; // Solo necesitamos contar cuántos alumnos entran en el tramo
            
            for (int j = 0; j < calificaciones.length; j++){
                // Comprobamos si la nota está dentro del tramo 
                if ((calificaciones[j] > i) && (calificaciones[j] <= (i + 1))) {
                    count++;
                }
            }
            
            // Calculamos el porcentaje
            double sol = (count * 100.0) / numAlumnos;
            
            estadistica[i] = (float) sol;

            System.out.println("Estadística nota tramo <=" 
                + (i+1) + " = " 
                + sol + "%");
        }
        
        //Aprobados y suspensos
        int[] aprobados = new int[numAlumnos];
        int[] suspensos = new int[numAlumnos];
        int countAprobados = 0;
        int countSuspensos = 0;

        for (int i = 0; i < numAlumnos; i++) {
            if (calificaciones[i] >= 5) { 
                aprobados[i] = i + 1;   
                countAprobados++;
            } else {
                suspensos[i] = i + 1;
                countSuspensos++;
            }
        }        
        
        System.out.println("Relación de aprobados por nº de lista: " + Arrays.toString(aprobados));
        System.out.println("Relación de suspensos por nº de lista: " + Arrays.toString(suspensos));
        
        //Resumen de aprobados y suspensos
        int[] listaLimpiaAprobados = new int[countAprobados];
        int[] listaLimpiaSuspensos = new int[countSuspensos];
        
        int idxA = 0;
        int idxS = 0;
        
        for (int i = 0; i < numAlumnos; i++) {
            if (aprobados[i] != 0) {
                listaLimpiaAprobados[idxA] = aprobados[i];
                idxA++;
            }
            if (suspensos[i] != 0) {
                listaLimpiaSuspensos[idxS] = suspensos[i];
                idxS++;
            }
        }
        
        System.out.println("Resumen  de aprobados por nº de lista: " + Arrays.toString(listaLimpiaAprobados));
        System.out.println("Resumen  de suspensos por nº de lista: " + Arrays.toString(listaLimpiaSuspensos));
    
        /*6. Suponer un vector de Calificaciones de tamaño 40 
        (máximo de alumnos por clase), pero que solo almacena las
        notas de 31 alumnos. Realizar un programa que permita insertar en
        la posición 4 del vector la calificación de un nuevo 
        alumno en clase al que supuestamente le corresponde como nota un 6.*/
        double[] califExtra = new double[40]; 
        
        for (int j = 0; j < 31; j++) {
            califExtra[j] = (int) (Math.random() * 11);
        }

        System.out.println("Nota antigua alumno nº4: " + califExtra[3]); 
        
        califExtra[3] = 6.0;
        
        System.out.println("Nota nueva   alumno nº4: " + califExtra[3]);
    }
}
