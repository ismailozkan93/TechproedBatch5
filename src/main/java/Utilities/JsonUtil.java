package Utilities;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {
    //bu class icinde seriliaziton ve deserilization methodlari olusturacagiz ve ihtiyac oldukca kullanacagiz.

    private static ObjectMapper mapper;//diger classlardan ulasabilmek icin methodlarin disinda class icinde olusturuldu

    //methodlardan önde olusmasi icin static block icerisinde mapper objesi olusturduk.
    static {
        mapper=new ObjectMapper();//mapper objemizi hemen olusturmus olduk.
    }

    //Java objesini JSON formatina ceviren method.
    public static String convertJavaToJson(Object object) {//veri tipi ne girersek jpon formatina cevirir.
        String jsonResult = "";
        try {
            jsonResult = mapper.writeValueAsString(object);
        } catch (JsonGenerationException e) {
            System.out.println("Java objesini cevirirken hata olsutu" + e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("Java objesini cevirirken hata olsutu" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Java objesini cevirirken hata olsutu" + e.getMessage());
        }
        return jsonResult;
    }
    //Json formatini Java formatina cevirme ==>DeSerialization
    //public static Object convertJsonToJava()

    public static <T> T convertJsontoJava(String json, Class<T> cls){
        //Generik bir method ürettik.Bu method ile Json formatini cevirmek istedigimiz formata göre ceviririz.
        //return type method kullanirken belirtiliyor.

        T javaResult=null; //objelere deger atamak icin null kullanilir.

        try {
            javaResult = mapper.readValue(json,cls);
            //readValue()methodu ObjectMapper classindan geliyor ve Json formatini Java formatina ceviriyor.
        }catch (JsonParseException e) {
            System.out.println("Java objesini cevirirken hata olsutu" + e.getMessage());
        }catch (JsonMappingException e) {
            System.out.println("Java objesini cevirirken hata olsutu" + e.getMessage());
        }catch (IOException e) {
            System.out.println("Java objesini cevirirken hata olsutu" + e.getMessage());
        }
            return javaResult;
    }

        //  Testerlar bu methodu cok kullanir,asil kullanilicak olan methoddur.
        //Bu islem Serilizationdir.

}
