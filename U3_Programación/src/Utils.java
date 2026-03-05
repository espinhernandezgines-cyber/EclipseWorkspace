
public class Utils {
	public static int buscarInt(int[] numeros, int valor) {
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] == valor) {
				return i;
			}
		}
		return -1;
	}
}