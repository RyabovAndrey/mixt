package matchparserrun;

import matchParser.MatchParser;
import matchParser.MatchParserPlusMinus;

public class MatchParserRun {

    public static void main(String[] args) {
        String[] formulas = new String[] { "2+2*2", "2+X*2", "sin(90)+4-cos(0)", "2--4", "2**3*5-----7", "3.5.6-2" };
        MatchParser p = new MatchParser();
        p.setVariable("X", 2.0 );
        for( int i = 0; i < formulas.length; i++){
            try{
                System.out.println( formulas[i] + "=" + p.Parse( formulas[i] ) );
            }catch(Exception e){
                System.err.println( "Error while parsing '"+formulas[i]+"' with message: " + e.getMessage() );
            } 
        }
        MatchParserPlusMinus pm = new MatchParserPlusMinus();
        String f = "10-8+2+6";
        try{
            System.out.println( "PlusMinus: " + pm.Parse(f) );
        }catch(Exception e){
            System.err.println( "Error while parsing '"+f+"' with message: " + e.getMessage() );
        } 
    }

}
