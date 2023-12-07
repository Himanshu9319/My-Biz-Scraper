package UtilsAPI.helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;

public class JsonComparator {
    static String ppJson = "{\n" +
            "  \"status\": 200,\n" +
//           "  \"main\": \"SUCCESS\",\n" +
            "  \"statusCode\": 200,\n" +
            "  \"errorCode\": null,\n" +
            "  \"message\": \"SUCCESS\",\n" +
            "  \"response\": {\n" +
            "    \"phone\": \"5627262727\",\n" +
            "    \"username\": \"xcyvh.910670@blu-smart.com\",\n" +
            "    \"password\": \"361230\",\n" +
            "    \"is_new\": false,\n" +
            "    \"attempt_left\": null\n" +
            "  },\n" +
            "  \"errorResponse\": null,\n" +
            "  \"responseData\": null\n" +
            "}";
    static String uatJson = "{\n" +
            "  \"status\": \"SUCCESS\",\n" +
            "  \"statusCode\": 200,\n" +
            "  \"errorCode\": null,\n" +
            "  \"message\": \"SUCCESS\",\n" +
            "  \"response\": {\n" +
            "    \"phone\": \"5627262727\",\n" +
            "    \"username\": \"xcyvh.910670@blu-smart.com\",\n" +
            "    \"password\": \"361230\",\n" +
            "    \"is_new\": false,\n" +
            "    \"attempt_left\": null\n" +
            "  },\n" +
            "  \"errorResponse\": null,\n" +
            "  \"responseData\": null\n" +
            "}";

    public static void main(String[] args) throws Exception {
        System.out.println("-----------Results when PP with UAT-----------");
        System.out.println(compareJson(ppJson, uatJson));
        System.out.println("-----------Results when UAT with PP-----------");
        System.out.println(compareJson(uatJson, ppJson));
    }

    public static boolean compareJson(String json1, String json2) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node1 = mapper.readTree(json1);
        JsonNode node2 = mapper.readTree(json2);

        if (!node1.getNodeType().equals(node2.getNodeType())) {
            return false;
        }

        switch (node1.getNodeType()) {
            case BOOLEAN:
                return node1.asBoolean() == node2.asBoolean();
            case NUMBER:
                return node1.asDouble() == node2.asDouble();
            case STRING:
                return node1.asText().equals(node2.asText());
            case ARRAY:
                if (node1.size() != node2.size()) {
                    return false;
                }
                for (int i = 0; i < node1.size(); i++) {
                    if (!compareJson(node1.get(i).toString(), node2.get(i).toString())) {
                        return false;
                    }
                }
                return true;
            case OBJECT:
//                if (node1.size() != node2.size()) {
//                    return false;
//                }
                for (Iterator<String> it = node1.fieldNames(); it.hasNext(); ) {
                    String field = it.next();
                    if (!node2.has(field)) {
                        System.out.println(field + " is not present.");
                        return false;
                    }
                    if (!compareJson(node1.get(field).toString(), node2.get(field).toString())) {
                        return false;
                    }
                }
                return true;
            case NULL:
                return true;
            default:
                return false;
        }
    }
}
