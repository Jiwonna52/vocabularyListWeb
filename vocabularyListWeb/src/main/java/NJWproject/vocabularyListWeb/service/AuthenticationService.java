package NJWproject.vocabularyListWeb.service;

public class AuthenticationService {
    public boolean checkCode(String code) {
        if (code.equals("0000")) {
            return true;
        }
        return false;
    }
}
