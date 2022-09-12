
/*
 * Created on 12/09/2022 by Paul Harrison (paul.harrison@manchester.ac.uk).
 */

import org.ivoa.dm.stc.coords.CoordsModel;

import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.util.Arrays;

public class Genschema {
   public static void main(String[] args) {


      try {
         CoordsModel.contextFactory().generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException {
               String name = Arrays.stream(namespaceURI.split("/+")).filter(s -> s.length() > 0).map(s -> s+".xsd").reduce((first, second) -> second).orElse(suggestedFileName);
               return new StreamResult(name);
            }
         });
      } catch (IOException | JAXBException e) {
         throw new RuntimeException(e);
      }
   }
}
