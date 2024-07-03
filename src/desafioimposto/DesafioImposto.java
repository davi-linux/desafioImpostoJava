package desafioimposto;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Mr.Mendes
 */
public class DesafioImposto {

    /*
    Salário MENSAL              |   Imposto
    Abaixo de 3000 por mês      =   Isento
    3000 até 5000 exclusive     =   10%
    5000 ou acima               =   20%
     */

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double salarioA, prestServ, ganhCap, med,
                salarioM, edu, maxDed, gasDed, impBr, abat, impDev,
                impSal, impServ, impGanh, totalImp, impDeb;
        impSal = 0;
        
        System.out.print("Renda anaual com salário: ");
        salarioA = sc.nextDouble();
        System.out.print("Renda anual com prestação de serviço: ");
        prestServ = sc.nextDouble();
        System.out.print("Renda anual com ganho de capital: ");
        ganhCap = sc.nextDouble();
        System.out.print("Gastos médicos: ");
        med = sc.nextDouble();
        System.out.print("Gastos educacionais: ");
        edu = sc.nextDouble();

        //FORMULAS\\
        salarioM = (salarioA / 12);

        // FUNÇÃO QUE VERIFICA O IMPOSTO DO SALARIO A PAGAR
        if (salarioM < 3.000) {

            impSal = 0;

        } else if (salarioM > 3.000 && salarioM < 5.000) {

            impSal = ((salarioM * 10) / 100);

        } else {

            salarioM = (salarioM / 20);
        }

        //FUNCAO QUE VERIFICAR O IMPOSTO DE PRESTACOA DE SERVIÇO A PAGAR
        if (prestServ > 0) {
            
            impServ = (( prestServ * 15)/100);
            
        } else {
        
            impServ = 0;
        }
        
        
        //FUNCAO QUE VERIFICA O IMPOSTO DE GANHOS A PAGAR
        
        if (ganhCap > 0 ){
            
            impGanh = ((ganhCap * 20)/100);
            
            
        } else {
        
            impGanh = 0;
        }
        
        //ABATIMENTO
        
        totalImp = (impSal + impServ + impGanh);
        impBr = (( totalImp * 30)/100);
        
        
        //IMPOSTO BRUTO
        
        totalImp = impSal + impServ + impGanh;
        impBr = ((totalImp * 30)/100);
        
        //DEDUCOES
        
        gasDed = med + edu;
        impDeb = ((gasDed * 30) / 100);
        
        
        if (impDeb > impBr ){
            
            maxDed = impBr;
        }else{
            maxDed = impDeb;
        }
        
        
        
        
        //RELATORIOS GERADOS\\
        System.out.println("RELATÓRIO DE IMPOSTO DE RENDA\n");
        System.out.println("CONSOLIDADO DE RENDA: ");
        System.out.println("Imposto sobre salário: " + salarioM);
        System.out.println("Imposto sobre serviços: " + impServ);
        System.out.println("Imposto sobre ganho de capital: " + impGanh);
        System.out.println("\nDEDUÇÕES");
        System.out.println("Máximo dedutível: " + maxDed);
        System.out.println("Gastos dedutiveis: " + gasDed);
        System.out.println("\nRESUMO:");
        System.out.println("Imposto bruto total: " + totalImp);
        System.out.println("Abatimento: " + maxDed);
        System.out.println("Imposto devido: " + (totalImp - maxDed));
    }

}
