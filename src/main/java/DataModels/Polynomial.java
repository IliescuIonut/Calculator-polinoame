package DataModels;

import java.util.Objects;
import java.util.TreeMap;

public class Polynomial {
    public TreeMap<Integer, Integer> polinom;


    public Polynomial(TreeMap<Integer, Integer> polionm) {
        this.polinom = polionm;
    }

    public void addMonome(int power, Integer index){

        if(polinom.containsKey(power))
        {
            if(index+polinom.get(power)==0)
                polinom.remove(power);
            else
            polinom.replace(power, index+polinom.get(power));
        }
        else
        polinom.put(power, index);
    }

    @Override
    public String toString() {
        String result="";
        if(polinom.isEmpty())
            result=result+'0';
        else
        for (Integer entry : polinom.keySet()) {
            if (polinom.get(entry) < 0) {
                if (entry == 0)
                    result = result + polinom.get(entry);
                 else if (entry == 1)
                    result=result+(polinom.get(entry)==-1?"-x":(polinom.get(entry)+"x"));
                else result = result + (polinom.get(entry) == -1 ? ("-x^"+entry) : (polinom.get(entry) + "x^"+entry));
            }
            else{
                if (entry == 0)
                    result = result + "+" + polinom.get(entry);
                else {
                    if (entry == 1)
                        result=result+(polinom.get(entry)==1?"+x":("+"+polinom.get(entry)+"x"));
                     else
                        result = result + (polinom.get(entry) == 1 ? ("+x^"+entry) : ("+"+polinom.get(entry) + "x^"+entry));
                }
            }
        }
        if(result.charAt(0)=='+')
            result=result.substring(1);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Polynomial other = (Polynomial) obj;
        return Objects.equals(polinom, other.polinom);
    }
    @Override
    public int hashCode() {
        return Objects.hash(polinom);
    }

}