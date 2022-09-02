package br.com.pedrobelmino.redis.keyspattern.model;

public class CacheRepresentation {

    private String key;
    private String value;

    public CacheRepresentation(){}

    public CacheRepresentation(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
