package no.geointegrasjon.arkiv.innsyn;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.5.5
 * 2024-12-18T13:51:13.647+01:00
 * Generated source version: 3.5.5
 *
 */
@WebServiceClient(name = "InnsynService",
                  wsdlLocation = "http://rep.geointegrasjon.no/Arkiv/Innsyn/xml.wsdl/2012.01.31/giArkivInnsyn20120131.wsdl",
                  targetNamespace = "http://rep.geointegrasjon.no/Arkiv/Innsyn/xml.wsdl/2012.01.31")
public class InnsynService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://rep.geointegrasjon.no/Arkiv/Innsyn/xml.wsdl/2012.01.31", "InnsynService");
    public final static QName ArkivInnsyn = new QName("http://rep.geointegrasjon.no/Arkiv/Innsyn/xml.wsdl/2012.01.31", "ArkivInnsyn");
    static {
        WSDL_LOCATION = InnsynService.class.getResource("wsdl/giArkivInnsyn20120131.wsdl");
    }

    public InnsynService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public InnsynService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public InnsynService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public InnsynService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public InnsynService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public InnsynService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ArkivInnsynPort
     */
    @WebEndpoint(name = "ArkivInnsyn")
    public ArkivInnsynPort getArkivInnsyn() {
        return super.getPort(ArkivInnsyn, ArkivInnsynPort.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ArkivInnsynPort
     */
    @WebEndpoint(name = "ArkivInnsyn")
    public ArkivInnsynPort getArkivInnsyn(WebServiceFeature... features) {
        return super.getPort(ArkivInnsyn, ArkivInnsynPort.class, features);
    }

}
