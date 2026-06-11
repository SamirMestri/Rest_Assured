package files;

public class DispatchBody {

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getEncSecretKey() {
        return encSecretKey;
    }

    public void setEncSecretKey(String encSecretKey) {
        this.encSecretKey = encSecretKey;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getEncPassword() {
        return encPassword;
    }

    public void setEncPassword(String encPassword) {
        this.encPassword = encPassword;
    }

    String portal;
    String loginId;
    String encPassword;
    String encSecretKey;
}
