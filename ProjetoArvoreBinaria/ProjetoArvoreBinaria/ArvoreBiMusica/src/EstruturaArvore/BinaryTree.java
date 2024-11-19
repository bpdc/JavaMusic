package EstruturaArvore;
public class BinaryTree<A> {

	Node<A> root;

    BinaryTree() {
    // Cria uma árvore binária vazia
        root = null;
    }
    
    public boolean isEmpty(){
        // verifica se a árvore está vazia
        if (root==null)
            return true;
        else
            return false;
    }
    
    public void addRoot(Node<A> e) throws Exception{
        // adiciona o Nó e como raiz
        if (root != null)
            throw new Exception ("Árvore já tem raiz");
        root = e;        
    }
    
    public Node root(){
        //retorna a raiz da árvore
        return root;
    }
    
    public boolean isInternal(Node<A> e){
        // verifica se o nó e é interno ou não
        if (e.left!=null || e.right!=null)
            return true;
        else
            return false;
    }
    
    public boolean isLeaf(Node<A> e){
        // verifica se o nó e é folha ou não
        if (e.left==null && e.right==null)
            return true;
        else
            return false;
    }
    
    public void addLeft(Node<A> e, Node<A> m) throws Exception{
        // adiciona e como filho esquerdo de m
        // e = filho
        // m  = pai
        if (m.left!=null)
            throw new Exception ("Já existe filho esquerdo");
        m.left = e;
        e.parent = m;
    }
    
    public Node<A> left (Node<A> e){
        // retorna o filho à esquerda de e
        return e.left;
    }
    
    public boolean hasLeft(Node<A> e){
        // verifica se e tem ou naõ filho à esquerda
        if (e.left!=null)
            return true;
        else
            return false;
    }
    
    public void addRight(Node<A> e, Node<A> m) throws Exception{
        // adiciona e como filho direito de m
        // e = filho
        // m  = pai
        if (m.right!=null)
            throw new Exception ("Já existe filho direito");
        m.right = e;
        e.parent = m;
    }
    
    public Node<A> right (Node<A> e){
        // retorna o filho à direita de e
        return e.right;
    }
    
    public boolean hasRight(Node<A> e){
        // verifica se e tem ou não filho à direita
        if (e.right!=null)
            return true;
        else
            return false;
    }
    
    public void remove(Node<A> e){
        //remove o e com todos os descendentes
        if (e==root)
            root = null;
        else
            if (e.parent.left == e)
                e.parent.left = null;
            else
                if (e.parent.right == e)
                    e.parent.right = null;            
    }
     
    public void visitaPreOrdem(Node<A> e){
        // exibe todos os nós na forma RED
        if (e == null)
            return;
        e.exibeNo();
        visitaPreOrdem(e.left);
        visitaPreOrdem(e.right);
    }
    
    public void visitaPosOrdem(Node<A> e){
        // exibe todos os nós na forma EDR
        if (e == null)
            return;        
        visitaPosOrdem(e.left);
        visitaPosOrdem(e.right);
        e.exibeNo();
    }
    
    public void visitaInOrdem(Node<A> e){
        // exibe todos os nós na forma ERD
        if (e == null)
            return;        
        visitaInOrdem(e.left);
        e.exibeNo();
        visitaInOrdem(e.right);        
    }
    
    public int PreOrdemSoma(Node<Palavra> e, int soma){
        // exibe todos os nós na forma RED
        if (e == null)
            return 0;
        soma += PreOrdemSoma(e.left, soma);
        soma += PreOrdemSoma(e.right, soma);
        return soma + e.elemento.getOcorrencia();
    }
    
    public int PreOrdemSomaDiferente(Node<Palavra> e, int soma){
        // exibe todos os nós na forma RED
        if (e == null)
            return 0;
        soma += PreOrdemSoma(e.left, soma);
        soma += PreOrdemSoma(e.right, soma);
        return soma + 1;
    }
    
    


}
