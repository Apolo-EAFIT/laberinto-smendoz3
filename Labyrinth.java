import java.util.Scanner;
public class Labyrinth {
    static int laberinto;
    static int contador;
    static char[][] matriz;
    static char[][] matriz2;
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[]) {
        contador = 0;   //contador de paredes
        laberinto = scan.nextInt();  //Genera la matriz de n numeros 
        
        if (laberinto >= 3 && laberinto <= 33) {      //se asegura que n sea mayor o igual que 3 y menor o igual que 33 
            matriz = new char[laberinto + 2][laberinto + 2];
        } else {
            System.out.println("0");
        }
        
        for (int i = 0; i < laberinto + 2; i++) {
            if (i == 0 || i == laberinto + 1) {
                for (int j = 0; j < laberinto + 2; j++) {
                    matriz[i][j] = '#';
                }
            } else {
                String linea = scan.next();               //Escanea la entrada del juez
                char[] fila = linea.toCharArray();        //Y la acomoda en un arreglo de caracteres
                int cuenta = 0;
                for (int j = 0; j < laberinto + 2; j++) {
                    if (j == 0 || j == laberinto + 1) {
                        matriz[i][j] = '#';
                    } else {
                        matriz[i][j] = fila[cuenta];
                        cuenta++;
                    }
                }
            }
        }
        
        matriz2=copiarMat(matriz);
        int resultado2=(recorrer(1,1)-2)*9;
        boolean conectado = false;
        
        if(matriz[laberinto][laberinto]=='v'){
            conectado=true;
        }
        
        contador=0;
        matriz=copiarMat(matriz2);
        int resultado3 = (recorrer(laberinto, laberinto) - 2) * 9;
        
        if(conectado){
            System.out.println(resultado2-18);
        }
        else{
            System.out.println(resultado2+resultado3);
        }
    }

    private static char[][] copiarMat(char[][] origen){
        char[][] resultado= new char[laberinto+2][laberinto+2];
        for (int i = 0; i < laberinto + 2; i++) {
            for (int j = 0; j < laberinto + 2; j++) {
                resultado[i][j]=origen[i][j];
            }
        }
        return resultado;
    }
    
    private static int recorrer(int x, int y) {
        matriz[x][y] = 'v';
        if (matriz[x - 1][y] == '.') {
            recorrer(x - 1, y);
        } else if (matriz[x - 1][y] == '#') {
            contador++;
        }
        if (matriz[x + 1][y] == '.') {
            recorrer(x + 1, y);
        } else if (matriz[x + 1][y] == '#') {
            contador++;
        }
        if (matriz[x][y - 1] == '.') {
            recorrer(x, y - 1);
        } else if (matriz[x][y - 1] == '#') {
            contador++;
        }
        if (matriz[x][y + 1] == '.') {
            recorrer(x, y + 1);
        } else if (matriz[x][y + 1] == '#') {
            contador++;
        }
        
        return contador;
    }
    
}
