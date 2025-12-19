import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    @Test
    public void test01() {
        JSONObject kisiBilgileriJsonObj = new JSONObject();

        JSONObject adresJsonObj = new JSONObject();

        JSONArray telefonBilgileriArr = new JSONArray();
        JSONObject cepTelJsonObj = new JSONObject();
        JSONObject evTelJsonObj = new JSONObject();

        adresJsonObj.put("streetAddress","naist street");
        adresJsonObj.put("city","Nara");
        adresJsonObj.put("postalCode","630-0192");

        cepTelJsonObj.put("type","iPhone");
        cepTelJsonObj.put("number","0123-4567-8888");
        evTelJsonObj.put("type","home");
        evTelJsonObj.put("number","0123-4567-8910");
        telefonBilgileriArr.put(cepTelJsonObj);
        telefonBilgileriArr.put(evTelJsonObj);

        kisiBilgileriJsonObj.put("firstname","John");
        kisiBilgileriJsonObj.put("lastname","Doe");
        kisiBilgileriJsonObj.put("age",26);
        kisiBilgileriJsonObj.put("addres",adresJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers",telefonBilgileriArr);

        System.out.println("firstname: "+kisiBilgileriJsonObj.get("firstname"));
        System.out.println("lastname: "+kisiBilgileriJsonObj.get("lastname"));

        System.out.println("streetAddress: "+kisiBilgileriJsonObj.getJSONObject("addres")
                .get("streetAddress"));

        System.out.println("streetAddress: "+kisiBilgileriJsonObj.getJSONObject("addres")
                .get("city"));

        System.out.println("cep tel no: "+kisiBilgileriJsonObj.getJSONArray("phoneNumbers")
                .getJSONObject(0).get("number"));


    }
}
