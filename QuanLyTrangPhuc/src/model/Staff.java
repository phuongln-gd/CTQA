/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Staff extends Person{
    private String branch;
    private String pos;

    public Staff() {
    }

    public Staff(int id, String name, String address, String tel, Account account, String branch, String pos) {
        super(id, name, address, tel, account);
        this.branch = branch;
        this.pos = pos;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
    
}
