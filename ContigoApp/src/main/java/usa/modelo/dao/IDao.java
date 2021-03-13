package usa.modelo.dao;

/**
 *
 * @author Santiago Pérez
 */
interface IDao<T> {
    boolean crear(T t);
    T consultar(String id);
    
}
