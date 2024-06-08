
package edu.unisabana.pizzafactory.consoleview;

// Amasadores
//import edu.unisabana.pizzafactory.model.AmasadorPizzaDelgada;
//import edu.unisabana.pizzafactory.model.AmasadorPizzaGruesa;
//import edu.unisabana.pizzafactory.model.AmasadorPizzaIntegral;

//Horneadores
//import edu.unisabana.pizzafactory.model.HorneadorPizzaDelgada;
//import edu.unisabana.pizzafactory.model.HorneadorPizzaGruesa;
//import edu.unisabana.pizzafactory.model.HorneadorPizzaIntegral;

//Moldeadores
//import edu.unisabana.pizzafactory.model.MoldeadorPizzaDelgada;
//import edu.unisabana.pizzafactory.model.MoldeadorPizzaGruesa;
//import edu.unisabana.pizzafactory.model.MoldeadorPizzaIntegral;

//Extras
import edu.unisabana.pizzafactory.model.ExcepcionParametrosInvalidos;
import edu.unisabana.pizzafactory.model.Tamano;
import edu.unisabana.pizzafactory.model.Ingrediente;

import java.util.Arrays;
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
        
        // Amasar la pizza
        pizza.amasar();

        // Agregar los ingredientes
        for (Ingrediente ingrediente : ingredientes) {
            System.out.println("[+] Agregando " + ingrediente.getCantidad() + " unidades de " + ingrediente.getNombre());
            // Implementar la lógica para agregar el ingrediente a la pizza (código específico de la clase concreta)
        }

        // Moldear la pizza según el tamaño
        if (tamano.equals(Tamano.PEQUENO)) {
            pizza.moldearPizzaPequena();
        } else {
            pizza.moldearPizzaMediana();
        }

        // Hornear la pizza
        pizza.hornear();

        System.out.println("[!] ¡Pizza lista para disfrutar!");
    }

    public static void main(String[] args) {
        try {
            Ingrediente[] ingredientes = new Ingrediente[]{new Ingrediente("queso", 1), new Ingrediente("jamón", 2)};
            Tamano tamano = Tamano.MEDIANO;

            String tipoPizza = "integral";
            CreadorPizza fabrica = null;
            switch (tipoPizza) {
                case "delgada":
                    fabrica = new FabricaPizzaDelgada();
                    break;
                case "gruesa":
                    fabrica = new FabricaPizzaGruesa();
                    break;
                case "integral":
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





/*
   public void prepararPizza(Ingrediente[] ingredientes, Tamano tam)
            throws ExcepcionParametrosInvalidos {
        
        
        if (tam == Tamano.PEQUENO) {
            mp.moldearPizzaPequena();
        } else if (tam == Tamano.MEDIANO) {
            mp.moldearPizzaMediana();
        } else {
            throw new ExcepcionParametrosInvalidos("Tamano de piza invalido:"+tam);
        }
	    aplicarIngredientes(ingredientes);
        hpd.hornear();
    }

    private void aplicarIngredientes(Ingrediente[] ingredientes) {
        Logger.getLogger(PreparadorPizza.class.getName())
                .log(Level.INFO, "APLICANDO INGREDIENTES!:{0}", Arrays.toString(ingredientes));
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
        
        
        
    }


}
*/


