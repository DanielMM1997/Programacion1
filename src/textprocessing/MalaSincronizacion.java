package textprocessing;

public class MalaSincronizacion {
    static class Contador{
        private int valor;
        public Contador(){
            valor = 0;
        }
        public void incrementa(){
            valor++;
        }
        int dameValor(){
            return valor;
        }
    }
    static class HiloIncrementador extends Thread{
        private Contador contador;
        private int incrementos;
        public HiloIncrementador(Contador contador, int incrementos){
            this.contador = contador;
            this.incrementos = incrementos;
        }
        @Override
        public void run(){
            for(int i = 0; i < incrementos; i++){
                contador.incrementa();
            }
        }
    }
    public static void main(String[] args){
        Contador contador = new Contador(); //Contador compartido por varios hilos
        HiloIncrementador hilo1 = new HiloIncrementador(contador, 2);
        HiloIncrementador hilo2 = new HiloIncrementador(contador, 2);
        hilo1.start(); //Iniciamos la ejecución del hilo
        hilo2.start(); //Iniciamos la ejecución del hilo
        try{
            hilo1.join(); //Esperamos a que termine
            hilo2.join(); //Esperamos a que termine, si no ha terminado ya
        }catch(Exception e){};
        //Mostramos el resultado total después todos los incrementos
        System.out.println("Valor final " + contador.dameValor());
    }
}
