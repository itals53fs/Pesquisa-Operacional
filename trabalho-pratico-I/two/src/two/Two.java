/*
2) Certa empresa fabrica 2 produtos P1 e P2. O lucro por unidade de P1 é de $100,00 e o lucro unitário de
P2 é de $150,00. A empresa necessita de 2 horas para fabricar uma unidade de P1 e 3 horas para fabricar
uma unidade de P2. O tempo mensal disponível para essas atividades é de 120 horas. As demandas
esperadas para os 2 produtos levaram a empresa a decidir que os montantes produzidos de P1 e P2 não
devem ultrapassar 40 unidades de P1 e 30 unidades de P2 por mês. Construa o modelo do sistema de
produção mensal com o objetivo de maximizar o lucro da empresa

 */
package two;

import java.util.logging.Level;
import java.util.logging.Logger;
import gurobi .*;

/**
 *
 * @author tales
 */
public class Two {

    
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
          funcao.addTerm(100.0, x);
          funcao.addTerm(150.0, y);
          
          //o que devemos fazer com a funçao objetiva: minimizar ou maximizar
          modelo.setObjective(funcao, GRB.MAXIMIZE);
          
          //criar a funcao das restriçoes do lado esquerdo
          funcao = new GRBLinExpr();
          funcao.addTerm(2.0, x);
          funcao.addTerm(3.0, y);
          
          //criar a desigualdade
          modelo.addConstr(funcao, GRB.LESS_EQUAL, 120.0, "restricao01");
          
          funcao = new GRBLinExpr();
          funcao.addTerm(1.0, x);
          
          //criar a desigualdade
          modelo.addConstr(funcao, GRB.LESS_EQUAL, 40.0, "restricao02");
          
          funcao = new GRBLinExpr();
          funcao.addTerm(1.0, y);
          
          //criar a desigualdade
          modelo.addConstr(funcao, GRB.LESS_EQUAL, 30.0, "restricao03");
          
          //otimizar o modelo
          modelo.optimize();
          
          //resultados obtidos
          System.out.println("Quantidade de P1: " + x.get(GRB.StringAttr.VarName) + " = " + x.get(GRB.DoubleAttr.X) );
          System.out.println("Quantidade de P2: " + y.get(GRB.StringAttr.VarName) + " = " + y.get(GRB.DoubleAttr.X) );
          
          //objetivo
            System.out.println("Maximizar o lucro da empresa");
            System.out.println("Objetivo: "+modelo.get(GRB.DoubleAttr.ObjVal));
          
            //
            modelo.dispose();
            funcao.clear();
        }
          
        catch (GRBException ex) {
            Logger.getLogger(Two.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
