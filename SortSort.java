import java.util.*;

public class SortSort{
  public static void main(String[] args){
    //Aquí empiezan a meter los numeros para sacarles el modulo.
    Scanner sc = new Scanner(System.in);
    //sabemos que la primera linea contiene el numero de numeros y el modulo
    String aEvaluar = sc.nextLine();
    while(aEvaluar!= "0 0"){
      String[] separados = aEvaluar.split(" ");
      try{
        int cuantosNumeros = Integer.parseInt(separados[0]);
        int modulo = Integer.parseInt(separados[1]);
        int numerosCalcular[]= new int[cuantosNumeros];
        //lista de arreglos
        ArrayList<int[]> ordenadosPorResiduos = new ArrayList<int[]>();
        //llenamos el arreglo de los numeros a Calcular
        for (int i = 0;i<cuantosNumeros ;i++) {
            numerosCalcular[i] = sc.nextInt();
        }
        for(int c = 0; c < cuantosNumeros; c++){
          int residuo =numerosCalcular[c]%modulo;
          int[] parResiduoValor = new int[2];
          parResiduoValor[0]=residuo;
          parResiduoValor[1]=numerosCalcular[c];
          ordenadosPorResiduos.add(parResiduoValor);
        }
        quicksort(ordenadosPorResiduos,0,cuantosNumeros-1);//ordenamos es arreglo
        for (int n = 0;n<cuantosNumeros ;n++ ) {
          System.out.printf(Integer.toString(ordenadosPorResiduos.get(n)[1])+"\n");
        }
      }catch(Exception e){
        System.out.printf("No se pudo convertir");
      }
    }
    sc.close();
  }
//toma en cuenta que los elementos en A[] son de la forma Pair<Integer,Integer>
  public static ArrayList<int[]> quicksort(ArrayList<int[]>lista, int izq, int der) {

  int[] pivote=lista.get(izq); // tomamos primer elemento como pivote
  int i=izq;         // i realiza la búsqueda de izquierda a derecha
  int j=der;         // j realiza la búsqueda de derecha a izquierda
  int aux[];

  while(i < j){                          // mientras no se crucen las búsquedas
     while( lista.get(i)[0] <= pivote[0] && i < j) i++; // busca elemento mayor que pivote
     while( lista.get(j)[0] > pivote[0]) j--;           // busca elemento menor que pivote
     if (i < j) {                        // si no se han cruzado
         aux= lista.get(i);                      // los intercambia
         lista.set(i,lista.get(j));//= lista.get(j); //recuerda que lista.get(int i) devuelve un array.
         lista.set(j,aux);//=aux;
     }
   }

   lista.set(izq, lista.get(j)); // = lista.get(j);      // se coloca el pivote en su lugar de forma que tendremos
   lista.set(j,pivote);//=pivote;      // los menores a su izquierda y los mayores a su derecha

   if(izq < j-1)
      quicksort(lista,izq,j-1);          // ordenamos subarray izquierdo
   if(j+1 < der)
      quicksort(lista,j+1,der);          // ordenamos subarray derecho

    return lista;

  }

}
