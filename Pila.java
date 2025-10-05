import java.util.Stack;

public class Pila {
    private Stack<Character> pila;
    public Pila(){
        pila=new Stack<Character>();
    }

    public boolean esVacia(){
        return pila.isEmpty();
    }

    public void push(Character c){
        pila.push(c);
    }

    public Character pop() throws Exception {
        if(esVacia())
            throw new Exception("No balanceada");
        return pila.pop();
    }

    public boolean balanceada(String cadena) throws Exception{
        Pila p1=new Pila();
        int contParentesis = 0;
        int contLlaves = 0;
        int contCorchetes = 0;
        for(int i=0; i<cadena.length();i++){
            char c = cadena.charAt(i);
            if (c == '(') {
                p1.push(c);
                contParentesis++;
            } else if (c == '{') {
                p1.push(c);
                contLlaves++;
            } else if (c == '[') {
                p1.push(c);
                contCorchetes++;
            } else if (c == ')') {
                if (p1.pop() != '(')
                    return false;
            } else if (c == '}') {
                if (p1.pop() != '{')
                    return false;
            } else if (c == ']') {
                if (p1.pop() != '[')
                    return false;
            }
        }
        if (p1.esVacia()) {
            return true;
        }
        return false;
    }
}

