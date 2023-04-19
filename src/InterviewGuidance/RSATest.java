package InterviewGuidance;

import java.math.BigInteger;

public class RSATest {
    public static void main(String[] args) {
        int p = 11, q = 17;
        int n = 187;
        int t = 160;
        int E = 13;
        int D = 37;
        //公钥（13,187）
        //私钥（37,187）

        //C A O
        //3 1 15
        //公钥加密
        System.out.println(3^13%187);
        System.out.println(1^13%187);
        System.out.println(15^13%187);
        //148 1 53

        //私钥解密
        System.out.println(148^37%187);
        System.out.println(1^37%187);
        System.out.println(53^37%187);
        //
        BigInteger a = new BigInteger("148");
        BigInteger c = a.pow(37).mod(new BigInteger("187"));
        System.out.println(c.toString());

         a = new BigInteger("1");
         c = a.pow(13).mod(new BigInteger("187"));
        System.out.println(c.toString());

         a = new BigInteger("53");
         c = a.pow(37).mod(new BigInteger("187"));
        System.out.println(c.toString());

    }
}
