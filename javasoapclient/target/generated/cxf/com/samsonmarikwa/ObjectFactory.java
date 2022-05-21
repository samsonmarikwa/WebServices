
package com.samsonmarikwa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.samsonmarikwa package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateOrdersRequest_QNAME = new QName("http://www.samsonmarikwa.com", "createOrdersRequest");
    private final static QName _CreateOrdersResponse_QNAME = new QName("http://www.samsonmarikwa.com", "createOrdersResponse");
    private final static QName _DeleteOrdersRequest_QNAME = new QName("http://www.samsonmarikwa.com", "deleteOrdersRequest");
    private final static QName _DeleteOrdersResponse_QNAME = new QName("http://www.samsonmarikwa.com", "deleteOrdersResponse");
    private final static QName _GetOrdersRequest_QNAME = new QName("http://www.samsonmarikwa.com", "getOrdersRequest");
    private final static QName _GetOrdersResponse_QNAME = new QName("http://www.samsonmarikwa.com", "getOrdersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.samsonmarikwa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateOrdersRequest }
     * 
     */
    public CreateOrdersRequest createCreateOrdersRequest() {
        return new CreateOrdersRequest();
    }

    /**
     * Create an instance of {@link CreateOrdersResponse }
     * 
     */
    public CreateOrdersResponse createCreateOrdersResponse() {
        return new CreateOrdersResponse();
    }

    /**
     * Create an instance of {@link DeleteOrdersRequest }
     * 
     */
    public DeleteOrdersRequest createDeleteOrdersRequest() {
        return new DeleteOrdersRequest();
    }

    /**
     * Create an instance of {@link DeleteOrdersResponse }
     * 
     */
    public DeleteOrdersResponse createDeleteOrdersResponse() {
        return new DeleteOrdersResponse();
    }

    /**
     * Create an instance of {@link GetOrdersRequest }
     * 
     */
    public GetOrdersRequest createGetOrdersRequest() {
        return new GetOrdersRequest();
    }

    /**
     * Create an instance of {@link GetOrdersResponse }
     * 
     */
    public GetOrdersResponse createGetOrdersResponse() {
        return new GetOrdersResponse();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrdersRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateOrdersRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.samsonmarikwa.com", name = "createOrdersRequest")
    public JAXBElement<CreateOrdersRequest> createCreateOrdersRequest(CreateOrdersRequest value) {
        return new JAXBElement<CreateOrdersRequest>(_CreateOrdersRequest_QNAME, CreateOrdersRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrdersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateOrdersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.samsonmarikwa.com", name = "createOrdersResponse")
    public JAXBElement<CreateOrdersResponse> createCreateOrdersResponse(CreateOrdersResponse value) {
        return new JAXBElement<CreateOrdersResponse>(_CreateOrdersResponse_QNAME, CreateOrdersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOrdersRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteOrdersRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.samsonmarikwa.com", name = "deleteOrdersRequest")
    public JAXBElement<DeleteOrdersRequest> createDeleteOrdersRequest(DeleteOrdersRequest value) {
        return new JAXBElement<DeleteOrdersRequest>(_DeleteOrdersRequest_QNAME, DeleteOrdersRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOrdersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteOrdersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.samsonmarikwa.com", name = "deleteOrdersResponse")
    public JAXBElement<DeleteOrdersResponse> createDeleteOrdersResponse(DeleteOrdersResponse value) {
        return new JAXBElement<DeleteOrdersResponse>(_DeleteOrdersResponse_QNAME, DeleteOrdersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrdersRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetOrdersRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.samsonmarikwa.com", name = "getOrdersRequest")
    public JAXBElement<GetOrdersRequest> createGetOrdersRequest(GetOrdersRequest value) {
        return new JAXBElement<GetOrdersRequest>(_GetOrdersRequest_QNAME, GetOrdersRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrdersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetOrdersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.samsonmarikwa.com", name = "getOrdersResponse")
    public JAXBElement<GetOrdersResponse> createGetOrdersResponse(GetOrdersResponse value) {
        return new JAXBElement<GetOrdersResponse>(_GetOrdersResponse_QNAME, GetOrdersResponse.class, null, value);
    }

}
