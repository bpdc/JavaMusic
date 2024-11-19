package EstruturaArvore;
public class ABB<A> {

    private Node root; // raiz da árvore   

    ABB() {
        // Cria uma árvore binária vazia  
        root = null;
    }

    public boolean isEmpty() {
        // Verifica se a árvore está vazia    
        return root == null;
    }

    public Node root() {
        // Devolve a raiz da árvore.   
        return root;
    }

    public boolean isLeaf(Node n) {
        // Verifica se um nó n é uma folha
        return n.left == null && n.right == null;
    }

    public void executaPreOrdem(Node no) {
        if (no == null) {
            return;
        }
        no.exibeNo();
        executaPreOrdem(no.left);
        executaPreOrdem(no.right);
    }

    public void executaInOrdem(Node no) {
        if (no == null) {
            return;
        }
        executaInOrdem(no.right);
        no.exibeNo();
        executaInOrdem(no.left);
    }

    public void executaPosOrdem(Node no) {
        if (no == null) {
            return;
        }
        executaPosOrdem(no.left);
        executaPosOrdem(no.right);
        no.exibeNo();
    }

    public void insere(Node<Palavra> z) {
    	Node<Palavra> y = null;
    	Node<Palavra> x = root();
        while (x != null) {
            y = x;
            if (z.elemento.getOcorrencia() < x.elemento.getOcorrencia()) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            root = z;
        } else if (z.elemento.getOcorrencia() < y.elemento.getOcorrencia()) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    public void delete(Node<Integer> Tree, int Tar) {
    	Node<Integer> Min, Temp;
        if (Tree == null) { // árvore vazia
            return;
        } else if (Tar < Tree.elemento) {
            delete(Tree.left, Tar); // buscar na esquerda
        } else if (Tar > Tree.elemento) {
            delete(Tree.right, Tar);// buscar na direita
        } else {
            // encontrou o nó a ser deletado
            if (Tree.left != null && Tree.right != null) {
                // nó com dois filhos 
                Min = minimo(Tree.right);
                Tree.elemento = Min.elemento;
                delete(Tree.right, Tree.elemento);
            } else {
                // nó com um ou nenhum filho
                if (Tree.left == null) {
                    if (Tree.parent == null) {
                        root = Tree.right; // A raiz deverá ser deletada
                    } else {
                        if (Tree.right != null) {
                            Tree.right.parent = Tree.parent;
                        }
                        if (Tree == Tree.parent.left) {
                            Tree.parent.left = Tree.right;
                        } else {
                            Tree.parent.right = Tree.right;
                        }
                    }

                } else if (Tree.right == null) {
                    if (Tree.parent == null) {
                        root = Tree.left; // A raiz deverá ser deletada
                    } else {

                        Tree.left.parent = Tree.parent;
                        if (Tree == Tree.parent.left) {
                            Tree.parent.left = Tree.left;
                        } else {
                            Tree.parent.right = Tree.left;
                        }
                    }
                }
            }
        }
    }

    public Node<Integer> busca(Node<Integer> k) {
    	Node<Integer> y = root();
        while (y != null) {
            if (y.elemento == k.elemento) {
                return y;
            } else if (y.elemento < k.elemento) {
                y = y.right;
            } else {
                y = y.left;
            }
        }
        return null;
    }

    public Node maximo(Node x) {
        //Node<E> x = root();
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    public Node<Integer> minimo(Node<Integer> n) {
    	Node<Integer> x = n;
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }
    
    public void setRoot(Node<Palavra> root) {
    	this.root = root;
    }

}
