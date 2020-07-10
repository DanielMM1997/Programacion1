/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso;
import java.util.*;

public class Tienda {

    public static void main(String[] args){   
        Productos prods = new Productos();
        Producto p1 = new Producto("pepino", 2);
        Producto p2 = new Producto("manzana", 3);
        Producto p3 = new Producto("tortilla", 5);
        Producto p4 = new Producto("mantas", 4);
        Producto p5 = new Producto("lejia", 2);
        Producto p6 = new Producto("cepillo", 8);
        Producto p7 = new Producto("tomate", 5);
        Producto p8 = new Producto("peras", 7);
        
        prods.addProduct(p1);
        prods.addProduct(p2);
        prods.addProduct(p3);
        prods.addProduct(p4);
        prods.addProduct(p5);
        prods.addProduct(p6);
        prods.addProduct(p7);
        prods.addProduct(p8);
        
        TiendaGUI tienda = new TiendaGUI();
        tienda.assing(prods);
        tienda.showProductos();
    }
}
