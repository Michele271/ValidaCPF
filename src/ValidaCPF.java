/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 * EXERCICO CPF AULA 10/10/2015: REFATORAR A CLASSE ABAIXO
 */
public class ValidaCPF {

    /**
     * @param args the command line arguments
     */
    public static void mainn(String[] args) {
        // TODO code application logic here
        String cpf = "281175491";
        Integer vA;
        Integer vB;
        String verificador;
        Integer multiplicador = cpf.length() + 1;
        Integer soma = 0;
        for(Character c:cpf.toCharArray()){
            soma += Integer.parseInt(c.toString()) * multiplicador;
            multiplicador--;
        }
        
        if(soma % 11 < 2){
            vA = 0;
        }else{
            vA = 11 - (soma % 11);
        }
        
        soma = 0;
        cpf += vA;
        multiplicador = cpf.length() + 1;
        for(Character c:cpf.toCharArray()){
            soma += Integer.parseInt(c.toString()) * multiplicador;
            multiplicador--;
        }
        
        cpf = cpf.substring(0, 9);
        
        if(soma % 11 < 2){
            vB = 0;
        }else{
            vB = 11 - (soma % 11);
        }
        
        verificador = vA + "" + vB;
        
        System.out.print(cpf);
        System.out.print("-");
        System.out.println(verificador);
    }
    
}
