package com.clientes;


import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import com.clases.BeneficiosCovid19;
import com.clases.Constant;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
	// write your code her
    	BeneficiosCovid19 beneficioCovid = new BeneficiosCovid19();
    	
		int nArray;
		
    	ArrayList <BeneficiosCovid19> ArrayBeneficios1 = new ArrayList <BeneficiosCovid19>();
    	ArrayList <BeneficiosCovid19> ArrayBeneficios2 = new ArrayList <BeneficiosCovid19>();
		
    	nArray = 1;
    	ArrayBeneficios1 = ingresarValores(nArray);
    	
    	nArray = 2;
		ArrayBeneficios2 = ingresarValores(nArray);
		
		getMejorbeneficios(ArrayBeneficios1, ArrayBeneficios2);
	
        
    }

    

    //Implementa un metodo que te entregue un numero aletorio para el ide de los beneficios usar el wrapper de Integer
    public static String getIdBeneficio(){
        //La Clase Math tiene varios metodos que te ayudaran
    	
    	int random1 = (int) (Math.random() * 100000 + 1);
    	String random = Integer.toString(random1);
    	return random;
    }
    
    public static ArrayList ingresarValores(int nArray){
    	
    	String type;
		String value;
		String entrada = "SI";
		String id;
		ArrayList <BeneficiosCovid19> ArrayBeneficios = new ArrayList <BeneficiosCovid19>();
		
    	System.out.println("Ingrese los subsidios del Array :" + nArray); 
        while (entrada.equals("SI")) {
		   	//Solicita el nombre del subsidio
        	BeneficiosCovid19 beneficioCovid = new BeneficiosCovid19();
        	
			type = "A";
			value = imprimir(Constant.TEXTO_INGRESE_NOMBRE, type);
			beneficioCovid.setNombre(value);
			
			type = "N";
			value = imprimir(Constant.TEXTO_INGRESE_SUBSIDIO, type);
			beneficioCovid.setValorSubsidio(Float.parseFloat(value));
			
			id = getIdBeneficio();
			beneficioCovid.setId(id);
			
			ArrayBeneficios.add(beneficioCovid);
			
			type = "A";
            entrada = imprimir(Constant.TEXTO_CONTINUAR, type);
            while ( !entrada.equals("SI") && !entrada.equals("NO")) {
            	entrada = imprimir(Constant.TEXTO_CONTINUAR, type);
            	
            }
		}
        return ArrayBeneficios;
    }
    
    
    public static String imprimir(String message, String tipo) {
    	String value;
    	
    	Scanner in = new Scanner(System.in);
    	
    	System.out.println(message);
    	value = in.nextLine();
        
    	if (tipo == "N") {
			while (isNumeric(value)==false) {
				System.out.println(message);
				value = in.nextLine();
		    }
    	}
		
		return value;
        
    }
    
    public static boolean isNumeric(String value) {
        
        try {
        	Float.parseFloat(value);
        	return true;
        	
        }
        catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,Constant.TEXTO_MENSAJE_ERROR_NUMERICO,
					"Error",
					JOptionPane.ERROR_MESSAGE);
        	
        	return false;
			
		}
        
    }
    
    public static void getMejorbeneficios(ArrayList<BeneficiosCovid19> Array1, ArrayList<BeneficiosCovid19> Array2) {
    	
    	BeneficiosCovid19 beneficioMayor = new BeneficiosCovid19();
    	float valor = 0;
    	beneficioMayor.setValorSubsidio(valor);
    	for (int i = 0;i< Array1.size();i++) { 
			BeneficiosCovid19 auxiliarCovid = Array1.get(i);
			
			if (auxiliarCovid.getValorSubsidio() > beneficioMayor.getValorSubsidio()){
				beneficioMayor = auxiliarCovid;
			}
		}
    	
		for (int i = 0;i< Array2.size();i++) {
			BeneficiosCovid19 auxiliarCovid2 = Array2.get(i);
			if (auxiliarCovid2.getValorSubsidio() > beneficioMayor.getValorSubsidio()){
				beneficioMayor = auxiliarCovid2;
			}
			
		}
		System.out.println("Array: El id mayor es:  " + beneficioMayor.getId());
		System.out.println("Array: El nombre meyor es:  " + beneficioMayor.getNombre());
		System.out.println("Array: El valor del subsidio mayor es:  " + beneficioMayor.getValorSubsidio());
		
    	
    }
}
