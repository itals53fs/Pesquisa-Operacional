/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfor;

import java.util.logging.Level;
import java.util.logging.Logger;
import gurobi .*;

/**
 *
 * @author tales
 */
public class For {

    
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
          funcao.addTerm(4.0, x);
          funcao.addTerm(3.0, y);
          
          //o que devemos fazer com a funçao objetiva: minimizar ou maximizar
          modelo.setObjective(funcao, GRB.MAXIMIZE);
          
          //criar a funcao das restriçoes do lado esquerdo
          funcao = new GRBLinExpr();
          funcao.addTerm(2.0, x);
          funcao.addTerm(1.0, y);
          
          //criar a desigualdade
          modelo.addConstr(funcao, GRB.LESS_EQUAL, 1000.0, "restricao01");
          
          funcao = new GRBLinExpr();
          funcao.addTerm(1.0, x);
          funcao.addTerm(1.0, y);
          
          modelo.addConstr(funcao, GRB.LESS_EQUAL, 800.0, "restricao02");
          
          
          funcao = new GRBLinExpr();
          funcao.addTerm(1.0, x);
          modelo.addConstr(funcao, GRB.LESS_EQUAL, 400.0, "restricao03");
          
          funcao = new GRBLinExpr();
          funcao.addTerm(1.0, y);
          modelo.addConstr(funcao, GRB.LESS_EQUAL, 700.0, "restricao04");
          
          //otimizar o modelo
          modelo.optimize();
          
          //resultados obtidos
          System.out.println("quantidade de M1 dia : " + x.get(GRB.StringAttr.VarName) + " = " + x.get(GRB.DoubleAttr.X) );
          System.out.println(" quantidade de M2 dia: " + y.get(GRB.StringAttr.VarName) + " = " + y.get(GRB.DoubleAttr.X) );
          
          //objetivo
            System.out.println("Produção máxima");
            System.out.println("Objetivo: "+modelo.get(GRB.DoubleAttr.ObjVal));
          
            //
            modelo.dispose();
            funcao.clear();
        }
          
        catch (GRBException ex) {
            Logger.getLogger(For.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}