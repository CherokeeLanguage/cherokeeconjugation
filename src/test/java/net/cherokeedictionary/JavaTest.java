package net.cherokeedictionary;

public class JavaTest {
    public static void main(String[] args) {
        boolean parta = false;
        boolean partb = true;
        boolean partc = false;
        munge: {
            if (parta) {
                System.out.println("printa");
                break munge;
            }

            if (partb) {
                System.out.println("printb");
                break munge;
            }

            if (partc) {
                System.out.println("printc");
                break munge;
            }
        }

        System.out.println("this is outside munge");
    }

}
