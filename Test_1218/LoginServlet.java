package Test_1218;

public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

//    public static void doPost(String username, String password) {
//        try {
//            usernameRef = username;
//            if (username.equals("a")) {
//                Thread.sleep(5000);
//            }
//
//            passwordRef = password;
//            System.out.println("username = " + usernameRef + " password = " + passwordRef);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    synchronized public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }

            passwordRef = password;
            System.out.println("username = " + usernameRef + " password = " + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
