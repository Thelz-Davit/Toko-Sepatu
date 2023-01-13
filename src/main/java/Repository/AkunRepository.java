/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

/**
 *
 * @author DARARI
 */
public interface AkunRepository<T, ID> {
    T login(String username, String password);
    ID checkLevel(String id);
}
