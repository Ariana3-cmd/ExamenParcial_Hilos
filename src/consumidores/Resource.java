package consumidores;


public class Resource {
   // Número de recursos actuales
   int num = 0;
        // El límite superior del recurso actual
   int size = 10;

        // Recursos de consumo
   public synchronized void remove() {
                // Si num es 0, no hay recursos y debes esperar
                while (num == 0) {// while se recomienda en el código fuente jdk aquí, ya que puede haber falsas activaciones, 
                	//así que confirma nuevamente
           try {
                                System.out.println ("El consumidor entra en espera");
                                this.wait (); // El hilo espera y libera el bloqueo
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
                // Si el hilo puede ejecutarse aquí, significa que hay recursos en el recurso que pueden ser consumidos
       num--;
                System.out.println ("Los subprocesos del consumidor son:" + Thread.currentThread (). getName() + '\n' + "--Número de recursos:" + num);
                this.notify (); // Despierta otros hilos de espera
   }

        // recursos de producción
   public synchronized void put() {
                // Si el recurso está lleno, entra en un estado de bloqueo
                while (num == size) {// while se recomienda en el código fuente jdk aquí, ya que puede haber falsas activaciones, así que confirma nuevamente
           try {
                                System.out.println ("el productor entra en espera");
                                this.wait (); // El hilo entra en un estado de bloqueo y libera el bloqueo

           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

       num++;
                System.out.println ("El hilo productor es:" + Thread.currentThread (). getName() + '\n' +" Número de recursos:" + num);
                this.notify (); // Despierta otros hilos de espera
   }
}
