package MyPackage;

public class User {
    private int id;
    private String userName;
    private String password1;
   
 @Override
    public String toString() {
       return ("  <div>"
                + "<table id=\"table1\">"                
                + "<tr>"               
                + "<td id=\"th1\">" + this.getId() + "</td>"
                + "<td id=\"th1\">" + this.getUserName()+ "</td>"
                + "<td id=\"th1\">" + this.getPassword1()+ "</td>"
                + "</tr>"
                + "</table>"
                + "</div>");
    }
    
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPassword1() {
        return password1;
    }
 
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
 
//    public String getEmail() {
//        return email;
//    }
// 
//    public void setEmail(String email) {
//        this.email = email;
//    }
// 
//    public String getPhone() {
//        return phone;
//    }
// 
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
// 
//    public String getCity() {
//        return city;
//    }
// 
//    public void setCity(String city) {
//        this.city = city;
//    }
// 
}
