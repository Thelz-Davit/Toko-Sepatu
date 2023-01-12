/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import java.util.List;

/**
 *
 * @author DARARI
 */
public interface CrudRepository<T, ID> {
    List<T> findAll();
    ID create(T object);
    ID update(T object);
    T findById(String id);
    ID delete(String id);
    ID countTransaksi();
    ID updateQty(int qty, String id);
    ID findQty(String id);
}