/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cliente
 */
public class ValidadorCPF {
    
    public static boolean validaCPF(String cpf){
        String verificadorGerado = geraVerificador(cpf.substring(0, 9));
        String verificadorAtual = getVerificador(cpf);
        return verificadorAtual.equals(verificadorGerado);
    }
    
    private static String geraVerificador(String cpf){
        String verificador = geraMetadeVerificador(cpf);
        verificador += geraMetadeVerificador(cpf + verificador);
        return verificador;
    }
    
    private static String geraMetadeVerificador(String cpf){
        Integer soma = somaDigitos(cpf);
        String verificador = resolveVerificador(soma);
        return verificador;
    }
    
    private static String getVerificador(String cpf){
        return cpf.substring(9, 11);
    }
    
    private static Integer somaDigitos(String cpf){
        Integer soma = 0;
        Integer multiplicador = cpf.length() + 1;
        for(Character c:cpf.toCharArray()){
            soma += Integer.parseInt(c.toString()) * multiplicador;
            multiplicador--;
        }
        return soma;
    }
    
    private static String resolveVerificador(Integer soma){
        Integer verificador;
        
        if(soma % 11 < 2){
            verificador = 0;
        }else{
            verificador = 11 - (soma % 11);
        }
        
        return String.valueOf(verificador);
    }
    
}
