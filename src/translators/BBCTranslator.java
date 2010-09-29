package translators;

import de.fuberlin.wiwiss.d2rq.values.Translator;
import java.lang.String;

/**
BBC URI translator
 */
public class BBCTranslator implements Translator {

	public BBCTranslator(){
		
	}

	public String toDBValue(String rdfValue) {
	    return rdfValue.replaceFirst("#artist",
					 "");
	}	

	public String toRDFValue(String dbValue) {
	    return dbValue + "#artist";
	}
}

