package Repaso;
import java.util.*;

public class Productos {
    
    public ArrayList<Producto> productos = new ArrayList<>();
    public ArrayList<Producto> carrito = new ArrayList<>();
    
    public void addProduct(Producto p){
        productos.add(p);
    }
    
    public void addCarrito(Producto p){
        carrito.add(p);
    }
    
    public int productosSize(){
        return productos.size();
    }
    
    public int carritoSize(){
        return carrito.size();
    }
}
