package kz.qazlingo.www.qazlingo;

import java.util.HashMap;

/**
 * Created by sansyzbaynurbolat on 1/17/18.
 */

public class Converter {
    private HashMap<String,String> kirilToLatin;
    private HashMap<String,String> latinToKiril;

    public Converter(){
        kirilToLatin = new HashMap<>();
        latinToKiril = new HashMap<>();
        initKiril();
        initLatin();
    }
    private void initKiril(){
        //Old version of letter of kazakh language 2017v
        /*kirilToLatin.put("а","a");
        kirilToLatin.put("ә","a'");
        kirilToLatin.put("б","b");
        kirilToLatin.put("в","v");
        kirilToLatin.put("г","g");
        kirilToLatin.put("ғ","g'");
        kirilToLatin.put("д","d");
        kirilToLatin.put("е","e");
        kirilToLatin.put("ё","");
        kirilToLatin.put("ж","j");
        kirilToLatin.put("з","z");
        kirilToLatin.put("и","i'");
        kirilToLatin.put("й","i'");
        kirilToLatin.put("к","k");
        kirilToLatin.put("қ","q");
        kirilToLatin.put("л","l");
        kirilToLatin.put("м","m");
        kirilToLatin.put("н","n");
        kirilToLatin.put("ң","n'");
        kirilToLatin.put("о","o");
        kirilToLatin.put("ө","o'");
        kirilToLatin.put("п","p");
        kirilToLatin.put("р","r");
        kirilToLatin.put("с","s");
        kirilToLatin.put("т","t");
        kirilToLatin.put("у","y'");
        kirilToLatin.put("ұ","u");
        kirilToLatin.put("ү","u'");
        kirilToLatin.put("ф","f");
        kirilToLatin.put("х","h");
        kirilToLatin.put("һ","h");
        kirilToLatin.put("ц","ts");
        kirilToLatin.put("ч","c'");
        kirilToLatin.put("ш","s'");
        kirilToLatin.put("щ","s'");
        kirilToLatin.put("ъ","");
        kirilToLatin.put("ы","y");
        kirilToLatin.put("і","i");
        kirilToLatin.put("ь","");
        kirilToLatin.put("э","e");
        kirilToLatin.put("ю","i'y'");
        kirilToLatin.put("я","i'a");*/

        //new version of kazakh alphabet
        kirilToLatin.put("а","a");
        kirilToLatin.put("ә","á"); /////
        kirilToLatin.put("б","b");
        kirilToLatin.put("в","v");
        kirilToLatin.put("г","g");
        kirilToLatin.put("ғ","ǵ");
        kirilToLatin.put("д","d");
        kirilToLatin.put("е","e");
        kirilToLatin.put("ё","");
        kirilToLatin.put("ж","j");
        kirilToLatin.put("з","z");
        kirilToLatin.put("и","ı");
        kirilToLatin.put("й","ı");
        kirilToLatin.put("к","k");
        kirilToLatin.put("қ","q");
        kirilToLatin.put("л","l");
        kirilToLatin.put("м","m");
        kirilToLatin.put("н","n");
        kirilToLatin.put("ң","ń");
        kirilToLatin.put("о","o");
        kirilToLatin.put("ө","ó");
        kirilToLatin.put("п","p");
        kirilToLatin.put("р","r");
        kirilToLatin.put("с","s");
        kirilToLatin.put("т","t");
        kirilToLatin.put("у","ý");
        kirilToLatin.put("ұ","u");
        kirilToLatin.put("ү","ú");
        kirilToLatin.put("ф","f");
        kirilToLatin.put("х","h");
        kirilToLatin.put("һ","h");
        kirilToLatin.put("ц","ts");
        kirilToLatin.put("ч","ch");
        kirilToLatin.put("ш","sh");
        kirilToLatin.put("щ","sh");
        kirilToLatin.put("ъ","");
        kirilToLatin.put("ы","y");
        kirilToLatin.put("і","i");
        kirilToLatin.put("ь","");
        kirilToLatin.put("э","e");
        kirilToLatin.put("ю","ıý");
        kirilToLatin.put("я","ıa");
}
    private void initLatin(){
        latinToKiril.put("a","а");
        latinToKiril.put("á","ә");
        latinToKiril.put("b","б");
        latinToKiril.put("v","в");
        latinToKiril.put("g","г");
        latinToKiril.put("ǵ","ғ");
        latinToKiril.put("d","д");
        latinToKiril.put("e","е");
        latinToKiril.put("j","ж");
        latinToKiril.put("z","з");
        latinToKiril.put("ı","и");
        latinToKiril.put("ı","й");
        latinToKiril.put("k","к");
        latinToKiril.put("q","қ");
        latinToKiril.put("l","л");
        latinToKiril.put("m","м");
        latinToKiril.put("n","н");
        latinToKiril.put("ń","ң");
        latinToKiril.put("o","о");
        latinToKiril.put("ó","ө");
        latinToKiril.put("p","п");
        latinToKiril.put("r","р");
        latinToKiril.put("s","с");
        latinToKiril.put("t","т");
        latinToKiril.put("ý","у");
        latinToKiril.put("u","ұ");
        latinToKiril.put("ú","ү");
        latinToKiril.put("f","ф");
        latinToKiril.put("h","х");
        latinToKiril.put("h","һ");
        latinToKiril.put("ts","ц");
        latinToKiril.put("ch","ч");
        latinToKiril.put("sh","ш");
        latinToKiril.put("sh","щ");
        latinToKiril.put("y","ы");
        latinToKiril.put("i","і");
        latinToKiril.put("ıý","ю");
        latinToKiril.put("ıa","я");
    }

    public String toLatin(String words){
        String[] letterArray = words.split("");
        String convertedText = "";
        boolean isLowerCase,isPlace;
        for(int i = 0;i<letterArray.length;i++){
            isLowerCase  = letterArray[i].equals(letterArray[i]=letterArray[i].toLowerCase());
            String letter = kirilToLatin.get(letterArray[i]);
            letter = letter!=null?letter:letterArray[i];
            letterArray[i] = isLowerCase?letter:letter.toUpperCase();
            convertedText+=letterArray[i];
        }
        return convertedText;
    }
    public String toKiril(String words){
        String[] letterArray = words.split("");
        String convertedText = "";
        boolean isLowerCase,isPlace;
        for(int i = 0;i<letterArray.length;i++){
            isLowerCase  = letterArray[i].equals(letterArray[i]=letterArray[i].toLowerCase());
            String draftLetter;
            String letter = latinToKiril.get(letterArray[i]);
            boolean isChanged=false;
            if(i<letterArray.length-3 && !isChanged){
                draftLetter = letterArray[i]+letterArray[i+1]+letterArray[i+2]+letterArray[i+3];
                if(latinToKiril.get(draftLetter)!=null){
                    letter = latinToKiril.get(draftLetter);
                    isChanged = true;
                    i+=3;
                }
            }
            if(i<letterArray.length-2 && !isChanged) {
                draftLetter = letterArray[i] + letterArray[i + 1] + letterArray[i + 2];
                if (latinToKiril.get(draftLetter) != null) {
                    letter = latinToKiril.get(draftLetter);
                    isChanged = true;
                    i+=2;
                }
            }

            if(i<(letterArray.length-1) && !isChanged){
                draftLetter = letterArray[i]+letterArray[i+1];
                if(latinToKiril.get(draftLetter)!=null){
                    letter = latinToKiril.get(draftLetter);

                    i++;
                }
            }

            letter = letter!=null?letter:letterArray[i];

            letterArray[i] = isLowerCase?letter:letter.toUpperCase();
            convertedText+=letterArray[i];
        }
        return convertedText;
    }
}
