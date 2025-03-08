class Bar{
    static int barNum = 28;
    static String val = "dad";
}

 class Foo {
    static int barNum = 20;
    static String val = "son";

    Bar myBar = new Bar();

    void changeIt(Bar myBar) {
        myBar = new Bar();
        myBar.barNum = 99;
        System.out.println("myBar.barNum in changeIt is " + myBar.barNum);
        myBar = new Bar();
        myBar.barNum = 420;
        System.out.println("myBar.barNum in changeIt is now " + myBar.barNum);
    }


}

class Main{
    public static void main(String[] args) {
        System.out.println(Foo.val);

        int _myname = 10;
        Foo f = new Foo();

    }
}