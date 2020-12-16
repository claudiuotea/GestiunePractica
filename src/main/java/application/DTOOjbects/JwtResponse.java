package application.DTOOjbects;


//used to send data back to the client after login
public class JwtResponse {
    private String jwt;
    private String username;
    private String role;


    public JwtResponse(String jwt, String username, String role) {

        this.jwt = jwt;
        this.username = username;
        this.role = role;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
