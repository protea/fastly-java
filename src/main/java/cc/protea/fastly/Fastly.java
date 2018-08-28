package cc.protea.fastly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fastly {

	String urlbase = "https://api.fastly.com";
	
	final String apiKey;
	final String serviceId;

	FastlyUtils util = new FastlyUtils(this);

	public Fastly(String apiKey, String serviceId) {
		this.apiKey = apiKey;
		this.serviceId = serviceId;
	}
	
	public Fastly(String apiKey) {
		this.apiKey = apiKey;
		this.serviceId = null;
	}
	
	public FastlyResponse purgeAll() {
		return util.post("/service/" + serviceId + "/purge_all", null, FastlyResponse.class);
	}

	public FastlyResponse purgeUrl(String url) {
		return util.purge(url, null, FastlyResponse.class, null);
	}
	
	public FastlyResponse purgeSurrogateKey(String surrogateKey) {
		return util.post("/service/" + serviceId + "/purge/" + surrogateKey	, null, FastlyResponse.class);
	}
	
	public FastlyResponse purgeSurrogateKeys(List<String> surrogateKeys) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("surrogate_keys", surrogateKeys);
		return util.post("/service/" + serviceId + "/purge" , map, FastlyResponse.class);
	}
	
	public FastlyResponse softPurgeUrl(String url) {
		return util.purge(url, null, FastlyResponse.class, "Fastly-Soft-Purge:1");
	}
	
	public FastlyResponse softPurgeSurrogateKey(String surrogateKey) {
		return util.post("/service/" + serviceId + "/purge/" + surrogateKey	, null, FastlyResponse.class, "Fastly-Soft-Purge:1");
	}
	


}
