
package com.zhengtong.service.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.zhengtong.service.ws package. 
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

    private final static QName _OrgCertBizQueryResponse_QNAME = new QName("http://ws.service.zhengtong.com/", "orgCertBizQueryResponse");
    private final static QName _OrgCertBizQuery_QNAME = new QName("http://ws.service.zhengtong.com/", "orgCertBizQuery");
    private final static QName _IdCert_QNAME = new QName("http://ws.service.zhengtong.com/", "idCert");
    private final static QName _IdCertResponse_QNAME = new QName("http://ws.service.zhengtong.com/", "idCertResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zhengtong.service.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OcBizQResp }
     * 
     */
    public OcBizQResp createOcBizQResp() {
        return new OcBizQResp();
    }

    /**
     * Create an instance of {@link OrgCertBizQuery }
     * 
     */
    public OrgCertBizQuery createOrgCertBizQuery() {
        return new OrgCertBizQuery();
    }

    /**
     * Create an instance of {@link Ic }
     * 
     */
    public Ic createIc() {
        return new Ic();
    }

    /**
     * Create an instance of {@link OcBizQ }
     * 
     */
    public OcBizQ createOcBizQ() {
        return new OcBizQ();
    }

    /**
     * Create an instance of {@link IcResp }
     * 
     */
    public IcResp createIcResp() {
        return new IcResp();
    }

    /**
     * Create an instance of {@link IdCertResponse }
     * 
     */
    public IdCertResponse createIdCertResponse() {
        return new IdCertResponse();
    }

    /**
     * Create an instance of {@link IdCert }
     * 
     */
    public IdCert createIdCert() {
        return new IdCert();
    }

    /**
     * Create an instance of {@link OrgCertBizQueryResponse }
     * 
     */
    public OrgCertBizQueryResponse createOrgCertBizQueryResponse() {
        return new OrgCertBizQueryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrgCertBizQueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.zhengtong.com/", name = "orgCertBizQueryResponse")
    public JAXBElement<OrgCertBizQueryResponse> createOrgCertBizQueryResponse(OrgCertBizQueryResponse value) {
        return new JAXBElement<OrgCertBizQueryResponse>(_OrgCertBizQueryResponse_QNAME, OrgCertBizQueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrgCertBizQuery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.zhengtong.com/", name = "orgCertBizQuery")
    public JAXBElement<OrgCertBizQuery> createOrgCertBizQuery(OrgCertBizQuery value) {
        return new JAXBElement<OrgCertBizQuery>(_OrgCertBizQuery_QNAME, OrgCertBizQuery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdCert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.zhengtong.com/", name = "idCert")
    public JAXBElement<IdCert> createIdCert(IdCert value) {
        return new JAXBElement<IdCert>(_IdCert_QNAME, IdCert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdCertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.zhengtong.com/", name = "idCertResponse")
    public JAXBElement<IdCertResponse> createIdCertResponse(IdCertResponse value) {
        return new JAXBElement<IdCertResponse>(_IdCertResponse_QNAME, IdCertResponse.class, null, value);
    }

}
