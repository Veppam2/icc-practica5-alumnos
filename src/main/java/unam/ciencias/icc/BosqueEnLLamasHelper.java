package unam.ciencias.icc;

public class BosqueEnLLamasHelper extends BosqueEnLLamas{

    protected double randomP;
    protected double randomF;
    
    public BosqueEnLLamasHelper(){
        super();
    }

    protected boolean satisfaceProbabilidadP(){
        //Returns the next pseudorandom, uniformly distributed double value between 0.0 and 1.0 from this random number generator's sequence.
        //return randomP < probaP;
        return randomP < probaP;
    }

    protected boolean satisfaceProbabilidadF(){
        //Returns the next pseudorandom, uniformly distributed double value between 0.0 and 1.0 from this random number generator's sequence.
        return randomF < probaF;
    }

    public void setRandomP( double p){
        this.randomP = p;
    }

    public void setRandomF( double f){
        this.randomF = f;
    }


}