package model;

import java.lang.reflect.Method;
import java.util.Collection;
import org.apache.struts2.dispatcher.Parameter;
/**@author Nakura-gui <Jisashi.Nakamura at Nakcom.org>
 * @param <T>
 */
public class Utileria<T> {

    public T getRegistro(Class clase, Collection<Parameter> p) throws Exception {
        T objeto = (T) Class.forName(clase.getName()).newInstance();
        Method[] metodos = objeto.getClass().getDeclaredMethods();
        for (Parameter parameter : p) {
            for (Method metodo : metodos) {
                if (metodo.getName().startsWith("set")) {
                    Class<?>[] parama = metodo.getParameterTypes();                    
                    String prop = metodo.getName().substring(3, 4).toLowerCase() + metodo.getName().substring(4, metodo.getName().length());
                    if (prop.equals(parameter.getName()) && !parama[0].getCanonicalName().startsWith("model")) {                        
                        if (parama[0].getCanonicalName().equals("java.lang.String")) {
                            metodo.invoke(objeto, parameter.getValue());
                        } else if (parama[0].getCanonicalName().equals("java.lang.Integer")) {
                            metodo.invoke(objeto, Integer.parseInt(parameter.getValue()));
                        } else if (parama[0].getCanonicalName().equals("java.lang.Date")) {
                            metodo.invoke(objeto, parameter.getValue());
                        }
                    }
                }
            }
        }
        return objeto;
    }
}