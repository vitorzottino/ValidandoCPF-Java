import java.util.Scanner;
public class CPF {
    public static void main(String[] args) throws Exception {
       
        Scanner input = new Scanner(System.in);

        
        String CPF = new String();

        while(CPF.length() != 11){
        
            try{
            System.out.print("CPF: ");
            CPF = input.next();
            }
            
            finally{
                input.close();
            }
        }

        
        if (ValidarCPF(CPF) == true)
            System.out.print("CPF VÁLIDO.");
        
        else
            System.out.print("CPF INVÁLIDO");
    }


    public static boolean ValidarCPF(String CPF){

        int DV1, DV2, DV1c, DV2c, peso, soma, i, x;
        
        DV1 = Character.getNumericValue(CPF.charAt(9));
        DV2 = Character.getNumericValue(CPF.charAt(10));

        soma = 0;
        peso = 10;

        for(i = 0; i < 9; i++){
            
            x = Character.getNumericValue(CPF.charAt(i));
            soma += x * peso;
            peso--;
        }

        DV1c = soma % 11;
        if (DV1c < 2)
			DV1c = 0;
		else
			DV1c = 11 - DV1c;

       soma = 0;
       peso = 11;    
       
       for (i = 0; i < 10; i++){
            x = Character.getNumericValue(CPF.charAt(i));
            soma += x * peso;
            peso--;
       }

       DV2c = soma % 11;
		if (DV2c < 2)
			DV2c = 0;
		else
			DV2c = 11 - DV2c;

       if ((DV1 == DV1c) &&(DV2 == DV2c))
        return true;
        
       else
       return false;     
       
    }



}
