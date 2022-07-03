package com.hong.fortune.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class JacksonUtil {
    private static ObjectMapper mapper;
    protected static final Include DEFAULT_PROPERTY_INCLUSION;
    protected static final boolean IS_ENABLE_INDENT_OUTPUT = false;

    public JacksonUtil() {
    }

    protected static void config(ObjectMapper objectMapper) {
        objectMapper.enable(new Feature[]{Feature.WRITE_BIGDECIMAL_AS_PLAIN});
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        objectMapper.enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
        objectMapper.enable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.enable(new com.fasterxml.jackson.core.JsonParser.Feature[]{com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_COMMENTS});
        objectMapper.disable(new Feature[]{Feature.ESCAPE_NON_ASCII});
        objectMapper.enable(new Feature[]{Feature.IGNORE_UNKNOWN});
        objectMapper.enable(new com.fasterxml.jackson.core.JsonParser.Feature[]{com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES});
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") {
            {
                this.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            }
        });
        objectMapper.enable(new com.fasterxml.jackson.core.JsonParser.Feature[]{com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES});
        objectMapper.enable(new com.fasterxml.jackson.core.JsonParser.Feature[]{com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS});
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }

    public static <V> V from(URL url, Class<V> type) {
        try {
            return mapper.readValue(url, type);
        } catch (IOException var3) {
            throw new IllegalArgumentException();
        }
    }

    public static <V> V from(URL url, TypeReference<V> type) {
        try {
            return mapper.readValue(url, type);
        } catch (IOException var3) {
            throw new IllegalArgumentException();
        }
    }

    public static <V> List<V> fromList(URL url, Class<V> type) {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, type);
            return (List) mapper.readValue(url, collectionType);
        } catch (IOException var3) {
            throw new IllegalArgumentException();
        }
    }

    public static <V> V from(InputStream inputStream, Class<V> type) {
        try {
            return mapper.readValue(inputStream, type);
        } catch (IOException var3) {
            throw new IllegalArgumentException();
        }
    }

    public static <V> V from(InputStream inputStream, TypeReference<V> type) {
        try {
            return mapper.readValue(inputStream, type);
        } catch (IOException var3) {
            throw new IllegalArgumentException();
        }
    }

    public static <V> List<V> fromList(InputStream inputStream, Class<V> type) {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, type);
            return (List) mapper.readValue(inputStream, collectionType);
        } catch (IOException var3) {
            throw new IllegalArgumentException();
        }
    }

    public static <V> V from(File file, Class<V> type) {
        try {
            return mapper.readValue(file, type);
        } catch (IOException var3) {
            throw new IllegalArgumentException();
        }
    }

    public static <V> V from(File file, TypeReference<V> type) {
        try {
            return mapper.readValue(file, type);
        } catch (IOException var3) {
            throw new IllegalArgumentException();
        }
    }

    public static <V> List<V> fromList(File file, Class<V> type) {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, type);
            return (List) mapper.readValue(file, collectionType);
        } catch (IOException var3) {
            throw new IllegalArgumentException();
        }
    }

    public static <V> V from(String json, Class<V> type) {
        return from((String) json, (Type) type);
    }

    public static <V> V from(String json, TypeReference<V> type) {
        return from(json, type.getType());
    }

    public static <V> V from(String json, Type type) {
        if (json == null) {
            return null;
        } else {
            try {
                JavaType javaType = mapper.getTypeFactory().constructType(type);
                return mapper.readValue(json, javaType);
            } catch (IOException var3) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    public static <V> List<V> fromList(String json, Class<V> type) {
        if (json == null) {
            return null;
        } else {
            try {
                CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, type);
                return (List) mapper.readValue(json, collectionType);
            } catch (IOException var3) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    public static Map<String, Object> fromMap(String json) {
        if (json == null) {
            return null;
        } else {
            try {
                MapType mapType = mapper.getTypeFactory().constructMapType(HashMap.class, String.class, Object.class);
                return (Map) mapper.readValue(json, mapType);
            } catch (IOException var2) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    public static <V> String to(List<V> list) {
        try {
            return mapper.writeValueAsString(list);
        } catch (JsonProcessingException var2) {
            throw new IllegalArgumentException();
        }
    }

    public static <V> String to(V v) {
        try {
            return mapper.writeValueAsString(v);
        } catch (JsonProcessingException var2) {
            throw new IllegalArgumentException();
        }
    }

    public static <V> void toFile(String path, List<V> list) {
        try {
            FileWriter writer = new FileWriter(new File(path), true);

            try {
                mapper.writer().writeValues(writer).writeAll(list);
            } catch (Throwable var6) {
                try {
                    writer.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            writer.close();
        } catch (Exception var7) {
            throw new IllegalArgumentException();
        }
    }

    public static <V> void toFile(String path, V v) {
        try {
            FileWriter writer = new FileWriter(new File(path), true);

            try {
                mapper.writer().writeValues(writer).write(v);
            } catch (Throwable var6) {
                try {
                    writer.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            writer.close();
        } catch (Exception var7) {
            throw new IllegalArgumentException();
        }
    }

    public static String getAsString(String json, String key) {
        if (StringUtils.isEmpty(json)) {
            return null;
        } else {
            try {
                JsonNode jsonNode = getAsJsonObject(json, key);
                return null == jsonNode ? null : getAsString(jsonNode);
            } catch (Exception var3) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    private static String getAsString(JsonNode jsonNode) {
        return jsonNode.isTextual() ? jsonNode.textValue() : jsonNode.toString();
    }

    public static int getAsInt(String json, String key) {
        if (StringUtils.isEmpty(json)) {
            return 0;
        } else {
            try {
                JsonNode jsonNode = getAsJsonObject(json, key);
                if (null == jsonNode) {
                    return 0;
                } else {
                    return jsonNode.isInt() ? jsonNode.intValue() : Integer.parseInt(getAsString(jsonNode));
                }
            } catch (Exception var3) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    public static long getAsLong(String json, String key) {
        if (StringUtils.isEmpty(json)) {
            return 0L;
        } else {
            try {
                JsonNode jsonNode = getAsJsonObject(json, key);
                if (null == jsonNode) {
                    return 0L;
                } else {
                    return jsonNode.isLong() ? jsonNode.longValue() : Long.parseLong(getAsString(jsonNode));
                }
            } catch (Exception var3) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    public static double getAsDouble(String json, String key) {
        if (StringUtils.isEmpty(json)) {
            return 0.0D;
        } else {
            try {
                JsonNode jsonNode = getAsJsonObject(json, key);
                if (null == jsonNode) {
                    return 0.0D;
                } else {
                    return jsonNode.isDouble() ? jsonNode.doubleValue() : Double.parseDouble(getAsString(jsonNode));
                }
            } catch (Exception var3) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    public static BigInteger getAsBigInteger(String json, String key) {
        if (StringUtils.isEmpty(json)) {
            return new BigInteger(String.valueOf(0.0D));
        } else {
            try {
                JsonNode jsonNode = getAsJsonObject(json, key);
                if (null == jsonNode) {
                    return new BigInteger(String.valueOf(0.0D));
                } else {
                    return jsonNode.isBigInteger() ? jsonNode.bigIntegerValue() : new BigInteger(getAsString(jsonNode));
                }
            } catch (Exception var3) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    public static BigDecimal getAsBigDecimal(String json, String key) {
        if (StringUtils.isEmpty(json)) {
            return new BigDecimal("0.00");
        } else {
            try {
                JsonNode jsonNode = getAsJsonObject(json, key);
                if (null == jsonNode) {
                    return new BigDecimal("0.00");
                } else {
                    return jsonNode.isBigDecimal() ? jsonNode.decimalValue() : new BigDecimal(getAsString(jsonNode));
                }
            } catch (Exception var3) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    public static boolean getAsBoolean(String json, String key) {
        if (StringUtils.isEmpty(json)) {
            return false;
        } else {
            try {
                JsonNode jsonNode = getAsJsonObject(json, key);
                if (null == jsonNode) {
                    return false;
                } else if (jsonNode.isBoolean()) {
                    return jsonNode.booleanValue();
                } else if (jsonNode.isTextual()) {
                    String textValue = jsonNode.textValue();
                    return "1".equals(textValue) ? true : BooleanUtils.toBoolean(textValue);
                } else {
                    return BooleanUtils.toBoolean(jsonNode.intValue());
                }
            } catch (Exception var4) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    public static byte[] getAsBytes(String json, String key) {
        if (StringUtils.isEmpty(json)) {
            return null;
        } else {
            try {
                JsonNode jsonNode = getAsJsonObject(json, key);
                if (null == jsonNode) {
                    return null;
                } else {
                    return jsonNode.isBinary() ? jsonNode.binaryValue() : getAsString(jsonNode).getBytes();
                }
            } catch (Exception var3) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    public static <V> V getAsObject(String json, String key, Class<V> type) {
        if (StringUtils.isEmpty(json)) {
            return null;
        } else {
            try {
                JsonNode jsonNode = getAsJsonObject(json, key);
                if (null == jsonNode) {
                    return null;
                } else {
                    JavaType javaType = mapper.getTypeFactory().constructType(type);
                    return from((String) getAsString(jsonNode), (Type) javaType);
                }
            } catch (Exception var5) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    public static <V> List<V> getAsList(String json, String key, Class<V> type) {
        if (StringUtils.isEmpty(json)) {
            return null;
        } else {
            try {
                JsonNode jsonNode = getAsJsonObject(json, key);
                if (null == jsonNode) {
                    return null;
                } else {
                    CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, type);
                    return (List) from((String) getAsString(jsonNode), (Type) collectionType);
                }
            } catch (Exception var5) {
                throw new IllegalArgumentException(json);
            }
        }
    }

    public static JsonNode getAsJsonObject(String json, String key) {
        try {
            JsonNode node = mapper.readTree(json);
            return null == node ? null : node.get(key);
        } catch (IOException var3) {
            throw new IllegalArgumentException(json);
        }
    }

    public static <V> String add(String json, String key, V value) {
        try {
            JsonNode node = mapper.readTree(json);
            add(node, key, value);
            return node.toString();
        } catch (IOException var4) {
            throw new IllegalArgumentException(json);
        }
    }

    private static <V> void add(JsonNode jsonNode, String key, V value) {
        if (value instanceof String) {
            ((ObjectNode) jsonNode).put(key, (String) value);
        } else if (value instanceof Short) {
            ((ObjectNode) jsonNode).put(key, (Short) value);
        } else if (value instanceof Integer) {
            ((ObjectNode) jsonNode).put(key, (Integer) value);
        } else if (value instanceof Long) {
            ((ObjectNode) jsonNode).put(key, (Long) value);
        } else if (value instanceof Float) {
            ((ObjectNode) jsonNode).put(key, (Float) value);
        } else if (value instanceof Double) {
            ((ObjectNode) jsonNode).put(key, (Double) value);
        } else if (value instanceof BigDecimal) {
            ((ObjectNode) jsonNode).put(key, (BigDecimal) value);
        } else if (value instanceof BigInteger) {
            ((ObjectNode) jsonNode).put(key, (BigInteger) value);
        } else if (value instanceof Boolean) {
            ((ObjectNode) jsonNode).put(key, (Boolean) value);
        } else if (value instanceof byte[]) {
            ((ObjectNode) jsonNode).put(key, (byte[]) value);
        } else {
            ((ObjectNode) jsonNode).put(key, to(value));
        }

    }

    public static String remove(String json, String key) {
        try {
            JsonNode node = mapper.readTree(json);
            ((ObjectNode) node).remove(key);
            return node.toString();
        } catch (IOException var3) {
            throw new IllegalArgumentException(json);
        }
    }

    public static <V> String update(String json, String key, V value) {
        try {
            JsonNode node = mapper.readTree(json);
            ((ObjectNode) node).remove(key);
            add(node, key, value);
            return node.toString();
        } catch (IOException var4) {
            throw new IllegalArgumentException(json);
        }
    }

    public static String format(String json) {
        try {
            JsonNode node = mapper.readTree(json);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
        } catch (IOException var2) {
            throw new IllegalArgumentException(json);
        }
    }

    public static boolean isJsonObject(String json) {
        if (StringUtils.isEmpty(json)) {
            return false;
        } else {
            try {
                JsonNode node = mapper.readTree(json);
                return node.isObject();
            } catch (Exception var2) {
                return false;
            }
        }
    }

    public static boolean isJsonArray(String json) {
        if (StringUtils.isEmpty(json)) {
            return false;
        } else {
            try {
                JsonNode node = mapper.readTree(json);
                return node.isArray();
            } catch (Exception var2) {
                return false;
            }
        }
    }

    static {
        DEFAULT_PROPERTY_INCLUSION = Include.NON_NULL;

        try {
            mapper = new ObjectMapper();
            mapper.setSerializationInclusion(DEFAULT_PROPERTY_INCLUSION);
            mapper.configure(SerializationFeature.INDENT_OUTPUT, false);
            config(mapper);
        } catch (Exception var1) {
        }

    }
}

