
package edu.unisabana.pizzafactory.consoleview;

//Extras
import edu.unisabana.pizzafactory.model.ExcepcionParametrosInvalidos;
import edu.unisabana.pizzafactory.model.Tamano;
import edu.unisabana.pizzafactory.model.Ingrediente;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarvefe
 */

/**
 * PreparadorPizza
 */


// Interfaz o clase abstracta para el Factory Method
interface CreadorPizza {
    PreparacionesPizza crearPizza();
}

// Interfaz para el producto
interface PreparacionesPizza {
    void amasar();
    void hornear();
    void moldearPizzaPequena();
    void moldearPizzaMediana();
}

// Clases para implementar el factory method
class FabricaPizzaDelgada implements CreadorPizza {
    @Override
    public PreparacionesPizza crearPizza() {
        return new PizzaDelgada();
    }
}

class FabricaPizzaGruesa implements CreadorPizza {
    @Override
    public PreparacionesPizza crearPizza() {
        return new PizzaGruesa();
    }
}

class FabricaPizzaIntegral implements CreadorPizza {
    @Override
    public PreparacionesPizza crearPizza() {
        return new PizzaIntegral();
    }
}

// Clase concreta del producto PizzaDelgada
class PizzaDelgada implements PreparacionesPizza {
    @Override
    public void amasar() {
        Logger.getLogger(PizzaDelgada.class.getName())
                .log(Level.INFO, "[@@] Amasando la pizza delgada con masa convencional.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

    @Override
    public void hornear() {
        Logger.getLogger(PizzaDelgada.class.getName())
                .log(Level.INFO, "[~~] Horneando la pizza delgada con masa convencional.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

    @Override
    public void moldearPizzaPequena() {
        Logger.getLogger(PizzaDelgada.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza pequena de masa convencional.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

    @Override
    public void moldearPizzaMediana() {
        Logger.getLogger(PizzaDelgada.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza mediana de masa convencional.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
}

// Clase concreta del producto PizzaGruesa
class PizzaGruesa implements PreparacionesPizza {
    @Override
    public void amasar() {
        Logger.getLogger(PizzaGruesa.class.getName())
                .log(Level.INFO, "[@@] Amasando la pizza gruesa con masa de pan.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

    @Override
    public void hornear() {
        Logger.getLogger(PizzaGruesa.class.getName())
                .log(Level.INFO, "[~~] Horneando la pizza gruesa con masa de pan.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

    @Override
    public void moldearPizzaPequena() {
        Logger.getLogger(PizzaGruesa.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza pequena de masa gruesa.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

    @Override
    public void moldearPizzaMediana() {
        Logger.getLogger(PizzaGruesa.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza mediana de masa gruesa.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
}

// Clase concreta del producto PizzaIntegral
class PizzaIntegral implements PreparacionesPizza {
    @Override
    public void amasar() {
        Logger.getLogger(PizzaIntegral.class.getName())
                .log(Level.INFO, "[@@] Amasando la pizza con masa integral.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

    @Override
    public void hornear() {
        Logger.getLogger(PizzaIntegral.class.getName())
                .log(Level.INFO, "[~~] Horneando la pizza con masa integral.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

    @Override
    public void moldearPizzaPequena() {
        Logger.getLogger(PizzaIntegral.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza pequena de masa integral.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

    @Override
    public void moldearPizzaMediana() {
        Logger.getLogger(PizzaIntegral.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza mediana de masa integral.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
}



public class PreparadorPizza {

    public void prepararPizza(PreparacionesPizza pizza, Ingrediente[] ingredientes, Tamano tamano) {
        pizza.amasar();
        for (Ingrediente ingrediente : ingredientes) {
            System.out.println("[+] Aplicando " + ingrediente.getCantidad() + " unidad/es de " + ingrediente.getNombre());
            
        }
        // Moldear la pizza según el tamaño
        if (tamano.equals(Tamano.PEQUENO)) {
            pizza.moldearPizzaPequena();
        } else {
            pizza.moldearPizzaMediana();
        }
        pizza.hornear();

        System.out.println("[!] ¡Pizza lista!");
    }

    public static void main(String[] args) {
        try {
            Ingrediente[] ingredientes = new Ingrediente[]{new Ingrediente("queso", 1), new Ingrediente("jamón", 2)};
            
            // -------------------------------
            // Escoger el tamano de la pizza
            Tamano tamano = Tamano.MEDIANO;
            // Escoger el tipo de Pizza
            String tipoPizza = "integral";
            // -------------------------------

            CreadorPizza fabrica = null;
            switch (tipoPizza) {
                case "Delgada":
                    fabrica = new FabricaPizzaDelgada();
                    break;
                case "Gruesa":
                    fabrica = new FabricaPizzaGruesa();
                    break;
                case "Integral":
                    fabrica = new FabricaPizzaIntegral();
                    break;
                default:
                    throw new ExcepcionParametrosInvalidos("Tipo de pizza no válido: " + tipoPizza);
            }

            // Crear una instancia de la pizza concreta
            PreparacionesPizza pizza = fabrica.crearPizza();

            // Preparar la pizza
            PreparadorPizza pp = new PreparadorPizza();
            pp.prepararPizza(pizza, ingredientes, tamano);
        } catch (ExcepcionParametrosInvalidos ex) {
            Logger.getLogger(PreparadorPizza.class.getName()).log(Level.SEVERE, "Problema en la preparación de la Pizza", ex);
        }
    }
}


