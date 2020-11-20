/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package five;

import java.util.logging.Level;
import java.util.logging.Logger;
import gurobi .*;

/**
 *
 * @author tales
 */
public class Five {

<<<<<<< HEAD
=======
    
>>>>>>> 1f5cb0e6eb642cea3e1d5fb184c48ebc5e5ee427
    public static void main(String[] args) {
        try {
          //cria o ambiente
          GRBEnv  env = new GRBEnv();
        
          //cria um objeto de modelo vazio
          GRBModel modelo = new GRBModel(env);
          
          //cria as variaveis de decisão - minimo
          GRBVar x = modelo.addVar(0.0,GRB.INFINITY,0.0, GRB.CONTINUOUS, "x");
          GRBVar y = modelo.addVar(0.0,GRB.INFINITY, 0.0, GRB.CONTINUOUS, "y");
          
          //construir a função objetiva vazia
          GRBLinExpr funcao = new GRBLinExpr();
          
          //construir a funcao objetiva
          funcao.addTerm(120.0, x);
          funcao.addTerm(150.0, y);
          
          //o que devemos fazer com a funçao objetiva: minimizar ou maximizar
          modelo.setObjective(funcao, GRB.MAXIMIZE);
          
          //criar a funcao das restriçoes do lado esquerdo
          funcao = new GRBLinExpr();
          funcao.addTerm(2.0, x);
          funcao.addTerm(4.0, y);
          
          //criar a desigualdade
          modelo.addConstr(funcao, GRB.LESS_EQUAL, 100.0, "restricao01");
          
          funcao = new GRBLinExpr();
          funcao.addTerm(3.0, x);
          funcao.addTerm(2.0, y);
          
          modelo.addConstr(funcao, GRB.LESS_EQUAL, 90.0, "restricao02");
          
          
          funcao = new GRBLinExpr();
          funcao.addTerm(5.0, x);
          funcao.addTerm(3.0, y);
          modelo.addConstr(funcao, GRB.LESS_EQUAL, 120.0, "restricao03");
         
          
          //otimizar o modelo
          modelo.optimize();
          
          //resultados obtidos
          System.out.println("quantidade de P1 : " + x.get(GRB.StringAttr.VarName) + " = " + x.get(GRB.DoubleAttr.X) );
          System.out.println("quantidade de P2: " + y.get(GRB.StringAttr.VarName) + " = " + y.get(GRB.DoubleAttr.X) );
          
          //objetivo
            System.out.println("Produção máxima");
            System.out.println("Objetivo: "+modelo.get(GRB.DoubleAttr.ObjVal));
          
            //
            modelo.dispose();
            funcao.clear();
        }
          
        catch (GRBException ex) {
            Logger.getLogger(Five.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}