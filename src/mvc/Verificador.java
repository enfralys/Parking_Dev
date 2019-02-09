package mvc;

public  class Verificador implements Runnable {
    private Thread t;
    private String threadName;
    public Verificador( String name){
        threadName = name;
        System.out.println("Creando Verificador " + threadName );
    }
    public void run() {
        System.out.println("Ejecutando " + threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Hilo: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("El Hilo " + threadName + " fue interrumpido");
        }
        System.out.println("El Hilo " + threadName + " esta activo.");
    }
    public void start (){
        System.out.println("Iniciando " + threadName );
            if (t == null) {
                t = new Thread (this, threadName);
                t.start ();
            }
    }
}