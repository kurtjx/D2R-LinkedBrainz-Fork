package translators;

import de.fuberlin.wiwiss.d2rq.values.Translator;
import java.lang.Integer;
import java.lang.Float;
import java.lang.String;

/**
change a duration in ms into a xsd:duration
    my $ms = shift;
    $ms or return undef;
    $ms >= 1000 or return "$ms ms";
    my $length_in_secs = int($ms / 1000.0 + 0.5);
    sprintf "PT%dM%dS", 
        int($length_in_secs / 60),
        ($length_in_secs % 60),
    ;

 */
public class DurationTranslator implements Translator {

	public DurationTranslator(){
		
	}

	public String toDBValue(String rdfValue) {
	    //TODO parse xsd:duration FIXME
	    return null;
	}	

	public String toRDFValue(String dbValue) {
	    int ms = Integer.parseInt(dbValue);
	    float secs = (float) (ms / 1000.0f);
	    int min = (int) (secs / 60.0f);
	    return "PT"+Integer.toString(min)+"M"+Float.toString((float) (secs % 60.0))+"S";
	}
}
