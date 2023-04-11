/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package other;

import model.Clothes;

/**
 *
 * @author ADMIN
 */
public interface ClothesState {
    public void entry(Clothes t);
    public void execute(Clothes t);
    public void exit(Clothes t);
}
