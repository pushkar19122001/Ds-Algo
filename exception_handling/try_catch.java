public class try_catch {
    public static void main(String[] args) {
        int [] arr=new int[5];
        try {
            System.out.println(arr[8]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(arr[4]);
        }
        System.out.println("hello");
    }
}
