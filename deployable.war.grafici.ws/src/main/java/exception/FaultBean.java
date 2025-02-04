package exception;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * Created by
 * User: logan
 * Date: 20/07/12
 * Time: 14.38
 */


public class FaultBean implements Serializable {

    private static final long serialVersionUID = 1L;

    //doesnt work without this annotation!
    @XmlElement(name="msg")
    private String msg;

    /** required by jax-ws */
    public FaultBean(){
    }

    public FaultBean(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}