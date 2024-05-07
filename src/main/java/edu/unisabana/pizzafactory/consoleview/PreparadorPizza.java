
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
 interface PreparadorPizza {
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
class FabricaPizzaDelgada implements PreparadorPizza{
    @Override
    public PreparacionesPizza crearPizza() {
        return new PizzaDelgada();
    }
}
class FabricaPizzaGruesa implements PreparadorPizza{
    @Override
    public PreparacionesPizza crearPizza() {
        return new PizzaGruesa();
    }
}
class FabricaPizzaIntegral implements PreparadorPizza{
    @Override
    public PreparacionesPizza crearPizza() {
        return new PizzaIntegral();
    }
}



// Clase concreta del producto PizzaDelgada
class PizzaDelgada implements PreparacionesPizza{
    @Override
    public void amasar() {
        Logger.getLogger(PizzaDelgada.class.getName())
                .log(Level.INFO, "[@@] Amasando la pizza delgada con masa convencional.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
        
    }
    @Override
    public void hornear() {
        Logger.getLogger(PizzaDelgada.class.getName())
            .log(Level.INFO, "[~~] Horneando la pizza delgada con masa convencional.");

        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
    @Override
    public void moldearPizzaPequena() {
        Logger.getLogger(PizzaDelgada.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza pequena de masa convencional.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR

    }
    @Override
    public void moldearPizzaMediana() {
        Logger.getLogger(PizzaDelgada.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza mediana de masa convencional.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

}

// Clase concreta del producto PizzaGruesa
class PizzaGruesa implements PreparacionesPizza{
    @Override
    public void amasar() {
        Logger.getLogger(PizzaGruesa.class.getName())
                .log(Level.INFO, "[@@] Amasando la pizza gruesa con masa de pan.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
        
    }
    @Override
    public void hornear() {
        Logger.getLogger(PizzaGruesa.class.getName())
            .log(Level.INFO, "[~~] Horneando la pizza gruesa con masa de pan.");

        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
    @Override
    public void moldearPizzaPequena() {
        Logger.getLogger(PizzaGruesa.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza pequena de masa gruesa.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR

    }
    @Override
    public void moldearPizzaMediana() {
        Logger.getLogger(PizzaGruesa.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza mediana de masa gruesa.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
    
}

// Clase concreta del producto PizzaIntegral
class PizzaIntegral implements PreparacionesPizza{
    @Override
    public void amasar() {
        Logger.getLogger(PizzaIntegral.class.getName())
                .log(Level.INFO, "[@@] Amasando la pizza con masa integral.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
        
    }
    @Override
    public void hornear() {
        Logger.getLogger(PizzaIntegral.class.getName())
            .log(Level.INFO, "[~~] Horneando la pizza con masa integral.");

        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
    @Override
    public void moldearPizzaPequena() {
        Logger.getLogger(PizzaIntegral.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza pequena de masa integral.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR

    }
    @Override
    public void moldearPizzaMediana() {
        Logger.getLogger(PizzaIntegral.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza mediana de masa integral.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

}







/**public class PreparadorPizza {

    public static void main(String args[]){
        try {
            Ingrediente[] ingredientes=new Ingrediente[]{new Ingrediente("queso",1),new Ingrediente("jamon",2)};            
            PreparadorPizza pp=new PreparadorPizza();            
            pp.prepararPizza(ingredientes, Tamano.MEDIANO);
        } catch (ExcepcionParametrosInvalidos ex) {
            Logger.getLogger(PreparadorPizza.class.getName()).log(Level.SEVERE, "Problema en la preparacion de la Pizza", ex);
        }
                
    }
    
    
    public void prepararPizza(Ingrediente[] ingredientes, Tamano tam)
            throws ExcepcionParametrosInvalidos {
        AmasadorPizzaDelgada am = new AmasadorPizzaDelgada();
        HorneadorPizzaDelgada hpd = new HorneadorPizzaDelgada();
        MoldeadorPizzaDelgada mp = new MoldeadorPizzaDelgada();
        am.amasar();
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


