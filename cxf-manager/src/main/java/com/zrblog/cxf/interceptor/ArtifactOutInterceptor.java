package com.zrblog.cxf.interceptor;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/13 23:03
 */
public class ArtifactOutInterceptor extends AbstractPhaseInterceptor<Message> {

    private static final Logger log = Logger.getLogger(ArtifactOutInterceptor.class);

    public ArtifactOutInterceptor(){
        super(Phase.PRE_STREAM);
    }

    public void handleMessage(Message message) {

        try {

            OutputStream os = message.getContent(OutputStream.class);

            CachedStream cs = new CachedStream();

            message.setContent(OutputStream.class, cs);

            message.getInterceptorChain().doIntercept(message);

            CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);
            InputStream in = csnew.getInputStream();

            String xml = IOUtils.toString(in);
            System.out.println("replaceBegin"+xml);

            xml=xml.replace("return", "receiveReturn")
                    .replace("xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"",
                            "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"")
                    .replace("xmlns:ns2=\"http://service.webservice.jeesite.thinkgem.com/\"","xmlns:ns2=\"http://service.webservice.jeesite.thinkgem.com/\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"")
                    //.replace("xmlns:ns2=\"http://localhost:8080/mycrm/webservice/customerService\"","xmlns:ns1=\"http://tzql.webservice.com/\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"")
                    .replace("<return>", "<receiveReturn>")
                    .replace("</return>", "</receiveReturn>")
                    .replace("soap:", "soapenv:")
                    .replace("<receiveReturn>", "<receiveReturn xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"soapenc:string\">")
                    //.replace("soapenvenv", "soapenv")

                    .replace("ns2", "ns1");

            System.out.println("replaceAfter"+xml);
            //这里对xml做处理，处理完后同理，写回流中
            IOUtils.copy(new ByteArrayInputStream(xml.getBytes("UTF-8")), os);

            cs.close();
            os.flush();

            message.setContent(OutputStream.class, os);

        } catch (Exception e) {
            log.error("Error when split original inputStream. CausedBy : " + "\n" + e);
        }
    }

    private class CachedStream extends CachedOutputStream {

        public CachedStream() {

            super();

        }

        protected void doFlush() throws IOException {

            currentStream.flush();

        }

        protected void doClose() throws IOException {

        }

        protected void onWrite() throws IOException {

        }

    }
}
