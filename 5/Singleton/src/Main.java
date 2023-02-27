public class Main {
    public static void main(String[] args) {
        Singleton var1 = Singleton.Inst("We have only one Sun");
        Singleton var2 = Singleton.Inst("And cannot have two Suns");

        System.out.println(var1.value);
        System.out.println(var2.value);

        System.out.printf("That is why var1 == var 2 is %b",var1.equals(var2));
    }
}