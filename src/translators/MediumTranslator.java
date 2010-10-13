package translators;

import java.net.URLDecoder;
import java.net.URLEncoder;
import de.fuberlin.wiwiss.d2rq.values.Translator;

public class MediumTranslator implements Translator {
	public static final String uri_base = "http://purl.org/ontology/mfo/"; 
	
	public MediumTranslator(){
		
	}
	
	public String toDBValue(String rdfValue) {
		return URLDecoder.decode(rdfValue.replaceAll(uri_base, "").replaceAll("_", " "));
	}	

	public String toRDFValue(String dbValue) {
		String uri_tail = URLEncoder.encode(dbValue.replaceAll(" ", "_"));
	    return uri_base + uri_tail;
	}
}
