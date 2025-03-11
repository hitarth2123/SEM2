class Gen<T> {
    T ob;
    
    Gen(T o) {
        ob = o;
    }
    
    T getob() {
        return ob;
    }
    
    void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}

public class GenEx {
    public static void main(String[] args) {
        Gen<Integer> iOb;
        iOb = new Gen<Integer>(88);
        iOb.showType();
        int v = iOb.getob();
        System.out.println("Value: " + v);
        
        Gen<String> strOb = new Gen<String>("Generics Test");
        strOb.showType();
        String str = strOb.getob();
        System.out.println("Value: " + str);


        Gen<Double>dob =new Gen<Double>(15.5);
        dob.showType();
        Double a = dob.getob();
        System.out.println("Value :" + a);

    }
    
}