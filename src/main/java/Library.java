import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Library {
    private BigDecimal givenNumber;
    private String convertedNumber;
    private int intLength;
    private BigDecimal intPart;
    private BigDecimal decimalPart;
    private BigDecimal[] dividedArray;


    private HashMap<BigDecimal,String> numberMap = new HashMap<>();
    private HashMap<Integer,String> decadesMap = new HashMap<>();
    private ArrayList<String> katataksi = new ArrayList<>();

    public boolean someLibraryMethod() {
        
        return true;
    }

    public void init(BigDecimal aNumber){
        decadesMap.put(0,"");
        decadesMap.put(1,"xiliades");
        decadesMap.put(2,"ekatomuria");
        decadesMap.put(3,"disekatomuria");
        decadesMap.put(4,"trisekatomuria");
        decadesMap.put(5,"tetrakis");
        decadesMap.put(6,"pentakis");
        decadesMap.put(7,"eksakis");

        numberMap.put(new BigDecimal(0),"mhden");
        numberMap.put(new BigDecimal(1),"ena");
        numberMap.put(new BigDecimal(2),"duo");
        numberMap.put(new BigDecimal(3),"tria");
        numberMap.put(new BigDecimal(4),"tesera");
        numberMap.put(new BigDecimal(5),"pente");
        numberMap.put(new BigDecimal(6),"eksi");
        numberMap.put(new BigDecimal(7),"epta");
        numberMap.put(new BigDecimal(8),"oxto");
        numberMap.put(new BigDecimal(9),"enia");
        numberMap.put(new BigDecimal(10),"deka");
        numberMap.put(new BigDecimal(11),"enteka");
        numberMap.put(new BigDecimal(12),"dodeka");
        numberMap.put(new BigDecimal(20),"eikosi");
        numberMap.put(new BigDecimal(30),"trianta");
        numberMap.put(new BigDecimal(40),"saranta");
        numberMap.put(new BigDecimal(50),"peninta");
        numberMap.put(new BigDecimal(60),"eksinta");
        numberMap.put(new BigDecimal(70),"evdominta");
        numberMap.put(new BigDecimal(80),"ogdonta");
        numberMap.put(new BigDecimal(90),"eneninta");
        numberMap.put(new BigDecimal(100),"ekato");
        numberMap.put(new BigDecimal(200),"diakosia");
        numberMap.put(new BigDecimal(300),"triakosia");
        numberMap.put(new BigDecimal(400),"tetrakosia");
        numberMap.put(new BigDecimal(500),"pentakosia");
        numberMap.put(new BigDecimal(600),"eksakosia");
        numberMap.put(new BigDecimal(700),"eptakosia");
        numberMap.put(new BigDecimal(800),"oktakosia");
        numberMap.put(new BigDecimal(900),"eniakosia");

        givenNumber = aNumber;

        givenNumber=givenNumber.stripTrailingZeros();
        intLength=givenNumber.precision()-givenNumber.scale();
        intPart=givenNumber.setScale(0, RoundingMode.DOWN);
        decimalPart = givenNumber.remainder(BigDecimal.ONE);

        System.out.println("int part is " + intPart);
        System.out.println("decimal part is " + decimalPart);
        System.out.println("total length is " + givenNumber.precision());
        System.out.println("int length is " + (givenNumber.precision()-givenNumber.scale()));
        System.out.println("decimal length is " + givenNumber.scale());

    }
    public void split(){
        dividedArray = new BigDecimal[((intLength)/3)+1];
        int power=((int) ((intLength-1)/3))*3;
        for (int i=0 ; i<(intLength-1)/3+1 ;i++){
            dividedArray[i]=intPart.divide(BigDecimal.TEN.pow(power),0,RoundingMode.DOWN);

            intPart=intPart.remainder(BigDecimal.TEN.pow(power));
            power=power-3;
            System.out.println(dividedArray[i] +" " + decadesMap.get(((power/3)+1)));

        }
        splitUnits(new BigDecimal(549));
    }
    public void splitUnits(BigDecimal number){
        BigDecimal ekatontades = number.divide(new BigDecimal(100),0,RoundingMode.DOWN);
        BigDecimal upolipo = number.remainder(new BigDecimal(100));
        BigDecimal dekades = upolipo.divide(new BigDecimal(10),0,RoundingMode.DOWN);
        BigDecimal monades = number.divide(new BigDecimal(100),0,RoundingMode.DOWN).remainder(new BigDecimal(10));
        System.out.println(ekatontades);
        System.out.println(dekades);
        System.out.println(monades);

    }

}
