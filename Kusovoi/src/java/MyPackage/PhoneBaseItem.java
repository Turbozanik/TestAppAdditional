/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

/**
 *
 * @author Лапа
 */
public class PhoneBaseItem{
    int id;
    String phoneNumber;
    String description;
    String mobNumber;

    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    public PhoneBaseItem() {
        
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
       return ("  <div>"
                + "<table id=\"table2\">"                
                + "<tr>"               
                + "<td id=\"th1\">" + this.getId() + "</td>"
                + "<td id=\"th1\">" + this.getPhoneNumber()+ "</td>"
                + "<td id=\"th1\">" + this.getDescription()+ "</td>"
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

    public void setDescription(String companyDescription) {
        this.description = companyDescription;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone) {
        this.phoneNumber = phone;
    }
            
}
