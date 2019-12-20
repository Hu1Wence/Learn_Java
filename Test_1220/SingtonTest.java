package Test_1220;

public class SingtonTest {
    
    private static SingtonTest SINGTON_SAFE = null;
    public SingtonTest() {

    }
    public static SingtonTest getInstance() {
        if (SINGTON_SAFE == null) {
            synchronized (SingtonTest.class) {
                if (SINGTON_SAFE == null) {
                    SINGTON_SAFE = new SingtonTest();
                }
            }
        }
        return SINGTON_SAFE;
    }
}
