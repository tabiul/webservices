package org.webservice.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by tabiul on 30 Jun 2016.
 */
@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class ServiceImpl implements Service {
    @Override
    @WebMethod
    public String sayHello(@WebParam(name="username") String name) {
        return "hello " + name;
    }
}
