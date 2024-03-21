package BusinessLogic;

import DataModels.Polynomial;
import java.util.regex.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Operations {

    private static final DecimalFormat df= new DecimalFormat("0.00");
    public Operations() {
    }

    public Polynomial addition(Polynomial p1, Polynomial p2) {

        TreeMap<Integer, Integer> m1 = p1.polinom;
        TreeMap<Integer, Integer> m2 = p2.polinom;
        for (Integer ent : m2.keySet())
            if (m1.containsKey(ent)) {
                if (m1.get(ent) + m2.get(ent) == 0)
                    m1.remove(ent);
                else
                    m1.replace(ent, m1.get(ent) + m2.get(ent));
            } else if(m2.get(ent)!=0)
                m1.put(ent, m2.get(ent));
        Polynomial p3 = new Polynomial(m1);
        return p3;
    }

    public Polynomial subtraction(Polynomial p1, Polynomial p2)
    {
        TreeMap<Integer, Integer> m1 = p1.polinom;
        TreeMap<Integer, Integer> m2 = p2.polinom;
        for (Integer ent : m2.keySet())
            if (m1.containsKey(ent)) {
                if (m1.get(ent) - m2.get(ent) == 0)
                    m1.remove(ent);
                else
                    m1.replace(ent, m1.get(ent) - m2.get(ent));
            } else if(m2.get(ent)!=0)
                m1.put(ent, -m2.get(ent));
        Polynomial p3 = new Polynomial(m1);
        return p3;
    }
    public Polynomial product(Polynomial p1, Polynomial p2)
    {
        Polynomial res=new Polynomial(new TreeMap<Integer, Integer>(Collections.reverseOrder()));
        for(Integer ent1:p1.polinom.keySet())
        {
            Polynomial partRes=new Polynomial(new TreeMap<Integer, Integer>(Collections.reverseOrder()));
            for(Integer ent2:p2.polinom.keySet())
                partRes.polinom.put(ent1+ent2,p2.polinom.get(ent2)*p1.polinom.get(ent1));
            res=addition(res,partRes);
        }
        return res;
    }
    public Polynomial derivate(Polynomial p1)
    {
        Polynomial res=new Polynomial(new TreeMap<Integer,Integer>(Collections.reverseOrder()));
        for(Integer ent:p1.polinom.keySet())
        {
            if(ent>0)
            {
                res.polinom.put(ent-1,p1.polinom.get(ent)*ent);
            }
        }
        return res;
    }
    public String integration(Polynomial p1)
    {
        df.setRoundingMode(RoundingMode.DOWN);
        String res="";
        for(Integer ent:p1.polinom.keySet()){
            Double aux=p1.polinom.get(ent)/(double)(ent+1);
             if(ent==0){
                if(p1.polinom.get(ent)<0)
                    if(p1.polinom.get(ent)%(ent+1)==0)
                        res = res + (aux.intValue() == -1 ? "-x" : (aux.intValue() + "x"));
                else res=res+"-"+df.format(aux)+"x";
                else if(p1.polinom.get(ent)%(ent+1)==0)
                 res = res + (aux.intValue() == 1 ? "+x" : ("+"+aux.intValue() + "x"));
                else res=res+"+"+df.format(aux)+"x";
            }
            else{
                if(p1.polinom.get(ent)<0)
                    if(p1.polinom.get(ent)%(ent+1)==0)
                        res = res + (aux.intValue() == -1 ? ("-x^"+(ent+1)) : (aux.intValue()+"x^"+(ent+1)));
                    else res=res+df.format(aux)+"x^"+(ent+1);
                else if(p1.polinom.get(ent)%(ent+1)==0)
                    res = res + (aux.intValue() == 1 ? ("+x^"+(ent+1)) : ("+"+aux.intValue()+"x^"+(ent+1)));
                else res=res+"+"+df.format(aux)+"x^"+(ent+1);
            }
        }
        if(res.charAt(0)=='+')
          res=res.substring(1);
        return res;
    }
    public String printDoublePol(TreeMap<Integer, Double> p1){
        String result="";
        if(p1.isEmpty())
            result=result+'0';
        else
            for (Integer entry : p1.keySet()) {
                if (p1.get(entry) < 0) {
                    if (entry == 0)
                        result = result + p1.get(entry);
                    else if (entry == 1)
                        result=result+(p1.get(entry).intValue()==-1?"-x":(p1.get(entry)+"x"));
                    else result = result + (p1.get(entry).intValue() == -1 ? ("-x^"+entry) : (p1.get(entry) + "x^"+entry));
                }
                else{
                    if (entry == 0)
                        result = result + "+" + p1.get(entry);
                    else {
                        if (entry == 1)
                            result=result+(p1.get(entry).intValue()==1?"+x":("+"+p1.get(entry)+"x"));
                        else
                            result = result + (p1.get(entry).intValue() == 1 ? ("+x^"+entry) : ("+"+p1.get(entry) + "x^"+entry));
                    }
                }
            }
        if(result.charAt(0)=='+')
            result=result.substring(1);
        return result;
    }

    public String division(Polynomial p1, Polynomial p2) throws DivideBy0
    {
        if(p2.polinom.get(p2.polinom.firstKey())==0)
            throw new DivideBy0("Don't divide by 0");
        else {
            String res = "";
            TreeMap<Integer, Double> pol1 = new TreeMap<Integer, Double>(Collections.reverseOrder());
            TreeMap<Integer, Double> pol2 = new TreeMap<Integer, Double>(Collections.reverseOrder());
            TreeMap<Integer, Double> cat = new TreeMap<Integer, Double>(Collections.reverseOrder());
            for (Map.Entry<Integer, Integer> ent : p1.polinom.entrySet()) {
                pol1.put(ent.getKey(), (double) ent.getValue());
            }
            for (Map.Entry<Integer, Integer> ent : p2.polinom.entrySet()) {
                pol2.put(ent.getKey(), (double) ent.getValue());
            }
            while (!pol1.isEmpty() && pol1.firstKey() - pol2.firstKey() >= 0) {
                TreeMap<Integer, Double> partRes = new TreeMap<Integer, Double>(Collections.reverseOrder());
                int powerDiff = pol1.firstKey() - pol2.firstKey();
                Double coef = (double) pol1.get(pol1.firstKey()) / pol2.get(pol2.firstKey());
                cat.put(powerDiff, coef);
                for (Integer entry : pol2.keySet())
                    partRes.put(entry + powerDiff, pol2.get(entry) * coef);
                for (Integer entry1 : partRes.keySet()) {
                    if (pol1.containsKey(entry1))
                        if ((double) pol1.get(entry1) - partRes.get(entry1) <= 0.0001 && (double) pol1.get(entry1) - partRes.get(entry1) >= -0.0001)
                            pol1.remove(entry1);
                        else
                            pol1.replace(entry1, pol1.get(entry1) - partRes.get(entry1));
                    else
                        pol1.put(entry1, -partRes.get(entry1));
                }
            }
            res = "Q:" + res + printDoublePol(cat);
            res = res + " R:" + printDoublePol(pol1);
            return res;
        }
    }

    public Polynomial stringToPol(String s) throws MissingInput, InvalidInput {
        if(s.isBlank()||s.isEmpty())
            throw new MissingInput("Mising input");
        Polynomial pol=new Polynomial(new TreeMap<Integer,Integer>(Collections.reverseOrder()));
        Pattern p=Pattern.compile("([-+]?\\d*)x(?:\\^(\\d+))?|([-+]?\\d+)");
        Pattern missmatch=Pattern.compile("[^\\W\\dxX]");
        Matcher miss=missmatch.matcher(s);
        Matcher m=p.matcher(s);
        if(miss.find())
            throw new InvalidInput("Invalit input! Only use x!");
        while(m.find())
        {
            String coefStr=m.group(1);
            String pwrStr=m.group(2);
            String ctStr=m.group(3);
            if(coefStr!=null){
            int coef=coefStr.isEmpty()?1:Integer.parseInt(coefStr.trim());
            int power=(pwrStr==null || pwrStr.isEmpty())?1:Integer.parseInt(pwrStr);
            pol.addMonome(power, coef);
            }else{
                int ct=Integer.parseInt(ctStr);
                pol.addMonome(0,ct);
            }
        }

   return pol;
    }
}
