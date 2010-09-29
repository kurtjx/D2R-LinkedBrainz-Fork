package translators;

import de.fuberlin.wiwiss.d2rq.values.Translator;
import java.lang.String;

/**
TODO FIXME: different languages in wikipedia break this
(e.g. http://fr.wikipedia.org/wiki/The_Arcade_Fire)

SELECT DISTINCT * WHERE {
<http://musicbrainz.org/artist/52074ba6-e495-4ef3-9bb4-0703888a9f68#_>
owl:sameAs ?o .  } LIMIT 10 

or a translation table with a custom Java class that returns null for
unwanted database values.
 */
public class WikipediaTranslator implements Translator {

	public WikipediaTranslator(){
		
	}

	public String toDBValue(String rdfValue) {
		return rdfValue.replaceFirst("http://dbpedia.org/resource/",
					     "http://en.wikipedia.org/wiki/");
	}	

	public String toRDFValue(String dbValue) {
	    if(!dbValue.contains("en.wikipedia")){
		return null; // FIXME horrible hack only deals w/ English pages
		    }
	    return dbValue.replaceFirst("http://en.wikipedia.org/wiki/",
					"http://dbpedia.org/resource/");
	}
}

