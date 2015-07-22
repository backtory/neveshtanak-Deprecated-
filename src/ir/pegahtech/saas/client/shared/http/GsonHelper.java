package ir.pegahtech.saas.client.shared.http;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonHelper {
    public static Gson getCustomGson() {
        return new GsonBuilder()
//                .registerTypeHierarchyAdapter(byte[].class, new ByteArrayToBase64TypeAdapter())
                .registerTypeHierarchyAdapter(Boolean.class, new BooleanSerializer())
                .setDateFormat("yyyy-MM-dd hh:mm:ss. mmm")
                .create();
    }

    public static class BooleanSerializer implements JsonSerializer<Boolean>, JsonDeserializer<Boolean> {

        @Override
        public JsonElement serialize(Boolean arg0, Type arg1, JsonSerializationContext arg2) {
            return new JsonPrimitive(arg0 ? "True" : "False");
        }

        @Override
        public Boolean deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
            // try to parse boolean
            try { return arg0.getAsBoolean(); } catch (Exception ex) { }

            // if failed, try to parse integer
            return arg0.getAsInt() == 1;
        }
    }
    // Using Android's base64 libraries. This can be replaced with any base64
    // library.
//	private static class ByteArrayToBase64TypeAdapter implements
//			JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
//		public byte[] deserialize
//                (
//                        JsonElement json,
//                        Type typeOfT,
//				        JsonDeserializationContext context
//                ) throws JsonParseException {
//			return Base64.decode(json.getAsString(), Base64.NO_WRAP);
//		}
//
//		public JsonElement serialize(byte[] src, Type typeOfSrc,
//				JsonSerializationContext context) {
//			return new JsonPrimitive(Base64.encodeToString(src, Base64.NO_WRAP));
//		}
//	}
}