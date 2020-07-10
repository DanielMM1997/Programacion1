package conjuntoenteros;

public class UsaConjunto {

    //private ConjuntoDeEnteros c1, c2, c3, c4, c5;
    public static void main (String[] args) {
        int[] v1 = {0, 7, 1, 2, 4, -5, -6};
        ConjuntoDeEnteros c1 = new ConjuntoDeEnteros (v1);
        int[] v2 = {0, 1, 2, -6, 6, 8};
        ConjuntoDeEnteros c2 = new ConjuntoDeEnteros (v2);
        c1 = c1.diferencia(c2);
        System.out.println("El cardnal es: " + c1.cardinal());
        for (int i = 0; i < c1.cardinal(); i++) {
            System.out.println("El conjunto es " + c1.elementos()[i] + ",");
        }
        //org.junit.runner.JUnitCore.main("ConjuntoTest");
    }
}
