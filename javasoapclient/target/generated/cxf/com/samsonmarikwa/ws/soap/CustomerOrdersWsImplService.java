package com.samsonmarikwa.ws.soap;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import com.samsonmarikwa.CustomerOrdersPortType;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.5.0
 * 2022-05-17T22:05:53.149-04:00
 * Generated source version: 3.5.0
 *
 */
@WebServiceClient(name = "CustomerOrdersWsImplService",
                  wsdlLocation = "classpath:wsdl/CustomerOrders.wsdl",
                  targetNamespace = "http://soap.ws.samsonmarikwa.com/")
public class CustomerOrdersWsImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soap.ws.samsonmarikwa.com/", "CustomerOrdersWsImplService");
    public final static QName CustomerOrdersWsImplPort = new QName("http://soap.ws.samsonmarikwa.com/", "CustomerOrdersWsImplPort");
    static {
        URL url = CustomerOrdersWsImplService.class.getClassLoader().getResource("wsdl/CustomerOrders.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(CustomerOrdersWsImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/CustomerOrders.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerOrdersWsImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerOrdersWsImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerOrdersWsImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public CustomerOrdersWsImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CustomerOrdersWsImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CustomerOrdersWsImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns CustomerOrdersPortType
     */
    @WebEndpoint(name = "CustomerOrdersWsImplPort")
    public CustomerOrdersPortType getCustomerOrdersWsImplPort() {
        return super.getPort(CustomerOrdersWsImplPort, CustomerOrdersPortType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerOrdersPortType
     */
    @WebEndpoint(name = "CustomerOrdersWsImplPort")
    public CustomerOrdersPortType getCustomerOrdersWsImplPort(WebServiceFeature... features) {
        return super.getPort(CustomerOrdersWsImplPort, CustomerOrdersPortType.class, features);
    }

}
