import java.io.*;
import java.util.Scanner;
public class Calculadora_IP {
	int red[];
	public Calculadora_IP(){
		red=new int[4];
	}
	public static void main(String[] arg){
		Calculadora_IP la = new Calculadora_IP();
		la.menu();
	}
	public void menu(){
		int opcion;
		do{
			System.out.println("¿Cual modo prefieres lanzar?"
				+ "\n1.Optimizar una subnet por medio del numero de subnet necesarias"
				+ "\n2.Salir");
			opcion=verificador(1,2);
			switch (opcion){
				case 1:subnet();break;
				}
		}while(opcion!=2);
	}
	public void subnet(){
		this.red=get_Network();
		int num=get_num();
		this.redes(num);
	}
	public static int[] str2int(String[] la){
		int tmp[]= new int[4];
		for(int i=0;i<la.length;i++){
			tmp[i]=Integer.parseInt(la[i]);
		}
		return tmp;
	}
	public static int str2int(String la){
		return Integer.parseInt(la);
	}
	public void redes(int x){
		int hosts=calcular_subnet(x);
		for(int i=this.red[3];i<255;i+=hosts+2){
			System.out.println("Network:\t"+this.red[0]+"."+this.red[1]+"."+this.red[2]+"."+i+
					"\nFirst Address:\t"+this.red[0]+"."+this.red[1]+"."+this.red[2]+"."+(i+1)+
					"\nLast Address:\t"+this.red[0]+"."+this.red[1]+"."+this.red[2]+"."+(i+hosts)+
					"\nBroadcast Address:"+this.red[0]+"."+this.red[1]+"."+this.red[2]+"."+(i+hosts+1)+"\n");
		}
	}
	public static int calcular_subnet(int x){
		return (256-(2*x))/x;
	}
	public static int[] get_Network(){
		String red,red2[];int tmp[]=new int[4];
		Scanner Readerman = new Scanner(System.in);
		do{
			System.out.println("Introduzca una direccion de red:");
			try{
			red=Readerman.next();
			red2=red.split("\\.");
			tmp=str2int(red2);}
			catch(Exception e){
				System.out.println("ERROR, Valores Introducidos no Validos");
			}
			if(tmp[3]!=0){
				System.out.println("ERROR, Usted a introducido una direccion de host, debe introducir una direccion de red de este formato"+
						"\n x.x.x.0");
			}
			if((tmp[0]>255)||(tmp[1]>255)||(tmp[2]>255)||(tmp[0]<0)||(tmp[1]<0)||(tmp[2]<0)){
				System.out.println("ERROR, las direcciones de red tiene un valor entre 255 y 0");
			}
		}while((tmp[0]>255)||(tmp[1]>255)||(tmp[2]>255)||(tmp[0]<0)||(tmp[1]<0)||(tmp[2]<0)||(tmp[3]!=0));
		return tmp;
	}
	public static int get_num(){
		Scanner Readerman = new Scanner(System.in);
		return Readerman.nextInt();
	}
	public static int verificador(int min,int max){
		int num=-3;
		do{
			
		System.out.print("Elija la Opcion Deseada("+min+"-"+max+"):");
		num=get_num();
		if(num<min||num>max){
					System.out.println("ERROR, ELIJA UN VALOR CORRECTO.");
				}
		}while(num<min||num>max);
		return num;
	}
}
