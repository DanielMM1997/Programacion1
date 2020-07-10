package buscarVector;

public class BuscaVector {
    
    public static void main(String [] args) {
        int[][] m = {{0,2,3,4,5,6,7,8},{1,2,5,6,7,8},{1,2,3,7,8},{1,6,7,8,8,8,10}};
        int[]   v = {8,8,10};

        PosicionMatriz res = buscaVectorEnMatriz(m, v);

        if(res == null){
            System.out.println("Vector no encontrado");
        }else{
            System.out.println("El vector se ha encontrado en la posición " + res);
        }
    }
    
    public static PosicionMatriz buscaVectorEnMatriz(int[][] mat, int[] vec) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == vec[0] && vec.length == 1) {
                        return new PosicionMatriz(i, j);
                } else if (mat[i][j] == vec[0] && ((mat[i].length-j) >= vec.length)) {
                    int aux = 1;
                    for (int k = 1; k < vec.length; k++) {
                        j++;
                        if (vec[k] == mat[i][j]) {
                            aux++;
                            if (aux == vec.length) {
                                return new PosicionMatriz(i, j-(vec.length-1));
                            }
                        }
                    }
                    j -= aux;
                }
            }
        }
        return null;
    }
}