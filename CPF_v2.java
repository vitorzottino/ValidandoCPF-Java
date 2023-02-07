
import javax.swing.JOptionPane;
public class CPF_v2{
    public static void main(String[] args) throws Exception {
       
        String CPF = new String();

        while(CPF.length() != 11){
    
            CPF = JOptionPane.showInputDialog("Informe o CPF");
        
        }

        
        if (ValidarCPF(CPF) == true)
            JOptionPane.showMessageDialog(null, "CPF Válido");

        else
            JOptionPane.showMessageDialog(null, "CPF Inválido");

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
