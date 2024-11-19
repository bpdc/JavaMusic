package EstruturaArvore;
public class Node<N> {

    N elemento; // elemento armazenado no nó
    Node left, right, parent; // apontadores do nó

    Node(N elemento) {
        this.elemento = elemento;
        left = right = parent = null;
    
    }
    
    public void exibeNo(){
        System.out.println(elemento.toString());
    }
}