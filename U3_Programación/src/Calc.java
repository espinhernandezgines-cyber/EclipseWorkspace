public class Calc {

private int numl;
private int num2;

public Calc(int a, int b) {
numl = a;
num2 = b;
}

public int suma () {
int resul = numl + num2;
return resul;
}

public int resta() {
int resul = numl - num2 ;
return resul;
}

public int multiplica() {
int resul = numl * num2 ;
return resul;
}

public int divide() {
int resul = numl / num2;
return resul;
}
}
