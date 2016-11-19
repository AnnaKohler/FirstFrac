/**
 * Created by schooler on 19.11.16.
 */
public class Frac {
        int a=0;
        int b=1;
        public String toString(){
            return (a+"/"+b);
        }
        Frac(){
            this.a=0;
            this.b=1;

        }
        Frac(int a, int b){
            if(b!=0) {
                this.a = a;
                this.b = b;
            }
            else{
                this.a=1;
                this.b=1;
            }
        }
        Frac(int a){
            this.a=a;
            this.b=1;
        }
        Frac sum(Frac d){
            Frac c=new Frac(a*d.b+d.a*b, this.b*d.b);
            if(c.isReduced()) {
                return c.reduce();
            }
            return c;
        }
        Frac mult(int a){
            Frac c=new Frac(a*this.a, this.b);
            if(c.isReduced()) {
                return c.reduce();
            }
            return c;
        }
        Frac mult(Frac d){
            Frac c=new Frac(d.a*this.a, d.b*this.b);
            if(c.isReduced()) {
                return c.reduce();
            }
            return c;
        }
        Frac div(int a){
            Frac c=new Frac(this.a, this.b*a);
            if(c.isReduced()) {
                return c.reduce();
            }
            return c;
        }
        Frac div(Frac d){
            Frac c=new Frac(this.a*d.b, this.b*d.a);
            if(c.isReduced()) {
                return c.reduce();
            }
            return c;
        }
    /*boolean isNull(){
        return(this.b==0);
    }*/

        boolean isReduced(){
            if(this.a<this.b)
                for(int i=2; i<=this.a; i++){
                    if(this.a%i==0 && this.b%i==0){
                        return true;
                    }
                }
            else{
                for(int i=2; i<=this.b; i++){
                    if(this.b%i==0 && this.b%i==0){
                        return true;
                    }
                }
            }
            return false;
        }
        Frac reduce(){
            if(!this.isReduced()){
                System.out.println("Ты хочешь сократить несократимое");
                return this;
            }
            if(this.a>this.b) {
                for (int i = 2; i <= this.b; i++) {
                    if (this.a % i == 0 && this.b % i == 0) {
                        this.a=this.a/i;
                        this.b=this.b/i;
                    }
                }
            }
            else{
                for (int i = 2; i <= this.a; i++) {
                    if (this.a % i == 0 && this.b % i == 0) {
                        this.a=this.a/i;
                        this.b=this.b/i;
                    }
                }
            }
            return this;
        }
        boolean equals(Frac d){
            return (this.a==d.a && this.b==d.b);
        }

}
