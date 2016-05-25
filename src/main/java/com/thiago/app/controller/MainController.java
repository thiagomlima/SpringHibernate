package com.thiago.app.controller;

import com.thiago.model.entity.GeoIp;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Thiago Lima on 2016-05-10.
 */
@Controller
public class MainController {

    private final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String home(Model model) throws JAXBException {
        logger.info("index");
        return "indexPage";
    }

    private void geoIp() throws JAXBException {
        final String url = "http://www.webservicex.net/geoipservice.asmx/GetGeoIP?IPAddress=69.70.164.250";
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);

        JAXBContext context = JAXBContext.newInstance(GeoIp.class); //1
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ByteArrayInputStream input = new ByteArrayInputStream(result.getBytes());
        JAXBElement<GeoIp> root = unmarshaller.unmarshal(new StreamSource(input), GeoIp.class);
        GeoIp geoIp = root.getValue();

        System.out.println(geoIp.getCountryCode());

//        StringReader reader = new StringReader(result);
//        GeoIp geoIp = (GeoIp) unmarshaller.unmarshal(reader);
//
//        System.out.println(geoIp.getCountryName());
    }

    private void geoIp2() {
        final String url = "http://www.webservicex.net/geoipservice.asmx/GetGeoIP?IPAddress=69.70.164.250";
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);

        SAXBuilder builder = new SAXBuilder();
//        File xmlFile = new File("c:\\file.xml");
        StringReader reader = new StringReader(result);

        try {

            Document document = (Document) builder.build(reader);
            Element rootNode = document.getRootElement();

            try {
                System.out.println(rootNode.getChild("ReturnCode", Namespace.getNamespace("http://www.webservicex.net/")).getValue());
                System.out.println(rootNode.getChild("ReturnCode", Namespace.getNamespace("http://www.webservicex.net/")).getText());
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
    }
}

