class TypeCastingEx {
    public  static void main(String[]args){
        double d =100.23;
        long l=(long)d;
        int i=(int)l;
        System.out.println("Long value "+l);
        System.out.println("Int value"+i);

        
        byte b=50;
        //b=b * 2; //error :possible lossy conversion from int to byte
        b=(byte)(b*2);

    }
}
