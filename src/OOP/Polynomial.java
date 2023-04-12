package OOP;

public class Polynomial {


    /* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
     *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
     *  is already present in the polynomial then previous coefficient is replaced by
     *  new coefficient value passed as function argument
     */
    private int coefficient[];
    private int nextDegree;

    //Constructor
    public Polynomial(){
        coefficient = new int[5];
        nextDegree = 0;
        for(int i = 0; i < 5 ; i++){
            coefficient[i] = 0;
        }
    }

    public void setCoefficient(int degree, int coeff){
        while(degree >= coefficient.length){
            doubleSize();
        }

        coefficient[degree] = coeff;
        if(nextDegree < degree){
            nextDegree = degree;
        }

    }

    //function that doubles size of array coefficient[]
    private void doubleSize(){
        int[] temp = coefficient;
        coefficient = new int[2*temp.length];
        for(int i = 0; i<temp.length ;i++){
            coefficient[i] = temp[i];
        }
        for(int i = temp.length; i < coefficient.length ; i++){
            coefficient[i] = 0;
        }
    }

    // Prints all the terms(only terms with non-zero coefficients are to be printed) in increasing order of degree.
    public void print(){
        for(int i = 0; i < nextDegree ; i++){
            if(coefficient[i] == 0)
                continue;
            System.out.print(coefficient[i]+"x"+i+" ");
        }
    }


    // Adds two polynomials and returns a new polynomial which has result
    public Polynomial add(Polynomial p){
        Polynomial ans = new Polynomial();
        for(int i=0 ; i < Math.max(this.coefficient.length, p.coefficient.length) ; i++){
            if(i > this.coefficient.length){
                this.setCoefficient(i,0);
            }
            if(i > p.coefficient.length){
                p.setCoefficient(i,0);
            }
            int val = this.coefficient[i]+p.coefficient[i];
            ans.setCoefficient(i,val);
        }
        return ans;

    }

    // Subtracts two polynomials and returns a new polynomial which has result
    public Polynomial subtract(Polynomial p){
        Polynomial ans = new Polynomial();
        for(int i=0 ; i < Math.max(this.coefficient.length, p.coefficient.length) ; i++){
            if(i > this.coefficient.length){
                this.setCoefficient(i,0);
            }
            if(i > p.coefficient.length){
                p.setCoefficient(i,0);
            }
            int val = this.coefficient[i]-p.coefficient[i];
            ans.setCoefficient(i,val);
        }
        return ans;

    }

    // Multiply two polynomials and returns a new polynomial which has result
    public Polynomial multiply(Polynomial p){
        Polynomial ans = new Polynomial();
        ans.setCoefficient(this.nextDegree+p.nextDegree-1,0);
        for(int i=0 ; i < this.nextDegree  ; i++){

            for(int j = 0 ; j < p.nextDegree ; j++){
                ans.coefficient[i+j] += this.coefficient[i]*p.coefficient[j];
            }

        }
        return ans;
    }

}

