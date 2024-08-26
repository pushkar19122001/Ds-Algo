
public class throwEx {
    public static void main(String[] args) throws Exception {
        age(0);
    }

    public static void age(int n) throws Exception {
        if(n<1)
        {
            // try {
            //     throw new Exception();
            // } catch (Exception e) {
            //     System.out.println("caught exception");
            // }
            throw new Exception("caught exceptn");
            
        }
    }
}
