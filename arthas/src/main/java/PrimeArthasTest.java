import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gradyzhou
 * @version 1.0, on 14:01 2020/1/30.
 */
public class PrimeArthasTest {

    public static void main(String[] args) {
        BigInteger number = BigInteger.valueOf(2L);
        BigInteger one = BigInteger.valueOf(1);
        List<BigInteger> primes  = new ArrayList<>();

        while (true){
            if (number.isProbablePrime(100)){
                System.out.println(number);
            }
            number = number.add(one);
        }
    }
}
