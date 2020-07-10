/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso;
/**
 *
 * @author danie
 */
public class busquedaTest {    
    public static void main(String[] args){
        busquedaTest Bus = new busquedaTest();         
        Bus.ejecutaPruebas();
    }
    public void ejecutaPruebas() {
        int[] vec = {1, 2, 3};
        int[][] mat = {{1,0,3},{1,5,6},{0,2,3}};
        
        busqueda res = buscaVectorEnMatriz(vec, mat);
        if (res == null) {
            System.out.println("El vector no se ha encontrado");
        } else {
            System.out.println("El vector se ha encontrado en: " + res.toString());
        }
    }
    public busqueda buscaVectorEnMatriz (int[] vec, int[][] mat){
        busqueda res = null;    
        //busqueda Bus = new busqueda(coor1, coor2);
        for (int f = 0; f < mat.length; f++){
            for (int c = 0; c < mat[f].length; c++){
                for (int i = 0; i < vec.length-2; i++){
                    if(vec[i] == mat[f][c] && vec[i+1] == mat[f][c+1] && vec[i+2] == mat[f][c+2]){
                        res = new busqueda(f, c);
                    }
                }
            }
        }
        return res;
    }
    
    
}
